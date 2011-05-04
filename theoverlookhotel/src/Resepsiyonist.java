
public class Resepsiyonist {
	private String isim;
	private String soyisim;
	private int resepsiyonistID;
	private boolean uygunluk;
	
	public Resepsiyonist(String _isim, String _soyisim, int _receptionistID) {
		this.isim = _isim;
		this.soyisim = _soyisim;
		this.resepsiyonistID = _receptionistID;
		this.uygunluk = true;
	}
	
	
	public Resepsiyonist() {
		// TODO Auto-generated constructor stub
	}
	
	public String isimGetir() {
		return isim;
	}
	public void isimAyarla(String isim) {
		this.isim = isim;
	}
	public String soyisimGetir() {
		return soyisim;
	}
	public void soyisimAyarla(String soyisim) {
		this.soyisim = soyisim;
	}
	public int resepsiyonistIDGetir() {
		return resepsiyonistID;
	}
	public void resepsiyonistIDAyarla(int resepsiyonistID) {
		this.resepsiyonistID = resepsiyonistID;
	}
	public boolean uygunMu() {
		return uygunluk;
	}
	public void uygunlukAyarla(boolean uygunMu) {
		this.uygunluk = uygunMu;
	}


	public void resepsiyonistOzellikleriniGir(String _ad, String _soyad,
			int _resepsiyonistID) {
		isimAyarla(_ad);
		soyisimAyarla(_soyad);
		resepsiyonistIDAyarla(_resepsiyonistID);
	}

}
