public class Deposito extends Thread {

    private ContaBancaria conta;
    private double valor;

    Deposito(ContaBancaria conta, double valor) {
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public void run() {
        synchronized(conta) {
            System.out.println("Deposito de R$ " + this.valor +
            " na conta de " + conta.getNome() + " realizado com sucesso!");
            conta.setSaldo(conta.getSaldo() + this.valor);
        }
    }



}