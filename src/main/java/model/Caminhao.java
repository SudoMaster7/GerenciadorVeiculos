package model;

/**
 *
 * @author SUDO
 */
public class Caminhao extends Veiculo {
    private double capacidadeCarga;

    public Caminhao(String placa, String modelo, String marca, int ano, double precoPorDia, double capacidadeCarga) {
        super(placa, modelo, marca, ano, precoPorDia);
        if (capacidadeCarga <= 0) {
            throw new IllegalArgumentException("A capacidade de carga do caminhão deve ser maior que zero.");
        }
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularAluguel(int dias) {
        // O cálculo do aluguel leva em consideração o preço por dia e a capacidade de carga
        return dias * getPrecoPorDia() + (capacidadeCarga * 10);  
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        if (capacidadeCarga <= 0) {
            throw new IllegalArgumentException("A capacidade de carga do caminhão deve ser maior que zero.");
        }
        this.capacidadeCarga = capacidadeCarga;
    }
    
    @Override
    public String toString() {
        return "Caminhao{" +
                "placa='" + getPlaca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", ano=" + getAno() +
                ", precoPorDia=" + getPrecoPorDia() +
                ", capacidadeCarga=" + capacidadeCarga +
                '}';
    }
}
