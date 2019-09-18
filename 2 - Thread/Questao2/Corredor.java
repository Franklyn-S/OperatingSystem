public class Corredor extends Thread{
    private String nome;
    private int tamanhoTrajetoMetros;
    private int tempoDescansoMedio;

    public Corredor(String nome, int tamanhoTrajetoMetros, int tempoDescansoMedio) {
        this.nome = nome;
        this.tamanhoTrajetoMetros = tamanhoTrajetoMetros;
        this.tempoDescansoMedio = tempoDescansoMedio;
    }

    @Override
    public void run() {
        for (int trajetoRestante = this.tamanhoTrajetoMetros; trajetoRestante > 0; trajetoRestante--) {
            System.out.println("Faltam " + trajetoRestante + " metros para o " + this.nome);
            System.out.println("O Corredor " + this.nome + " está descansando");
            
            try {
                sleep(this.tempoDescansoMedio*1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
}