package Model;

public class NoticeBoardDTO {
	private int No;
	private String Name;
	private String ID;
	private String CONTENT;
	private String TITLE;
	
	public NoticeBoardDTO(String title, String content) {
		this.TITLE = title;
		this.CONTENT = content;
	}
	public NoticeBoardDTO(String name, String iD, String cONTENT, String tITLE) {
		this.Name = name;
		this.ID = iD;
		this.CONTENT = cONTENT;
		this.TITLE = tITLE;
	}
	
	public NoticeBoardDTO(int no, String name, String iD, String cONTENT, String tITLE) {
		this.No = no;
		this.Name = name;
		this.ID = iD;
		this.CONTENT = cONTENT;
		this.TITLE = tITLE;
	}
	public NoticeBoardDTO(String title, String content, int no) {
		this.No = no;
		this.CONTENT = content;
		this.TITLE = title;
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
