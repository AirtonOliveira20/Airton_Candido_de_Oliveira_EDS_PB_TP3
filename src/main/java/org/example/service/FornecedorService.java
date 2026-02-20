package org.example.service;

import org.example.entity.Fornecedor;
import org.example.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/*Injetar dentro da camada de serviço a camada de repositório = injeção de dependência */

@Service
public class FornecedorService {
    private FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository){
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> findAll(){
        return (List<Fornecedor>) fornecedorRepository.findAll();
    }

    public Fornecedor findById(Integer id){
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        if(fornecedor.isPresent()){
            return fornecedor.get();
        }
        return null;
    }

    public void deleteFornecedor(Integer id){
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);
        if(fornecedor.isPresent()){
            fornecedorRepository.deleteById(id);

        }

    }
}
