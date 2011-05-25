package UnitTypes;

public class MusteriTipi {
	private int ID;
	private String name;

	public MusteriTipi(String name){
		this.name = name;
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
