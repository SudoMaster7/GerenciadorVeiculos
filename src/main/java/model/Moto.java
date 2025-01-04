package model;

/**
 *
 * @author SUDO
 */
public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String placa, String modelo, String marca, int ano, double precoPorDia, int cilindradas) {
        super(placa, modelo, marca, ano, precoPorDia);
        try {
            if (cilindradas <= 0) {
                throw new IllegalArgumentException("O número de cilindradas deve ser maior que zero.");
            }
            this.cilindradas = cilindradas;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar a moto: " + e.getMessage());
            this.cilindradas = 1;  // Valor padrão para continuar
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

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        try {
            if (cilindradas <= 0) {
                throw new IllegalArgumentException("O número de cilindradas deve ser maior que zero.");
            }
            this.cilindradas = cilindradas;
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir as cilindradas: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Moto{"
                + "placa='" + getPlaca() + '\''
                + ", modelo='" + getModelo() + '\''
                + ", marca='" + getMarca() + '\''
                + ", ano=" + getAno()
                + ", precoPorDia=" + getPrecoPorDia()
                + ", cilindradas=" + cilindradas
                + '}';
    }
}
