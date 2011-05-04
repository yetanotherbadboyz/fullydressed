import java.util.List;


public class System {
	private List<Otel> otelListesi;
	private Otel aktifOtel;
	
	public Musteri musteriKaydiIsleminiBaslat() {
		return aktifOtel.musteriKaydiIsleminiBaslat();

	}
	
	public void musteriKayitBilgileriniGonder(Musteri m, String musteriAdi, String musteriSoyadi, 
			int musteriTcKimlikNo, short yas) {
		aktifOtel.musteriKayitBilgileriniGonder(m, musteriAdi, musteriSoyadi, musteriTcKimlikNo, yas);
	}
	
	public void odaKiralamaIsleminiBaslat() {
		// TODO Auto-generated method stub

	}
	
	public void uygunOdaSec() {
		// TODO Auto-generated method stub

	}
	
	public void kiralamaTarihiSec() {
		// TODO Auto-generated method stub

	}
	
	public void kiralamaSonlandir() {
		// TODO Auto-generated method stub

	}
	
	public void odaEklemeIsleminiBaslat() {
		// TODO Auto-generated method stub

	}
	
	public void katalogSec() {
		// TODO Auto-generated method stub

	}
	
	public void odaOzellikleriBelirt() {
		// TODO Auto-generated method stub

	}
	
	public void otelEklemeIsleminiBaslat() {
		// TODO Auto-generated method stub

	}
	
	public void otelOzellikleriniGir() {
		// TODO Auto-generated method stub

	}
	
	public void resepsiyonistEklemeIsleminiBaslat() {
		// TODO Auto-generated method stub

	}
	
	public void resepsiyonistOzellikleriniGir() {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
		
	}

}
