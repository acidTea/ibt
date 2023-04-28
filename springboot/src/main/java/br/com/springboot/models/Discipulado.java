package br.com.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discipulado")
public class Discipulado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_GRUPO_DISCIPULADO")
    private Long id;
    
    @Column(name = "NOME_GRUPO_DISCIPULADO")
    private String name;

    @OneToMany(mappedBy = "discipulado")
    private List<Membro> membros;
    
    @Column(name = "DIA_GRUPO_DISCIPULADO")
    private String diaGrupo;

    @Column(name = "HORA_GRUPO_DISCIPULADO")
    private String horaGrupo;

    @Column(name = "LOCAL_GRUPO_DISCIPULADO")
    private String localGrupo;
    
    @Column(name = "STATUS_GRUPO_DISCIPULADO")
    private String status;

    @Column(name = "DATA_CRIACAO_GRUPO_DISCIPULADO")
    private Date dataCriacao;

    
}
