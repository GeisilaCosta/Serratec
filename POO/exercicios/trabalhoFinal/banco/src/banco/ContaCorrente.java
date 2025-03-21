package banco;

class ContaCorrente extends Conta {

	private final double TAXA_SAQUE = 0.10;
    private final double TAXA_DEPOSITO = 0.10;
    private final double TAXA_TRANSFERENCIA = 0.20;
	public ContaCorrente(String cpfTitular, String agencia) {
		super(cpfTitular, agencia);
	}
	public double getTAXA_SAQUE() {
		return TAXA_SAQUE;
	}
	public double getTAXA_DEPOSITO() {
		return TAXA_DEPOSITO;
	}
	public double getTAXA_TRANSFERENCIA() {
		return TAXA_TRANSFERENCIA;
	}
	@Override
	public double calcularRendimento(int dias) {
		// TODO Auto-generated method stub
		return 0;
	}

     @Override
    public double calcularTributacao() {
        // Implementação da tributação específica para conta corrente
        return 0.0;
    }

	

}	
