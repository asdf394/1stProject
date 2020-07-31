package Model;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String address;
	private String phoneNumber;
	private int saletarget;
	private String term;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public MemberDTO(String id, String pw, String name, String address, String phoneNumber, int saletarget) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.saletarget = saletarget;
	}

	public MemberDTO(String pw, String name, String address, String phoneNumber, int saletarget) {
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.saletarget = saletarget;
	}

	public MemberDTO(String id, String pw, String name, String address, String phoneNumber, int saletarget,
			String term) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.saletarget = saletarget;
		this.term = term;
	}

	public int getSaletarget() {
		return saletarget;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

}
