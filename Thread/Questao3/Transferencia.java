public class Transferencia extends Thread {

    private ContaBancaria conta1;
    private ContaBancaria conta2;
    private double valor;

    Transferencia(ContaBancaria conta1, ContaBancaria conta2, double valor) {
        this.conta1 = conta1;
        this.conta2 = conta2;
        this.valor = valor;
    }

    @Override
    public void run() {
        synchronized(conta1) {
            synchronized(conta2) {
                if (conta1.getSaldo() > this.valor) {
                    System.out.println("Transferiu R$" + this.valor + " da conta Bancária " + conta1 +" para Conta Bancária " + conta2);
                    conta1.setSaldo(conta1.getSaldo() - this.valor);
                    conta2.setSaldo(conta2.getSaldo() + this.valor);
                }else {
                    System.out.println(conta1 + " não possui saldo suficiente");
                }
            }
        }
    }

}