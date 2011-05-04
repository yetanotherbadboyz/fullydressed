import java.util.List;


public class OdaKatalogu {
	private int katalogID;
	private List<MusteriTipi> musteriTipleri;

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

}
