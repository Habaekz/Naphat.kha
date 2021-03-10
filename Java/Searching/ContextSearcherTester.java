
public class ContextSearcherTester {

	public static void main(String[] args)
	{
		System.out.println("***************** NORMAL****************");
		ContextSearcher linearA = new LinearContextSearcher("small.txt");
		Word.resetCompareCounter();
		System.out.println(linearA.find(new Word("origin", -1), 5));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(linearA.find(new Word("budgets", -1), 5));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		ContextSearcher linearB = new LinearContextSearcher("medium.txt");
		Word.resetCompareCounter();
		System.out.println(linearB.find(new Word("Suppawong", -1), 7));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(linearB.find(new Word("iPhone5", -1), 3));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(linearB.find(new Word("Echinoderm", -1), 3));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		ContextSearcher linearC = new LinearContextSearcher("final_fantasy_15.txt");
		Word.resetCompareCounter();
		System.out.println(linearC.find(new Word("Noctis", -1), 10));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(linearC.find(new Word("Behemoth", -1), 10));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(linearC.find(new Word("Boss", -1), 3));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(linearC.find(new Word("codebreak1337", -1), 10));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(linearC.find(new Word("Mahidol", -1), 3));
		System.out.println("# Comparisons (Linear):"+Word.getNumComparisons()+"\n");
		
		//BONUS
		System.out.println("********* BONUS for CRAZY PEOPLE************");
		
		ContextSearcher binaryA = new BinaryContextSearcher("small.txt");
		Word.resetCompareCounter();
		System.out.println(binaryA.find(new Word("origin", -1), 5));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
	
		Word.resetCompareCounter();
		System.out.println(binaryA.find(new Word("budgets", -1), 5));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
		ContextSearcher binaryB = new BinaryContextSearcher("medium.txt");
		Word.resetCompareCounter();
		System.out.println(binaryB.find(new Word("Suppawong", -1), 7));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(binaryB.find(new Word("iPhone5", -1), 3));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(binaryB.find(new Word("Echinoderm", -1), 3));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
		ContextSearcher binaryC = new BinaryContextSearcher("final_fantasy_15.txt");
		Word.resetCompareCounter();
		System.out.println(binaryC.find(new Word("Noctis", -1), 10));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(binaryC.find(new Word("Behemoth", -1), 10));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(binaryC.find(new Word("Boss", -1), 3));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(binaryC.find(new Word("codebreak1337", -1), 10));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
		Word.resetCompareCounter();
		System.out.println(binaryC.find(new Word("Mahidol", -1), 3));
		System.out.println("# Comparisons (Binary):"+Word.getNumComparisons()+"\n");
		
	}
}
