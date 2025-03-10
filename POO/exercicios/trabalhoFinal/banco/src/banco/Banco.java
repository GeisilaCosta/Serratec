package banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;
    private List<Conta> contas;
    private List<Gerente> gerentes;
    private List<Diretor> diretores;
    private List<Presidente> presidentes;
    private static Scanner scanner = new Scanner(System.in);

    public Banco() {
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        contas = new ArrayList<>();
        gerentes = new ArrayList<>(); // Adicionando inicialização das listas
        diretores = new ArrayList<>();
        presidentes = new ArrayList<>();
    }

    // Métodos para adicionar clientes, funcionários e contas
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        if (funcionario instanceof Gerente) {
            gerentes.add((Gerente) funcionario);
        } else if (funcionario instanceof Diretor) {
            diretores.add((Diretor) funcionario);
        } else if (funcionario instanceof Presidente) {
            presidentes.add((Presidente) funcionario);
        }
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    // Métodos para buscar clientes, funcionários e contas
    public boolean validarCliente(String cpf, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarGerente(String cpf, String senha) {
        for (Gerente gerente : gerentes) {
            if (gerente.getCpf().equals(cpf) && gerente.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarDiretor(String cpf, String senha) {
        for (Diretor diretor : diretores) {
            if (diretor.getCpf().equals(cpf) && diretor.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarPresidente(String cpf, String senha) {
        for (Presidente presidente : presidentes) {
            if (presidente.getCpf().equals(cpf) && presidente.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public Funcionario buscarFuncionarioPorCPF(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : contas) {
            if (conta.numeroConta== numero) { // Corrigido para '=='
                return conta;
            }
        }
        return null;
    }

    // Método para realizar login de funcionário
    public Funcionario realizarLoginFuncionario(String cpf, String senha) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf) && funcionario.getSenha().equals(senha)) {
                return funcionario;
            }
        }
        return null;
    }

    // Método para realizar login de cliente
    public Cliente realizarLoginCliente(String cpf, String senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        return null;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Banco.scanner = scanner;
    }
}

