package principal;

import conexao.Conexao;
import dominio.Carro;
import dominio.Marca;
import dominio.MarcaDao;
import dominio.Moto;
import dominio.VeiculoDao;

public class Testador {
	
	public static void main(String[] args) {
		
		Marca m1 = new Marca("ford");
		Marca m2 = new Marca("honda");
		
		Carro c1 = new Carro(2017, "Ka", 1, "1.0");
		Carro c2 = new Carro(1997, "Civic", 2, "4.0");
		Moto mt1 = new Moto(2018, "Fireblade", 2, 1000);
		Moto mt2 = new Moto(2012, "600F", 2, 600);
		
		Conexao c = new Conexao();
		MarcaDao mdao = new MarcaDao(c.abreConexao());
		mdao.save(m1);
		mdao.save(m2);
		c.fechaConexao();
		VeiculoDao vdao = new VeiculoDao(c.abreConexao());
		vdao.save(c1);
		vdao.save(c2);
		vdao.save(mt1);
		vdao.save(mt2);
		
		System.out.println(vdao.list());
		System.out.println("---------------------------------------");
		
		vdao.delete(4);
		
		Carro c3 = new Carro(2010, "Mustang", 1, "V8");
		c3.setId(1);
		vdao.update(c3);
		
		System.out.println(vdao.list());
		System.out.println("---------------------------------------");
		
		System.out.println(vdao.getOne(1));
		
		
		c.fechaConexao();
	
	}

}
