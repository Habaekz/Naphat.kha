public class MyDate {
public int year;
public int month;
public int day;
public int objectNumber;
public static int objectCounter;
public static String[] strmonths = {"January", "February","March", "April", "May", "June", "July", "August", "September", "October", "November","December"};
MyDate(){
this.year = 1900;
this.month = 1;
this.day = 1;
this.objectNumber = ++objectCounter;
}
MyDate(int aYear, int aMonth, int aDay){
this.year = aYear;
this.month = aMonth;
this.day = aDay;
this.objectNumber = ++objectCounter;
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
public String toString() {
String date = this.day + " " + strmonths[this.month - 1] + " " + this.year;
return date;
}
public MyDate nextDay() {
if (this.month == 12 && this.day == 31) {
this.year++;
this.month = 1;
this.day = 1;
} else {
if (month == 4 || month == 6 || month == 9 || month == 11) {
if (this.day == 30) {
this.month++;
this.day = 1;
} else
this.day++;
} else if (this.month != 2) {
if (this.day == 31) {
this.month++;
this.day = 1;
} else
this.day++;
} else {
if (isLeapYear(this.year) && this.day == 29) {
this.month++;
this.day = 1;
} else if (!isLeapYear(this.year) && this.day == 28) {
this.month++;
this.day = 1;
} else
this.day++;
}
}

	return this;
}
public MyDate previousDay() {
	if (this.month == 1 && this.day == 1) {
		this.year--;
		this.month = 12;
		this.day = 31;
	} else {
		if (this.month == 5 || this.month == 7 || this.month == 10 || this.month == 12) {
			if (this.day == 1) {
				this.month--;
				this.day = 30;
			} else {
				this.day--;
			}
		} else if (this.month != 3) {
			if (this.day == 1) {
				this.month--;
				this.day = 31;
			} else {
				this.day--;
			}
		} else {
			if (isLeapYear(this.year) && this.day == 1) {
				this.month--;
				this.day = 29;
			} else if (!isLeapYear(year) && this.day == 1) {
				this.month--;
				this.day = 28;
			} else
				this.day--;
		}
	}

	return this;
}

public MyDate nextMonth() {
	if (this.month == 12) {
		this.month = 1;
		this.year++;
	} else {
		if (this.month == 1 && this.month == 3 || this.month == 5 || this.month == 8 || this.month == 7|| this.month == 10) {
			if (this.day == 31) {
				this.month++;
				this.day = 30;
			} else
				this.month++;
		} else if (this.month == 1) {
			if (this.day > 28) {
				if (isLeapYear(year) && this.day >= 29) {
					this.day = 29;
				} else {
					this.day = 28;
				}
				this.month++;
			} else
				this.month++;
		} else
			this.month++;
	}
	return this;
}

public MyDate previousMonth() {
	if (this.month == 1) {
		this.month = 12;
		this.year--;
	} else {
		if (this.month == 7 || this.month == 5 || this.month == 12 || this.month == 10) {
			if (this.day == 31) {
				this.month--;
				this.day = 30;
			} else
				this.month--;
		} else if (this.month == 3) {
			if (this.day > 28) {
				if (isLeapYear(year) && this.day >= 29) {
					this.day = 29;
				} else {
					this.day = 28;
				}
				this.month--;
			} else
				this.month--;
		} else
			this.month--;
	}
	return this;
}

public MyDate nextYear() {
	if (isLeapYear(this.year) && this.month == 2 && this.day == 29) {
		this.day = 28;
	}
	this.year++;
	return this;
}

public MyDate previousYear() {
	if (isLeapYear(this.year) && this.month == 2 && this.day == 29) {
		this.day = 28;
	}
	year--;
	return this;
}
public static boolean isLeapYear(int year) {
	if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
		return true;
	}
	return false;
}
}