package MappersPackage;

import java.util.List;

import UnitTypes.Otel;

import DatabasePackage.DataConnector;
import DatabasePackage.IMapper;

public class OtelMapper implements IMapper {

	@Override
	public Object get(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int set(Object obje) {
		Otel object = (Otel) obje;
		DataConnector.getInstance().update("INSERT INTO `otel` " +
				"(`isim`, `adres`, `odaListesi`, `resepsiyonistListesi`, " +
				"`musteriListesi`, `katalogListesi`, `kiralamaListesi`, `uygunluk`, `otelID`) " +
				"VALUES ('"+object.isimGetir()+"', '"+object.adresGetir()+"', '', '', '', '', '', '1', '"+object.otelIDGetir()+"');");
		return 1;
	}

	public int getAvailableID() {
		// TODO Auto-generated method stub
		return 0;
	}

}