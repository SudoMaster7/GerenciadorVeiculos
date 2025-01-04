package model;
import java.time.LocalDate;

/**
 *
 * @author SUDO
 */
public class Aluguel {
    private Cliente cliente;
    private Veiculo veiculo;
    private LocalDate dataInicio;
    private int duracaoDias;
    private double valorTotal;

    public Aluguel(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, int duracaoDias) {
        if (duracaoDias <= 0) {
            throw new IllegalArgumentException("A duração do aluguel deve ser maior que zero.");
        }
        if (dataInicio.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de início não pode ser uma data futura.");
        }
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.duracaoDias = duracaoDias;
        this.valorTotal = veiculo.calcularAluguel(duracaoDias);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setDuracaoDias(int duracaoDias) {
        if (duracaoDias <= 0) {
            throw new IllegalArgumentException("A duração do aluguel deve ser maior que zero.");
        }
        this.duracaoDias = duracaoDias;
        this.valorTotal = veiculo.calcularAluguel(duracaoDias);  // Recalcula o valor total
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "cliente=" + cliente.getNome() +
                ", veiculo=" + veiculo.getModelo() +
                ", dataInicio=" + dataInicio +
                ", duracaoDias=" + duracaoDias +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
