/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roberto.bruna.cruddesenvolvimentoweb.repository;

import com.roberto.bruna.cruddesenvolvimentoweb.models.Produto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Beto
 */
public interface ProdutoRepository extends CrudRepository<Produto ,String>{
    Produto findById(long id);
}
