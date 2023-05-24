package Model;

public class Oder {
	private int idOder;
	private String date;
	private int idBuyer;
	public Oder() {
		// TODO Auto-generated constructor stub
	}
	public Oder(int idOder, String date, int idBuyer) {
		super();
		this.idOder = idOder;
		this.date = date;
		this.idBuyer = idBuyer;
	}
	public int getIdOder() {
		return idOder;
	}
	public void setIdOder(int idOder) {
		this.idOder = idOder;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getIdBuyer() {
		return idBuyer;
	}
	public void setIdBuyer(int idBuyer) {
		this.idBuyer = idBuyer;
	}
	@Override
	public String toString() {
		return "Oder [idOder=" + idOder + ", date=" + date + ", idBuyer=" + idBuyer + "]";
	}
	
}
