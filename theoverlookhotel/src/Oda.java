
public class Oda {
	private int odaID;
	private boolean uygunluk;
	private boolean bosOlma;
	private OdaKatalogu odaKatalogu;
	
	public Oda(int _odaID) {
		this.odaID = _odaID;
		this.uygunluk = true;
		this.bosOlma = true;
	}
	
	public Oda() {
		this.uygunluk = true;
		this.bosOlma = true;
	}
	
	public int odaIDGetir() {
		return odaID;
	}
	public void odaIDAyarla(int odaID) {
		this.odaID = odaID;
	}
	public boolean isAvailable() {
		return uygunluk;
	}
	public void odaKataloguAyarla(OdaKatalogu odaKatalogu){
		this.odaKatalogu = odaKatalogu;
	}
	
	public boolean uygunMu(Musteri musteri) {
		if (!this.isAvailable()){
			return false;
		}
		return this.odaKatalogu.uygunMu(musteri);
	}
	public void uygunlukAyarla(boolean uygunluk) {
		this.uygunluk = uygunluk;
	}
	public boolean bosMu() {
		return bosOlma;
	}
	public void bosOlmaDurumuAyarla(boolean bosOlmaDurumu) {
		this.bosOlma = bosOlmaDurumu;
	}

	public void odaOzellikleriBelirt(int odaNo) {
		odaIDAyarla(odaNo);
		
	}

	public void katalogSec(OdaKatalogu katalog) {
		this.odaKatalogu = katalog;
		
	}

	public float tutarOgren() {
		return 0;
	}

}
