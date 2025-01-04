package service.gerenciador;

import model.Veiculo;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorVeiculos<T extends Veiculo> {  // Usando Generics para permitir diferentes tipos de Veículos
    private Map<String, T> veiculos;
    
    public GerenciadorVeiculos(){
        veiculos = new HashMap<>();
    }
    
    // Método para adicionar um veículo
    public void adicionarVeiculo(T veiculo) {
        veiculos.put(veiculo.getPlaca(), veiculo);
    }

    // Método para buscar um veículo pela placa
    public T buscarVeiculo(String placa) {
        return veiculos.get(placa);
    }
    
    // Método para listar todos os veículos com Lambda
    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo disponível.");
        } else {
            veiculos.values().forEach(veiculo -> System.out.println(veiculo));  // Usando Lambda para iterar sobre os veículos
        }
    }
}
