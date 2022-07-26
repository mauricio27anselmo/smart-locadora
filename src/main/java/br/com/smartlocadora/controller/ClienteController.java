package br.com.smartlocadora.controller;

import br.com.smartlocadora.beans.ClienteDTO;
import br.com.smartlocadora.service.ClienteService;
import br.com.smartlocadora.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/cliente")
public class ClienteController extends AbstractRestfullController<ClienteDTO>{

    @Autowired
    private ClienteService clienteService;

    @Override
    public IService<ClienteDTO> getService() {
        return this.clienteService;
    }
}
