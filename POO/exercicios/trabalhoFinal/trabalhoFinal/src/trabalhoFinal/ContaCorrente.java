package trabalhoFinal;

import java.util.List;
import java.io.*;
import utilitarios.utils;

public class ContaCorrente extends Conta implements OperacoesBancariasInterface{
	
private static int contadorDeContasC = 1; //contar as contas criadas
private int numeroConta;
private double taxaSaque = 0.10;
private double taxaDeposito = 0.10;
private double taxaTransferencia = 0.20;

public ContaCorrente(Cliente cliente, int identificadorAgencia, TipoContaEnun tipoConta, double saldo,
		List<String> historico, int numeroConta, double taxaSaque, double taxaDeposito, double taxaTransferencia) {
	super(cliente, identificadorAgencia, tipoConta, saldo, historico);
	this.numeroConta = contadorDeContasC;
	this.taxaSaque = taxaSaque;
	this.taxaDeposito = taxaDeposito;
	this.taxaTransferencia = taxaTransferencia;
	contadorDeContasC +=1;
}
public static int getContadorDeContasC() {
	return contadorDeContasC;
}
public static void setContadorDeContasC(int contadorDeContasC) {
	ContaCorrente.contadorDeContasC = contadorDeContasC;
}
public int getNumeroConta() {
	return numeroConta;
}
public void setNumeroConta(int numeroConta) {
	this.numeroConta = numeroConta;
}
public double getTaxaSaque() {
	return taxaSaque;
}
public void setTaxaSaque(double taxaSaque) {
	this.taxaSaque = taxaSaque;
}
public double getTaxaDeposito() {
	return taxaDeposito;
}
public void setTaxaDeposito(double taxaDeposito) {
	this.taxaDeposito = taxaDeposito;
}
public double getTaxaTransferencia() {
	return taxaTransferencia;
}
public void setTaxaTransferencia(double taxaTransferencia) {
	this.taxaTransferencia = taxaTransferencia;
}
@Override
public void sacar(double valor) {
	  if (valor <= 0) {
          throw new ValorInvalidoException("Valor de saque inválido");
      }
      if (valor + taxaSaque > getSaldo()) {
          throw new SaldoInsuficienteException("Saldo insuficiente para saque");
      }
      double valorTotal = valor + taxaSaque;
      super.registrarOperacao("Saque", valorTotal);
      super.saldo -= valorTotal;
	
}
@Override
public void depositar(double valor) throws ValorInvalidoException {
	if (valor <= 0) {
        throw new ValorInvalidoException("Valor de depósito inválido");
    }
    super.registrarOperacao("Depósito", valor - taxaDeposito);
    super.saldo += valor - taxaDeposito;
	
}
@Override
public void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException {
	if (valor <= 0) {
        throw new ValorInvalidoException("Valor de transferência inválido");
    }
    if (valor + taxaTransferencia > getSaldo()) {
        throw new SaldoInsuficienteException("Saldo insuficiente para transferência");
    }
    super.registrarOperacao("Transferência para " + destino.getCpf(), valor + taxaTransferencia);
    super.saldo -= valor + taxaTransferencia;
    destino.depositar(valor);
}
	
}





/*public String toString() { 
	return
	"\nSaldo: " + utils.doubleToString(this.getSaldo());
}*/

/*@Override
public void sacar(double valor) {
	// TODO Auto-generated method stub
	
}

@Override
public void depositar(double valor) throws ValorInvalidoException {
	// TODO Auto-generated method stub
	
}

@Override
public void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException {
	// TODO Auto-generated method stub
	
}*/

}

