package com.gabrielaandrade.controller;

import com.gabrielaandrade.dao.PessoaDAO;
import com.gabrielaandrade.model.Pessoa;
import com.gabrielaandrade.model.PessoaForm;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRESTController {


    private PessoaDAO pessoaDAO;

    @RequestMapping(value="/pessoas",//
        method = RequestMethod.GET,//
        produces = {MediaType.APPLICATION_JSON_VALUE,//
                MediaType.APPLICATION_XML_VALUE})

    @ResponseBody
    public List<Pessoa> getPessoas(){
        List<Pessoa> list = pessoaDAO.getAllPessoas();
        return list;
    }

    @RequestMapping(value="/pessoa/{id}",//
            method = RequestMethod.GET,//
            produces = {MediaType.APPLICATION_JSON_VALUE,//
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Pessoa getPessoa(@PathVariable("id") Long id){
        return pessoaDAO.getPessoa(id);
    }

    @RequestMapping(value= "/pessoa",//
        method = RequestMethod.POST,//
        produces = {MediaType.APPLICATION_JSON_VALUE,//
                MediaType.APPLICATION_XML_VALUE})


    @ResponseBody
    public Pessoa addPessoa(@RequestBody PessoaForm pessoaForm){
        System.out.println("(Service Side) Criando Pessoa com Matricula" + pessoaForm.getMatricula());

        return pessoaDAO.addPessoa(pessoaForm);
    }

    @RequestMapping(value= "/pessoa",//
            method = RequestMethod.PUT,//
            produces = {MediaType.APPLICATION_JSON_VALUE,//
                    MediaType.APPLICATION_XML_VALUE})

    @ResponseBody
    public Pessoa updatePessoa(@RequestBody PessoaForm pessoaForm){

        System.out.println("(Service Side) Editando Pessoa com Id: " + pessoaForm.getId());

        return pessoaDAO.updatePessoa(pessoaForm);
        }
    @RequestMapping(value = "/pessoa/{id}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public void deletePessoa(@PathVariable("id") Long id) {

            System.out.println("(Service Side) Deletando Pessoa com Id: " + id);

            pessoaDAO.deletePessoa(id);
            }
}