package model;

/**
 *
 * @author SUDO
 */
public class Carro extends Veiculo {
    private String tipoCarroceria;

    public Carro(String placa, String modelo, String marca, int ano, double precoPorDia, String tipoCarroceria) {
        super(placa, modelo, marca, ano, precoPorDia);
        if (tipoCarroceria == null || tipoCarroceria.trim().isEmpty()) {
            System.out.println("Erro: Tipo de carroceria não pode ser vazio.");
            this.tipoCarroceria = "Desconhecido"; // Valor padrão para evitar erro
        } else {
            this.tipoCarroceria = tipoCarroceria;
        }
    }

    @Override
    public double calcularAluguel(int dias) {
        // Garantir que os dias sejam positivos
        if (dias <= 0) {
            System.out.println("Erro: A quantidade de dias de aluguel deve ser maior que zero.");
            return 0;  // Retorna zero em caso de erro
        }
        return dias * getPrecoPorDia();
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        if (tipoCarroceria == null || tipoCarroceria.trim().isEmpty()) {
            System.out.println("Erro: Tipo de carroceria não pode ser vazio.");
        } else {
            this.tipoCarroceria = tipoCarroceria;
        }
    }

    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + getPlaca() + '\'' +
                ", modelo='" + getModelo() + '\'' +
                ", marca='" + getMarca() + '\'' +
                ", ano=" + getAno() +
                ", precoPorDia=" + getPrecoPorDia() +
                ", tipoCarroceria='" + tipoCarroceria + '\'' +
                '}';
    }
}
