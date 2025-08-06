public class Main {
    public static void main(String[] args) {
        // Criando o banco
        Banco bancoDigital = new Banco("Banco Digital G-Bank");

        // Criando clientes
        Cliente venilton = new Cliente("Venilton");
        Cliente gleyson = new Cliente("Gleyson");

        // Criando contas para os clientes
        IConta contaCorrenteVenilton = new ContaCorrente(venilton);
        IConta contaPoupancaGleyson = new ContaPoupanca(gleyson);

        // Adicionando as contas ao banco
        bancoDigital.adicionarConta((Conta) contaCorrenteVenilton);
        bancoDigital.adicionarConta((Conta) contaPoupancaGleyson);

        // Realizando operações
        System.out.println("Realizando depósito na Conta Corrente...");
        contaCorrenteVenilton.depositar(500.75);

        System.out.println("\nRealizando transferência da Conta Corrente para a Poupança...");
        contaCorrenteVenilton.transferir(200.50, contaPoupancaGleyson);

        // Imprimindo extratos
        System.out.println("\n--- Extratos Individuais ---");
        contaCorrenteVenilton.imprimirExtrato();
        System.out.println(); // Apenas para espaçamento
        contaPoupancaGleyson.imprimirExtrato();

        // Listando clientes do banco
        System.out.println("\n---------------------------------");
        bancoDigital.listarClientes();
        System.out.println("---------------------------------");
    }
}