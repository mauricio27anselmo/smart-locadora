package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.domain.Cliente;
import br.com.smartlocadora.repository.ClienteRepository;
import br.com.smartlocadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteServiceImpl extends SmartLocadoraServiceImpl<Cliente> implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public JpaRepository<Cliente, Long> getRepository() {
        return this.repository;
    }

    @Override
    public Cliente find(Long id) {
        return getRepository().findById(id).orElse(new Cliente());
    }

    @Override
    @Transactional
    public void update(Cliente entity) {
        getRepository().findById(entity.getId()).map(e -> {
            getRepository().save(entity);
            return Void.TYPE;
        });
    }
}
