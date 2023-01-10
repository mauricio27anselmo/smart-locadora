package br.com.smartlocadora.service.impl;

import br.com.smartlocadora.service.IService;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public abstract class SmartLocadoraServiceImpl<T> implements IService<T> {

    public abstract JpaRepository<T, Long> getRepository();

    public List<T> listAll() {
        return getRepository().findAll();
    }

    public abstract T find(Long id);

    @Transactional
    public void delete(Long id){
        getRepository().findById(id).map(e -> {
            getRepository().deleteById(id);
            return Void.TYPE;
        });
    }

    @Transactional
    public  T insert(T entity) {
        return getRepository().save(entity);
    }

    @Transactional
    public abstract void update(T entity);
}
