import java.util.HashSet;
import java.util.Set;

public class Movie {
	public int mid = -1;
	public String title = null;
	public Set<String> tags = null;
	public Movie(int _mid, String _title)
	{
		mid = _mid;
		title = _title;
		tags = new HashSet<String>();
	}
	
	
	public String toString()
	{
		return "[mid: "+mid+":"+title+" "+tags+"]";
	}
	
}
