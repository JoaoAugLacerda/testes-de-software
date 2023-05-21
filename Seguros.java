public class Seguros {
    private Pessoa pessoa;

    public Seguros(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void contratar(String tipoSeguro) {
        if(tipoSeguro.equalsIgnoreCase("carro")) {
            if(pessoa.getContaCorrente().verSaldo() >= 150) {
                pessoa.getContaCorrente().sacar(150);
                System.out.println("Seguro de carro contratado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para contratar seguro de carro.");
            }
        } else if(tipoSeguro.equalsIgnoreCase("moto")) {
            if(pessoa.getContaCorrente().verSaldo() >= 100) {
                pessoa.getContaCorrente().sacar(100);
                System.out.println("Seguro de moto contratado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para contratar seguro de moto.");
            }
        } else {
            System.out.println("Tipo de seguro não reconhecido.");
        }
    }
}
