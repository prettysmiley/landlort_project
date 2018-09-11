package LandlordTestCases;

public class LandLord {

	private String firstName;
	private String lastName;
	private boolean trusted;
	
	LandLord(){
		
	}
	public LandLord(String FN, String LN, boolean t){
		this.firstName=FN;
		this.lastName=LN;
		this.trusted=t;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isTrusted() {
		return trusted;
	}
	public void setTrusted(boolean trusted) {
		this.trusted = trusted;
	}
	
	

	
}
