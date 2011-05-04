import java.util.ArrayList;
import java.util.List;


public class Sistem {
	private List<Otel> otelListesi = new ArrayList<Otel>();
	private Otel aktifOtel;
	
	public Musteri musteriKaydiIsleminiBaslat() {
		return aktifOtel.musteriKaydiIsleminiBaslat();

	}
	
	public void musteriKayitBilgileriniGonder(Musteri m, String musteriAdi, String musteriSoyadi, 
			int musteriTcKimlikNo, short yas) {
		aktifOtel.musteriKayitBilgileriniGonder(m, musteriAdi, musteriSoyadi, musteriTcKimlikNo, yas);
	}
	
	public void odaKiralamaIsleminiBaslat(int musteriTcKimlikNo) {
		Musteri musteri = aktifOtel.musteriGetir(musteriTcKimlikNo);
		List<Oda> uygunOdalar = aktifOtel.uygunOdalariGetir(musteri);

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
	
	public Oda odaEklemeIsleminiBaslat() {
		return aktifOtel.odaYarat();
	}
	
	public void katalogSec(Oda o, int _katalogID) {
		o.katalogSec(_katalogID);

	}
	
	public void odaOzellikleriBelirt(Oda o, int odaNo) {
		o.odaOzellikleriBelirt(odaNo);
	}
	
	public Otel otelEklemeIsleminiBaslat() {
		Otel _otel = new Otel();
		otelListesi.add(_otel);
		return _otel;
	}
	
	public void otelOzellikleriniGir(Otel _otel, String otelAdi, int otelID) {
		_otel.otelOzellikleriniGir(otelAdi, otelID);
	}
	
	public Resepsiyonist resepsiyonistEklemeIsleminiBaslat() {
		return aktifOtel.resepsiyonistYarat();

	}
	
	public void resepsiyonistOzellikleriniGir(Resepsiyonist _resepsiyonist, String ad, String soyad, int resepsiyonistID) {
		_resepsiyonist.resepsiyonistOzellikleriniGir(ad, soyad, resepsiyonistID);

	}
	
	
	public static void main(String[] args) {
		
		
	}

}
