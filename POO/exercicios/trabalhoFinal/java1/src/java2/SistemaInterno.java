package java2;

import java.util.Scanner;

public class SistemaInterno {
	// Classe para representar o Sistema Interno do Banco
	
	    private Scanner scanner;
	    private Banco banco;
	    private Usuario usuarioLogado;

	    public SistemaInterno() {
	        scanner = new Scanner(System.in);
	        banco = new Banco();
	    }

	    public void iniciarSistema() {
	        // Lógica de inicialização do sistema
	        System.out.println("Bem-vindo ao Sistema Bancário!");
	        // Carregar dados do banco a partir de um arquivo
	        banco.carregarDadosDoArquivo("dados_banco.txt");

	        // Login do usuário
	        String cpf = solicitarCPF();
	        String senha = solicitarSenha();
	        usuarioLogado = banco.fazerLogin(cpf, senha);

	        if (usuarioLogado != null) {
	            exibirMenu();
	        } else {
	            System.out.println("CPF ou senha incorretos. Tente novamente.");
	        }
	    }

	    private String solicitarCPF() {
	        System.out.print("Digite seu CPF: ");
	        return scanner.nextLine();
	    }

	    private String solicitarSenha() {
	        System.out.print("Digite sua senha: ");
	        return scanner.nextLine();
	    }

	    private void exibirMenu() {
	        // Lógica para exibir o menu correspondente ao tipo de usuário
	        if (usuarioLogado instanceof Cliente) {
	            exibirMenuCliente((Cliente) usuarioLogado);
	        } else if (usuarioLogado instanceof Gerente) {
	            exibirMenuGerente((Gerente) usuarioLogado);
	        } else if (usuarioLogado instanceof Diretor) {
	            exibirMenuDiretor((Diretor) usuarioLogado);
	        } else if (usuarioLogado instanceof Presidente) {
	            exibirMenuPresidente((Presidente) usuarioLogado);
	        }
	    }

	    private void exibirMenuCliente(Cliente cliente) {
	    	 int opcao;
	         do {
	             System.out.println("Menu do Cliente:");
	             System.out.println("1. Saque");
	             System.out.println("2. Depósito");
	             System.out.println("3. Transferência para outra conta");
	             System.out.println("4. Relatórios");
	             System.out.println("5. Sair");
	             System.out.print("Escolha uma opção: ");
	             opcao = scanner.nextInt();
	             scanner.nextLine(); // Limpar o buffer do scanner

	             switch (opcao) {
	                 case 1:
	                	 cliente.realizarDeposito(100.00);
	                     break;
	                 case 2:
	                	 cliente.realizarDeposito(500.00);
	                     break;
	                 case 3:
	                     cliente.realizarTransferencia();
	                     break;
	                 case 4:
	                     cliente.exibirRelatorios();
	                     break;
	                 case 5:
	                     System.out.println("Saindo do sistema...");
	                     break;
	                 default:
	                     System.out.println("Opção inválida. Tente novamente.");
	             }
	         } while (opcao != 5);
	      // Implemente o menu para clientes
	    }

	    private void exibirMenuGerente(Gerente gerente) {
	        // Implemente o menu para gerentes
	    }

	    private void exibirMenuDiretor(Diretor diretor) {
	        // Implemente o menu para diretores
	    }

	    private void exibirMenuPresidente(Presidente presidente) {
	        // Implemente o menu para presidentes
	    }
	    
	    public void exibirSaldo() {
	        System.out.println("Saldo atual: R$" + saldo);
	    }
	    
	    public class Cliente {
	        // ... (código anterior)

	        // Método para calcular tributação da conta corrente
	        public void relatorioTributacaoContaCorrente() {
	            double totalGasto = 0.10 * (saquesRealizados + depositosRealizados) + 0.20 * transferenciasRealizadas;
	            System.out.println("Total gasto nas operações: R$" + totalGasto);
	            System.out.println("Taxa por saque: R$0.10");
	            System.out.println("Taxa por depósito: R$0.10");
	            System.out.println("Taxa por transferência: R$0.20 (cobrada apenas do remetente)");
	        }

			public void realizarDeposito(double d) {
				// TODO Auto-generated method stub
				
			}

			public void exibirRelatorios() {
				// TODO Auto-generated method stub
				
			}
	    }

}
