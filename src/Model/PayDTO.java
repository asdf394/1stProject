package Model;

public class PayDTO {
	private int no; //결제번호 시퀀스
	private String id; //회원 ID
	private int discount; // 할인 여부 1:해당없음, 2:장애, 기초수급자
	private int place; //대여 장소 0:직접수령, 1:택배
	private int pay_year; //연회비 여부 0: 냄,  1: 안냄
	private int toy_No; //장난감 번호
	private int total; //결제 금액
	
	public PayDTO(String id, int discount, int place, int pay_year, int toy_No) {
		this.id = id;
		this.discount = discount;
		this.place = place;
		this.pay_year = pay_year;
		this.toy_No = toy_No;
	}

	public int getNo() {
		return no;
	}

	public String getId() {
		return id;
	}

	public int getDiscount() {
		return discount;
	}

	public int getPlace() {
		return place;
	}

	public int getPay_year() {
		return pay_year;
	}

	public int getToy_No() {
		return toy_No;
	}

	public int getTotal() {
		return total;
	}
	
	

}
