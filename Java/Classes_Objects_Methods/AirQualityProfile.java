import java.time.LocalDateTime;
public class AirQualityProfile {

	public LocalDateTime datetime;
	public String location;
	private int aqi;
	private int pm25;
	private int temp;
	public String weather;
	
	
	
	public LocalDateTime getdate() {
		return datetime;
	}
	public void setdate() {
		this.datetime = LocalDateTime.now();
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAqi() {
		return aqi;
	}
	public void setAqi(int aqi) {
		this.aqi = aqi;
	}
	public int getPm25() {
		return pm25;
	}
	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	AirQualityProfile(String cou,int aqi,int pm,int tem,String wea)
	{
		this.setdate();
		this.setLocation(cou);
		this.setAqi(aqi);
		this.setPm25(pm);
		this.setTemp(tem);
		this.setWeather(wea);
	}
	public void printdata()
	{
		System.out.println(this.getLocation() + " at " + this.getdate());
		System.out.println("AQI: " + this.getAqi() + ", PM2.5: " + this.getPm25() + " microgram/m3");
		System.out.println(this.getWeather() + " celsius (" + this.getWeather() + ")");
	}
	public static void main(String [] args)
	{
		AirQualityProfile a1 = new AirQualityProfile("Thon Buli",112,40,29,"Few Clouds");
		AirQualityProfile a2 = new AirQualityProfile("Bangkok",112,52,33,"Few Clouds");
		AirQualityProfile a3 = new AirQualityProfile("Phuket",40,48,31,"Few Clouds");
		
		a1.printdata();
		a2.printdata();
		a3.printdata();
	}
	
	
	
}
