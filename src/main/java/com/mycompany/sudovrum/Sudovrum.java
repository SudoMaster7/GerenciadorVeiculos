package com.mycompany.sudovrum;

import service.gerenciador.GerenciadorCupons;
import service.gerenciador.GerenciadorAlugueis;
import service.gerenciador.GerenciadorVeiculos;
import model.*;
import service.*;

import java.util.Scanner;

public class Sudovrum {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            GerenciadorVeiculos gerenciadorVeiculos = new GerenciadorVeiculos();
            GerenciadorAlugueis gerenciadorAlugueis = new GerenciadorAlugueis();
            GerenciadorCupons<Cupom> gerenciadorCupons = new GerenciadorCupons<>();

            // Veiculos iniciais
            gerenciadorVeiculos.adicionarVeiculo(new Carro("ABC1234", "Civic", "Honda", 2020, 150.0, "Sedan"));
            gerenciadorVeiculos.adicionarVeiculo(new Moto("XYZ5678", "Ninja", "Kawasaki", 2019, 100.0, 600));
            gerenciadorVeiculos.adicionarVeiculo(new Caminhao("JKL9101", "Actros", "Mercedes", 2022, 300.0, 10.0));
            
            gerenciadorCupons.gerarCupom("Desconto10", 0.1); // Cupom de 10%
            gerenciadorCupons.gerarCupom("Desconto50", 0.5); // Cupom de 50%

            int opcao;
            
            do {
                System.out.println("\n=== Sistema de Aluguel de Veiculos ===");
                System.out.println("1. Listar Veiculos");
                System.out.println("2. Registrar Aluguel");
                System.out.println("3. Listar Alugueis");
                System.out.println("4. Gerar Cupom");
                System.out.println("5. Listar Cupons");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opcao: ");
                
                // Garantir que o usuário insira uma opção válida
                while (!scanner.hasNextInt()) {
                    System.out.println("Entrada invalida! Por favor, insira um numero.");
                    scanner.next(); // Limpa o buffer
                    System.out.print("Escolha uma opcao: ");
                }
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> gerenciadorVeiculos.listarVeiculos();

                    case 2 -> {
                        // Solicitar dados do cliente
                        System.out.print("Digite o nome do cliente: ");
                        scanner.nextLine(); // Limpa o buffer
                        String nome = scanner.nextLine();
                        
                        String cpf = "";
                        boolean cpfValido = false;
                        
                        // Validação do CPF
                        while (!cpfValido) {
                            System.out.print("Digite o CPF do cliente (somente numeros): ");
                            cpf = scanner.next();
                            
                            if (cpf.length() == 11 && cpf.matches("[0-9]+")) {
                                cpfValido = true;
                            } else {
                                System.out.println("CPF invalido! O CPF deve conter 11 digitos numericos.");
                            }
                        }

                        System.out.print("Digite o contato do cliente: ");
                        String contato = scanner.next();

                        Cliente cliente = new Cliente(nome, cpf, contato);

                        System.out.print("Digite a placa do veiculo: ");
                        String placa = scanner.next();
                        Veiculo veiculo = gerenciadorVeiculos.buscarVeiculo(placa);

                        if (veiculo == null) {
                            System.out.println("Veiculo nao encontrado!");
                        } else {
                            System.out.print("Digite a quantidade de dias para o aluguel: ");
                            int dias = scanner.nextInt();

                            System.out.print("Digite o codigo do cupom (ou pressione ENTER para pular): ");
                            scanner.nextLine(); // Limpa o buffer
                            String codigoCupom = scanner.nextLine();
                            
                            // Verificação de cupom
                            double desconto = 1.0; // Sem desconto por padrão
                            double valorOriginal = veiculo.calcularAluguel(dias);

                            if (!codigoCupom.isBlank()) {
                                Double percentualDesconto = gerenciadorCupons.validarCupom(codigoCupom);
                                if (percentualDesconto != null) {
                                    desconto = 1 - percentualDesconto;
                                    System.out.println("Cupom valido! Desconto aplicado.");
                                } else {
                                    System.out.println("Cupom invalido. Continuando sem desconto.");
                                }
                            }

                            double valorComDesconto = valorOriginal * desconto;
                            System.out.println("Valor original: R$ " + valorOriginal);
                            System.out.println("Valor com desconto: R$ " + valorComDesconto);

                            gerenciadorAlugueis.registrarAluguel(cliente, veiculo, dias);
                        }
                    }

                    case 3 -> gerenciadorAlugueis.listarAlugueis();

                    case 4 -> {
                        System.out.print("Digite o codigo do cupom: ");
                        String codigo = scanner.next();
                        System.out.print("Digite o percentual de desconto (entre 0 e 1): ");
                        String percentualInput = scanner.next().replace(",", ".");
                        double percentual;
                        
                        try {
                            percentual = Double.parseDouble(percentualInput);

                            if (percentual >= 0 && percentual <= 1) {
                                gerenciadorCupons.gerarCupom(codigo, percentual);
                                System.out.println("Cupom gerado com sucesso!");
                            } else{
                                System.out.println("Percentual invalido! Deve ser entre 0 e 1.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada invalida! Certifique-se de digitar um numero.");
                        }
                    }

                    case 5 -> gerenciadorCupons.listarCupons();
                        
                    case 0 -> System.out.println("Encerrando o sistema...");

                    default -> System.out.println("Opcao invalida!");
                }
            } while (opcao != 0);
        }
    }
}
