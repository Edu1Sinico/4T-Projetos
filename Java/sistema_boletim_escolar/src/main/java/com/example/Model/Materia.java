package com.example.Model;

public class Materia {

    // Atributos
    private int id;
    private String nomeMateria;
    private double nota1;
    private double nota2;
    private double nota3;
    private double media;
    private String cpfProfessor; // Foreign Key do CPF do professor
    private String raAluno; // Foreign key do RA do aluno

    // Construtor
    public Materia(int id, String nomeMateria, double nota1, double nota2, double nota3, double media, String cpfProfessor, String raAluno) {
        this.id = id;
        this.nomeMateria = nomeMateria;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.media = media;
        this.cpfProfessor = cpfProfessor;
        this.raAluno = raAluno;
    }

    // Métodos Getters & Setters
    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public String getRaAluno() {
        return raAluno;
    }

    public void setRaAluno(String raAluno) {
        this.raAluno = raAluno;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
