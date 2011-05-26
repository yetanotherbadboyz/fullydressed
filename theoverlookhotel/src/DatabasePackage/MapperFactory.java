package DatabasePackage;

import UnitTypes.*;
import MappersPackage.*;



public class MapperFactory {

	public static IMapper getMapper(Object objectClass) {
		if (objectClass == Kiralama.class)
			return new KiralamaMapper();
		if (objectClass == Musteri.class)
			return new MusteriMapper();
		if (objectClass == MusteriTipi.class)
			return new MusteriTipiMapper();
		if (objectClass == Oda.class)
			return new OdaMapper();
		if (objectClass == OdaKatalogu.class)
			return new OdaKataloguMapper();
		if (objectClass == Otel.class)
			return new OtelMapper();
		if (objectClass == Resepsiyonist.class)
			return new ResepsiyonistMapper();
		return null;												//this should never happen	
	}

	/*
	public Mapper getMapper(Object objectClass){
		
	}
	*/
}
