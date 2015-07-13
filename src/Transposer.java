import java.util.Scanner;


public class Transposer {
	
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a chord to be transposed: ");
		String toTranspose = sc.nextLine();
		System.out.print("Please enter the amount to be transposed: ");
		int amount = sc.nextInt();
		System.out.print("The transposed chord is: ");
		System.out.println(trans(toTranspose, amount));
		
	}
	
	public static String [] chords = {
			"a", 
			"a#", 
			"b", 
			"c", 
			"c#", 
			"d", 
			"d#", 
			"e",
			"f",
			"f#",
			"g",
			"g#"
	};
	
	public static String trans(String toTrans, int amount){
		
		//Must pull out relevant chord info
		//i.e. C#dim, all we need is C#.
		//TODO
		
		toTrans = toTrans.toLowerCase();
		
		int index = -1;
		
		for(int i = 0; i < chords.length; i++){
			if(chords[i].equals(toTrans)){
				index = i;
				break;
			} 
		}
		
		if(index == -1){
			return "Please enter a valid chord";
		}
		
		index += amount;
		
		//Deal with potential wrap around
		if(index < 0){
			index = index + chords.length;
		}
		else if(index > chords.length-1){
			index = index%chords.length;
		}
		
		//add back in relevant information
		
		return chords[index].toUpperCase();
	}


}
