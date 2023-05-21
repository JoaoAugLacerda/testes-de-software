public class Poupanca extends Conta {
    private double saldoPoupanca;

    public Poupanca(double saldoInicial) {
        super(saldoInicial);
    }

    public void investirPoupanca(double valor) {
        if(valor > 0) {
            if(valor <= saldo) {
                sacar(valor);
                saldoPoupanca += valor;
                System.out.println("Investimento realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para investimento.");
            }
        } else {
            System.out.println("O valor do investimento deve ser positivo.");
        }
    }

    public void sacarInvestimento(double valor) {
        if(valor > 0) {
            if(valor <= saldoPoupanca) {
                saldoPoupanca -= valor;
                depositar(valor);
                System.out.println("Investimento sacado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente no investimento.");
            }
        } else {
            System.out.println("O valor do saque do investimento deve ser positivo.");
        }
    }

    public double saldoPoupanca() {
        return saldoPoupanca;
    }
}