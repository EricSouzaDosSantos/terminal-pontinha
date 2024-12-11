package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<User> usuarios = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final File arquivo = new File("src/main/resources/usuarios.txt");

    public static void main(String[] args) {
        carregarUsuariosDoArquivo();

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Exibir alunos cadastrados");
            System.out.println("3 - Buscar aluno por nome ou matrícula");
            System.out.println("4 - atualizar aluno por nome  ou matricula");
            System.out.println("5 - deletar aluno pelo nome ou matricula");
            System.out.println("6 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    exibirAlunos();
                    break;
                case 3:
                    buscarAluno();
                    break;
                case 4:
                    atualizarAluno();
                    break;
                case 5:
                    deletarAluno();
                    break;
                case 6:
                    salvarUsuariosNoArquivo();
                    System.out.println("Fim do programa!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private static void cadastrarAluno() {
        System.out.println("\nDigite as informações do aluno:");

        System.out.print("Nome do aluno: ");
        String nomeAluno = scanner.nextLine();

        System.out.print("Número de matrícula do aluno: ");
        String numeroMatriculaAluno = scanner.nextLine();

        System.out.print("Nome do AQV: ");
        String nomeAQV = scanner.nextLine();

        System.out.print("Nome do coordenador: ");
        String nomeCoordenador = scanner.nextLine();

        System.out.print("Número de matrícula do funcionário: ");
        String numeroMatriculaFuncionario = scanner.nextLine();

        User usuario = new User(nomeAluno, numeroMatriculaAluno, nomeAQV, nomeCoordenador, numeroMatriculaFuncionario);
        usuarios.add(usuario);
        salvarUsuariosNoArquivo();
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void exibirAlunos() {
        System.out.println("\nLista de alunos cadastrados:");
        System.out.println("Código | Nome | Matrícula | AQV | Coordenador | Matrícula Funcionário");
        for (User usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private static void buscarAluno() {
        System.out.println("\nBuscar aluno:");
        System.out.println("1 - Por nome");
        System.out.println("2 - Por número de matrícula");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                System.out.print("Digite o nome do aluno: ");
                String nome = scanner.nextLine();
                for (User usuario : usuarios) {
                    if (usuario.getNomeAluno().equalsIgnoreCase(nome)) {
                        System.out.println(usuario);
                    }
                }
                break;
            case 2:
                System.out.print("Digite o número de matrícula do aluno: ");
                String matricula = scanner.nextLine();
                for (User usuario : usuarios) {
                    if (usuario.getNumeroMatriculaAluno().equals(matricula)) {
                        System.out.println(usuario);
                    }
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    public static void deletarAluno(){
        System.out.println("\nAtualizar por aluno:");
        System.out.println("1 - Por nome");
        System.out.println("2 - Por número de matrícula");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                System.out.print("Digite o nome do aluno: ");
                String nome = scanner.nextLine();
                int id = 0;
                for (User usuario : usuarios) {
                    id++;
                    if (usuario.getNomeAluno().equalsIgnoreCase(nome)) {
                        usuarios.remove(id-1);
                    }
                }
            case 2:
                System.out.print("Digite o número de matrícula do aluno: ");
                String matricula = scanner.nextLine();
                id = 0;

                for (User usuario : usuarios) {
                    id++;
                    if (usuario.getNumeroMatriculaAluno().equals(matricula)) {
                        usuarios.remove(id-1);
                    }
                }
                break;
        }
        }


    public static void atualizarAluno(){
        System.out.println("\nAtualizar por aluno:");
        System.out.println("1 - Por nome");
        System.out.println("2 - Por número de matrícula");

        int escolha = scanner.nextInt();
        scanner.nextLine();

        switch (escolha) {
            case 1:
                System.out.print("Digite o nome do aluno: ");
                String nome = scanner.nextLine();
                int id = 0;
                for (User usuario : usuarios) {
                    id++;
                    if (usuario.getNomeAluno().equalsIgnoreCase(nome)) {
                        System.out.print("Nome do aluno: ");
                        String nomeAluno = scanner.nextLine();

                        System.out.print("Número de matrícula do aluno: ");
                        String numeroMatriculaAluno = scanner.nextLine();

                        System.out.print("Nome do AQV: ");
                        String nomeAQV = scanner.nextLine();

                        System.out.print("Nome do coordenador: ");
                        String nomeCoordenador = scanner.nextLine();

                        System.out.print("Número de matrícula do funcionário: ");
                        String numeroMatriculaFuncionario = scanner.nextLine();

                        User atualizarusuario = new User(nomeAluno, numeroMatriculaAluno, nomeAQV, nomeCoordenador, numeroMatriculaFuncionario);
                        usuarios.set(id, atualizarusuario);
                        salvarUsuariosNoArquivo();
                        System.out.println(usuario);
                        return;
                    }
                }
                break;
            case 2:
                System.out.print("Digite o número de matrícula do aluno: ");
                String matricula = scanner.nextLine();
                for (User usuario : usuarios) {
                    if (usuario.getNumeroMatriculaAluno().equals(matricula)) {
                        System.out.println(usuario);
                    }
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void salvarUsuariosNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (User usuario : usuarios) {
                writer.write(usuario.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar usuários: " + e.getMessage());
        }
    }

    private static void carregarUsuariosDoArquivo() {
        if (!arquivo.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" : ");
                if (partes.length == 6) {
                    User usuario = new User(partes[1], partes[2], partes[3], partes[4], partes[5]);
                    usuarios.add(usuario);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar usuários: " + e.getMessage());
        }
    }
}