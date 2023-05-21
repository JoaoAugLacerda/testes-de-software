public class CartaoCredito {
    private double limite;
    private double saldoUsado;

    public CartaoCredito() {
        this.limite = 500.00;
    }

    public boolean usarCartao(double valor) {
        if (valor <= (limite - saldoUsado)) {
            saldoUsado += valor;
            System.out.println("Pagamento de " + valor + " realizado com sucesso no cartão de crédito.");
            return true;
        } else {
            System.out.println("Saldo insuficiente no cartão de crédito.");
            return false;
        }
    }

    public double verSaldo() {
        return limite - saldoUsado;
    }
}