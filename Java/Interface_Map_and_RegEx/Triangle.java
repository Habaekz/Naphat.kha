/*
 * DO NOT MODIFY THIS CLASS
 */
class Triangle extends Shape{
	double base;
	double height;
	
	public Triangle(double base, double height){
		super("red", "Triangle with base " + base + ", height " + height);
		this.base = base;
		this.height = height;
	}
	
	public double getArea(){
		return 0.5 * base * height;
	}

	
}