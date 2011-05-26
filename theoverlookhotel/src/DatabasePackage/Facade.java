package DatabasePackage;

import java.util.List;




public class Facade {
	Save saveAPI;
	private static Facade thisFacade;
	
	private Facade(){
	}
	
	public static Facade getInstance(){
		if (thisFacade == null)
			thisFacade = new Facade();
		return thisFacade;
	}
	
	public void setSaveAPI(Save saveAPI){
		this.saveAPI = saveAPI;
	}

	public Object get(int ID, Object objectClass){
		return this.saveAPI.get(ID, objectClass);
	}
	
	public int set(Object object,Object objectClass){
		return this.saveAPI.set(object, objectClass);
	}
	
	public List<Object> getAll(Object objectClass){
		return this.saveAPI.getAll(objectClass);
	}
	
	public int getAvailableID(Object objectClass){
		return this.saveAPI.getAvailableID(objectClass);
	}

}
