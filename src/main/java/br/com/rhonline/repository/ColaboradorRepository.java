package br.com.rhonline.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rhonline.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador,Long> {

}
