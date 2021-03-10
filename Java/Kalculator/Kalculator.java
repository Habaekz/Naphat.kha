import java.util.ArrayList;


//Name:Naphat Khajohn-Udomrith
//ID:6188029
//Section:1


public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	//**************************************
	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here. 
	 */

	ArrayList<Double> datain = new ArrayList<Double>();
	int size = datain.size();
	//int size;
	double[] dataink;
	double[] numlist;
	double sum;
	double avg;
	Kalculator()
	{
		//******INSERT YOUR CODE HERE***********
		sum=0;
		avg=0;
		//**************************************
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	//******INSERT YOUR CODE HERE***********
		datain.add(number);
		/*for(int i = 0; i < size ; i++)
		{
			numlist[i] = datain.get(i);
		}*/
		
		//**************************************
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		
		//******INSERT YOUR CODE HERE***********
		if(datain.isEmpty())
		{
		
		}
		else
		{
			datain.remove(0);
		}
		//**************************************
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		//******INSERT YOUR CODE HERE***********
		if(datain.isEmpty())
		{
		
		}
		else
		{
			datain.remove(datain.size()-1);
		}
		//**************************************
	}
	
	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		//******INSERT YOUR CODE HERE***********
		double sum=0;
		for(int i = 0; i < datain.size() ; i++)
		{
			//double num = dataink[i];//datain.get(i);
			sum = sum + datain.get(i);
		}
		return sum;
		//**************************************
	}
	

	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		//******INSERT YOUR CODE HERE***********
		int i,count=0;
		if(datain.isEmpty())
		{
			return 0;
		}
		else
		{
			for(i = 0; i < datain.size(); i++)
			{
				sum = sum + datain.get(i);//datain.get(i);
				count++;
			}
			avg=sum/count;
			return avg;
		}
			//**************************************
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		//******INSERT YOUR CODE HERE***********
		int j;
		double alsum=0;
		double d = (double) datain.size()-1; 
		if(d==0 || datain.isEmpty())
		{
			return 0;
		}
		else
		{
			for(j = 0; j < datain.size(); j++)
			{
				alsum = alsum+((datain.get(j)-avg)*(datain.get(j)-avg));//((datain.get(j)-avg)*(datain.get(j)-avg));
			}
			alsum=alsum/(j-1);
			alsum=Math.sqrt(alsum);
			return alsum;
		}
		//**************************************
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		//******INSERT YOUR CODE HERE***********
	if(datain.isEmpty())
	{
			return 0;
	}
	else
	{
		double Max=-9999999;
		for(int k = 0; k < datain.size(); k++)
		{
			if(datain.get(k)>=Max)//(datain.get(k)>=Max)
			{
				Max=datain.get(k);//datain.get(k);
			}
		}
		return Max;
	}
		//**************************************
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
	//******INSERT YOUR CODE HERE***********
			if(datain.isEmpty())
			{
				return 0;
			}
			else
			{
			double Min=9999999;
			for(int k = 0; k < datain.size(); k++)
			{
				if(datain.get(k)<=Min)//(datain.get(k)<=Min)
				{
					Min=datain.get(k);//datain.get(k);
				}
			}
			return Min;
		}
	//**************************************
	}
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		//******INSERT YOUR CODE HERE***********
				double d = (double) datain.size()-1; 
				ArrayList<Double> maxkk = new ArrayList<Double>(datain);
				double temp= maxkk.get(0);
				double[] maxk = new double[k];
				int count =0;
				int maximum=0;
				if(d==0 || datain.isEmpty())
				{
					return null;
				}
				else
				{
					for(int i=0;i<k;i++){
						for(int j=maxkk.size()-1; j>=0;j--){
						   if(temp<=maxkk.get(j) ){
								temp = maxkk.get(j);
								maxk[count] = temp;
								maximum=j;
							}
						 }
						 if(maxk[i]==maxkk.get(maximum)) 
						 {
							 maxkk.remove(maximum); 
							temp= maxkk.get(0);
						 }
						 count++;
				}
					return maxk;
				}
				//**************************************
	}

	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{
		//******INSERT YOUR CODE HERE***********
		double d = (double) datain.size()-1; 
		ArrayList<Double> minkk = new ArrayList<Double>(datain);
		double temp= minkk.get(0);
		double[] mink = new double[k];
		int count =0;
		int minimum=0;
		if(d==0 || datain.isEmpty())
		{
			return null;
		}
		else
		{
			for(int i=0;i<k;i++){
				for(int j=minkk.size()-1; j>=0;j--){
				   if(temp>=minkk.get(j) ){
						temp = minkk.get(j);
						mink[count] = temp;
						minimum=j;
					}
				 }
				 if(mink[i]==minkk.get(minimum)) 
				 {
					minkk.remove(minimum); 
					temp= minkk.get(0);
				 }
				 count++;
		}
			return mink;
		}
		//**************************************
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{
		//******INSERT YOUR CODE HERE***********
		
		System.out.println("DATA["+datain.size()+"]:"+datain);
		
		
		//**************************************
	}

	
}
