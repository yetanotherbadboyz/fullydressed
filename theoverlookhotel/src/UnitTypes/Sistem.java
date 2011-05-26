package UnitTypes;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import DatabasePackage.Facade;


public class Sistem {
	private List<Integer> otelListesi = new ArrayList<Integer>();
	private int aktifOtelID;
	private int aktifResepsiyonistID;
	private int aktifKiralamaID;
	private Scanner in = new Scanner(System.in);
	
	public Musteri musteriKaydiIsleminiBaslat() {
		return ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).musteriKaydiIsleminiBaslat();

	}
	
	public void musteriKayitBilgileriniGonder(Musteri m, String musteriAdi, String musteriSoyadi, 
			long __id, short yas) {
		((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).musteriKayitBilgileriniGonder(m.getID(), musteriAdi, musteriSoyadi, __id, yas);
	}
	
	public List<Oda> odaKiralamaIsleminiBaslat(long musteriTcKimlikNo) {
		Musteri musteri = ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).musteriGetir(musteriTcKimlikNo);
		this.aktifKiralamaID = new Kiralama(musteri.getID()).getID();
		return ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).uygunOdalariGetir(musteri);

	}
	
	public List<Integer> kataloglariGetir(){
		return ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).kataloglariGetir();
	}
	
	public void katalogSec(int _katalogID,Oda oda){
		((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).katalogSec(_katalogID,oda);
	}
	
	public void uygunOdaSec(int odaID) {
		((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).uygunOdaSec(odaID, aktifKiralamaID);
	}
	
	public float kiralamaTarihiSec(int girisGun, int girisAy, int girisYil,
								int cikisGun, int cikisAy, int cikisYil) {

		float tutar = ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).kiralamaTarihiSec(new GregorianCalendar(girisYil, girisAy, girisGun), 
				new GregorianCalendar(cikisYil, cikisAy, cikisGun), ((Kiralama) Facade.getInstance().get(aktifKiralamaID, Kiralama.class)));
		return tutar;
		

	}
	
	public void kiralamaSonlandir() {
		((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).kiralamaSonlandir(aktifKiralamaID);

	}
	
	public Oda odaEklemeIsleminiBaslat() {
		return ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).odaYarat();
	}
	
	
	public void odaOzellikleriBelirt(Oda o, int odaNo) {
		o.odaOzellikleriBelirt(odaNo);
	}
	
	public Otel otelEklemeIsleminiBaslat() {
		Otel _otel = new Otel();
		otelListesi.add(_otel.getID());
		return _otel;
	}
	
	public void otelOzellikleriniGir(Otel _otel, String otelAdi, String __adres, int otelID) {
		_otel.otelOzellikleriniGir(otelAdi, __adres, otelID);
	}
	
	public Resepsiyonist resepsiyonistEklemeIsleminiBaslat() {
		return ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).resepsiyonistYarat();

	}
	
	public void resepsiyonistOzellikleriniGir(Resepsiyonist _resepsiyonist, String ad, String soyad, int resepsiyonistID) {
		_resepsiyonist.resepsiyonistOzellikleriniGir(ad, soyad, resepsiyonistID);

	}
	
	public void anaMenuYazdir(){
		System.out.println("-----TheOverLookHotel Systems-----\n" +
				"\n1. Otele giriş." +
				"\n2. Otel yarat." +
				"\n3. Otel listele." +
				"\n0. Çıkış." +
				"\n-----------TheOverLookHotel Systems---------\nSeçiminiz: ");
	}
	
	public void otelYazdir() {
		System.out.println("-------"+((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).isimGetir()+"-------\n" +
				"-------"+((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).adresGetir()+"-------\n" +
				"\n1. Sistem'e Resepsiyonist olarak giriş yap. " +
				"\n2. Sistem'e Yönetici olarak giriş yap." +
				"\n\n\n9. Sistem Menüye geri dön." +
				"\n0. Çıkış." +
				"\n\n-------"+((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).isimGetir()+"-------\nSeçiminiz: ");
	}
	
	private void resepsiyonistMenuYazdir() {
		System.out.println("-------"+((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).isimGetir()+"-------\n" +
				"\n=======Resepsiyonist: "+((Resepsiyonist) Facade.getInstance().get(aktifResepsiyonistID, Resepsiyonist.class)).isimGetir()+" " + ((Resepsiyonist) Facade.getInstance().get(aktifResepsiyonistID, Resepsiyonist.class)).soyisimGetir() +"=======\n" +
				"\n1. Müşteri Kayıt işlemi. " +
				"\n2. Müşteri Listeleme işlemi." +
				"\n3. Oda Kiralama İşlemi." +
				"\n4. Boş Oda Listeleme İşlemi" +
				"\n7. Kiralamaları Listeleme işlemi." +
				"\n\n\n8. Otel Menü'ye geri dön." +
				"\n9. Sistem Menü'ye geri gön." +
				"\n0. Sistemden Çıkış." +
				"\n=======Resepsiyonist: "+((Resepsiyonist) Facade.getInstance().get(aktifResepsiyonistID, Resepsiyonist.class)).isimGetir()+" " + ((Resepsiyonist) Facade.getInstance().get(aktifResepsiyonistID, Resepsiyonist.class)).soyisimGetir() +"=======\n" +
				"\n\n-------"+((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).isimGetir()+"-------\nSeçiminiz: ");

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
				"\n7. Kiralamaları Listeleme işlemi." +
				"\n10. Resepsiyonist Listeleme işlemi." +
				"\n\n\n8. Otel Menü'ye geri dön." +
				"\n9. Sistem Menü'ye geri gön." +
				"\n0. Sistemden Çıkış." +
				"\n\n-------TheOverLookHotel-------\nSeçiminiz: ");

	}
	
	public boolean resepsiyonistIDSorgula(int id){
		for (Integer i: ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).getReceptionistList()){
			if (((Resepsiyonist) Facade.getInstance().get(i, Resepsiyonist.class)).resepsiyonistIDGetir() == id)
				return true;
		}
		return false;
	}
	
	public boolean otelIDSorgula(int id){
		for (Integer i: otelListesi){
			if (((Otel) Facade.getInstance().get(i, Otel.class)).otelIDGetir() == id)
				return true;
		}
		return false;
	}
	
	public void aktifOtelAyarla(Otel otel) {
		this.aktifOtelID = otel.getID();
		
	}
	
	public Otel aktifOtelGetir(){
		return ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class));
	}
	
	public Otel otelGetirID(int id){
		for (Integer i: otelListesi){
			if (((Otel) Facade.getInstance().get(i, Otel.class)).otelIDGetir() == id)
				return ((Otel) Facade.getInstance().get(i, Otel.class));
		}
		return null;
	}
	
	public boolean strKarsilastir(String ilk, String ikinci){
		if (ilk.length() != ikinci.length())
			return false;
		
		for (int i=0;i<ilk.length();i++){
			if (ilk.charAt(i) != ikinci.charAt(i))
				return false;
		}
		
		return true;
		
	}
	
	public Otel otelGetirIsim(String isim){
		for (Integer i: otelListesi){
			if (strKarsilastir(((Otel) Facade.getInstance().get(i, Otel.class)).isimGetir(), isim))
				return ((Otel) Facade.getInstance().get(i, Otel.class));
		}
		return null;
	}
	
	public Otel otelGetirAdres(String adres){
		for (Integer i: otelListesi){
			if (strKarsilastir(((Otel) Facade.getInstance().get(i, Otel.class)).adresGetir(), adres))
				return ((Otel) Facade.getInstance().get(i, Otel.class));
		}
		return null;
	}
	
	public void aktifResepsiyonistAyarla(Resepsiyonist _resepsiyonist){
		this.aktifResepsiyonistID = _resepsiyonist.getID();
	}
	
	public Resepsiyonist resepsiyonistGetir(int id){
		for (Integer i: ((Otel) Facade.getInstance().get(aktifOtelID, Otel.class)).getReceptionistList()){
			if (((Resepsiyonist) Facade.getInstance().get(i, Resepsiyonist.class)).resepsiyonistIDGetir() == id)
				return ((Resepsiyonist) Facade.getInstance().get(i, Resepsiyonist.class));
		}
		return null;
	}
	
	public Kiralama kiralamaGetir(){
		return ((Kiralama) Facade.getInstance().get(this.aktifKiralamaID, Kiralama.class));
	}
	
	public void kiralamaAyarla(Kiralama _kiralama){
		this.aktifKiralamaID = _kiralama.getID();
	}
	
	public boolean menuOtelListele(Sistem sistem){
		for (Integer i: sistem.otelListesi){
			System.out.println("\nOtel Adı: " + ((Otel) Facade.getInstance().get(i, Otel.class)).isimGetir() 
					+ "\nOtel Adresi: " + ((Otel) Facade.getInstance().get(i, Otel.class)).adresGetir() 
					+ "\nOtel ID: " + ((Otel) Facade.getInstance().get(i, Otel.class)).otelIDGetir());
		}
		in.nextLine();
		in.nextLine();
		
		return true;
	}
	
	public boolean menuOtelSec(Sistem sistem){
		
		System.out.println("Otel ID giriniz: ");
		int gelenID = in.nextInt();
		
		if (!sistem.otelIDSorgula(gelenID)){
			System.err.println("Yanlış Otel ID!...\n");
			return false;
			
		}
		 
		else {
			sistem.aktifOtelAyarla(sistem.otelGetirID(gelenID));
			return true;
		}
	}
	
	public boolean menuOtelYarat(Sistem sistem){
		in.nextLine();
		Otel _otel = sistem.otelEklemeIsleminiBaslat();
		System.out.println("Otel Adı giriniz: ");
		String __ad = in.nextLine();
		while (sistem.otelGetirIsim(__ad) != null){
			System.err.println("Aynı isimde kayıtlı otel adı var, başka bir tane giriniz: ");
			__ad = in.nextLine();
		}
		System.out.println("Odel Adresi giriniz: ");
		String __adres = in.nextLine();
		while (sistem.otelGetirAdres(__adres) != null){
			System.err.println("Aynı adreste kayıtlı otel adı var, başka bir tane giriniz: ");
			__adres = in.nextLine();
		}
		System.out.println("Otel ID giriniz: ");
		int __id = in.nextInt();
		
		while (sistem.otelGetirID(__id) != null){
			System.err.println("Aynı ID'de kayıtlı otel adı var, başka bir tane giriniz: ");
			__id = in.nextInt();
		}
		sistem.otelOzellikleriniGir(_otel, __ad, __adres, __id);
		return true;
	}
	
	public boolean menuResepsiyonistGirisYap(Sistem sistem){
		System.out.println("Resepsiyonist ID giriniz: ");
		int id = in.nextInt();
		if (!sistem.resepsiyonistIDSorgula(id)){
			System.err.println("Hatalı ID!...\n");
			return false;
			
		}
		else {
			sistem.aktifResepsiyonistAyarla(sistem.resepsiyonistGetir(id));
			return true;
		}
	}
	
	public boolean menuMusteriKayit(Sistem sistem) {
		in.nextLine();
		
		Musteri __musteri = sistem.musteriKaydiIsleminiBaslat();
		
		System.out.println("İsim giriniz: ");
		String __isim = in.nextLine();
		System.out.println("Soyisim giriniz: ");
		String __soyisim = in.nextLine();
		System.out.println("Tc Kimlik NO giriniz: ");
		long __id = in.nextLong();
		if (__id == 0){
			System.err.println("Tc Kimlik No yanlış.");
			return false;
		}
		if (sistem.aktifOtelGetir().musteriGetir(__id) != null){
			System.err.println("Aynı Tc Kimlik No'ya sahip kayıtlı müşteri var.");
			return false;
		}
		System.out.println("Yaş giriniz: ");
		short __yas = in.nextShort();
		sistem.musteriKayitBilgileriniGonder(__musteri, __isim, __soyisim, __id, __yas);
		return true;
	}
	
	public boolean menuMusteriListesi(Sistem sistem){
		for (Musteri i: sistem.aktifOtelGetir().musteriListesiGetir()){
			System.out.println(" | İsim: " + i.adGetir() + " | Soyisim: " + i.soyadGetir() 
					+ " | Tc Kimlik: " + i.tcKimlikNoGetir() + " | Yaş: " + i.yasGetir() + " |");
		}
		
		in.nextLine();
		in.nextLine();
		
		return true;
	}
	
	public boolean menuOdaKiralama(Sistem sistem){
		System.out.println("Tc Kimlik No girin: ");
		long _tcKimlikNo = in.nextLong();
		for (Oda i: sistem.odaKiralamaIsleminiBaslat(_tcKimlikNo)){
			System.out.println("OdaID:" + i.odaIDGetir());
		}
		in.nextLine();
		System.out.println("Oda ID seçiniz: ");
		int __odaID = in.nextInt();

		sistem.uygunOdaSec(__odaID);
		
		System.out.println("Giris Gun: ");
		int _girisGun = in.nextInt();
		System.out.println("Giris Ay: ");
		int _girisAy = in.nextInt();
		System.out.println("Giris Yil: ");
		int _girisYil = in.nextInt();
		
		System.out.println("Cikis Gun: ");
		int _cikisGun = in.nextInt();
		System.out.println("Cikis Ay: ");
		int _cikisAy = in.nextInt();
		System.out.println("Cikis Yil: ");
		int _cikisYil = in.nextInt();
		
		float fiyat = sistem.kiralamaTarihiSec(_girisGun, _girisAy, _girisYil, _cikisGun, _cikisAy, _cikisYil);
		
		System.out.println("Fiyat: " + fiyat);
		
		in.nextLine();
		
		sistem.kiralamaSonlandir();
		
		return true;
	}
	
	public boolean menuBosOdalar(Sistem sistem){
		for (Oda i: sistem.aktifOtelGetir().bosOdalariGetir())
			System.out.println("OdaID:" + i.odaIDGetir());
		
		in.nextLine();
		
		return true;
	}
	
	public boolean menuKiralamaListeleme(Sistem sistem){
		for (Integer i: sistem.aktifOtelGetir().kiralamaListesiGetir())
			System.out.println("Oda: " + ((Kiralama) Facade.getInstance().get(i, Kiralama.class)).getKiralananOda().odaIDGetir() + " | Ad: " + 
					((Kiralama) Facade.getInstance().get(i, Kiralama.class)).getKiralayanMusteri().adGetir() + " | Giris:" + ((Kiralama) Facade.getInstance().get(i, Kiralama.class)).baslangicTarihiGetir().get(GregorianCalendar.YEAR) + "/" 
					+ ((Kiralama) Facade.getInstance().get(i, Kiralama.class)).baslangicTarihiGetir().get(GregorianCalendar.MONTH) + "/" + ((Kiralama) Facade.getInstance().get(i, Kiralama.class)).baslangicTarihiGetir().get(GregorianCalendar.DAY_OF_MONTH) +
					" | Cikis:" + ((Kiralama) Facade.getInstance().get(i, Kiralama.class)).getBitisTarihi().get(GregorianCalendar.YEAR) + "/" + ((Kiralama) Facade.getInstance().get(i, Kiralama.class)).getBitisTarihi().get(GregorianCalendar.MONTH) + "/" +
					((Kiralama) Facade.getInstance().get(i, Kiralama.class)).getBitisTarihi().get(GregorianCalendar.DAY_OF_MONTH) + " | Kalınan gün sayısı : "+((Kiralama) Facade.getInstance().get(i, Kiralama.class)).gunSayisiniGetir()+" | Günlük Fiyat : "+((Kiralama) Facade.getInstance().get(i, Kiralama.class)).getKiralananOda().tutarOgren() + "| Fiyat: " + ((Kiralama) Facade.getInstance().get(i, Kiralama.class)).getFiyat() );
		in.nextLine();
		in.nextLine();
		
		return true;
	}
	
	public boolean menuYoneticiGirisYap(Sistem sistem){
		System.out.println("Yönetici ID giriniz: ");
		int id = in.nextInt();
		if (id != 237){
			System.err.println("Hatalı ID!...\n");
			return false;
		}
		return true;
	}
	
	public boolean menuOdaEkleme(Sistem sistem){
		Oda _oda = sistem.odaEklemeIsleminiBaslat();
		for (Integer i: sistem.aktifOtelGetir().kataloglariGetir()){
			System.out.println(((OdaKatalogu) Facade.getInstance().get(i, OdaKatalogu.class)).katalogIDGetir()+": "+ ((OdaKatalogu) Facade.getInstance().get(i, OdaKatalogu.class)).isimGetir());	
		}
		System.out.println("\nKatalog ID seçiniz: ");
		int __katalogID = in.nextInt();
		sistem.aktifOtelGetir().katalogSec(__katalogID, _oda);
		
		System.out.println("Oda No giriniz: ");
		int __odaNo = in.nextInt();
		while (sistem.aktifOtelGetir().odaGetir(__odaNo) != null){
			System.err.println("Oda Mevcut, başka Oda No giriniz: ");
			__odaNo = in.nextInt();
		}
		sistem.odaOzellikleriBelirt(_oda, __odaNo);
		
		return true;
	}
	
	public boolean menuResepsiyonistEkleme(Sistem sistem){
		Resepsiyonist __resepsiyonist = sistem.resepsiyonistEklemeIsleminiBaslat();
		System.out.println("İsim giriniz: ");
		String __isim = in.nextLine();
		System.out.println("Soyisim giriniz: ");
		String __soyisim = in.nextLine();
		System.out.println("ID giriniz: ");
		int __id = in.nextInt();
		
		while (sistem.aktifOtelGetir().resepsiyonistGetir(__id) != null){
			System.err.println("Aynı ID'ye sahip resepsiyonist var. Başka bir tane giriniz: ");
			__id = in.nextInt();
		}
		sistem.resepsiyonistOzellikleriniGir(__resepsiyonist, __isim, __soyisim, __id);
		return true;
	}
	
	public boolean menuResepsiyonistListeleme(Sistem sistem){
		for (Integer i: sistem.aktifOtelGetir().getReceptionistList())
			System.out.println("Resepsiyonist Adı: " + ((Resepsiyonist) Facade.getInstance().get(i, Resepsiyonist.class)).isimGetir() + " Soyadi: " + ((Resepsiyonist) Facade.getInstance().get(i, Resepsiyonist.class)).soyisimGetir() +
					" ID: " + ((Resepsiyonist) Facade.getInstance().get(i, Resepsiyonist.class)).resepsiyonistIDGetir());
		in.nextLine();
		in.nextLine();
		
		return true;
	}
	
	
	public static void main(String[] args) {
		Sistem sistem = new Sistem();
		/* Varsayılan Sınıflar */
		Otel varsayilanOtel = new Otel("The Overlook Hotel");
		varsayilanOtel.otelIDAyarla(237);
		varsayilanOtel.adresAyarla("The Overlook Hotel");
		
		Resepsiyonist varsayilanResepsiyonist = varsayilanOtel.resepsiyonistYarat();
		varsayilanResepsiyonist.resepsiyonistOzellikleriniGir("Jack", "Torrance", 237);
		Oda varsayilanOda = varsayilanOtel.odaYarat();
		varsayilanOda.odaOzellikleriBelirt(237);
		varsayilanOda.odaKataloguAyarla(new OdaKatalogu("Room 237", 237, (float) 237).getID());
		
		Musteri varsayilanMusteri = varsayilanOtel.musteriKaydiIsleminiBaslat();
		varsayilanMusteri.bilgileriKaydet("Jack", "Torrance", 237, (short) 237);
		
		Kiralama varsayilanKiralama = new Kiralama(varsayilanMusteri.getID());
		varsayilanOtel.uygunOdaSec(237, varsayilanKiralama.getID());
		varsayilanOtel.kiralamaTarihiSec(new GregorianCalendar(2011, 2, 3), 
				new GregorianCalendar(2011, 2, 7), varsayilanKiralama);
		
		varsayilanOtel.kiralamaSonlandir(varsayilanKiralama.getID());
		
//		sistem.otelListesi.add(varsayilanOtel);
	    
		/* Varsayılan Sınıflar */
	
		
		
		sistem.otelListesi.add(varsayilanOtel.getID());

		Scanner in = new Scanner(System.in);
		int gelenInt = -1;
		String gelenStr = "";
		while (gelenInt != 0){
			sistem.anaMenuYazdir();
			gelenInt = in.nextInt();
			if (gelenInt == 1){
				if (!sistem.menuOtelSec(sistem))
					continue;
			}
			else if (gelenInt == 2){
				if (!sistem.menuOtelYarat(sistem));
					continue;
			}
			
			else if (gelenInt == 3){
				if (!sistem.menuOtelListele(sistem));
				continue;
			}
			else {
				System.err.println("Yanlış seçim.");
				continue;
			}
			
			
			while (gelenInt != 9 && gelenInt != 0){
				sistem.otelYazdir();
				gelenInt = in.nextInt();
				if (gelenInt == 1){
					
					if (!sistem.menuResepsiyonistGirisYap(sistem))
						continue;
						
					
					while (gelenInt != 8 && gelenInt != 9 && gelenInt != 0){
						sistem.resepsiyonistMenuYazdir();
						gelenInt = in.nextInt();
						// FIXME:
						in.nextLine();
						if (gelenInt == 1){
							
							if(!sistem.menuMusteriKayit(sistem)){
								System.err.println("Musteri Kaydı yapılamadı.");
								continue;
							}
						}
						
						else if (gelenInt == 2){
							if (!sistem.menuMusteriListesi(sistem)){
								System.err.println("Liste Getirilemedi.");
								continue;
							}
						}
						
						else if (gelenInt == 3){
							if (!sistem.menuOdaKiralama(sistem)){
								System.err.println("Oda Kiralama Başarısız.");
								continue;
							}
						}
						
						else if (gelenInt == 4){
							if (!sistem.menuBosOdalar(sistem)){
								System.err.println("Boş oda listeleme başarısız.");
								continue;
							}
						}
						
						else if (gelenInt == 7){
							
							if (!sistem.menuKiralamaListeleme(sistem)){
								System.err.println("Kiralama Listeleme başarısız.");
								continue;
							}
							
						}
						
					}
				}
				
				else if (gelenInt == 2){
					if (!sistem.menuYoneticiGirisYap(sistem)){
						System.err.println("Yönetici girişi başarısız.");
						continue;
					}
					
					while (gelenInt != 8 && gelenInt != 9 && gelenInt != 0){
						yoneticiMenuYazdir();
						gelenInt = in.nextInt();
						// FIXME:
						in.nextLine();
						
						if (gelenInt == 1){
							if (!sistem.menuMusteriKayit(sistem)){
								System.err.println("Musteri kayıt başarısız.");
								continue;
							}
							
						}
						
						else if (gelenInt == 2){
							if (!sistem.menuMusteriListesi(sistem)){
								System.err.println("Liste Getirilemedi.");
								continue;
							}
						}
						
						else if (gelenInt == 3){
							if (!sistem.menuOdaKiralama(sistem)){
								System.err.println("Oda Kiralama Başarısız.");
								continue;
							}
						}
						
						else if (gelenInt == 4){
							if (!sistem.menuBosOdalar(sistem)){
								System.err.println("Boş oda listeleme başarısız.");
								continue;
							}
						}
						
						else if (gelenInt == 5){
							if (!sistem.menuOdaEkleme(sistem)){
								System.err.println("Oda ekleme başarısız.");
								continue;
							}
						}
						else if (gelenInt == 6){
							
							if (!sistem.menuResepsiyonistEkleme(sistem)){
								System.err.println("Resepsiyonist ekleme başarısız.");
								continue;
							}
							
						}
						else if (gelenInt == 7){
							if (!sistem.menuKiralamaListeleme(sistem)){
								System.err.println("Kiralama Listeleme başarısız.");
								continue;
							}
							
						}
						
						else if (gelenInt == 10){
							
							if (!sistem.menuResepsiyonistListeleme(sistem)){
								System.err.println("Resepsiyonist Listeleme Başarısız.");
								continue;
							}
							
						}
					}
				}
				
				else if (gelenInt == 9)
					break;
				
				else if (gelenInt == 0)
					System.exit(0);
				
				else {
					System.out.println("\n\nYanlis Secim.\n\n");
				}
			}
		}
	}



	
}
