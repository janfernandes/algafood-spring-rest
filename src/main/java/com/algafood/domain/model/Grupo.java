package com.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tbl_grupo")
public class Grupo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(name = "tbl_grupo_permissao",
            joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private List<Permissao> permissoes = new ArrayList<>();

    public boolean desassociarPermissao(Permissao permissao) {
        return this.getPermissoes().remove(permissao);
    }

    public boolean associarPermissao(Permissao permissao) {
        return this.getPermissoes().add(permissao);
    }
}
