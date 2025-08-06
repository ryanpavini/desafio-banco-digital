import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void listarClientes() {
        System.out.println("=== Clientes do Banco " + this.nome + " ===");
        for (Conta conta : this.contas) {
            System.out.println("- " + conta.cliente.getNome());
        }
    }

    // Outros métodos poderiam ser adicionados, como buscar conta por número, etc.
}