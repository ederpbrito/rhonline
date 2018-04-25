package br.com.rhonline.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.rhonline.model.Logradouro;

public interface LogradouroRepository extends CrudRepository<Logradouro,Integer> {

//    Logradouro findByCEP(String cep);
}
