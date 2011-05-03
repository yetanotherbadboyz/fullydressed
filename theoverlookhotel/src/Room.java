
public class Room {
	private int RoomID;
	private boolean isAvailable;
	private boolean isReserved;
	private boolean isEmpty;
	
	public Room(int _RoomID) {
		this.RoomID = _RoomID;
		this.isAvailable = true;
		this.isReserved = false;
		this.isEmpty = false;
		
	}
	
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean isReserved() {
		return isReserved;
	}
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

}
