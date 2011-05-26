package UnitTypes;

import DatabasePackage.Facade;

public class Musteri {
	private int ID;
	private String adi;
	private String soyadi;
	private long tcKimlikNo;
	private short yas;
	private boolean uygunluk;
	private int musteriTipiID;
	
	public Musteri(String _adi, String _soyadi, long _tcKimlikNo, short _yas, int musteriTipiID) {
		this.adi = _adi;
		this.soyadi = _soyadi;
		this.tcKimlikNo = _tcKimlikNo;
		this.yas = _yas;
		this.uygunluk = true;
		this.musteriTipiID = musteriTipiID;
		this.setID(Facade.getInstance().getAvailableID(Musteri.class));
	}

	public Musteri() {
		this.uygunluk = true;
		this.musteriTipiID = (new MusteriTipi("Standart")).getID();
		this.setID(Facade.getInstance().getAvailableID(Musteri.class));
	}

	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return this.ID;
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
	
	public int getMusteriTipiID(){
		return this.musteriTipiID;
	}
	public MusteriTipi musteriTipiGetir(){
		return (MusteriTipi) Facade.getInstance().get(this.getMusteriTipiID(), MusteriTipi.class);
	}
	
	public void bilgileriKaydet(String musteriAdi, String musteriSoyadi,
			long musteriTcKimlikNo, short yas) {
		adAyarla(musteriAdi);
		soyadAyarla(musteriSoyadi);
		tcKimlikNoAyarla(musteriTcKimlikNo);
		yasAyarla(yas);
		Facade.getInstance().set(this, Musteri.class);
	}

}
