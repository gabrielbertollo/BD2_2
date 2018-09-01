package dominio;

public class Veiculo {
	
	protected int id;
	protected int ano;
	protected String modelo;
	protected int marca;
	protected String tipo;
	protected String nomeMarca;
	
	public Veiculo() {}
	
	public Veiculo(int ano, String modelo, int marca) {
		super();
		this.ano = ano;
		this.modelo = modelo;
		this.marca = marca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getMarca() {
		return marca;
	}

	public void setMarca(int marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	@Override
	public String toString() {
		return "\nVeiculo codigo = " + id + ", ano = " + ano + ", modelo = " + modelo + ", tipo = " + tipo + ", Marca = "
				+ nomeMarca + "";
	}	
	
	
}
