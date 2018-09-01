package dominio;

public class Carro extends Veiculo{
	public String motor;
	
	public Carro(int ano, String modelo, int marca, String motor) {
		super(ano, modelo, marca);
		this.motor = motor;
		this.tipo = "carro";
		this.marca = marca;
	}
	
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = "carro";
	}

	
}
