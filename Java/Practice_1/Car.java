public class Car {
	public double efficiency;
	public double fuel = 0;
	
	public Car (double efficiency) {
		this.efficiency = efficiency;
	}
	public void drive(double distance) {
		this.efficiency = this.fuel - (distance / this.efficiency);
	}
	public double getGasInTank() {
		return this.efficiency;
	}
	public void addGas(double litter) {
		this.fuel = this.fuel + litter;
	}

}
