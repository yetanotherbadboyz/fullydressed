package DatabasePackage;

import java.util.List;


interface Save{
	public Object get(int ID, Object objectClass);
	
	public int set(Object object,Object objectClass);
	
	public List<Object> getAll(Object objectClass);
	
	public int getAvailableID(Object objectClass);
}



