
package service.cupom;

/**
 *
 * @author SUDO
 */
public class CupomDescontoPercentual implements CupomDesconto{
    private double percentual; // Percentual de desconto (ex: 0.1 para 10%)

    public CupomDescontoPercentual(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal * (1 - percentual); // Aplica o desconto percentual
    }

    // Getter e Setter
    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    } 
}
