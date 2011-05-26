package UnitTypes;

import DatabasePackage.Facade;

public class MusteriTipi {
	private int ID;
	private String name;

	public MusteriTipi(String name){
		this.name = name;
		this.setID(Facade.getInstance().getAvailableID(MusteriTipi.class));
		Facade.getInstance().set(this, MusteriTipi.class);
	}

	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public String getName(){
		return this.name;
	}
}
