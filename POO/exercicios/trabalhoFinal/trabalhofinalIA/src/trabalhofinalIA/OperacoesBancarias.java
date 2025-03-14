package trabalhofinalIA;
import java.io.*;
import java.util.*;

public interface OperacoesBancarias {
	 void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException;
	    void depositar(double valor) throws ValorInvalidoException;
	    void transferir(double valor, Conta destino) throws SaldoInsuficienteException, ValorInvalidoException;
}
