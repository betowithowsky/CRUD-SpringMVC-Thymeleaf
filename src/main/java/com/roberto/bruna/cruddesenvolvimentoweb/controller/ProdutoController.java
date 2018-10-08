/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.bruna.cruddesenvolvimentoweb.controller;

import com.roberto.bruna.cruddesenvolvimentoweb.models.Produto;
import com.roberto.bruna.cruddesenvolvimentoweb.repository.ProdutoRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Beto
 */

@Controller
public class ProdutoController {
    
    @Autowired //injeção de depencencia
    private ProdutoRepository pr;
    
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Produto> produtos = pr.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }
    
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String saveProduto(@Valid Produto produto, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os Campos Obrigatorios!");
            return "redirect:/";
        }
        
        pr.save(produto);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
        return "redirect:/";
    }
    
    @RequestMapping("deletarProduto/{id}")
    public String deletarProduto(@PathVariable("id") long id ){
        Produto produto = pr.findById(id);
        pr.delete(produto);
        
        return "redirect:/";
    }
    
    @RequestMapping(value="/editProduto/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Produto editarEvento(@PathVariable("id") long id){
        return pr.findById(id);
    }
    
    @RequestMapping(value="/editarProduto",method=RequestMethod.POST)
    public String editarProduto(@ModelAttribute("produto") Produto produto, BindingResult result, ModelMap model) {
    if (result.hasErrors()) {
        return "redirect:/";
    }
    pr.save(produto);
    return "redirect:/";
    }
    
    
    
}
 