package UnitTypes;
import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.sound.midi.Receiver;

import DatabasePackage.Facade;



public class Otel {
	private int ID;
	private String isim = "";
	private String adres = "";
	private List<Integer> odaListesi;
	private List<Integer> resepsiyonistListesi;
	private List<Integer> musteriListesi;
	private List<Integer>  katalogListesi;
	private List<Integer> kiralamaListesi;
	private boolean uygunluk;
	private int otelID;
	
	public List<Musteri> musteriListesiGetir() {
		List<Musteri> musteriList = new ArrayList<Musteri>();
		for (Integer i: musteriListesi)
			musteriList.add((Musteri) Facade.getInstance().get(i.intValue(), Musteri.class));
		return musteriList;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return this.ID;
	}

	public void musteriListesiAyarla(List<Integer> musteriListesi) {
		this.musteriListesi = musteriListesi;
	}
	
	public void musteriEkle(int _musteriID){
		musteriListesi.add(_musteriID);
	}
	
	/*public void musteriSil(long _tcKimlikNo){
		for (Musteri i: musteriListesi){
			if (i.tcKimlikNoGetir() == _tcKimlikNo)
				musteriListesi.remove(i);
		}
	}*/
	
	public Musteri musteriGetir(long musteriTcKimlikNo){
		for (Integer i: musteriListesi){
			if (((Musteri) Facade.getInstance().get(i.intValue(), Musteri.class)).tcKimlikNoGetir() == musteriTcKimlikNo)
				return ((Musteri) Facade.getInstance().get(i.intValue(), Musteri.class));
		}
		return null;
	}
	
	public Musteri musteriKaydiIsleminiBaslat() {
		Musteri _musteri = new Musteri();
		musteriEkle(_musteri.getID());
		return _musteri;
	}
	
	public void musteriKayitBilgileriniGonder(Musteri musteri, String musteriAdi, String musteriSoyadi, 
			long musteriTcKimlikNo, short yas) {
		musteri.bilgileriKaydet(musteriAdi, musteriSoyadi, musteriTcKimlikNo, yas);
	}

	public int otelIDGetir() {
		return otelID;
	}

	public void otelIDAyarla(int _otelID) {
		this.otelID = _otelID;
	}

	public Otel(String _Name) {
		this.isim = _Name;
		this.uygunluk = true;
		odaListesi = new ArrayList<Integer>();
		resepsiyonistListesi = new ArrayList<Integer>();
		musteriListesi = new ArrayList<Integer>();
		katalogListesi = new ArrayList<Integer>();
		kiralamaListesi = new ArrayList<Integer>();
		OdaKatalogu katalog1 = new OdaKatalogu("standart", 1, (float) 2.0);
		this.katalogEkle(katalog1.getID());
		OdaKatalogu katalog2 = new OdaKatalogu("vip", 2, (float) 5.0);
		this.katalogEkle(katalog2.getID());
		OdaKatalogu katalog3 = new OdaKatalogu("ekonomik", 3, (float) 1.0);
		this.katalogEkle(katalog3.getID());
		this.setID(Facade.getInstance().getAvailableID(Otel.class));
		
	}
	
	public Otel() {
		odaListesi = new ArrayList<Integer>();
		resepsiyonistListesi = new ArrayList<Integer>();
		musteriListesi = new ArrayList<Integer>();
		katalogListesi = new ArrayList<Integer>();
		kiralamaListesi = new ArrayList<Integer>();
		OdaKatalogu katalog1 = new OdaKatalogu("standart", 1, (float) 2.0);
		this.katalogEkle(katalog1.getID());
		OdaKatalogu katalog2 = new OdaKatalogu("vip", 2, (float) 5.0);
		this.katalogEkle(katalog2.getID());
		OdaKatalogu katalog3 = new OdaKatalogu("ekonomik", 3, (float) 1.0);
		this.katalogEkle(katalog3.getID());
		this.setID(Facade.getInstance().getAvailableID(Otel.class));
	}
	
	public int resepsiyonistEkle(String _isim, String _soyisim){
		Resepsiyonist _resepsiyonist = new Resepsiyonist(_isim, _soyisim, resepsiyonistListesi.size());
		resepsiyonistListesi.add(_resepsiyonist.getID());
		return _resepsiyonist.resepsiyonistIDGetir();
	}
	/*
	public boolean resepsiyonistSil(int _resepsiyonistID){
		for (Resepsiyonist i: resepsiyonistListesi){
			if (i.resepsiyonistIDGetir() == _resepsiyonistID){
				resepsiyonistListesi.remove(i);
				return true;
			}
		}
		
		return false;	
	}
	*/
	public List<Resepsiyonist> uygunResepsiyonistleriGetir(){
		List<Resepsiyonist> _innerList = new ArrayList<Resepsiyonist>();
		for (Integer i: resepsiyonistListesi){
			if (((Resepsiyonist) Facade.getInstance().get(i.intValue(), Resepsiyonist.class)).uygunMu())
				_innerList.add((Resepsiyonist) Facade.getInstance().get(i.intValue(), Resepsiyonist.class));			
		}
		return _innerList;
	}
	
	public void katalogEkle(int katalogID){
		katalogListesi.add(katalogID);
	}
	
	/*public boolean odaSil(int _odaID){
		for (Oda i: odaListesi){
			if (i.odaIDGetir() == _odaID){
				odaListesi.remove(i);
				return true;
			}
		}
		
		return false;	
	}
	*/
	public Oda odaGetir(int _odaID){
		for (Integer i: odaListesi){
			if (((Oda) Facade.getInstance().get(i.intValue(), Oda.class)).odaIDGetir() == _odaID){
				return (Oda) Facade.getInstance().get(i.intValue(), Oda.class);
			}
		}
//		System.err.println("oda yok.");
		
		return null;
	}
	
	public List<Oda> uygunOdalariGetir(Musteri musteri){
		List<Oda> _innerList = new ArrayList<Oda>();
		for (Integer i: odaListesi){
			if (((Oda) Facade.getInstance().get(i.intValue(), Oda.class)).uygunMu(musteri) &&
					((Oda) Facade.getInstance().get(i.intValue(), Oda.class)).uygunMu(musteri))
				_innerList.add(((Oda) Facade.getInstance().get(i.intValue(), Oda.class)));
		}
		return _innerList;
	}
	
	public List<Oda> bosOdalariGetir(){
		List<Oda> _innerList = new ArrayList<Oda>();
		for (Integer i: odaListesi){
			if (((Oda) Facade.getInstance().get(i.intValue(), Oda.class)).isAvailable() && 
					((Oda) Facade.getInstance().get(i.intValue(), Oda.class)).bosMu())
				_innerList.add(((Oda) Facade.getInstance().get(i.intValue(), Oda.class)));
		}
		return _innerList;
	}
	
	public String adresGetir() {
		return this.adres;
	}
	
	public void adresAyarla(String _adres){
		this.adres = _adres;
	}
	
	public String isimGetir() {
		return isim;
	}
	public void isimAyarla(String _isim) {
		this.isim = _isim;
	}
	public List<Integer> odaListesiGetir() {
		return odaListesi;
	}
	public void setRoomList(List<Integer> roomList) {
		this.odaListesi = roomList;
	}
	public List<Resepsiyonist> getReceptionistList() {
		List<Resepsiyonist> liste= new ArrayList<Resepsiyonist>();
		for (Integer i:this.resepsiyonistListesi){
			Resepsiyonist resepsiyonist = (Resepsiyonist) Facade.getInstance().get(i, Resepsiyonist.class);
			liste.add(resepsiyonist);
		}
		return liste;
	}
	public void setReceptionistList(List<Integer> receptionistList) {
		this.resepsiyonistListesi = receptionistList;
	}
	public boolean isAvailable() {
		return uygunluk;
	}
	public void setAvailable(boolean isAvailable) {
		this.uygunluk = isAvailable;
	}

	public Oda odaYarat() {
		Oda _oda = new Oda();
		odaListesi.add(_oda.getID());
		return _oda;
	}

	public Resepsiyonist resepsiyonistYarat() {
		Resepsiyonist _resepsiyonist;
		_resepsiyonist = new Resepsiyonist();
		
		resepsiyonistListesi.add(_resepsiyonist.getID());
		return _resepsiyonist;
	}

	public void otelOzellikleriniGir(String _otelAdi, String __adres, int _otelID) {
		isimAyarla(_otelAdi);
		otelIDAyarla(_otelID);
		adresAyarla(__adres);
		Facade.getInstance().set(this, Otel.class);
	}

	public void uygunOdaSec(int odaID, Kiralama k) {
		Oda oda = this.odaGetir(odaID);
		k.odaSec(oda.getID());
	}

	public float kiralamaTarihiSec(GregorianCalendar _baslangicTarihi,
			GregorianCalendar _bitisTarihi, Kiralama kiralama) {
		kiralama.kiralamaTarihiSec(_baslangicTarihi, _bitisTarihi);
		float tutar = kiralama.tutarOgren();
		return tutar;
	}

	public void kiralamaSonlandir(Kiralama kiralama) {
		kiralama.sonlandir();
		kiralamaListesi.add(kiralama.getID());
	}
	
	public List<Kiralama> kiralamaListesiGetir(){
		List<Kiralama> liste = new ArrayList<Kiralama>();
		for (Integer i: this.kiralamaListesi){
			liste.add((Kiralama) Facade.getInstance().get(i.intValue(), Kiralama.class));
		}
		return liste;
	}
	
	public List<OdaKatalogu> kataloglariGetir() {
		List<OdaKatalogu> liste = new ArrayList<OdaKatalogu>();
		for (Integer i: this.katalogListesi){
			liste.add((OdaKatalogu) Facade.getInstance().get(i.intValue(), OdaKatalogu.class));
		}
		return liste;
	}
	
	public OdaKatalogu katalogGetir(int _katalogID){
		for (Integer i: this.katalogListesi){
			if (((OdaKatalogu) Facade.getInstance().get(i.intValue(), OdaKatalogu.class)).katalogIDGetir() == _katalogID)
				return ((OdaKatalogu) Facade.getInstance().get(i.intValue(), OdaKatalogu.class));
		}
		return null;
	}
	
	public void katalogSec(int __katalogID, Oda oda) {
		
		OdaKatalogu katalog = katalogGetir(__katalogID); 
		oda.katalogSec(katalog);
	}

	public Object resepsiyonistGetir(int __id) {
		for (Integer i: this.resepsiyonistListesi){
			if (((Resepsiyonist) Facade.getInstance().get(i.intValue(), Resepsiyonist.class)).resepsiyonistIDGetir() == __id)
				return ((Resepsiyonist) Facade.getInstance().get(i.intValue(), Resepsiyonist.class));
		}
		return null;
	}
}
