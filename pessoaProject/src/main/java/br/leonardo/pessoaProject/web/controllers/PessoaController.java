package br.leonardo.pessoaProject.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.leonardo.pessoaProject.models.Pessoa;
import br.leonardo.pessoaProject.services.PessoaService;

@RestController
@RequestMapping("/pessoa/")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{pessoaCodigo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) // Produz JSON como retorno
    public Pessoa get(@PathVariable(value = "pessoaCodigo") String pessoaCodigo){
        return pessoaService.findByCodigo(pessoaCodigo);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pessoa> findAll(){
        return pessoaService.findAll();
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa update(@RequestBody Pessoa pessoa){
        return pessoaService.update(pessoa);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{pessoaCodigo}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "pessoaCodigo") String pessoaCodigo){
        pessoaService.delete(pessoaCodigo);
    }
}
