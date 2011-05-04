
public class Musteri {
	private String adi;
	private String soyadi;
	private long tcKimlikNo;
	private short yas;
	private boolean uygunluk;
	private MusteriTipi musteriTipi;
	
	public Musteri(String _adi, String _soyadi, long _tcKimlikNo, short _yas, MusteriTipi musteriTipi) {
		this.adi = _adi;
		this.soyadi = _soyadi;
		this.tcKimlikNo = _tcKimlikNo;
		this.yas = _yas;
		this.uygunluk = true;
		this.musteriTipi = musteriTipi;
	}
	
	public Musteri() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean uygunlukGetir(){
		return this.uygunluk;
	}
	
	public void uygunlukAyarla(boolean uygunlukDurumu){
		this.uygunluk = uygunlukDurumu;
	}
	
	public String adGetir() {
		return adi;
	}
	public void adAyarla(String adi) {
		this.adi = adi;
	}
	public String soyadGetir() {
		return soyadi;
	}
	public void soyadAyarla(String soyadi) {
		this.soyadi = soyadi;
	}
	public long tcKimlikNoGetir() {
		return tcKimlikNo;
	}
	public void tcKimlikNoAyarla(long _tcKimlikNo) {
		this.tcKimlikNo = _tcKimlikNo;
	}
	public short yasGetir() {
		return yas;
	}
	public void yasAyarla(short yas) {
		this.yas = yas;
	}
	
	public MusteriTipi musteriTipiGetir(){
		return (this.musteriTipi);
	}
	
	public void bilgileriKaydet(String musteriAdi, String musteriSoyadi,
			long musteriTcKimlikNo, short yas) {
		adAyarla(musteriAdi);
		soyadAyarla(musteriSoyadi);
		tcKimlikNoAyarla(musteriTcKimlikNo);
		yasAyarla(yas);
	}

}
