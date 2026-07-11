package com.mariabeatriz.wishlist;

import jakarta.persistence.*;
import jakarta.persistence.Column;

/**
 * Representa um item da wishlist.
 * Cada item contém informações como nome, preço, link, imagem e prioridade.
 */

@Entity
public class Item {

    /** Identificador único gerado automaticamente pelo banco de dados. */
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )

    private Long id;

    /** Nome do item desejado. */
    private String nome;

    /** Preço do item. */
    private double preco;

    /** Link para o produto. */
    @Column(length = 1000)
    private String link;

    /** Prioridade do item (ex: Urgente, Média, Sonho). */
    private String prioridade;

    /** URL da imagem do item. */
    @Column(length = 1000)
    private String imagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
