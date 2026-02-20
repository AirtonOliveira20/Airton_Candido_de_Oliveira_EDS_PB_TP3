package org.example;

import org.example.entity.Fornecedor;
import org.example.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/*Injetar dentro da camada de serviço a camada de repositório = injeção de dependência */

@Service
public class FornecedorService {
    private FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> consultarFornecedoresDb(){
        return fornecedorRepository.findAll();
    }
}
