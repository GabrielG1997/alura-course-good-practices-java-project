package br.com.alura.domain;

public class Pet {
    public Pet() {
    }
    public Pet( String tipo, String nome, String raca, int idade, String cor, Float peso ) {
        this.idade = idade;
        this.cor = cor;
        this.nome = nome;
        this.tipo = tipo;
        this.raca = raca;
        this.peso = peso;
    }

    private int idade;
    private String cor;
    private String nome;
    private String tipo;
    private String raca;
    private Float peso;
    private Long id;

    public int getIdade() {
        return idade;
    }
    public Long getId() {
        return id;
    }
    public String getCor() {
        return cor;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public String getRaca() {
        return raca;
    }
    public Float getPeso() {
        return peso;
    }
}
