public class ContaCorrente extends Conta {
    private Emprestimo emprestimo;
    private boolean jaFezEmprestimo = false;
    private double saldoEuro;
    private double saldoDolar;

    public static final double TAXA_EURO = 0.84; // taxa de conversão do real para euro
    public static final double TAXA_DOLAR = 0.19; // taxa de conversão do real para dólar

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
        this.saldoEuro = saldoInicial * TAXA_EURO;
        this.saldoDolar = saldoInicial * TAXA_DOLAR;
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor);
        this.saldoEuro += valor * TAXA_EURO;
        this.saldoDolar += valor * TAXA_DOLAR;
    }

    @Override
    public void sacar(double valor) {
        super.sacar(valor);
        this.saldoEuro -= valor * TAXA_EURO;
        this.saldoDolar -= valor * TAXA_DOLAR;
    }

    public double verSaldoReal() {
        return this.saldo;

    }

    public double verSaldoEuro() {
        return this.saldoEuro;

    }

    public double verSaldoDolar() {
        return this.saldoDolar;

    }

    public boolean fazerEmprestimo(double valor) {
        if (!jaFezEmprestimo) {
            this.emprestimo = new Emprestimo(valor);
            this.saldo += emprestimo.getValor();
            jaFezEmprestimo = true;
            return true;
        } else {
            System.out.println("Você já fez um empréstimo anteriormente.");
            return false;
        }
    }

    public double verSaldoEmprestimo() {
        return (emprestimo != null) ? emprestimo.getValor() : 0.0;
    }

    public static double getTaxaEuro() {
        return TAXA_EURO;
    }

    public static double getTaxaDolar() {
        return TAXA_DOLAR;
    }
}
