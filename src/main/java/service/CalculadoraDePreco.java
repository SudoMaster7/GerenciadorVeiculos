
package service;

/**
 *
 * @author SUDO
 */
public class CalculadoraDePreco {
     public void exibirPrecoComDesconto(double valorOriginal, double desconto) {
        double valorComDesconto = valorOriginal * desconto;
        System.out.println("\n--- Detalhes do Aluguel ---");
        System.out.println("Valor original (sem desconto): R$" + valorOriginal);
        System.out.println("Valor do desconto: R$" + (valorOriginal - valorComDesconto));
        System.out.println("Valor final (com desconto): R$" + valorComDesconto);
    }
     
     public double calcularValorComDesconto(double valorOriginal, double desconto) {
        return valorOriginal * desconto;
    }
}
