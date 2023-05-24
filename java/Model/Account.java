package Model;

public class Account {
	private int id;
	private String user;
	private String pass;
	private int isAdmin;
	
	public Account() {
		
	}

	public Account(int id, String user, String pass, int isAdmin) {
		super();
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.isAdmin = isAdmin;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}



	@Override
	public String toString() {
		return "Account [id=" + id + ", user=" + user + ", pass=" + pass + ", isAdmin=" + isAdmin + "]";
	}


	
}
