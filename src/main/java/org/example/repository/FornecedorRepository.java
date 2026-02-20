package org.example.repository;

import org.example.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

/*Essa interface é a camada de persistência, onde os dados serão gravados */

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

}
