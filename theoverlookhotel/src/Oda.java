
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
		// TODO Auto-generated constructor stub
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

	public void katalogSec(int _katalogID) {
		// TODO Auto-generated method stub
		
	}

}
