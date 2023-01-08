package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.domain.Ator;
import br.com.smartlocadora.repository.AtorRepository;
import br.com.smartlocadora.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AtorServiceImpl implements AtorService {

    @Autowired
    private AtorRepository repository;

    @Override
    public List<Ator> listAll() {
        return repository.findAll();
    }

    @Override
    public Ator find(Long id) {
        return repository.findById(id).orElse(new Ator());
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
    public Ator insert(Ator entity) {
        return repository.save(entity);
    }

    @Override
    @Transactional
    public void update(Ator entity) {
        repository.findById(entity.getId()).map(e -> {
            repository.save(entity);
            return Void.TYPE;
        });
    }
}
