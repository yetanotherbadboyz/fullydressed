import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;


public class Sistem {
	private List<Otel> otelListesi = new ArrayList<Otel>();
	private Otel aktifOtel;
	private Kiralama kiralama;
	
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
	
	public void uygunOdaSec(int odaID) {
		aktifOtel.uygunOdaSec(odaID, kiralama);

	}
	
	public float kiralamaTarihiSec(int girisGun, int girisAy, int girisYil,
								int cikisGun, int cikisAy, int cikisYil) {
		GregorianCalendar _baslangicTarihi = new GregorianCalendar(girisYil, girisAy, girisYil);
		GregorianCalendar _bitisTarihi = new GregorianCalendar(cikisYil, cikisAy, cikisGun);
		float tutar = aktifOtel.kiralamaTarihiSec(_baslangicTarihi, _bitisTarihi, kiralama);
		return tutar;
		

	}
	
	public void kiralamaSonlandir() {
		aktifOtel.kiralamaSonlandir(kiralama);

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
	
	private boolean resepsiyonistIDSorgula(int id){
		for (Resepsiyonist i: aktifOtel.getReceptionistList()){
			if (i.resepsiyonistIDGetir() == id)
				return true;
		}
		return false;
	}
	
	private void aktifOtelAyarla(Otel otel) {
		this.aktifOtel = otel;
		
	}

	
	
	public static void main(String[] args) {
		Sistem sistem = new Sistem();
		sistem.aktifOtelAyarla(new Otel());
		Scanner in = new Scanner(System.in);
		int gelen = -1;
		int id = 0;
		while (gelen != 0){
			sistem.anaMenuYazdir();
			gelen = in.nextInt();
			if (gelen == 1){
				System.out.println("Resepsiyonist ID giriniz: ");
				id = in.nextInt();
				if (!sistem.resepsiyonistIDSorgula(id)){
					System.err.println("Hatalı ID!...");
					System.exit(1);
					
				}
					
				resepsiyonistMenuYazdir();
				while (gelen != 9 && gelen != 0){
					System.out.println("resepmenu: " + gelen);
					gelen = in.nextInt();
				}
			}
			
			else if (gelen == 2){
				System.out.println("Yönetici ID giriniz: ");
				id = in.nextInt();
				if (id != 237){
					System.err.println("Hatalı ID!...");
					System.exit(1);
				}
				yoneticiMenuYazdir();
				while (gelen != 9 && gelen != 0){
					System.out.println("resepmenu: " + gelen);
					gelen = in.nextInt();
				}
			}
			else if (gelen == 0)
				System.exit(0);
			
			else {
				System.out.println("\n\nYanlis Secim.\n\n");
			}
		}
	}

	
}
