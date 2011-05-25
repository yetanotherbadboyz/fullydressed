package UnitTypes;

import java.util.GregorianCalendar;

public class Kiralama {
	private int ID;
	private boolean uygunluk;
	private GregorianCalendar baslangicTarihi;
	private GregorianCalendar bitisTarihi;
	private int kiralananOdaID;
	private int kiralayanMusteriID;
	private float fiyat;
	private boolean sonlanma;

	public Kiralama(GregorianCalendar _baslangicTarihi, GregorianCalendar _bitisTarihi, int _kiralananOdaID, 
			int _kiralayanMusteriID) {
		this.baslangicTarihi = _baslangicTarihi;
		this.bitisTarihi = _bitisTarihi;
		this.kiralananOdaID = _kiralananOdaID;
		this.kiralayanMusteriID = _kiralayanMusteriID;
		this.uygunluk = true;
		this.sonlanma = false;
		
	}
	
	public Kiralama() {
		// TODO Auto-generated constructor stub
	}

	
	public Kiralama(Musteri musteriID) {
		this.kiralayanMusteri = musteriID;
	}

	public void setID(int ID){
		this.ID = ID;
	}
	
	public int getID(){
		return this.ID;
	}

	public void kiralamaTarihiSec(GregorianCalendar _baslangicTarihi, GregorianCalendar _bitisTarihi){
		this.baslangicTarihi = _baslangicTarihi;
		this.bitisTarihi = _bitisTarihi;
		this.tutarAyarla();
	}
	
	public boolean uygunMu() {
		return uygunluk;
	}
	public void uygunlukAyarla(boolean uygunMu) {
		this.uygunluk = uygunMu;
	}
	public GregorianCalendar baslangicTarihiGetir() {
		return baslangicTarihi;
	}
	public void baslangicTarihiSec(GregorianCalendar baslangicTarihi) {
		this.baslangicTarihi = baslangicTarihi;
	}
	public GregorianCalendar getBitisTarihi() {
		return bitisTarihi;
	}
	public void setBitisTarihi(GregorianCalendar bitisTarihi) {
		this.bitisTarihi = bitisTarihi;
	}
	public Oda getKiralananOda() {
		return kiralananOda;
	}
	public void setKiralananOda(Oda kiralananOda) {
		this.kiralananOda = kiralananOda;
		this.fiyat = this.kiralananOda.tutarOgren();
	}
	public Musteri getKiralayanMusteri() {
		return kiralayanMusteri;
	}
	public void setKiralayanMusteri(Musteri kiralayanMusteri) {
		this.kiralayanMusteri = kiralayanMusteri;
	}
	public float getFiyat() {
		return fiyat;
	}
	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}

	public void odaSec(Oda _oda) {
		_oda.bosOlmaDurumuAyarla(false);
		this.setKiralananOda(_oda);
		
	}
	
	public void tutarAyarla() {
		float gunlukFiyat = this.kiralananOda.tutarOgren();
		int gunSayisi = this.gunSayisiniGetir();
		this.setFiyat(gunlukFiyat*gunSayisi);
	}

	public float tutarOgren() {
		return this.getFiyat();
	}
	
	public boolean sonlandiMi(){
		return this.sonlanma;
	}
	
	public void sonlandir(){
		this.sonlanma = true;
	}

    public int gunSayisiniGetir() {
    	GregorianCalendar start = new GregorianCalendar();
    	start.setTime(baslangicTarihi.getTime());
    	GregorianCalendar end = new GregorianCalendar();
    	end.setTime(bitisTarihi.getTime());
    	GregorianCalendar current = start;
    	int numWorkingDays = 0;

    	while (current.before(end)) {
    	            numWorkingDays++;
    	            current.add(GregorianCalendar.DATE, 1);
    	        }

    	        return numWorkingDays;
    	    }
}
