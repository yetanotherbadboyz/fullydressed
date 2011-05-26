package DatabasePackage;

import java.util.ArrayList;
import java.util.List;

class SaveWithObjectSerialization implements Save {
	public Object get(int ID, Object objectClass){
		return new Object();
	}
	public int set(Object object,Object objectClass){
		return 0;
	}
	
	public List<Object> getAll(Object objectClass){
		List<Object> liste = new ArrayList<Object>();
		return liste;
	}
	
	public int getAvailableID(Object objectClass){
		return 0;
	}
}
