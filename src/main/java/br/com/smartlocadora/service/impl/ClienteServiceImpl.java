package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.domain.Cliente;
import br.com.smartlocadora.repository.ClienteRepository;
import br.com.smartlocadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> listAll() {
        return repository.findAll();
    }

    @Override
    public Cliente find(Long id) {
        return repository.findById(id).orElse(new Cliente());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.findById(id).map(e -> {
            repository.deleteById(id);
            return Void.TYPE;
        });
    }

    @Override
    @Transactional
    public Cliente insert(Cliente entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public Cliente update(Cliente entity) {
        return repository.save(entity);
    }


}
