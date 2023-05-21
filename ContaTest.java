import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ContaTest {
    @Test
    public void testCriarConta() {
        // Cria uma nova conta com saldo inicial de 100
        ContaCorrente conta = new ContaCorrente(100);

        // Verifica se a conta foi criada corretamente
        assertEquals(100, conta.verSaldoReal(), "O saldo inicial deve ser 100");
        assertEquals(100 * ContaCorrente.getTaxaEuro(), conta.verSaldoEuro(),
                "O saldo em euro deve ser o saldo inicial em reais convertido para euro");
        assertEquals(100 * ContaCorrente.getTaxaDolar(), conta.verSaldoDolar(),
                "O saldo em dolar deve ser o saldo inicial em reais convertido para dolar");
    }

    @Test
    public void testDepositarDinheiro() {
        // Cria a conta com um saldo inicial
        ContaCorrente conta = new ContaCorrente(100.0);

        // Deposita dinheiro na conta
        conta.depositar(50.0);

        // Verifica se o saldo após o depósito é o esperado
        assertEquals(150.0, conta.verSaldoReal(), "O saldo após o depósito deve ser 150.0");

        // Verifica se o saldo em outras moedas é o esperado
        assertEquals(150.0 * ContaCorrente.getTaxaEuro(), conta.verSaldoEuro(),
                "O saldo em euro deve ser o saldo em reais convertido para euro");
        assertEquals(150.0 * ContaCorrente.getTaxaDolar(), conta.verSaldoDolar(),
                "O saldo em dolar deve ser o saldo em reais convertido para dolar");
    }

    @Test
    public void testSacarDinheiro_SaldoSuficiente() {
        // Cria a conta com um saldo inicial
        ContaCorrente conta = new ContaCorrente(100.0);

        // Saca dinheiro da conta
        conta.sacar(50.0);

        // Verifica se o saldo após o saque é o esperado
        assertEquals(50.0, conta.verSaldoReal(), "O saldo após o saque deve ser 50.0");
    }

    @Test
    public void testSacarDinheiro_SaldoInsuficiente() {
        // Cria a conta com um saldo inicial
        ContaCorrente conta = new ContaCorrente(100.0);

        // Tenta sacar uma quantia maior que o saldo
        conta.sacar(150.0);

        // Verifica se o saldo permanece o mesmo após uma tentativa de saque malsucedida
        assertEquals(100.0, conta.verSaldoReal(),
                "O saldo deve permanecer o mesmo após uma tentativa de saque malsucedida");
    }

    @Test
    public void testVerificarSaldo() {
        // Cria a conta com um saldo inicial
        ContaCorrente conta = new ContaCorrente(100.0);

        // Verifica se o saldo é o esperado
        assertEquals(100.0, conta.verSaldoReal(), "O saldo deve ser igual ao saldo inicial");
    }

    @Test
    public void testVerificarSaldo_AposDepositoESaque() {
        // Cria a conta com um saldo inicial
        ContaCorrente conta = new ContaCorrente(100.0);

        // Deposita dinheiro na conta
        conta.depositar(50.0);

        // Verifica se o saldo após o depósito é o esperado
        assertEquals(150.0, conta.verSaldoReal(), "O saldo após o depósito deve ser 150.0");

        // Saca dinheiro da conta
        conta.sacar(70.0);

        // Verifica se o saldo após o saque é o esperado
        assertEquals(80.0, conta.verSaldoReal(), "O saldo após o saque deve ser 80.0");
    }

    @Test
    public void testRealizarEmprestimo_PrimeiroEmprestimo() {
        // Cria a conta com um saldo inicial
        ContaCorrente conta = new ContaCorrente(100.0);

        // Faz um empréstimo
        boolean sucesso = conta.fazerEmprestimo(50.0);

        // Verifica se o empréstimo foi bem-sucedido
        assertTrue(sucesso, "O primeiro empréstimo deve ser bem-sucedido");

        // Verifica se o saldo após o empréstimo é o esperado
        assertEquals(150.15, conta.verSaldoReal(), "O saldo após o empréstimo deve ser 150.15");
    }

    @Test
    public void testRealizarEmprestimo_SegundoEmprestimo() {
        // Cria a conta com um saldo inicial
        ContaCorrente conta = new ContaCorrente(100.0);

        // Faz um primeiro empréstimo
        conta.fazerEmprestimo(50.0);

        // Tenta fazer um segundo empréstimo
        boolean sucesso = conta.fazerEmprestimo(50.0);

        // Verifica se o segundo empréstimo falhou
        assertFalse(sucesso, "Um segundo empréstimo não deve ser permitido");

        // Verifica se o saldo após a tentativa de segundo empréstimo é o esperado
        assertEquals(150.15, conta.verSaldoReal(), "O saldo após a tentativa de segundo empréstimo deve ser 150.15");
    }

    @Test
    public void testUsarCartaoCredito_DentroDoLimite() {
        // Cria o cartão de crédito
        CartaoCredito cartao = new CartaoCredito();

        // Usa o cartão de crédito
        boolean sucesso = cartao.usarCartao(400.0);

        // Verifica se a operação foi bem-sucedida
        assertTrue(sucesso, "A operação deve ser bem-sucedida");

        // Verifica se o limite do cartão de crédito foi reduzido pelo valor da operação
        assertEquals(100.0, cartao.getLimite(),
                "O limite do cartão de crédito deve ser reduzido pelo valor da operação");
    }

    @Test
    public void testUsarCartaoCredito_AcimaDoLimite() {
        // Cria o cartão de crédito
        CartaoCredito cartao = new CartaoCredito();

        // Tenta usar o cartão de crédito
        boolean sucesso = cartao.usarCartao(600.0);

        // Verifica se a operação falhou
        assertFalse(sucesso, "A operação deve falhar");

        // Verifica se o limite do cartão de crédito permaneceu o mesmo
        assertEquals(500.0, cartao.getLimite(), "O limite do cartão de crédito deve permanecer o mesmo");
    }

    @Test
    public void testContratarSeguroCarro_SaldoSuficiente() {
        // Cria uma conta corrente com saldo inicial suficiente para contratar seguro de
        // carro
        ContaCorrente conta = new ContaCorrente(200.0);

        // Cria uma conta poupança com saldo inicial de 0
        Poupanca poupanca = new Poupanca(0.0);

        // Cria uma pessoa com a conta criada
        Pessoa pessoa = new Pessoa("12345678901", "João", poupanca, conta);

        // Cria o seguro para a pessoa
        Seguros seguro = new Seguros(pessoa);

        // Contrata o seguro de carro
        seguro.contratar("carro");

        // Verifica se o saldo da conta foi reduzido pelo valor do seguro
        assertEquals(50.0, conta.verSaldoReal(), 0.001, "O saldo da conta deve ser reduzido pelo valor do seguro");
    }

    @Test
    public void testContratarSeguroCarro_SaldoInsuficiente() {
        // Cria uma conta corrente com saldo inicial insuficiente para contratar seguro
        // de carro
        ContaCorrente conta = new ContaCorrente(100.0);

        // Cria uma conta poupança com saldo inicial de 0
        Poupanca poupanca = new Poupanca(0.0);

        // Cria uma pessoa com a conta criada
        Pessoa pessoa = new Pessoa("12345678901", "João", poupanca, conta);

        // Cria o seguro para a pessoa
        Seguros seguro = new Seguros(pessoa);

        // Tenta contratar o seguro de carro
        seguro.contratar("carro");

        // Verifica se o saldo da conta permaneceu o mesmo
        assertEquals(100.0, conta.verSaldoReal(), 0.001, "O saldo da conta deve permanecer o mesmo");
    }
}
