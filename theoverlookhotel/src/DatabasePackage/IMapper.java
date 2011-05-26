package DatabasePackage;

import java.util.List;

public interface IMapper {
	public abstract Object get(int ID);
	public abstract int set(Object object);
	public abstract List<Object> getAll();
	public abstract int getAvailableID();
	
	
}
