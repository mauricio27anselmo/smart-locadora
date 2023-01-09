package br.com.smartlocadora.domain;

import javax.persistence.*;

@Entity
@Table(name = "SMT_TITULO")
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private Long id;



}
