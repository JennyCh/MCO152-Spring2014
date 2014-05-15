package sortingANDsearching;

public class Sorts {

	//buble sort AKA exchange sort 
	//exchange values so that they are in order until the entire list of values appear in order
	
	private int [] array = {9,8,7,6,5,4,3,2,1,0};
	
	public Sorts(){
		bubbleSort(array);
	}
	
	public void bubbleSort(int [] values){
		int temp;
		boolean swapped;
		
		do{
			swapped = false;
			for(int inner  = 0; inner < values.length-1; inner++){
				//compare two values, if not in order - swap them
				if(values[inner] > values [inner+1]){
					temp = values[inner];
					values[inner] = values[inner+1];
					values[inner+1] = temp;
					//2 values were swapped, means list was not in order
					swapped = true;
					
					
				}
			}
			for(int i: array){
				System.out.print(i);
			}
			System.out.println("\n");
		}while(swapped);
	}
	
	public static void main (String [] args){
		new Sorts();
	}
}
