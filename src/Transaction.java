import java.io.Serializable;
import java.math.BigDecimal;

public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -314928486171196789L;
	private String name;
	private String surname;
	private String src_iban;
	private String dst_iban;
	private Amount amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSrc_iban() {
		return src_iban;
	}
	public void setSrc_iban(String src_iban) {
		this.src_iban = src_iban;
	}
	public String getDst_iban() {
		return dst_iban;
	}
	public void setDst_iban(String dst_iban) {
		this.dst_iban = dst_iban;
	}
	
	
	public Transaction(){
		
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public Transaction(String name, String surname, String src_iban, String dst_iban, Amount amount) {
		super();
		this.name = name;
		this.surname = surname;
		this.src_iban = src_iban;
		this.dst_iban = dst_iban;
		this.amount = amount;
	}
	
	
	
}
