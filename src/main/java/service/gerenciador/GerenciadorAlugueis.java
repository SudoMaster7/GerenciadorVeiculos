package service.gerenciador;

import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author SUDO
 */
public class GerenciadorAlugueis {
    private final Set<Aluguel> alugueis;

    public GerenciadorAlugueis() {
        alugueis = new HashSet<>();
    }

    public void registrarAluguel(Cliente cliente, Veiculo veiculo, int dias) {
        Aluguel aluguel = new Aluguel(cliente, veiculo, LocalDate.now(), dias);
        if (alugueis.add(aluguel)) {  // Retorna true se o aluguel foi adicionado com sucesso
            System.out.println("Aluguel registrado com sucesso!");
        } else {
            System.out.println("Erro ao registrar aluguel. Possível duplicidade.");
        }
    }

    public void listarAlugueis() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel registrado.");
        } else {
            for (Aluguel aluguel : alugueis) {
                System.out.println(aluguel);
            }
        }
    }
}
