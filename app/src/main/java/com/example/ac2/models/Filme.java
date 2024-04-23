package com.example.ac2.models;

public class Filme {
    private String titulo;
    private String sinopse;
    private String diretor;
    private int ano;
    private String imagems;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getImagems() {
        return imagems;
    }

    public void setImagems(String imagems) {
        this.imagems = imagems;
    }

    public Filme(String titulo, String sinopse, String diretor, int ano, String imagems) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.ano = ano;
        this.imagems = imagems;
    }

    public Filme() {
    }
}
