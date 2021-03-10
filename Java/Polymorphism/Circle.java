public class Circle extends Shape {

	private double R; 
	private double PI = 3.14;
	
	public Circle()
	{
		R=0;
	}
	public Circle(String color,double R)
	{
		super.setColor(color);
		this.R=R;
	}
	public double getArea()
	{
		return PI*(R*R);
	}
	public double getArea(double R)
	{
		this.R=R;
		return getArea();
	}
	public String toString() 
	{
		return "Circle[Radius="+R+","+super.toString()+"]";
	}
}
