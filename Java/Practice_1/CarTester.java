public class CarTester {
	public static void main(String[] args) {
		Car myCar = new Car(20);	// 20 kilometers per litter
		myCar.addGas(40);		// Add gasoline 40 litters
		myCar.drive(100);		// Drive 100 kilometers
		double gasLeft = myCar.getGasInTank(); 
		System.out.print(gasLeft);
	}
}
