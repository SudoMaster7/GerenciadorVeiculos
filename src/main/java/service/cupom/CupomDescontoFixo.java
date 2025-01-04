
package service.cupom;

/**
 *
 * @author SUDO
 */
public class CupomDescontoFixo implements CupomDesconto{
    private double valorDesconto; // Valor fixo de desconto (ex: 50)

    public CupomDescontoFixo(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal - valorDesconto; // Aplica o desconto fixo
    }

    // Getter e Setter
    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }
}
