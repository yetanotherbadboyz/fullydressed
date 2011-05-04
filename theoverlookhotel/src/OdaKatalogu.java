import java.util.ArrayList;
import java.util.List;


public class OdaKatalogu {
	private String katalogAdi;
	private int katalogID;
	private List<MusteriTipi> musteriTipleri = new ArrayList<MusteriTipi>();
	
	public OdaKatalogu(String _katalogAdi, int _katalogID) {
		this.katalogAdi =  _katalogAdi;
		this.katalogID = _katalogID;
		MusteriTipi _musteriTipi1 = new MusteriTipi("Standart");
		musteriTipleri.add(_musteriTipi1);
		MusteriTipi _musteriTipi2 = new MusteriTipi("VIP");
		musteriTipleri.add(_musteriTipi2);
	}

	public int katalogIDGetir() {
		return katalogID;
	}

	public void katalogIDAyarla(int _katalogID) {
		this.katalogID = _katalogID;
	}
	
	public boolean uygunMu(Musteri musteri){
		for (MusteriTipi i: musteriTipleri){
			if (i.getName() == musteri.musteriTipiGetir().getName())
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

}
