package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.beans.ClienteDTO;
import br.com.smartlocadora.domain.Cliente;
import br.com.smartlocadora.exception.NotFoundObjectException;
import br.com.smartlocadora.repository.ClienteRepository;
import br.com.smartlocadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl extends IServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<ClienteDTO> listAll() {
        return repository.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO find(Long id) {
        return repository.findById(id).map(ClienteDTO::new).orElseThrow(() -> new NotFoundObjectException(getMessage("br.com.smartlocadora.cliente.notFound")));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.findById(id).map(e -> {
            repository.deleteById(id);
            return Void.TYPE;
        }).orElseThrow(() -> new NotFoundObjectException(getMessage("br.com.smartlocadora.cliente.notFound")));
    }

    @Override
    @Transactional
    public Long insert(ClienteDTO entity) {
        Cliente cliente = entity.convertToDomain();
        return repository.save(cliente).getId();
    }

    @Override
    @Transactional
    public void update(Long id, ClienteDTO entity) {
        repository.findById(id).map(e ->
                repository.saveAndFlush(entity.convertToDomain()))
                .orElseThrow(() -> new NotFoundObjectException(getMessage("br.com.smartlocadora.cliente.notFound")));
    }
}
