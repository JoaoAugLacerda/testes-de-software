public class Pessoa {
    private String nome;
    private String cpf;
    private Poupanca poupanca;
    private ContaCorrente contaCorrente;
    private CartaoCredito cartaoCredito;
    private Empresa empresa;

    public Pessoa(String nome, String cpf, Poupanca poupanca, ContaCorrente contaCorrente) {
        this.nome = nome;
        this.cpf = cpf;
        this.poupanca = poupanca;
        this.contaCorrente = contaCorrente;
        this.cartaoCredito = new CartaoCredito();
    }

    public void criarEmpresa(String nome, String cnpj, double saldoInicial) {
        this.empresa = new Empresa(nome, cnpj, saldoInicial);
    }

    public String verDadosPessoais() {
        return "Nome: " + nome + ", CPF: " + cpf;
    }

    public Poupanca getPoupanca() {
        return poupanca;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public Empresa getEmpresa() {
        return empresa;
    }
}