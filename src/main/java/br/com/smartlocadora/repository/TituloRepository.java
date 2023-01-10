package br.com.smartlocadora.repository;

import br.com.smartlocadora.domain.Ator;
import br.com.smartlocadora.domain.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Long> {
}
