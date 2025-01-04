package model;

public class Cupom {
    private String codigo;
    private double percentualDesconto;

    // Construtor
    public Cupom(String codigo, double percentualDesconto) {
        this.codigo = codigo;
        this.percentualDesconto = percentualDesconto;
    }

    // Getter e Setter para 'codigo'
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Getter e Setter para 'percentualDesconto'
    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    // Método para validar o cupom
    public boolean validarCupom(String codigo) {
        return this.codigo.equals(codigo);
    }

    // Método toString para exibir as informações do cupom com o percentual de desconto formatado
    @Override
    public String toString() {
        // Formatar o percentual de desconto como porcentagem (multiplicando por 100)
        double percentualFormatado = this.percentualDesconto * 100;
        return "Cupom [Codigo: " + codigo + ", Desconto: " + String.format("%.2f", percentualFormatado) + "%]";
    }
}
