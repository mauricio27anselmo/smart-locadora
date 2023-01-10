package br.com.smartlocadora.controller;

import br.com.smartlocadora.domain.Ator;
import br.com.smartlocadora.service.AtorService;
import br.com.smartlocadora.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/ator")
public class AtorController extends SmartLocadoraController<Ator> {

    @Autowired
    private AtorService service;

    public IService<Ator> getService() {
        return this.service;
    }
}
