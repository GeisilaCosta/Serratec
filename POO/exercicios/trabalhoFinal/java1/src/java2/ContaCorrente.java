package java2;

public class ContaCorrente extends Conta {
    private String tipo = "corrente";
    private double saldo;
    private double saquesRealizados;
    private double depositosRealizados;
    private double transferenciasRealizadas;

   

	public String getTipo() {
		return tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getSaquesRealizados() {
		return saquesRealizados;
	}

	public double getDepositosRealizados() {
		return depositosRealizados;
	}

	public double getTransferenciasRealizadas() {
		return transferenciasRealizadas;
	}

	public ContaCorrente(String cpfTitular, String tipo, double saldo, double saquesRealizados,
			double depositosRealizados, double transferenciasRealizadas) {
		super(cpfTitular);
		this.tipo = tipo;
		this.saldo = saldo;
		this.saquesRealizados = saquesRealizados;
		this.depositosRealizados = depositosRealizados;
		this.transferenciasRealizadas = transferenciasRealizadas;
	}
	
	  // Método para calcular tributação da conta corrente
    public void relatorioTributacaoContaCorrente() {
        double taxaSaque = 0.10; // Taxa por saque
        double taxaDeposito = 0.10; // Taxa por depósito
        double taxaTransferencia = 0.20; // Taxa por transferência (cobrada apenas do remetente)

        double totalGasto = (taxaSaque * saquesRealizados) + (taxaDeposito * depositosRealizados)
                + (taxaTransferencia * transferenciasRealizadas);

        System.out.println("Total gasto nas operações: R$" + totalGasto);
        System.out.println("Taxa por saque: R$" + taxaSaque);
        System.out.println("Taxa por depósito: R$" + taxaDeposito);
        System.out.println("Taxa por transferência: R$" + taxaTransferencia + " (cobrada apenas do remetente)");
    }


	@Override
    public void deposito(double valor) {
        saldo += valor;
    }

    @Override
    public void saque(double valor) {
        saldo -= valor;
    }

    @Override
    public void transferencia(Conta destino, double valor) {
        saldo -= valor;
        destino.deposito(valor);
    }
}
