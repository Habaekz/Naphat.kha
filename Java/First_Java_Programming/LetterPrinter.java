package week1;

public class LetterPrinter {
	  public static void main (String[] args) throws Exception {
			int i,j;
			for(i=0 ; i<5 ; i++)
			{
				System.out.print("X");
				for(j=1 ; j<i ; j++)
				{
					System.out.print(" ");
				}
				if(i>0 && i<4)
				{
					System.out.print("X");
				}
				for(j=3-i ; j>0 ; j--)
				{
					System.out.print(" ");
				}
				System.out.print("X");
				System.out.println("");
			}
		  }
}
