package Model;

import java.io.File;

public class ToyDTO {
	private int no;
	private String name;
	private String domain;
	private String develop;
	private String age;
	private int rent;
	private String img;
	private String explain;

	public ToyDTO(String name, String domain, String develop, String age, int rent, String img) {

		this.name = name;
		this.domain = domain;
		this.develop = develop;
		this.age = age;
		this.rent = rent;
		this.img = img;
	}

	public ToyDTO(int no, String name, String domain, String develop, String age, int rent, String img,
			String explain) {
		this.no = no;
		this.name = name;
		this.domain = domain;
		this.develop = develop;
		this.age = age;
		this.rent = rent;
		this.img = img;
		this.explain = explain;
	}

	public ToyDTO(String name, int no) {
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getDomain() {
		return domain;
	}

	public String getDevelop() {
		return develop;
	}

	public String getAge() {
		return age;
	}

	public int getRent() {
		return rent;
	}

	public String getImg() {
		return img;
	}

	public String getExplain() {
		return explain;
	}

}
