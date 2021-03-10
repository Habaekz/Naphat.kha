
public class LinearContextSearcher extends ContextSearcher {
	
	
	LinearContextSearcher(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String find(Word query, int window) {
		// TODO Auto-generated method stub
//		int pos = sortedWords.indexOf(query);
//		query.setPosition(pos);
//		if(pos == -1) return "null";
		for(Word w : sortedWords) {
			if(query.equals(w)) return getSnippet(w, window);
		}
		return null;
	}

}
