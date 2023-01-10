package br.com.smartlocadora.controller;

import br.com.smartlocadora.domain.Cliente;
import br.com.smartlocadora.service.ClienteService;
import br.com.smartlocadora.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/cliente")
public class ClienteController extends SmartLocadoraController<Cliente> {

    @Autowired
    private ClienteService service;

    public IService<Cliente> getService() {
        return this.service;
    }

}
