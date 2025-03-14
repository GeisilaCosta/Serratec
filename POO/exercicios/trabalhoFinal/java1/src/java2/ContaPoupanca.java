package java2;

public class ContaPoupanca extends Conta {
    private String tipo;

    public ContaPoupanca(String cpfTitular, String tipo) {
        super(cpfTitular);
        this.tipo = tipo;
    }

    public String getTipo() {
		return tipo;
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
