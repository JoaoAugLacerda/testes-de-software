public class Main {
    public static void main(String[] args) {
        Poupanca minhaPoupanca = new Poupanca(200.00); // Criar conta poupança com saldo inicial de 200
        ContaCorrente minhaContaCorrente = new ContaCorrente(500.00); // Criar conta corrente com saldo inicial de 500
        Pessoa minhaPessoa = new Pessoa("João", "123.456.789-00", minhaPoupanca, minhaContaCorrente); // Criar uma pessoa com a poupança e a conta corrente
        Seguros meusSeguros = new Seguros(minhaPessoa); // Criar seguros para a pessoa

        // Testando a conta corrente
        minhaContaCorrente.depositar(100.00); // Depositar 100 na conta corrente
        System.out.println("Saldo da conta corrente após depósito: " + minhaContaCorrente.verSaldo());
        minhaContaCorrente.sacar(50.00); // Sacar 50 da conta corrente
        System.out.println("Saldo da conta corrente após saque: " + minhaContaCorrente.verSaldo());

        // Testando a poupança
        minhaPoupanca.depositar(100.00); // Depositar 100 na poupança
        System.out.println("Saldo da poupança após depósito: " + minhaPoupanca.verSaldo());
        minhaPoupanca.sacar(50.00); // Sacar 50 da poupança
        System.out.println("Saldo da poupança após saque: " + minhaPoupanca.verSaldo());

        // Testando a contratação de seguro
        meusSeguros.contratar("carro"); // Contratar seguro de carro
        System.out.println("Saldo da conta corrente após contratar seguro de carro: " + minhaContaCorrente.verSaldo());

        // Testando o cartão de crédito
        minhaPessoa.getCartaoCredito().usarCartao(200.00); // Usar o cartão para pagar 200
        System.out.println("Saldo do cartão de crédito após pagamento: " + minhaPessoa.getCartaoCredito().verSaldo());

        // Testando o empréstimo
        minhaContaCorrente.fazerEmprestimo(200.00); // Fazer um empréstimo de 200
        System.out.println("Saldo da conta corrente após empréstimo: " + minhaContaCorrente.verSaldo());

         // Testando a criação de uma empresa
         minhaPessoa.criarEmpresa("Minha Empresa", "12.345.678/0001-90", 1000.00);
         System.out.println("Saldo da conta corrente da empresa após a criação: " + minhaPessoa.getEmpresa().getContaCorrente().verSaldo());

          // Testando a consulta de saldo em diferentes moedas
        System.out.println("Saldo em reais: " + minhaContaCorrente.verSaldoReal());
        System.out.println("Saldo em euros: " + minhaContaCorrente.verSaldoEuro());
        System.out.println("Saldo em dólares: " + minhaContaCorrente.verSaldoDolar());
    }
}
