public class Emprestimo {
    private double valor;
    private static final double JUROS = 0.003;

    public Emprestimo(double valor) {
        this.valor = valor + (valor * JUROS);
    }

    public double getValor() {
        return this.valor;
    }
}