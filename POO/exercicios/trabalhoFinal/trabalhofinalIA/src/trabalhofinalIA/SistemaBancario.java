package trabalhofinalIA;

import java.util.*;

public class SistemaBancario {
    private static Banco banco;

    public static void main(String[] args) {
        inicializarSistema();
        iniciarSistema();
    }

    private static void inicializarSistema() {
        banco = new Banco();
        banco.inicializarDados();
    }

    private static void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Sistema Bancário!");

        while (true) {
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            Usuario usuario = banco.autenticarUsuario(cpf, senha);
            if (usuario != null) {
                exibirMenu(usuario);
                break;
            }

            System.out.println("CPF ou senha inválidos. Tente novamente.");
        }
    }


/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SistemaBancario {
    private static Map<String, Cliente> clientes = new HashMap<>();
    private static Map<String, Funcionario> funcionarios = new HashMap<>();
    private static List<Conta> contas = new ArrayList<>();

    public static void main(String[] args) {
        // Aqui você pode carregar os dados do sistema a partir de um arquivo de texto
        // Por simplicidade, vou adicionar alguns dados diretamente aqui
        inicializarDados();

        // Iniciar o sistema
        iniciarSistema();
    }

    private static void inicializarDados() {
        // Adicionar clientes
        clientes.put("12345678901", new Cliente("12345678901", "senha123"));
        clientes.put("98765432109", new Cliente("98765432109", "senha456"));

        // Adicionar funcionários
        funcionarios.put("11111111111", new Gerente("11111111111", "senhaGerente", "Agencia1"));
        funcionarios.put("22222222222", new Diretor("22222222222", "senhaDiretor"));
        funcionarios.put("33333333333", new Presidente("33333333333", "senhaPresidente"));

        // Adicionar contas
        contas.add(new ContaCorrente("12345678901", "Agencia1"));
        contas.add(new ContaPoupanca("98765432109", "Agencia2"));
    }

    static void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao Sistema Bancário!");

   
       // Autenticação do usuário
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // Verificar se é cliente
        Cliente cliente = clientes.get(cpf);
        if (cliente != null && cliente.getSenha().equals(senha)) {
            exibirMenuCliente();
            return;
        }

        // Verificar se é funcionário
        Funcionario funcionario = funcionarios.get(cpf);
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            exibirMenuFuncionario(funcionario);
            return;
        }

        System.out.println("CPF ou senha inválidos. Tente novamente.");
    }

    private static void exibirMenuCliente(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu do Cliente:");
        // Implemente as opções do menu para o cliente
        while (true) {
            System.out.println("1. Movimentações na Conta");
            System.out.println("2. Relatórios");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    exibirMenuMovimentacoes(cliente);
                    break;
                case 2:
                    exibirMenuRelatorios(cliente);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    ivate static void exibirMenuMovimentacoes(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Movimentações na Conta:");
        System.out.println("1. Saque");
        System.out.println("2. Depósito");
        System.out.println("3. Transferência para outra conta");
        System.out.println("4. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                realizarSaque(cliente);
                break;
            case 2:
                realizarDeposito(cliente);
                break;
            case 3:
                realizarTransferencia(cliente);
                break;
            case 4:
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void realizarSaque(Cliente cliente) {
        // Implementar lógica para saque
    }

    private static void realizarDeposito(Cliente cliente) {
        // Implementar lógica para depósito
    }

    private static void realizarTransferencia(Cliente cliente) {
        // Implementar lógica para transferência
    }
    
    rivate static void exibirMenuRelatorios(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Relatórios:");
        System.out.println("1. Saldo");
        System.out.println("2. Relatório de tributação da conta corrente");
        System.out.println("3. Relatório de rendimento da poupança");
        System.out.println("4. Desafio - Contratar seguro de vida");
        System.out.println("5. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                imprimirSaldo(cliente);
                break;
            case 2:
                gerarRelatorioTributacao(cliente);
                break;
            case 3:
                gerarRelatorioRendimentoPoupanca(cliente);
                break;
            case 4:
                contratarSeguroVida(cliente);
                break;
            case 5:
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void imprimirSaldo(Cliente cliente) {
        // Implementar lógica para imprimir saldo
    }

    private static void gerarRelatorioTributacao(Cliente cliente) {
        // Implementar lógica para gerar relatório de tributação
    }

    private static void gerarRelatorioRendimentoPoupanca(Cliente cliente) {
        // Implementar lógica para gerar relatório de rendimento da poupança
    }

    private static void contratarSeguroVida(Cliente cliente) {
        // Implementar lógica para contratar seguro de vida
    }
    private static void exibirMenuFuncionario(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu do " + funcionario.getCargo() + ":");
        // Implemente as opções do menu para o funcionário
    }
}*/
