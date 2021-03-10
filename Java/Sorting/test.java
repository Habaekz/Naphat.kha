import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class test {
	
	public static boolean isPal(String s)
    {   
        if(s.length() == 0 || s.length() == 1)
            return true; 
        if(s.charAt(0) == s.charAt(s.length()-1))
        {
        	return isPal(s.substring(1, s.length()-1));
        }
        	return false;
    }
	public static void main(String[] args)
	{
		
		String original, reverse = ""; 
	      Scanner in = new Scanner(System.in);
	     
	      System.out.println("Enter a string to check :");
	      original = in.nextLine();
	     
	      int length = original.length();
	     
	      for (int i = length - 1; i >= 0; i--)
	         reverse = reverse + original.charAt(i);
	         
	      if (isPal(original))
	         System.out.println("The string is a palindrome.");
	      else
	         System.out.println("The string isn't a palindrome.");
	         
	   }
	}
