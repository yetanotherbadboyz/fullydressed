package UnitTypes;
import java.util.ArrayList;
import java.util.List;

import DatabasePackage.Facade;


public class OdaKatalogu {
	private int ID;
	private String katalogAdi;
	private int katalogID;
	private float tutar;
	private List<Integer> musteriTipleri = new ArrayList<Integer>();
	
	public OdaKatalogu(String _katalogAdi, int _katalogID, float _tutar) {
		this.katalogAdi =  _katalogAdi;
		this.katalogID = _katalogID;
		this.tutar = _tutar;
		MusteriTipi _musteriTipi1 = new MusteriTipi("Standart");
		Facade.getInstance().set(_musteriTipi1, MusteriTipi.class);
		musteriTipleri.add(_musteriTipi1.getID());
		MusteriTipi _musteriTipi2 = new MusteriTipi("VIP");
		Facade.getInstance().set(_musteriTipi2, MusteriTipi.class);
		musteriTipleri.add(_musteriTipi2.getID());
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return this.ID;
	}

	public int katalogIDGetir() {
		return katalogID;
	}

	public void katalogIDAyarla(int _katalogID) {
		this.katalogID = _katalogID;
	}
	
	public boolean uygunMu(Musteri musteri){
		Facade facade = Facade.getInstance();
		for (int i: musteriTipleri){
			MusteriTipi musteriTipi = (MusteriTipi) facade.get(i, MusteriTipi.class);
			if (musteriTipi.getName() == musteri.musteriTipiGetir().getName())
				return true;
		}
		return false;
	}

	public String isimGetir() {
		return this.katalogAdi;
	}
	
	public void isimAyarla(String _katalogAdi) {
		this.katalogAdi = _katalogAdi;
	}

	public float tutarGetir() {
		return this.tutar;
	}

}
