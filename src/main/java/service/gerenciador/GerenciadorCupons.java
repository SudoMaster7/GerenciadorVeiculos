package service.gerenciador;

import java.util.ArrayList;
import java.util.List;
import model.Cupom;

public class GerenciadorCupons<T extends Cupom> {  // Usando Generics
    private List<T> cupons;

    public GerenciadorCupons() {
        cupons = new ArrayList<>();
    }

    // Método para gerar um cupom
    public void gerarCupom(String codigo, double percentual) {
        T cupom = (T) new Cupom(codigo, percentual);  // Usando Generics
        cupons.add(cupom);
    }

    // Método para validar um cupom com Lambda
    public Double validarCupom(String codigo) {
        return cupons.stream()  // Usando Stream
                     .filter(cupom -> cupom.validarCupom(codigo))  // Função Lambda para validar o cupom
                     .map(Cupom::getPercentualDesconto)  // Mapeando o percentual do desconto
                     .findFirst()  // Pega o primeiro resultado válido
                     .orElse(null);  // Retorna null se não encontrar
    }

    // Método para listar os cupons cadastrados com Lambda
    public void listarCupons() {
        if (cupons.isEmpty()) {
            System.out.println("Nenhum cupom cadastrado.");
        } else {
            cupons.forEach(cupom -> System.out.println(cupom));  // Função Lambda para exibir cupons
        }
    }
}
