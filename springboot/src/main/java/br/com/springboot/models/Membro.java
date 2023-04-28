package br.com.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "membro")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_MEMBRO")
    private Long id;
    
    @Column(name = "NOME_MEMBRO")
    private String name;

    @Column(name = "NOME_EXIBICAO_MEMBRO")
    private String userName;
    
    @Column(name = "DATA_INGRESSO_MEMBRO")
    private Date dataIngresso;

    @Column(name = "DATA_NASCIMENTO_MEMBRO")
    private Date dataNascimento;

    @Column(name = "DATA_BATISMO_MEMBRO")
    private Date dataBatismo;

    @Column(name = "STATUS_MEMBRO")
    private String status;

    
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
   //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ID_GRUPO_DISCIPULADO")
    private Discipulado discipulado;
    
}
