public class Saque extends Thread {
    private ContaBancaria conta;
    private double valor;

    Saque(ContaBancaria conta, double valor) {
        this.conta = conta;
        this.valor = valor;
    }

    @Override
    public void run() {
        synchronized(conta) {
            if (conta.getSaldo() >= this.valor) {
                System.out.println("Saque de R$ " + this.valor +  " realizado com sucesso!");
                conta.setSaldo(conta.getSaldo() - this.valor);
            }else {
                System.out.println("Você não possui saldo suficiente para sacar R$ " + this.valor);
            }
        }
    }
}