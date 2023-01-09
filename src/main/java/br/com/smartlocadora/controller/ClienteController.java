package br.com.smartlocadora.controller;

import br.com.smartlocadora.domain.Cliente;
import br.com.smartlocadora.service.ClienteService;
import br.com.smartlocadora.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/cliente")
public class ClienteController implements ISmartLocadoraController<Cliente> {

    @Autowired
    private ClienteService clienteService;

    private IService<Cliente> getService() {
        return this.clienteService;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<Cliente> listAll() {
        return getService().listAll();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Cliente find(@PathVariable("id") Long id) {
        return getService().find(id);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Cliente insert(@RequestBody Cliente object) {
        return getService().insert(object);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public void update(Cliente object) {
        getService().update(object);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public void delete(@PathVariable("id") Long id) {
        getService().delete(id);
    }
}
