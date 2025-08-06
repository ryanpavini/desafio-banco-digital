public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0; // Saldo inicial zerado
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            System.out.println("Saque não realizado. Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        } else {
            System.out.println("Transferência não realizada. Saldo insuficiente ou valor inválido.");
        }
    }

    // Getters para acesso externo às informações da conta
    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    // Método protegido para ser usado pelas classes filhas na impressão do extrato
    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
    }
}