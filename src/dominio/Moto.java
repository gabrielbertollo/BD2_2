package dominio;

public class Moto extends Veiculo {
	
	public int cilindrada;
	
	public Moto(int ano, String modelo, int marca, int cilindrada) {
		super(ano, modelo, marca);
		this.cilindrada = cilindrada;
		this.tipo = "moto";
		this.marca = marca;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
