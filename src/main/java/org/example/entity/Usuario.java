package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "operador")
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOperador;

    private String nomeOperador;
    private String emailOperador;
    private String loginOperador;
    private String senhaOperador;


    private String tipoOperador;

    // true = usuáriou ativo, false = usuário desativado
    private Boolean status;
}
