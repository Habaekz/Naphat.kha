import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase {
	public Map<Integer, Movie> movies = null;
	
	public void importMovies(String movieFilename)
	{	//YOUR CODE GOES HERE
		movies = new HashMap<Integer, Movie>();
		File file = new File("lab10_movies.txt");
		try {
			List<String> lines = FileUtils.readLines(file);
			for(String line : lines) {
				String[] parts = line.split(",");
				int mid = 0;
				String title = null;
				String tags = null;
				try {
					mid = Integer.parseInt(parts[0]);
					if(!parts[1].equals(" ")) {
						title = parts[1];
						try {
							tags = parts[2].replaceAll("\\|", ", ");
							Movie mov = new Movie(mid, title);
							movies.put(mid, mov);
							movies.get(mid).tags.add(tags);
						}
						catch (Exception c) {
							continue;
						}
					}
					else {
						continue;
					}
				}
				catch (Exception c) {
					continue;
				}
			}
			
		}
		catch (IOException c) {
			c.printStackTrace();
		}
		
		
	}
	
	
	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query) 
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> xxx = new ArrayList<Movie>();
		
		for(Movie mv : movies.values()) {
			if(mv.title.toLowerCase().indexOf(query.toLowerCase())!=-1) {
				xxx.add(mv);
			}
			else continue;
		}
		return xxx;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> xxx = new ArrayList<Movie>();
		
		for(Movie mv : movies.values()) {
			if(mv.tags.toString().toLowerCase().indexOf(tag.toLowerCase())!=-1) {
				xxx.add(mv);
			}
			else {
				continue;
			}
		}
		return xxx;
	}
	
	
	public static void main(String[] args)
	{
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		mdb.importMovies("lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[]{"america", "thai", "thailand"};
		for(String query: queries)
		{
			System.out.println("Results for movies that match: "+query);
			for(Movie m: mdb.searchMovies(query))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		String[] tags = new String[]{"Musical", "Action", "Thriller"};
		for(String tag: tags)
		{
			System.out.println("Results for movies in category: "+tag);
			for(Movie m: mdb.getMoviesByTag(tag))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		
	}

}
