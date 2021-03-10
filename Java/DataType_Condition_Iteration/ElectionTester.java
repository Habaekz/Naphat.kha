//import java.util.ArrayList;
import java.util.Scanner;
public class ElectionTester {

	public static void main(String[] args) {
		MyDate election = new MyDate(2019, 3, 24);
		
		Person a = new Person("Lalisa", "Manoban", 1997, 3, 27);
		printPersonElectionInfo(a, election);
		
		Person b = new Person("Nuda", "Inter", 2012, 1, 16);
		printPersonElectionInfo(b, election);
		
		// Create another Person object with your information
		// Print your information, age, and election eligibility.

		Person c = new Person("Suphanat", "Limpaarayakul", 1998, 2, 1);
		printPersonElectionInfo(c, election);
		
		// Write a program to take 3 persons information from the user
		// (Hint: Use scanner and for loop to get input)
		int i = 0;
		Scanner people = new Scanner(System.in);
		/*ArrayList<String> name1 = new ArrayList<String>();
		ArrayList<String>last1 = new ArrayList<String>();
		ArrayList<Integer> year1 = new ArrayList<Integer>();
		ArrayList<Integer> month1 = new ArrayList<Integer>();
		ArrayList day1 = new ArrayList();*/
		String[] name = new String[3];
		String[] lastname = new String[3];
		int[] year =  new int[3];
		int[] month =  new int[3];
		int[] day =  new int[3];
		Person[] n = new Person[3];
		//String e ;
		//char exit = people.next().charAt(0);
		//do {
		for(i = 0;i < 3;i++){
			System.out.print("Enter firstname: ");
			name[i] = people.next();
			/*if(name[i] == "q") {
				System.exit(0);
			}
			else continue;*/
			System.out.print("Enter lastname: ");
			lastname[i] = people.next();
			System.out.print("Enter year of birthday: ");
			year[i] = people.nextInt();
			//System.out.print("\n");
			System.out.print("Enter month of birthday: ");
			month[i] = people.nextInt();
			//System.out.print("\n");
			System.out.print("Enter day of birthday: ");
			day[i] = people.nextInt();
			n[i] = new Person(name[i], lastname[i], year[i], month[i], day[i]);
			printPersonElectionInfo(n[i], election);
			i++;
		}
		//}while( i != 0);
		people.close();
		
		
		// Challenge Bonus
		// Instead of taking 3 persons' information, write a program to continuously take input from the user
		// until the user types 'q' to quite the program.
		
		/*
		 * YOUR CODE GOES HERE
		 */
		
	}
	
	public static void printPersonElectionInfo(Person p, MyDate election) {
		p.printPersonInfo();
		System.out.println("Age: " + p.getAge(election));
		if(p.isEligible(election))
			System.out.println("This person is eligible to vote.");
		else
			System.out.println("This person is NOT eligible to vote");
		
		System.out.println("-----------------------------------");
	}
}
