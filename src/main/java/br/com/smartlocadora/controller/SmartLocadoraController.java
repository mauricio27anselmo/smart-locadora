package br.com.smartlocadora.controller;

import br.com.smartlocadora.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class SmartLocadoraController<T> {

    public abstract IService<T> getService();

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<T> listAll() {
        return getService().listAll();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public T get(@PathVariable("id") Long id) {
        return getService().find(id);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public T post(@RequestBody @Valid T object) {
        return getService().insert(object);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void put(@RequestBody @Valid T object) {
        getService().update(object);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(method = RequestMethod.DELETE, value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable("id") Long id) {
        getService().delete(id);
    }

}
