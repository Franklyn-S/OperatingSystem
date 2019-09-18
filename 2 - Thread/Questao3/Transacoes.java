public class Transacoes {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("Franklyn", 15);
        ContaBancaria conta2 = new ContaBancaria("Natalia", 100);

        Deposito depConta1 = new Deposito(conta1, 80);
        Saque saqConta1 = new Saque(conta1, 30);
        Transferencia trasnfConta1Conta2 = new Transferencia(conta1, conta2, 45);
        
        
        depConta1.start();
        saqConta1.start();
        trasnfConta1Conta2.start();

    }
}