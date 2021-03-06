package DatabasePackage;

import java.util.List;

public class SaveWithDatabase implements Save {
	
	public Object get(int ID, Object objectClass){
		IMapper mapper = MapperFactory.getMapper(objectClass);
		return mapper.get(ID);
	}
	public int set(Object object,Object objectClass){
		IMapper mapper = MapperFactory.getMapper(objectClass);
		return mapper.set(object);
	}
	
	public List<Object> getAll(Object objectClass){								// since we don't know what type will be returned, we can not cast 
		IMapper mapper = MapperFactory.getMapper(objectClass);					// to any type here, this must be done in controller class
		return mapper.getAll();
	}
	
	public int getAvailableID(Object objectClass){
		
		IMapper mapper = MapperFactory.getMapper(objectClass);
		return mapper.getAvailableID();
	}
}
