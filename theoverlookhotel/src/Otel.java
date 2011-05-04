import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class Otel {
	private String isim;
	private List<Oda> odaListesi;
	private List<Resepsiyonist> resepsiyonistListesi;
	private List<Musteri> musteriListesi;
	private List<OdaKatalogu>  katalogListesi;
	private List<Kiralama> kiralamaListesi;
	private boolean uygunluk;
	private int otelID;
	
	public List<Musteri> musteriListesiGetir() {
		return musteriListesi;
	}

	public void musteriListesiAyarla(List<Musteri> musteriListesi) {
		this.musteriListesi = musteriListesi;
	}
	
	public void musteriEkle(Musteri _musteri){
		musteriListesi.add(_musteri);
	}
	
	public void musteriSil(long _tcKimlikNo){
		for (Musteri i: musteriListesi){
			if (i.tcKimlikNoGetir() == _tcKimlikNo)
				musteriListesi.remove(i);
		}
	}
	
	public Musteri musteriGetir(long musteriTcKimlikNo){
		for (Musteri i: musteriListesi){
			if (i.tcKimlikNoGetir() == musteriTcKimlikNo)
				return i;
		}
		return null;
	}
	
	public Musteri musteriKaydiIsleminiBaslat() {
		Musteri _musteri = new Musteri();
		musteriEkle(_musteri);
		return _musteri;
	}
	
	public void musteriKayitBilgileriniGonder(Musteri m, String musteriAdi, String musteriSoyadi, 
			long musteriTcKimlikNo, short yas) {
		m.bilgileriKaydet(musteriAdi, musteriSoyadi, musteriTcKimlikNo, yas);
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
		odaListesi = new ArrayList<Oda>();
		resepsiyonistListesi = new ArrayList<Resepsiyonist>();
		musteriListesi = new ArrayList<Musteri>();
		katalogListesi = new ArrayList<OdaKatalogu>();
		kiralamaListesi = new ArrayList<Kiralama>();
		OdaKatalogu katalog1 = new OdaKatalogu("standart", 1, (float) 2.0);
		this.katalogEkle(katalog1);
		OdaKatalogu katalog2 = new OdaKatalogu("vip", 2, (float) 5.0);
		this.katalogEkle(katalog2);
		OdaKatalogu katalog3 = new OdaKatalogu("ekonomik", 3, (float) 1.0);
		this.katalogEkle(katalog3);
		
	}
	
	public Otel() {
		odaListesi = new ArrayList<Oda>();
		resepsiyonistListesi = new ArrayList<Resepsiyonist>();
		musteriListesi = new ArrayList<Musteri>();
		katalogListesi = new ArrayList<OdaKatalogu>();
		kiralamaListesi = new ArrayList<Kiralama>();
		OdaKatalogu katalog1 = new OdaKatalogu("standart", 1, (float) 2.0);
		this.katalogEkle(katalog1);
		OdaKatalogu katalog2 = new OdaKatalogu("vip", 2, (float) 5.0);
		this.katalogEkle(katalog2);
		OdaKatalogu katalog3 = new OdaKatalogu("ekonomik", 3, (float) 1.0);
		this.katalogEkle(katalog3);
	}
	
	public int resepsiyonistEkle(String _isim, String _soyisim){
		Resepsiyonist _resepsiyonist = new Resepsiyonist(_isim, _soyisim, resepsiyonistListesi.size());
		resepsiyonistListesi.add(_resepsiyonist);
		return _resepsiyonist.resepsiyonistIDGetir();
	}
	
	public boolean resepsiyonistSil(int _resepsiyonistID){
		for (Resepsiyonist i: resepsiyonistListesi){
			if (i.resepsiyonistIDGetir() == _resepsiyonistID){
				resepsiyonistListesi.remove(i);
				return true;
			}
		}
		
		return false;	
	}
	
	public List<Resepsiyonist> uygunResepsiyonistleriGetir(){
		List<Resepsiyonist> _innerList = new ArrayList<Resepsiyonist>();
		for (Resepsiyonist i: resepsiyonistListesi){
			if (i.uygunMu())
				_innerList.add(i);			
		}
		return _innerList;
	}
	
	public void katalogEkle(OdaKatalogu katalog){
		katalogListesi.add(katalog);
	}
	
	public boolean odaSil(int _odaID){
		for (Oda i: odaListesi){
			if (i.odaIDGetir() == _odaID){
				odaListesi.remove(i);
				return true;
			}
		}
		
		return false;	
	}
	
	public Oda odaGetir(int _odaID){
		for (Oda i: odaListesi){
			if (i.odaIDGetir() == _odaID){
				return i;
			}
		}
		System.err.println("oda yok.");
		
		return null;
	}
	
	public List<Oda> uygunOdalariGetir(Musteri musteri){
		List<Oda> _innerList = new ArrayList<Oda>();
		for (Oda i: odaListesi){
			if (i.uygunMu(musteri))
				_innerList.add(i);
		}
		return _innerList;
	}
	
	public List<Oda> bosOdalariGetir(){
		List<Oda> _innerList = new ArrayList<Oda>();
		for (Oda i: odaListesi){
			if (i.isAvailable() && i.bosMu())
				_innerList.add(i);
		}
		return _innerList;
	}
	
	public String isimGetir() {
		return isim;
	}
	public void isimAyarla(String _isim) {
		this.isim = _isim;
	}
	public List<Oda> odaListesiGetir() {
		return odaListesi;
	}
	public void setRoomList(List<Oda> roomList) {
		this.odaListesi = roomList;
	}
	public List<Resepsiyonist> getReceptionistList() {
		return resepsiyonistListesi;
	}
	public void setReceptionistList(List<Resepsiyonist> receptionistList) {
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
		odaListesi.add(_oda);
		return _oda;
	}

	public Resepsiyonist resepsiyonistYarat() {
		Resepsiyonist _resepsiyonist;
		_resepsiyonist = new Resepsiyonist();
		
		resepsiyonistListesi.add(_resepsiyonist);
		return _resepsiyonist;
	}

	public void otelOzellikleriniGir(String _otelAdi, int _otelID) {
		isimAyarla(_otelAdi);
		otelIDAyarla(_otelID);
	}

	public void uygunOdaSec(int odaID, Kiralama kiralama) {
		Oda oda = this.odaGetir(odaID);
		kiralama.odaSec(oda);
	}

	public float kiralamaTarihiSec(GregorianCalendar _baslangicTarihi,
			GregorianCalendar _bitisTarihi, Kiralama kiralama) {
		kiralama.kiralamaTarihiSec(_baslangicTarihi, _bitisTarihi);
		float tutar = kiralama.tutarOgren();
		return tutar;
	}

	public void kiralamaSonlandir(Kiralama kiralama) {
		kiralama.sonlandir();
		kiralamaListesi.add(kiralama);
	}
	
	public List<Kiralama> kiralamaListesiGetir(){
		return kiralamaListesi;
	}
	
	public List<OdaKatalogu> kataloglariGetir() {
		return this.katalogListesi;
	}
	
	public OdaKatalogu katalogGetir(int _katalogID){
		for (OdaKatalogu i: this.kataloglariGetir()){
			if (i.katalogIDGetir() == _katalogID)
				return i;
		}
		return null;
	}
	
	public void katalogSec(int __katalogID, Oda oda) {
		
		OdaKatalogu katalog = katalogGetir(__katalogID); 
		oda.katalogSec(katalog);
	}
}
