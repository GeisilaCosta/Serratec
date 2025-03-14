package java1;

public class Cliente {
	private String senha;
	private String CPF;
	private double saldo;
	private String nome;
	private String agencia;
	
	 // Construtor
    public Cliente(String nome, String cpf, double saldoInicial, String senha,String agencia) {
        this.nome = nome;
        this.CPF = cpf;
        this.saldo = saldoInicial;
        this.senha = senha;
        this.agencia = agencia;
    
	}
	// Getter
    public String getAgencia() {
		
		return agencia;
	}
    public double getSaldo() {
        return saldo;
    }

	 public String getSenha() {
		return senha;
	}
	 public String getCPF() {
		return CPF;
	}
	 public String getNome() {
			return nome;
	 }


	// Método para realizar um saque
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }
        
        /* // Método para realizar saque
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }*/
    }

    // Método para realizar um depósito
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }
    /*// Método para realizar depósito
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso. Novo saldo: R$" + saldo);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }*/

    // Método para realizar uma transferência
    public void transferir(double valor, Cliente destinatario) {
        if (saldo >= valor) {
            saldo -= valor;
            destinatario.depositar(valor);
            System.out.println("Transferência de R$" + valor + " realizada para " + destinatario);
        } else {
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
    }
/*  // Método para realizar transferência
    public void transferir(double valor, Cliente destinatario) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            destinatario.depositar(valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }*/
   
    
 // Método para exibir o saldo atual da conta do cliente
    public void exibirSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }
    
    // Método para calcular tributação da conta corrente
    public void relatorioTributacaoContaCorrente() {
        double totalGasto = 0.10 * (saquesRealizados + depositosRealizados) + 0.20 * transferenciasRealizadas;
        System.out.println("Total gasto nas operações: R$" + totalGasto);
        System.out.println("Taxa por saque: R$0.10");
        System.out.println("Taxa por depósito: R$0.10");
        System.out.println("Taxa por transferência: R$0.20 (cobrada apenas do remetente)");
    }
    

	}
	// Método para simular rendimento da poupança
    public void relatorioRendimentoPoupanca(int meses) {
        double taxaJurosAnual = 0.03; // Exemplo: 3% ao ano
        double saldoFinal = saldo * Math.pow(1 + taxaJurosAnual / 12, meses);
        double rendimento = saldoFinal - saldo;

        System.out.println("Rendimento da poupança após " + meses + " meses: R$" + rendimento);
        System.out.println("Saldo final: R$" + saldoFinal);
    }
	

}

