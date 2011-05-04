import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
	
	public void anaMenuYazdir() {
		System.out.println("-------TheOverLookHotel-------\n" +
				"\n1. Sistem'e Resepsiyonist olarak giriş yap. " +
				"\n2. Sistem'e Yönetici olarak giriş yap." +
				"\n\n\n0. Çıkış." +
				"\n\n-------TheOverLookHotel-------\nSeçiminiz: ");
	}
	
	private static void resepsiyonistMenuYazdir() {
		System.out.println("-------TheOverLookHotel-------\n" +
				"=======Resepsiyonist Menu=======\n" +
				"\n1. Müşteri Kayıt işlemi. " +
				"\n2. Müşteri Listeleme işlemi." +
				"\n3. Oda Kiralama İşlemi." +
				"\n4. Boş Oda Listeleme İşlemi" +
				"\n\n\n9. Ana Menü'ye geri dön." +
				"\n0. Sistemden Çıkış." +
				"\n\n-------TheOverLookHotel-------\nSeçiminiz: ");

	}
	
	private static void yoneticiMenuYazdir() {
		System.out.println("-------TheOverLookHotel-------\n" +
				"=======Yönetici Menü=======\n" +
				"\n1. Müşteri Kayıt işlemi. " +
				"\n2. Müşteri Listeleme işlemi." +
				"\n3. Oda Kiralama İşlemi." +
				"\n4. Boş Oda Listeleme İşlemi" +
				"\n5. Yeni Oda Kayıt işlemi." +
				"\n6. Yeni Resepsiyonist Kayıt işlemi." +
				"\n\n\n9. Ana Menü'ye geri dön." +
				"\n0. Sistemden Çıkış." +
				"\n\n-------TheOverLookHotel-------\nSeçiminiz: ");

	}
	
	
	public static void main(String[] args) {
		Sistem sistem = new Sistem();
		Scanner in = new Scanner(System.in);
		int gelen = -1;
		while (gelen != 0){
			sistem.anaMenuYazdir();
			gelen = in.nextInt();
			if (gelen == 1)
				resepsiyonistMenuYazdir();
				
			
			else if (gelen == 2)
				yoneticiMenuYazdir();
			
			else if (gelen == 0)
				System.exit(0);
			
			else {
				System.out.println("\n\nYanlis Secim.\n\n");
			}
		}
	}

}
