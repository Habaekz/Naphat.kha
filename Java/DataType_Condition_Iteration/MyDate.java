
public class MyDate {
	int year;
	int month;
	int day;
	int objectNumber;
	static int objectCounter = 0;
	static int byear = 0;
	public static String[] strMonths = {"January","Febuary","March","April","May","June",
			"July","August","September","October","November","December"};
	
	public MyDate() {
		this.year = 1900;
		this.month = 1;
		this.day = 1;
		objectCounter++;
		this.objectNumber = objectCounter;
	}
	
	public MyDate(int aYear, int aMonth, int aDay) {
		this.year = aYear;
		this.month = aMonth;
		this.day = aDay;
		objectCounter++;
		this.objectNumber = objectCounter;
	}
	
	public int getObjectNumber() {
		return objectNumber;
	}
	
	public void setDate(int aYear, int aMonth, int aDay) {
		this.year = aYear;
		this.month = aMonth;
		this.day = aDay;
	}

	public void setYear(int aYear) {
		this.year = aYear;
	}

	public void setMonth(int aMonth) {
		this.month = aMonth;
	}

	public void setDay(int aDay) {
		this.day = aDay;
	}

	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public static int getObjectCounter() {
		return objectCounter;
	}

	public static void setObjectCounter(int objectCounter) {
		MyDate.objectCounter = objectCounter;
	}

	public static String[] getStrMonths() {
		return strMonths;
	}

	public static void setStrMonths(String[] strMonths) {
		MyDate.strMonths = strMonths;
	}

	public void setObjectNumber(int objectNumber) {
		this.objectNumber = objectNumber;
	}

	public String toString() {
		return (this.day +" "+strMonths[this.month-1]+" "+this.year);
	}
	
	static boolean isLeapYear(int year) {
		if(year%4!=0) {
			return false;
		}
		else if(year%100!=0) {
			return true;
		}
		else if(year%400!=0) {
			return false;
		}
		else return true;
	}
	
	public MyDate nextDay() {
		if(this.month==12 && this.day == 31) {
			this.year++;
			this.month = 1;
			this.day = 1;
		}
		else if(this.month == 4 || this.month == 6 || this.month == 9) {
			if(this.day == 30) {
				this.month++;
				this.day = 1;
			}
			else this.day++;
		}
		else if(this.month != 2) {
			if(this.day == 31) {
				this.month++;
				this.day = 1;
			}
			else this.day++;
		}
		else {
			if(isLeapYear(this.year)&&this.day==29) {
				this.month++;
				this.day = 1;
			}
			else if(!isLeapYear(this.year)&&this.day==29) {
				this.month++;
				this.day = 1;
			}
			else this.day++;
	
		}
		return this;
	}
	
	public MyDate nextMonth() {
		if(this.month == 12) {
			this.year++;
			this.month = 1;
		}
		else this.month++;
		return this;
	}
	
	public MyDate nextYear() {
		this.year++;
		if(isLeapYear(this.year) && this.month == 2 &&this.day==29) {
			this.month++;
			this.day = 1;
		}
		return this;
	}
	
	public MyDate previousDay() {
		if(this.month == 1 && this.day == 1) {
			this.year--;
			this.month = 12;
			this.day = 31;
		}
		else
			if(this.month == 5 ||this.month == 7 ||this.month == 10 ||this.month == 12) {
				if(this.day == 1) {
					this.month --;
					this.day = 30;
				}
				else this.day--;
			}
			else if(this.month!=3) {
				if(this.day != 1) {
					this.month --;
					this.day = 31;
				}
				else this.day --;
			}
			else
				if(isLeapYear(this.year)&&this.day==1) {
					this.month--;
					this.day = 29;
				}
				else if(!isLeapYear(this.year)&&this.day==1) {
					this.month--;
					this.day = 28;
				}
				else this.day--;
		return this;
	}
	public MyDate previousMonth() {
		if(this.month == 1) {
			this.year--;
			this.month = 12;
		}
		else this.month --;
	return this;	
	}
	public MyDate previousYear() {
		this.year --;
		if(isLeapYear(this.year)&& this.month == 2 &&this.day==1) {
			this.month--;
			this.day = 31;
		}
		else if(!isLeapYear(this.year)&& this.month == 2 &&this.day==29) {
			this.month--;
			this.day = 28;
		}
		return this;
	}
	
	public static int yearDiff(MyDate start,MyDate end) {
		if(start.year > end.year) {
			return -1;
		}
		else if(start.month > end.month) {
			byear = end.year - start.year - 1;
		}
		else if(start.month == end.month && start.day > end.day) {
			byear = end.year - start.year - 1;
		}
		else byear = end.year - start.year;
		
		return byear;
	}
}

