package utilitarios;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class utils {
	static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
		public static String doubleToString(Double saldo) {
		return formatandoValores.format(saldo);
	//public static String doubleToString(Double saldo) {
		//return formatandoValores.format(saldo);
	}

	
	}
