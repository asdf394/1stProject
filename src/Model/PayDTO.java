package Model;

public class PayDTO {
	private int no; //������ȣ ������
	private String id; //ȸ�� ID
	private int discount; // ���� ���� 1:�ش����, 2:���, ���ʼ�����
	private int place; //�뿩 ��� 0:��������, 1:�ù�
	private int pay_year; //��ȸ�� ���� 0: ��,  1: �ȳ�
	private int toy_No; //�峭�� ��ȣ
	private int total; //���� �ݾ�
	
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
