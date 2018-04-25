package br.com.rhonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rhonline.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa,String> {	
	

}
