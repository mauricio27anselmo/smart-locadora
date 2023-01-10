package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.domain.Titulo;
import br.com.smartlocadora.repository.TituloRepository;
import br.com.smartlocadora.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TituloServiceImpl extends SmartLocadoraServiceImpl<Titulo> implements TituloService {

    @Autowired
    private TituloRepository repository;

    @Override
    public JpaRepository<Titulo, Long> getRepository() {
        return this.repository;
    }

    @Override
    public Titulo find(Long id) {
        return getRepository().findById(id).orElse(new Titulo());
    }

    @Override
    public void update(Titulo entity) {
        getRepository().findById(entity.getId()).map(e -> {
            getRepository().save(entity);
            return Void.TYPE;
        });
    }
}
