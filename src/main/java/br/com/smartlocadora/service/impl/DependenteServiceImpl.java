package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.domain.Dependente;
import br.com.smartlocadora.repository.DependenteRepository;
import br.com.smartlocadora.service.DependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DependenteServiceImpl extends SmartLocadoraServiceImpl<Dependente> implements DependenteService {

    @Autowired
    private DependenteRepository repository;

    @Override
    public JpaRepository<Dependente, Long> getRepository() {
        return this.repository;
    }

    @Override
    public Dependente find(Long id) {
        return getRepository().findById(id).orElse(new Dependente());
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
    public void update(Dependente entity) {
        getRepository().findById(entity.getId()).map(e -> {
            getRepository().save(entity);
            return Void.TYPE;
        });
    }
}
