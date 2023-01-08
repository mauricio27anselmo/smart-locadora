package br.com.smartlocadora.controller;

import br.com.smartlocadora.domain.Dependente;
import br.com.smartlocadora.service.DependenteService;
import br.com.smartlocadora.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/dependente")
public class DependenteController implements ISmartLocadoraController<Dependente> {

    @Autowired
    private DependenteService dependenteService;

    private IService<Dependente> getService() {
        return this.dependenteService;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<Dependente> listAll() {
        return getService().listAll();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Dependente find(@PathVariable("id") Long id) {
        return getService().find(id);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Dependente insert(@RequestBody Dependente dependent) {
        return getService().insert(dependent);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public void update(Dependente dependent) {
        getService().update(dependent);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public void delete(@PathVariable("id") Long id) {
        getService().delete(id);
    }
}
