import java.util.HashMap;

public abstract class Shape {

	public static double PI = 3.14;
	private String color;
	private String description;
	
	Shape(String color, String description)
	{
		this.color = color;
		this.description = description;
	}
	public void setColor(String color)
	{
		this.color=color;
	}
	public String getColor()
	{
		return color;
	}
	public abstract double getArea();
	
	public String toString()
	{
		return "->"+description+"(color="+color+", area="+this.getArea()+")";
	}
	public double compareTo(Triangle shape)
	{
		
		if(this.getArea() == shape.getArea())
		{
			return 0;
		}
		else if(shape == null || this.getArea() >= shape.getArea())
		{
			return 1;
		}
		else
		{
			return -1;
		}
		
	}
}
