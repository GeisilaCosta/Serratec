package planoSaude;

public class Anestesia extends Medico {
private String tipoAnestesia;

public Anestesia(String empresa, String nome, int crm, String tipoAnestesia) {
	super(empresa, nome, crm);
	this.tipoAnestesia = tipoAnestesia;
}

public String getTipoAnestesia() {
	return tipoAnestesia;
}

public void setTipoAnestesia(String tipoAnestesia) {
	this.tipoAnestesia = tipoAnestesia;
}

@Override
public String toString() {
	return super.toString();
}

@Override
public double calcularPagamento() {
	
	return super.calcularPagamento() +1000;
}
}
