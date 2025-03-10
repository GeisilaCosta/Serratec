package planoSaude;

public class Medico extends Plano {
	private String nome;
	private int crm;
	
	public Medico(String empresa, String nome, int crm) {
		super(empresa);
		this.nome = nome;
		this.crm = crm;
	}
	@Override
	public String toString() {
		return super.toString() +"Medico:" + nome;
	}
	public String getNome() {
		return nome;
	}
	
	public int getCrm() {
		return crm;
	}
	
	@Override
    public double calcularPagamento() {
        return super.calcularPagamento() * 1.10;
    }
	
	}

