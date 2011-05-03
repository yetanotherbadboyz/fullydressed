
public class Receptionist {
	private String name;
	private String surname;
	private int receptionistID;
	private boolean isAvailable;
	
	public Receptionist(String _name, String _surname, int _receptionistID) {
		this.name = _name;
		this.surname = _surname;
		this.receptionistID = _receptionistID;
		this.isAvailable = true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getReceptionistID() {
		return receptionistID;
	}
	public void setReceptionistID(int receptionistID) {
		this.receptionistID = receptionistID;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

}
