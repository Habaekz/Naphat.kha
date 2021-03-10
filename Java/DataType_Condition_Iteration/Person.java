
public class Person {
	String firstname;
	String lastname;
	MyDate birthday;
	
	/*public Person(String[] aFirstname, String[] aLastname) {
		this.firstname = aFirstname;
		this.lastname = aLastname;
		this.birthday = new MyDate();
	}*/
	public Person(String aFirstname, String aLastname,int aYear,int aMonth,int aDay) {
		this.firstname = aFirstname;
		this.lastname = aLastname;
		this.birthday = new MyDate(aYear,aMonth,aDay);
	}
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public MyDate getBirthday() {
		return birthday;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}
	public int getAge(MyDate aDate) {
		return MyDate.yearDiff(birthday,aDate);
	}
	
	public boolean isEligible(MyDate elecDate) {
		if(getAge(elecDate) >= 18) {
			return true;
		}
		else
		return false;
	}
	
	public void printPersonInfo() {
		System.out.println("Person: " + firstname + " " + lastname);
		System.out.println("Birthday: " + birthday.toString());
	}
}
