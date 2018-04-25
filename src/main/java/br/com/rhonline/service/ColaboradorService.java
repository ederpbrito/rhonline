package br.com.rhonline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rhonline.model.Colaborador;
import br.com.rhonline.model.Logradouro;
import br.com.rhonline.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	

    @Autowired
    private ColaboradorRepository repository;
    
    public Iterable<Colaborador> buscarFuncionarios() {
    	return repository.findAll();
	}

    public Double calcularSalario(String cpf){
        //TODO Calcular o salario do colaborador
        return 0.0;
    }

    public void save(Colaborador colaborador) throws Exception {
		validar(colaborador);
		repository.save(colaborador);
	}

    private void validar(Colaborador colaborador) throws Exception {
        if(!isCPFValido(colaborador.getCpf())){
            throw new Exception("CPF inválido");
        }

        if(!isRGValido(colaborador.getRg())){
            throw new Exception("RG inválido");
        }

        if(!isCepValdio(colaborador.getLogradouro())){
            throw new Exception("");
        }
    }

    private boolean isCepValdio(Logradouro logradouro) {
        return true;
    }

    private boolean isRGValido(String rg) {
        return true;
    }

    private boolean isCPFValido(String cpf) {
        return true;
    }	
}
