package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.domain.Ator;
import br.com.smartlocadora.repository.AtorRepository;
import br.com.smartlocadora.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AtorServiceImpl extends SmartLocadoraServiceImpl<Ator> implements AtorService {

    @Autowired
    private AtorRepository repository;

    @Override
    public JpaRepository<Ator, Long> getRepository() {
        return this.repository;
    }

    @Override
    public Ator find(Long id) {
        return getRepository().findById(id).orElse(new Ator());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        getRepository().findById(id).map(e -> {
            getRepository().deleteById(id);
            return Void.TYPE;
        });
    }

    @Override
    @Transactional
    public void update(Ator entity) {
        getRepository().findById(entity.getId()).map(e -> {
            getRepository().save(entity);
            return Void.TYPE;
        });
    }
}
