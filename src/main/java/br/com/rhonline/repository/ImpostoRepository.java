package br.com.rhonline.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rhonline.model.Imposto;

public interface ImpostoRepository extends CrudRepository<Imposto,Integer> {

//    Imposto findByNome(String nome);

}
