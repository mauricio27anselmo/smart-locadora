package br.com.smartlocadora.controller;

import br.com.smartlocadora.domain.Dependente;
import br.com.smartlocadora.service.DependenteService;
import br.com.smartlocadora.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/dependente")
public class DependenteController extends SmartLocadoraController<Dependente> {

    @Autowired
    private DependenteService service;

    public IService<Dependente> getService() {
        return this.service;
    }
}
