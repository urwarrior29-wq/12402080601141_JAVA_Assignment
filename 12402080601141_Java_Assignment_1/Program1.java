/*P-1:Implement Array and String operations (Reverse, Sort,
Search, Average, Maximum) using class and objects*/

class Main{
	int arr[]={10,5,4,7,2};   // array initialization
	
   void reverse()
   {
	   // reverse array (first becomes last and last becomes first)
	   for(int i=0;i<arr.length/2;i++)
	   {
		   int temp=arr[i];   // store current element
		   arr[i]=arr[arr.length-1-i];   // swap with last element
           arr[arr.length-1-i]=temp;    // put temp value here
       }
	   
	   // printing reversed array
	   System.out.println("Reversed Array:");
	   for(int i=0;i<arr.length;i++)
	   {
		   System.out.print(" " + arr[i]);
	   }
	   System.out.println();
   }
   
    void search(int key) {

        for (int i = 0; i <arr.length; i++) {

            if (arr[i] == key) {
                System.out.println("Element found at position: " + (i + 1));
                return;
            }
        }

        System.out.println("Element not found");
    }


       
   void sort()
   {
	   // sorting array in ascending order
	   for(int i=0;i<arr.length;i++)
	   {
		   for(int j=i+1;j<arr.length;j++)
		   {
			   // compare elements and swap if needed
			   if(arr[i] > arr[j])
			   {
				   int temp = arr[i];
				   arr[i] = arr[j];
				   arr[j] = temp;
			   }
		   } 
	   }
	
	   // printing sorted array
	   System.out.println("Sorted Array:");
	   for(int i=0;i<arr.length;i++)
	   {
		   System.out.print(" " + arr[i]);
	   }
	   System.out.println();
    }
	
	void avg()
	{
		int sum=0;
		double avg;
		
		// calculate sum of all elements
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
		
		// calculate average
		avg=(double)sum/arr.length;
		
		System.out.println("Average of Array is: " + avg);
	}
	
	void max()
	{
	    int max=arr[0];   // assume first element is max
		
		// find maximum element
		for(int i=0;i<arr.length;i++)
		{
		   	if(arr[i]>max)
			{
				max=arr[i];   // update max value
			}
		}
		
		System.out.println("Maximum Number is: " + max);
	}
}
    
public class Program1
{
	public static void main(String args[])
	{
		Main obj=new Main();   // creating object
		
		// calling different methods
		obj.reverse();
		obj.sort();
		obj.max();
		obj.avg();
		obj.search(5);
	}
}