import java.util.ArrayList;
import java.util.List;


public class Hotel {
	private String name;
	private List<Room> roomList;
	private List<Receptionist> receptionistList;
	private boolean isAvailable;
	
	public Hotel(String _Name) {
		this.name = _Name;
		this.isAvailable = true;
		roomList = new ArrayList<Room>();
		receptionistList = new ArrayList<Receptionist>();
		
	}
	
	public int addReceptionist(String _name, String _surname){
		Receptionist _receptionist = new Receptionist(_name, _surname, receptionistList.size());
		receptionistList.add(_receptionist);
		return _receptionist.getReceptionistID();
	}
	
	public boolean removeReceptionist(int _receptionistID){
		for (Receptionist i: receptionistList){
			if (i.getReceptionistID() == _receptionistID){
				receptionistList.remove(i);
				return true;
			}
		}
		
		return false;	
	}
	
	public List<Receptionist> getAvailableReceptionists(){
		List<Receptionist> _innerList = new ArrayList<Receptionist>();
		for (Receptionist i: receptionistList){
			if (i.isAvailable())
				_innerList.add(i);			
		}
		return _innerList;
	}
	
	public int addRoom(){
		Room _room = new Room(roomList.size());
		roomList.add(_room);
		return _room.getRoomID();
	}
	
	public boolean removeRoom(int _roomID){
		for (Room i: roomList){
			if (i.getRoomID() == _roomID){
				roomList.remove(i);
				return true;
			}
		}
		
		return false;	
	}
	
	public List<Room> getAvailableRooms(){
		List<Room> _innerList = new ArrayList<Room>();
		for (Room i: roomList){
			if (i.isAvailable())
				_innerList.add(i);
		}
		return _innerList;
	}
	
	public List<Room> getEmptyRooms(){
		List<Room> _innerList = new ArrayList<Room>();
		for (Room i: roomList){
			if (i.isAvailable() && i.isEmpty() && !i.isReserved())
				_innerList.add(i);
		}
		return _innerList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	public List<Receptionist> getReceptionistList() {
		return receptionistList;
	}
	public void setReceptionistList(List<Receptionist> receptionistList) {
		this.receptionistList = receptionistList;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	

}
