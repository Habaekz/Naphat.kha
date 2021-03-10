
public class Word implements Comparable<Object>
{
	private String word;	//word content
	private int position;	//position in the file, starting with 0;
	private Word previousWord = null;
	private Word nextWord = null;
	
	public Word getPreviousWord() {
		return previousWord;
	}

	public void setPreviousWord(Word previousWord) {
		this.previousWord = previousWord;
	}
	
	public Word getNextWord() {
		return nextWord;
	}

	public void setNextWord(Word nextWord) {
		this.nextWord = nextWord;
	}
	private static long numCompares = 0;
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}



	public int getPosition() {
		return position;
	}



	public void setPosition(int position) {
		this.position = position;
	}



	Word(String _word, int _position)
	{
		word = _word;
		position = _position;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.compareTo(this, (Word)obj) == 0;
	}

	public String toString()
	{
		return this.word;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Word)
			return compareTo(this, ((Word)o));
		return -1;
	}
	
	public static int compareTo(Word o1,Word o2)
	{	numCompares++;
		int wordLvComp = o1.getWord().toLowerCase().compareTo(o2.getWord().toLowerCase());
		if(o1.getPosition() < 0 || o2.getPosition() < 0) return wordLvComp;
		return wordLvComp==0?(o1.getPosition()-o2.getPosition()):wordLvComp;
	}
	public static long getNumComparisons()
	{
		return numCompares;
	}
	public static void resetCompareCounter()
	{
		numCompares = 0;
	}
}