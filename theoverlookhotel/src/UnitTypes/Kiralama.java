package UnitTypes;

import java.util.GregorianCalendar;

import DatabasePackage.Facade;

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

	
	public Kiralama(int musteriID) {
		this.kiralayanMusteriID = musteriID;
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
		return (Oda) Facade.getInstance().get(kiralananOdaID, Oda.class);
	}
	public void setKiralananOda(int kiralananOdaID) {
		this.kiralananOdaID = kiralananOdaID;
		this.fiyat = ((Oda) Facade.getInstance().get(kiralananOdaID, Oda.class)).tutarOgren();
	}
	public Musteri getKiralayanMusteri() {
		return (Musteri) Facade.getInstance().get(kiralayanMusteriID, Musteri.class);
	}
	public void setKiralayanMusteri(int kiralayanMusteriID) {
		this.kiralayanMusteriID = kiralayanMusteriID;
	}
	public float getFiyat() {
		return fiyat;
	}
	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}

	public void odaSec(int _odaID) {
		((Oda) Facade.getInstance().get(_odaID, Oda.class)).bosOlmaDurumuAyarla(false);
		this.setKiralananOda(_odaID);

		
	}
	
	public void tutarAyarla() {
		float gunlukFiyat = ((Oda) Facade.getInstance().get(kiralananOdaID, Oda.class)).tutarOgren();
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
