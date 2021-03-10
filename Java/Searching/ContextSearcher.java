import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.io.FileUtils;

public abstract class ContextSearcher {

	protected ArrayList<Word> sortedWords = null;

	ContextSearcher(String filename)
	{
		//load file
		String text = null;
		try {
			text = FileUtils.readFileToString(new File(filename), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//clean text
		text = text.toLowerCase().replaceAll("\\W+", " ").replaceAll("\\s\\w\\s", " ");
		
		//System.out.println(text);
		//tokenize words
		String[] tokens = text.split("\\s+");
		
		//store tokens in words
		sortedWords = new ArrayList<Word>();
		for(int i = 0; i < tokens.length; i++) 
		{	sortedWords.add(new Word(tokens[i],i));
			if(i > 0) 
			{	sortedWords.get(i).setPreviousWord(sortedWords.get(i-1));
				sortedWords.get(i-1).setNextWord(sortedWords.get(i));
			}
		}
		//sort word
		Collections.sort(sortedWords);
		
	}
	
	/**
	 * Return beautified string version of the "words" from startIndex to endIndex
	 * @param numWords
	 * @return
	 */
	public static String getSnippet(Word root, int window)
	{
		if(root == null) return null;
		StringBuilder str = new StringBuilder();
		str.append("["+root+"] ");
		Word pointer = root.getPreviousWord();
		for(int i = 0; i < window; i++)
		{	if(pointer == null)
			{
				break;
			}
			else 
			{	str.insert(0, pointer.getWord()+" ");
				pointer = pointer.getPreviousWord();
			}
		}
		if(pointer != null) str.insert(0, "... ");
		
		pointer = root.getNextWord();
		for(int i = 0; i < window; i++)
		{	if(pointer == null)
			{
				str.append("... ");
				break;
			}
			else 
			{	str.append(pointer.getWord()+" ");
				pointer = pointer.getNextWord();
			}
		}
		if(pointer != null) str.append("... ");
		
		return str.toString().trim();
	}	
	
	public abstract String find(Word query, int window);
}


