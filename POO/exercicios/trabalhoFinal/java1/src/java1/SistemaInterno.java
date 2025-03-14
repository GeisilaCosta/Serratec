package java1;

import java.util.Scanner;

public class SistemaInterno {
	    public static void main(String[] args) {
	    	private static Scanner scanner = new Scanner(System.in);

	        
	            // Simulação de autenticação do usuário (CPF e senha)
	            String tipoUsuario = autenticarUsuario();
	            
	            // Exibir menu correspondente ao tipo de usuário autenticado
	            switch (tipoUsuario) {
	                case "Cliente":
	                    menuCliente();
	                    break;
	                case "Gerente":
	                    menuGerente();
	                    break;
	                case "Diretor":
	                    menuDiretor();
	                    break;
	                case "Presidente":
	                    menuPresidente();
	                    break;
	                default:
	                    System.out.println("Tipo de usuário não reconhecido.");
	                    break;
	            }
	        }

	        public static String autenticarUsuario() {
	            System.out.println("=== Login ===");
	            System.out.print("CPF: ");
	            String cpf = scanner.nextLine();
	            System.out.print("Senha: ");
	            String senha = scanner.nextLine();

	            // Simulação de autenticação (substitua por sua lógica real)
	            if (cpf.equals("123456789") && senha.equals("senha_cliente")) {
	                return "Cliente";
	            } else if (cpf.equals("987654321") && senha.equals("senha_gerente")) {
	                return "Gerente";
	            } else if (cpf.equals("111222333") && senha.equals("senha_diretor")) {
	                return "Diretor";
	            } else if (cpf.equals("444555666") && senha.equals("senha_presidente")) {
	                return "Presidente";
	            } else {
	                System.out.println("CPF ou senha incorretos.");
	                return "";
	            }
	        }

	        public static void menuCliente() {
	            System.out.println("=== Menu do Cliente ===");
	            // Implemente as opções do menu para o Cliente
	        }

	        public static void menuGerente() {
	            System.out.println("=== Menu do Gerente ===");
	            // Implemente as opções do menu para o Gerente
	        }

	        public static void menuDiretor() {
	            System.out.println("=== Menu do Diretor ===");
	            // Implemente as opções do menu para o Diretor
	        }

	        public static void menuPresidente() {
	            System.out.println("=== Menu do Presidente ===");
	            // Implemente as opções do menu para o Presidente
	        }
	    
	    	
	    	
	        // Criando uma instância da classe Cliente
	        Cliente cliente = new Cliente("Geisila", "098765543322", 1000.00);

	        // Agora você pode chamar os métodos da classe Cliente usando o objeto 'cliente'
	        cliente.depositar(100.0); // Exemplo de chamada de método para realizar um depósito
	        cliente.sacar(50.0); // Exemplo de chamada de método para realizar um saque
	        cliente.exibirSaldo(); // Exemplo de chamada de método para exibir o saldo
	        Cliente cliente1 = new Cliente("João", "123456789", 1000.0);

	        // Realize operações com o cliente
	        cliente1.depositar(200.0);
	        cliente1.sacar(50.0);
	        cliente1.exibirSaldo();

	        // Exemplo de transferência para outro cliente (crie outro objeto Cliente)
	        Cliente cliente2 = new Cliente("Maria", "987654321", 1500.0);
	        cliente1.transferir(100.0, cliente2);

	        // Relatório de tributação da conta corrente
	        //cliente1.relatorioTributacaoContaCorrente();
	        //cliente1.relatorioRendimentoPoupanca(6); //apos 6 meses

	    
	            Gerente gerente = new Gerente();

	            // Chamando métodos do Gerente
	            gerente.exibirSaldoCliente(1000.0);
	            gerente.sacar(500.0);
	            gerente.exibirSaldoCliente(cliente); // Supondo que 'cliente' seja uma instância de Cliente

	            // Criando instância de Diretor
	            Diretor diretor = new Diretor();
	            // Chamando método do Diretor para gerar relatório de clientes em ordem alfabética
	            diretor.relatorioClientesEmOrdemAlfabetica(listaClientes); // Supondo que 'listaClientes' seja uma lista de objetos Cliente
	        }
	    }

}