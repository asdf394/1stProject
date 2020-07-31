package Model;

public class noticeBoardTheViewDTO {
	private int No;
	private String Name;
	private String ID;
	private String CONTENT;
	private String TITLE;
	
	public noticeBoardTheViewDTO(String name, String iD, String cONTENT, String tITLE) {
		Name = name;
		ID = iD;
		CONTENT = cONTENT;
		TITLE = tITLE;
	}

	public noticeBoardTheViewDTO(int no, String name, String iD, String cONTENT, String tITLE) {
		No = no;
		Name = name;
		ID = iD;
		CONTENT = cONTENT;
		TITLE = tITLE;
	}

	public int getNo() {
		return No;
	}

	public String getName() {
		return Name;
	}

	public String getID() {
		return ID;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public String getTITLE() {
		return TITLE;
	}
	
	
}