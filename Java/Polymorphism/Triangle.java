

/*  The structure of Triangle class is similar to Rectangle */
public class Triangle extends Shape {


   //add your code here
	private double base;
	private double height;
	
	
	public Triangle()
	{
		base=0;
		height=0;
	}
	public Triangle(String color,double base,double height)
	{
		super.setColor(color);
		this.base=base;
		this.height=height;
	}
	public double getArea()
	{
		return 0.5*base*height;
	}
	public double getArea(double base,double height)
	{
		this.base=base;
		this.height=height;
		return getArea();
	}
	public String toString() 
	{
		return "Triangle[base="+base+",height="+height+","+super.toString()+"]";
	}

}
