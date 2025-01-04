
package model;

/**
 *
 * @author SUDO
 */
public abstract class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private double precoPorDia;

    public Veiculo(String placa, String modelo, String marca, int ano, double precoPorDia) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.precoPorDia = precoPorDia;
    }
    
    public abstract double calcularAluguel(int dias);

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPrecoPorDia() {
        return precoPorDia;
    }

    public void setPrecoPorDia(double precoPorDia) {
        this.precoPorDia = precoPorDia;
    }

    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", ano=" + ano + ", precoPorDia=" + precoPorDia + '}';
    }
    
}
