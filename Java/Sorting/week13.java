import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class week13 {
	static int count = 1;
    
	
    static String[] loadfile(String fileName){
    	String[] Sorted = null;
		try {
		File file = new File(fileName);
			LineIterator it = FileUtils.lineIterator(file, "UTF-8");
			StringBuilder Strb = new StringBuilder();
				while (it.hasNext()) {
					Strb.append(it.nextLine());
				}
				Sorted = Strb.toString().split(" ");
				
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Sorted;
	}
    
    static void DescendingOrder(String[] arr){
       for ( int j = 0 ; j < arr.length ; j++ )
       {
           for(int i = j + 1 ; i < arr.length ; i++ )
           {
                if(arr[i].compareTo(arr[j]) > 0 )
                {
                    String t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                    System.out.print("Pass "+(count++)+": ");
                    PrintToString(arr);
                }
            }
        }
        
    }
    static void PrintToString(String[] texts) 
    {
    	if(texts != null)
    	{
 			System.out.print("[");
 			for(String k:texts) {
 				System.out.print(k);
 				if(!k.equals(texts[texts.length-1]))
 				{
 					System.out.print(", ");
 				}
 			}
 			System.out.println("]");
 		}
 	}
     
    public static void main(String[] args) 
    {
    	System.out.print("Original : ");
    	PrintToString(loadfile("unsorted.txt"));
    	System.out.println("\n*********************** Sort by use Bubble Sort ***********************\n");
    	DescendingOrder(loadfile("unsorted.txt"));
    	
    	
    }
}