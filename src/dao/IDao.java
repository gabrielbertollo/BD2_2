package dao;

import java.util.List;

public interface IDao <V>{ // generics
	
	void save(V t);
	
	V getOne(int id);
	
	List<V> list();
	
	void update (V t);
	
	void delete (int id);

}
