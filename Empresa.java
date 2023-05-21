public class Empresa {
    private String nome;
    private String cnpj;
    private ContaCorrente contaCorrente;

    public Empresa(String nome, String cnpj, double saldoInicial) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contaCorrente = new ContaCorrente(saldoInicial);
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }
}