public class DateTester{
	public static void main(String[] args){
		MyDate a = new MyDate();
		System.out.println("Object Number (a): " + a.getObjectNumber());
		System.out.println("a's Date: " + a.toString());
		System.out.println("a's Date: " + a.previousDay().toString());
		System.out.println("a's Date: " + a.nextDay().toString());
		System.out.println("a's Date: " + a.previousMonth().toString());
		System.out.println("a's Date: " + a.nextMonth().toString());
		a.setDate(2000, 4, 13);
		System.out.println("a's Date: " + a.toString());
		System.out.println("a's year is " + a.getYear() + ", which " + DateTester.strLeapYear(MyDate.isLeapYear(a.getYear())) + ".\n");

		MyDate b = new MyDate(2016, 2, 28);
		System.out.println("Object Number (b): " + b.getObjectNumber());
		System.out.println("b's Date: " + b.toString());
		System.out.println("b's Date: " + b.nextDay().toString());
		System.out.println("b's Date: " + b.nextDay().toString());
		System.out.println("b's Date: " + b.nextYear().toString());
		System.out.println("b's Date: " + b.nextMonth().toString());
		System.out.println("b's Date: " + b.previousYear().toString());
		System.out.println("b's year is " + b.getYear() + ", which " + DateTester.strLeapYear(MyDate.isLeapYear(b.getYear())) + ".\n");

		MyDate c = new MyDate(2017, 3, 2);
		System.out.println("Object Number (c): " + c.getObjectNumber());
		System.out.println("c's Date: " + c.toString());
		System.out.println("c's Date: " + c.previousDay().toString());
		System.out.println("c's Date: " + c.previousDay().toString());
		System.out.println("c's Date: " + c.previousYear().toString());
		System.out.println("c's Date: " + c.nextDay().toString());
		System.out.println("c's Date: " + c.previousYear().toString());
		System.out.println("c's year is " + c.getYear() + ", which " + DateTester.strLeapYear(MyDate.isLeapYear(c.getYear())) + ".\n");
	}

	public static String strLeapYear(boolean leapYear){
		if(leapYear)
			return "is a leap year";
		else
			return "is not a leap year";
	}
}
