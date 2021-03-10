//Name: Naphat Khajohn-Udomrith 
//Student ID: 6188091
//Section: 1

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SimpleMovieSearchEngine implements BaseMovieSearchEngine {
	public Map<Integer, Movie> movies;
	
	@Override
	public Map<Integer, Movie> loadMovies(String movieFilename) {
		
		Map<Integer, Movie> loadedData = new HashMap<Integer, Movie>();
		
		try {
			File DataOfMovie = new File(movieFilename);
			InputStream inputsteam = new FileInputStream(DataOfMovie);
			BufferedReader read = new BufferedReader(new InputStreamReader(inputsteam));
			String stream = "";
			
			while((stream = read.readLine()) != null) {
				String regex = "(\\d+),(\"?)(.+) [(](\\d{4})[)](\"?),(.+)";
				
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(stream);
				
				if(m.find()) {
					int mid = Integer.parseInt(m.group(1));												 
					String title = m.group(3);															
					int year = Integer.parseInt(m.group(4));											
					String[] tags = m.group(6).split("\\|");											
					Movie movie = new Movie(mid,title,year);
					loadedData.put(mid, movie);
					
					for(String key: tags) {																
						loadedData.get(mid).addTag(key);
					}
				}
			}
			inputsteam.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return loadedData;
	}

	@Override
	public void loadRating(String ratingFilename) {
		
		Map<Integer,User> users = new HashMap<Integer,User>();
		
		try {
			File DataOfRating = new File(ratingFilename);
			InputStream inputsteam = new FileInputStream(DataOfRating);
			BufferedReader read = new BufferedReader(new InputStreamReader(inputsteam));
			String stream = "";
			
			while((stream = read.readLine()) != null) {
				
				String regex = "(\\d+),(\\d+),(\\d+.\\d+),(\\d+)";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(stream);
				
				if(m.find()) {
					
					int uid = Integer.parseInt(m.group(1));								
					int movieKey = Integer.parseInt(m.group(2));							
					double rating = Double.parseDouble(m.group(3));						
					long timestamp = Long.parseLong(m.group(4));						
					
					if(!users.containsKey(uid)) {	
						User userid = new User(uid);
						users.put(uid, userid);									
					}																	
					
					if(movies.containsKey(movieKey)) {
						if(movies.get(movieKey).getRating().containsKey(uid)) {
							if(movies.get(movieKey).getRating().get(uid).timestamp < timestamp) movies.get(movieKey).getRating().replace(uid, new Rating(users.get(uid),movies.get(movieKey),rating,timestamp)); 
						}
						else {
							movies.get(movieKey).addRating(users.get(uid), movies.get(movieKey), rating, timestamp);
						}
					}
				}
			}
			
			inputsteam.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void loadData(String movieFilename, String ratingFilename) {
		
		// YOUR CODE GOES HERE
		movies = loadMovies(movieFilename);
		loadRating(ratingFilename);
	}
	

	@Override
	public Map<Integer, Movie> getAllMovies() {
		return movies;
	}

	@Override
	public List<Movie> searchByTitle(String title, boolean exactMatch) {

		List<Movie> MovieTitle = new ArrayList<Movie>();
		if(exactMatch==true){																					
			for(Integer key:movies.keySet()) {
				if(movies.get(key).getTitle().toLowerCase().equals(title.toLowerCase())) {				
					MovieTitle.add(movies.get(key));
				}
			}
		}
		else {
			for(Integer key:movies.keySet()) {															
				if(movies.get(key).getTitle().toLowerCase().contains(title.toLowerCase())){
					MovieTitle.add(movies.get(key));
				}
			}
		}
		return MovieTitle;
	}

	@Override
	public List<Movie> searchByTag(String tag) {

		List<Movie> MovieTag = new ArrayList<Movie>();
		for(Integer i:movies.keySet()) {
			if(movies.get(i).getTags().contains(tag)) {
				MovieTag.add(movies.get(i));
			}
		}
		
		return MovieTag;
	}

	@Override
	public List<Movie> searchByYear(int year) {

		List<Movie> MovieYear = new ArrayList<Movie>();
		for(Integer i:movies.keySet()) {
			if(movies.get(i).getYear() == year) {
				MovieYear.add(movies.get(i));
			}
		}
		
		return MovieYear;
	}

	@Override
	public List<Movie> advanceSearch(String title, String tag, int year) {

		// YOUR CODE GOES HERE
		List<Movie> movie = new ArrayList<Movie>();
		for(Integer key:movies.keySet()) {
			if(year>1) {
				if(title!=null) {
					if(tag != null) {
						if(movies.get(key).getYear() == year && movies.get(key).getTags().contains(tag) && movies.get(key).getTitle().toLowerCase().contains(title.toLowerCase())) {
							movie.add(movies.get(key));
						}
					}
					else if(movies.get(key).getYear() == year && movies.get(key).getTitle().toLowerCase().contains(title.toLowerCase())) {
						movie.add(movies.get(key));
					}
				}
				else if(tag != null) {
					if(movies.get(key).getYear() == year && movies.get(key).getTags().contains(tag)) {
						movie.add(movies.get(key));
					}
				}
				else {
					movie = searchByYear(year);
				}
				
			}
			else{
				if(title!=null) {
					if(tag != null) {
						if(movies.get(key).getTags().contains(tag) && movies.get(key).getTitle().toLowerCase().contains(title.toLowerCase())) {
							movie.add(movies.get(key));
						}
					}
					else {
						movie = searchByTitle(title, false);
					}
				}
				else if(tag != null) {
					movie = searchByTag(tag);
				}
				
			}
		}
		
		return movie;
		
	}
	@Override
	public List<Movie> sortByTitle(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		if(asc==true) {
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle));
			return unsortedMovies;
		}else if(asc==false) {
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
			return unsortedMovies;
		}
		return null;
	}

	@Override
	public List<Movie> sortByRating(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		if(asc==true) {
			unsortedMovies.sort(Comparator.comparing(Movie::getMeanRating));
			return unsortedMovies;
		}else if(asc==false) {
			unsortedMovies.sort(Comparator.comparing(Movie::getMeanRating).reversed());
			return unsortedMovies;
		}
		return null;
	}
}