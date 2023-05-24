package Model;

public class OderDetail {
	private int idOderDetail;
	private int quanlity;
	private int idP;
	private int idO;
	
	public OderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OderDetail(int idOderDetail, int quanlity, int idP, int idO) {
		super();
		this.idOderDetail = idOderDetail;
		this.quanlity = quanlity;
		this.idP = idP;
		this.idO = idO;
	}

	public int getIdOderDetail() {
		return idOderDetail;
	}

	public void setIdOderDetail(int idOderDetail) {
		this.idOderDetail = idOderDetail;
	}

	public int getQuanlity() {
		return quanlity;
	}

	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public int getIdO() {
		return idO;
	}

	public void setIdO(int idO) {
		this.idO = idO;
	}

	@Override
	public String toString() {
		return "OderDetail [idOderDetail=" + idOderDetail + ", quanlity=" + quanlity + ", idP=" + idP + ", idO=" + idO
				+ "]";
	}
	
}
