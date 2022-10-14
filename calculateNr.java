
import java.io.FileNotFoundException;
import java.util.*;

public class calculateNr {
	
	
	/**
	 * 
	 * @param arr
	 * @param n
	 */
	private static void countFreq(int arr[], int abc)
	   {
		boolean visited[];
		visited = new boolean[abc];
		
        Arrays.fill(visited, false);

        // count frequencies whjile traversing through array
        for (int i = 0; 
        	 i < abc; i
        	 ++) {
        	
        	//counting the frequency
           if (visited[i] != true) {
        	   int count = 1;
	           for (int z = i + 1;
	        		z < abc; 
	        		z++) {
	               if (arr[i] == arr[z]) { visited[z] = true; count++;}
	           }
	           System.out.println(arr[i] + " occurs " + count + " times ");
           }
           else {
	           continue;
           }
        }
	  }
	
	/**
	 * 
	 * @param numbers
	 */
	public static void Dup(int numbers[]) {
		boolean duplicate = false;
		int l = 0;
	    for (int z = 0; 
	         z < numbers.length; 
	    	 z++) {
		        while (z > l){
		            if (numbers[z] == numbers[l] && (z != l)) {
		                duplicate = true;
		            }
		            l++;
		        }
	
		        if (duplicate == true) {
		            System.out.print(numbers[z] + "  ");
		        }
	    }
	}
	
	
	
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	//main
	public static void main(String[] args) throws FileNotFoundException {
		

		 int maximum = 0; 
		 int temp = 0; int tempo2 = 0;
		 AVLTree AVL;
		 AVL = new AVLTree();
		 AVLTree avl;
		 avl = new AVLTree();
		 int i;
		 
		 
		FileWordRead words;
		words = new FileWordRead("words.txt");
		
		//grabbing the iterator in the variable
		Iterator<String> abc;
		abc = words.get_iterator();
		
		//hashmap
		HashMap<String, Integer> grid;
		grid = new HashMap<>();
			
		//checks if aything is left in the iterator
		while (abc.hasNext() == true) {
		
			//get next item in iterator
			String str;
			str = abc.next(); 
			str = str.replaceAll(" [^&,()*.?!@#$%_+-]+", ""); // remove ([ ^ & , () * . ? ! @ # $ % _ + - ] +) 
			 
			
			 if(grid.containsKey(str) != true) {
				 temp = 1;
	             grid.put(str, temp);
	             if (str.length() >= maximum + 1) { maximum = str.length();}
	             }
			 else {temp = grid.get(str)+1; grid.put(str,temp);}
		
		
		}

		TreeMap<String, Integer> treemap = new TreeMap<>();
		
        int A[] = new int[treemap.size()];
        treemap.putAll(grid);
        int x = treemap.size();
        boolean v[] = new boolean[x];
        Arrays.fill(v, false);
        int l;
        
        for (Map.Entry<String, Integer> e: treemap.entrySet()) {
     
        	if(temp == 0) {
        		System.out.println("word is not in file");
        		}
        	else 
 		    	{
        		  AVL.Insert(e.getValue());
        		  
        		  for(i = 0; 
        			  i <= treemap.size() + 1; 
        			  ++i) {
        			  if(i == e.getValue()) {A[tempo2++] = i;}
        			  else {return;}
        		  }
 		    }
        }
        
        
        
     
       //traversing through elements in the array and counting frequencies
       for (l = 0; 
    		l < x; 
    		l++) {
    	   
    	   //counting frequency
          if (v[l] != true) {
        	  int count;
        	  count = 1;
	          for (int z = l + 1; 
	        	   z < x; 
	        	   z++) {
	              if (A[l] == A[z]) {v[z] = true; count++;}
	          }
	          
	          System.out.println("(" + A[l] + ", " + count + " ) ");
	          
	          avl.Insert(count);
          }
          
          //if already processed, skip the element
          else {
	          continue;
          }
       }
	}
	
}
