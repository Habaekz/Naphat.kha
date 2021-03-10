

public class BinaryContextSearcher extends ContextSearcher {

	BinaryContextSearcher(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String find(Word query, int window) {
		// TODO Auto-generated method stub
//		if(sortedWords.contains(query)) {
		int pos =  findHelper(query, window, 0, sortedWords.size());
		if(pos == -1) return null;
		int get = pos-1;
		boolean useget=false;
		while(sortedWords.get(get).getWord().equals(sortedWords.get(pos).getWord())) {
			get--;
			useget = true;
		}
		if(useget) return getSnippet(sortedWords.get(get+1), window);
		return getSnippet(sortedWords.get(pos), window);
//		}
//		return null;
	}
	
	public int findHelper(Word query, int window, int first, int last) {
		if(last<first) return -1;
		int center = first + (last-first)/2;
		if(query.equals(sortedWords.get(center))) return center;
		else if(query.compareTo(sortedWords.get(center)) > 0) return findHelper(query, window, center+1, last);
		else if(query.compareTo(sortedWords.get(center)) < 0) return findHelper(query, window, first, center-1);
		return -1;
		
	}

}
