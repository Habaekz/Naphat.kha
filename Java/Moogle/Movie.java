// Name: Naphat Khajohn-Udomrith
// Student ID: 6188029
// Section: 1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Movie {
	private int mid;
	private String title;
	private int year;
	private Set<String> tags;
	private Map<Integer, Rating> ratings;	//mapping userID -> rating
	private Double avgRating;
	
	public Movie(int _mid, String _title, int _year){
		this.mid = _mid;
		this.title = _title;
		this.year = _year; 
		this.tags = new HashSet<String>();
		this.ratings = new HashMap<Integer, Rating>();
		this.avgRating = 0.0;
	}
	
	public int getID() {
		
		// YOUR CODE GOES HERE
		return mid;
	}
	public String getTitle(){
		
		// YOUR CODE GOES HERE
		return title;
	}
	
	public Set<String> getTags() {
		
		// YOUR CODE GOES HERE
		return tags;
	}
	
	public void addTag(String tag){
		
		// YOUR CODE GOES HERE
		tags.add(tag);
	}
	
	public int getYear(){
		
		// YOUR CODE GOES HERE
		return year;
	}
	
	public String toString()
	{
		return "[mid: "+mid+":"+title+" ("+year+") "+tags+"] -> avg rating: " + avgRating;
	}
	
	
	public double calMeanRating(){
		
		// YOUR CODE GOES HERE
		double SumOfMean = 0.0;
		for(Integer i :ratings.keySet()) {		
			SumOfMean += ratings.get(i).rating;
		}
		SumOfMean = SumOfMean/ratings.size();
		return SumOfMean;
	}
	
	public Double getMeanRating(){
		
		// YOUR CODE GOES HERE
		return avgRating;
	}
	
	public void addRating(User user, Movie movie, double rating, long timestamp) {
		
		// YOUR CODE GOES HERE
		ratings.put(user.getID(), new Rating(user,movie,rating,timestamp));
		this.avgRating = calMeanRating();
	}
	
	public Map<Integer, Rating> getRating(){
		
		// YOUR CODE GOES HERE
		return ratings;
	}
	
}