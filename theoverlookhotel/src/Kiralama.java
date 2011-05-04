import java.util.GregorianCalendar;

public class Kiralama {
	private boolean uygunluk;
	private GregorianCalendar baslangicTarihi;
	private GregorianCalendar bitisTarihi;
	private Oda kiralananOda;
	private Musteri kiralayanMusteri;
	private int fiyat;
	
	public void kiralamaTarihiSec(GregorianCalendar _baslangicTarihi, GregorianCalendar _bitisTarihi){
		this.baslangicTarihi = _baslangicTarihi;
		this.bitisTarihi = _bitisTarihi;
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
	}
	public Musteri getKiralayanMusteri() {
		return kiralayanMusteri;
	}
	public void setKiralayanMusteri(Musteri kiralayanMusteri) {
		this.kiralayanMusteri = kiralayanMusteri;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

}
