import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


public class Sistem {
	private List<Otel> otelListesi = new ArrayList<Otel>();
	private Otel aktifOtel;
	private Kiralama kiralama;
	
	public Musteri musteriKaydiIsleminiBaslat() {
		return aktifOtel.musteriKaydiIsleminiBaslat();

	}
	
	public void musteriKayitBilgileriniGonder(Musteri m, String musteriAdi, String musteriSoyadi, 
			long __id, short yas) {
		aktifOtel.musteriKayitBilgileriniGonder(m, musteriAdi, musteriSoyadi, __id, yas);
	}
	
	public void odaKiralamaIsleminiBaslat(long musteriTcKimlikNo) {
		Musteri musteri = aktifOtel.musteriGetir(musteriTcKimlikNo);
		List<Oda> uygunOdalar = aktifOtel.uygunOdalariGetir(musteri);

	}
	
	public List<OdaKatalogu> kataloglariGetir(){
		return this.aktifOtel.kataloglariGetir();
	}
	
	public void katalogSec(OdaKatalogu katalog,Oda oda){
		this.aktifOtel.katalogSec(katalog,oda);
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
	
	public void aktifOtelAyarla(Otel otel) {
		this.aktifOtel = otel;
		
	}
	
	public Otel aktifOtelGetir(){
		return this.aktifOtel;
	}

	
	
	public static void main(String[] args) {
		Sistem sistem = new Sistem();
		sistem.aktifOtelAyarla(new Otel("The OverLook Hotel"));
		Scanner in = new Scanner(System.in);
		int gelenInt = -1;
		String gelenStr = "";
		int id = 0;
		while (gelenInt != 0){
			sistem.anaMenuYazdir();
			gelenInt = in.nextInt();
			if (gelenInt == 1){
				System.out.println("Resepsiyonist ID giriniz: ");
				id = in.nextInt();
				if (!sistem.resepsiyonistIDSorgula(id)){
					System.err.println("Hatalı ID!...");
					continue;
					
				}
					
				
				while (gelenInt != 9 && gelenInt != 0){
					resepsiyonistMenuYazdir();
					gelenInt = in.nextInt();
					// FIXME:
					in.nextLine();
					if (gelenInt == 1){
						
						Musteri __musteri = sistem.musteriKaydiIsleminiBaslat();
						
						System.out.println("İsim giriniz: ");
						String __isim = in.nextLine();
						System.out.println("Soyisim giriniz: ");
						String __soyisim = in.nextLine();
						System.out.println("Tc Kimlik NO giriniz: ");
						long __id = in.nextLong();
						System.out.println("Yaş giriniz: ");
						short __yas = in.nextShort();
						sistem.musteriKayitBilgileriniGonder(__musteri, __isim, __soyisim, __id, __yas);
					}
					
					else if (gelenInt == 2){
						for (Musteri i: sistem.aktifOtelGetir().musteriListesiGetir()){
							System.out.println("| İsim: " + i.adGetir() + "| Soyisim: " + i.soyadGetir() 
									+ "| Tc Kimlik: " + i.tcKimlikNoGetir() + "| Yaş: " + i.yasGetir() + " |");
						}
						
						in.nextLine();
					}
					
				}
			}
			
			else if (gelenInt == 2){
				System.out.println("Yönetici ID giriniz: ");
				id = in.nextInt();
				if (id != 237){
					System.err.println("Hatalı ID!...");
					continue;
				}
				
				while (gelenInt != 9 && gelenInt != 0){
					yoneticiMenuYazdir();
					gelenInt = in.nextInt();
					// FIXME:
					in.nextLine();
					if (gelenInt == 6){
						Resepsiyonist __resepsiyonist = sistem.resepsiyonistEklemeIsleminiBaslat();
						System.out.println("İsim giriniz: ");
						String __isim = in.nextLine();
						System.out.println("Soyisim giriniz: ");
						String __soyisim = in.nextLine();
						System.out.println("ID giriniz: ");
						int __id = in.nextInt();
						sistem.resepsiyonistOzellikleriniGir(__resepsiyonist, __isim, __soyisim, __id);
						continue;
					}
				}
			}
			else if (gelenInt == 0)
				System.exit(0);
			
			else {
				System.out.println("\n\nYanlis Secim.\n\n");
			}
		}
	}

	
}
