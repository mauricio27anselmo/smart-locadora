package br.com.smartlocadora.controller;

import br.com.smartlocadora.domain.Titulo;
import br.com.smartlocadora.service.IService;
import br.com.smartlocadora.service.TituloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/titulo")
public class TituloController extends SmartLocadoraController<Titulo> {

    @Autowired
    private TituloService service;

    public IService<Titulo> getService() {
        return this.service;
    }
}
