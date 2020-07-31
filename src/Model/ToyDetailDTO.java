package Model;

public class ToyDetailDTO {

	
	private String Domain;
	private String Develop;
	private int age;
	private String registrationDate;//µÓ∑œ¿œ
	private String rent;
	
	public ToyDetailDTO(String domain, String develop, int age, String registrationDate, String rent) {
		Domain = domain;
		Develop = develop;
		this.age = age;
		this.registrationDate = registrationDate;
		this.rent = rent;
	}

	public String getDomain() {
		return Domain;
	}

	public String getDevelop() {
		return Develop;
	}

	public int getAge() {
		return age;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public String getRent() {
		return rent;
	}
	
	
}
