package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.domain.Dependente;
import br.com.smartlocadora.repository.DependenteRepository;
import br.com.smartlocadora.service.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DependenteServiceImpl implements DependenteService {

    @Autowired
    private DependenteRepository repository;

    @Override
    public List<Dependente> listAll() {
        return repository.findAll();
    }

    @Override
    public Dependente find(Long id) {
        return repository.findById(id).orElse(new Dependente());
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
    public Dependente insert(Dependente entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void update(Dependente entity) {
        repository.findById(entity.getId()).map(e -> {
            repository.save(entity);
            return Void.TYPE;
        });
    }
}
