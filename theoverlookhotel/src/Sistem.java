import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


public class Sistem {
	private List<Otel> otelListesi = new ArrayList<Otel>();
	private Otel aktifOtel;
	private Resepsiyonist aktifResepsiyonist;
	private Kiralama kiralama;
	
	public Musteri musteriKaydiIsleminiBaslat() {
		return aktifOtel.musteriKaydiIsleminiBaslat();

	}
	
	public void musteriKayitBilgileriniGonder(Musteri m, String musteriAdi, String musteriSoyadi, 
			long __id, short yas) {
		aktifOtel.musteriKayitBilgileriniGonder(m, musteriAdi, musteriSoyadi, __id, yas);
	}
	
	public List<Oda> odaKiralamaIsleminiBaslat(long musteriTcKimlikNo) {
		Musteri musteri = aktifOtel.musteriGetir(musteriTcKimlikNo);
		this.kiralama = new Kiralama(musteri);
		return aktifOtel.uygunOdalariGetir(musteri);

	}
	
	public List<OdaKatalogu> kataloglariGetir(){
		return this.aktifOtel.kataloglariGetir();
	}
	
	public void katalogSec(int _katalogID,Oda oda){
		this.aktifOtel.katalogSec(_katalogID,oda);
	}
	
	public void uygunOdaSec(int odaID) {
		aktifOtel.uygunOdaSec(odaID, kiralama);
	}
	
	public float kiralamaTarihiSec(int girisGun, int girisAy, int girisYil,
								int cikisGun, int cikisAy, int cikisYil) {

		float tutar = aktifOtel.kiralamaTarihiSec(new GregorianCalendar(girisYil, girisAy, girisGun), 
				new GregorianCalendar(cikisYil, cikisAy, cikisGun), kiralama);
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
	
	public void anaMenuYazdir(){
		System.out.println("-----TheOverLookHotel Systems-----\n" +
				"\n1. Otele giriş." +
				"\n2. Otel yarat." +
				"\n0. Çıkış." +
				"\n-----------TheOverLookHotel Systems---------Seçiminiz: ");
	}
	
	public void otelYazdir() {
		System.out.println("-------"+aktifOtel.isimGetir()+"-------\n" +
				"\n1. Sistem'e Resepsiyonist olarak giriş yap. " +
				"\n2. Sistem'e Yönetici olarak giriş yap." +
				"\n\n\n0. Çıkış." +
				"\n\n-------"+aktifOtel.isimGetir()+"-------\nSeçiminiz: ");
	}
	
	private void resepsiyonistMenuYazdir() {
		System.out.println("-------"+aktifOtel.isimGetir()+"-------\n" +
				"\n=======Resepsiyonist: "+aktifResepsiyonist.isimGetir()+" " + aktifResepsiyonist.soyisimGetir() +"=======\n" +
				"\n1. Müşteri Kayıt işlemi. " +
				"\n2. Müşteri Listeleme işlemi." +
				"\n3. Oda Kiralama İşlemi." +
				"\n4. Boş Oda Listeleme İşlemi" +
				"\n7. Kiralamaları Listeleme işlemi." +
				"\n\n\n8. Otel Menü'ye geri dön." +
				"\n9. Sistem Menü'ye geri gön." +
				"\n0. Sistemden Çıkış." +
				"\n=======Resepsiyonist: "+aktifResepsiyonist.isimGetir()+" " + aktifResepsiyonist.soyisimGetir() +"=======\n" +
				"\n\n-------"+aktifOtel.isimGetir()+"-------\nSeçiminiz: ");

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
				"\n\n\n8. Otel Menü'ye geri dön." +
				"\n9. Sistem Menü'ye geri gön." +
				"\n0. Sistemden Çıkış." +
				"\n\n-------TheOverLookHotel-------\nSeçiminiz: ");

	}
	
	public boolean resepsiyonistIDSorgula(int id){
		for (Resepsiyonist i: aktifOtel.getReceptionistList()){
			if (i.resepsiyonistIDGetir() == id)
				return true;
		}
		return false;
	}
	
	public boolean otelIDSorgula(int id){
		for (Otel i: otelListesi){
			if (i.otelIDGetir() == id)
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
	
	public Otel otelGetir(int id){
		for (Otel i: otelListesi){
			if (i.otelIDGetir() == id)
				return i;
		}
		return null;
	}
	
	public void aktifResepsiyonistAyarla(Resepsiyonist _resepsiyonist){
		this.aktifResepsiyonist = _resepsiyonist;
	}
	
	public Resepsiyonist resepsiyonistGetir(int id){
		for (Resepsiyonist i: aktifOtel.getReceptionistList()){
			if (i.resepsiyonistIDGetir() == id)
				return i;
		}
		return null;
	}
	
	public Kiralama kiralamaGetir(){
		return this.kiralama;
	}
	
	public void kiralamaAyarla(Kiralama _kiralama){
		this.kiralama = _kiralama;
	}
	
	
	public static void main(String[] args) {
		Sistem sistem = new Sistem();
		
		Otel varsayilanOtel = new Otel("The Overlook Hotel");
		varsayilanOtel.otelIDAyarla(237);
		
		Resepsiyonist varsayilanResepsiyonist = varsayilanOtel.resepsiyonistYarat();
		varsayilanResepsiyonist.resepsiyonistOzellikleriniGir("Jack", "Torrance", 237);
	
		sistem.otelListesi.add(varsayilanOtel);

		Scanner in = new Scanner(System.in);
		int gelenInt = -1;
		String gelenStr = "";
		int id = 0;
		while (gelenInt != 0){
			sistem.anaMenuYazdir();
			gelenInt = in.nextInt();
			if (gelenInt == 1){
				System.out.println("Otel ID giriniz: ");
				int gelenID = in.nextInt();
				
				if (!sistem.otelIDSorgula(gelenID)){
					System.err.println("Yanlış Otel ID!...\n");
					continue;
				}
				 
				sistem.aktifOtelAyarla(sistem.otelGetir(gelenID));
			}
			else if (gelenInt == 2){
				in.nextLine();
				Otel _otel = sistem.otelEklemeIsleminiBaslat();
				System.out.println("Otel Adı giriniz: ");
				String __ad = in.nextLine();
				System.out.println("Otel ID giriniz: ");
				int __id = in.nextInt();
				sistem.otelOzellikleriniGir(_otel, __ad, __id);
				continue;
			}
			else 
				continue;
			
			
			while (gelenInt != 9 && gelenInt != 0){
				sistem.otelYazdir();
				gelenInt = in.nextInt();
				if (gelenInt == 1){
					System.out.println("Resepsiyonist ID giriniz: ");
					id = in.nextInt();
					if (!sistem.resepsiyonistIDSorgula(id)){
						System.err.println("Hatalı ID!...\n");
						continue;
						
					}
					
					sistem.aktifResepsiyonistAyarla(sistem.resepsiyonistGetir(id));
						
					
					while (gelenInt != 8 && gelenInt != 9 && gelenInt != 0){
						sistem.resepsiyonistMenuYazdir();
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
						
						else if (gelenInt == 3){
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
						}
						
						else if (gelenInt == 4){
							for (Oda i: sistem.aktifOtelGetir().odaListesiGetir())
								System.out.println("OdaID:" + i.odaIDGetir());
							
							in.nextLine();
						}
						
						else if (gelenInt == 7){
							for (Kiralama i: sistem.aktifOtelGetir().kiralamaListesiGetir())
								System.out.println("Oda: " + i.getKiralananOda().odaIDGetir() + "|Ad: " + 
										i.getKiralayanMusteri().adGetir() + "|Giris:" + i.baslangicTarihiGetir().YEAR + ":" 
										+ i.baslangicTarihiGetir().MONTH + ":" + i.baslangicTarihiGetir().DAY_OF_MONTH +
										"|Cikis" + i.getBitisTarihi().YEAR + ":" + i.getBitisTarihi().MONTH + ":" +
										i.getBitisTarihi().DAY_OF_MONTH + "Fiyat: " + i.getFiyat());
							in.nextLine();
						}
						
					}
				}
				
				else if (gelenInt == 2){
					System.out.println("Yönetici ID giriniz: ");
					id = in.nextInt();
					if (id != 237){
						System.err.println("Hatalı ID!...\n");
						continue;
					}
					
					while (gelenInt != 8 && gelenInt != 9 && gelenInt != 0){
						yoneticiMenuYazdir();
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
						
						else if (gelenInt == 3){
							System.out.println("Tc Kimlik No girin: ");
							long _tcKimlikNo = in.nextLong();
							for (Oda i: sistem.odaKiralamaIsleminiBaslat(_tcKimlikNo)){
								System.out.println("OdaID:" + i.odaIDGetir());
							}
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
							in.nextLine();
							
							sistem.kiralamaSonlandir();
						}
						
						else if (gelenInt == 4){
							for (Oda i: sistem.aktifOtelGetir().odaListesiGetir())
								System.out.println("OdaID:" + i.odaIDGetir());
							
							in.nextLine();
						}
						
						else if (gelenInt == 5){
							Oda _oda = sistem.odaEklemeIsleminiBaslat();
							for (OdaKatalogu i: sistem.aktifOtelGetir().kataloglariGetir()){
								System.out.println(i.katalogIDGetir()+": "+ i.isimGetir());	
							}
							System.out.println("\nKatalog ID seçiniz: ");
							int __katalogID = in.nextInt();
							sistem.aktifOtelGetir().katalogSec(__katalogID, _oda);
							
							System.out.println("Oda No giriniz: ");
							int __odaNo = in.nextInt();
							sistem.odaOzellikleriBelirt(_oda, __odaNo);
						}
						else if (gelenInt == 6){
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
						else if (gelenInt == 7){
							for (Kiralama i: sistem.aktifOtelGetir().kiralamaListesiGetir())
								System.out.println("Oda: " + i.getKiralananOda().odaIDGetir() + "|Ad: " + 
										i.getKiralayanMusteri().adGetir() + "|Giris:" + i.baslangicTarihiGetir().YEAR + ":" 
										+ i.baslangicTarihiGetir().MONTH + ":" + i.baslangicTarihiGetir().DAY_OF_MONTH +
										"|Cikis" + i.getBitisTarihi().YEAR + ":" + i.getBitisTarihi().MONTH + ":" +
										i.getBitisTarihi().DAY_OF_MONTH + "Fiyat: " + i.getFiyat());
							in.nextLine();
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

	
}
