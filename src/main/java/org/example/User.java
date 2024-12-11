package org.example;

public class User {
    private static int contadorCodigoUsuario = 1;

    private int codigoUsuario;
    private String nomeAluno;
    private String numeroMatriculaAluno;
    private String nomeAQV;
    private String nomeCoordenador;
    private String numeroMatriculaFuncionario;

    public User(String nomeAluno, String numeroMatriculaAluno, String nomeAQV, String nomeCoordenador, String numeroMatriculaFuncionario) {
        this.codigoUsuario = contadorCodigoUsuario++;
        this.nomeAluno = nomeAluno;
        this.numeroMatriculaAluno = numeroMatriculaAluno;
        this.nomeAQV = nomeAQV;
        this.nomeCoordenador = nomeCoordenador;
        this.numeroMatriculaFuncionario = numeroMatriculaFuncionario;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getNumeroMatriculaAluno() {
        return numeroMatriculaAluno;
    }

    @Override
    public String toString() {
        return codigoUsuario + " : " + nomeAluno + " : " + numeroMatriculaAluno + " : " + nomeAQV + " : " + nomeCoordenador + " : " + numeroMatriculaFuncionario;
    }
}
