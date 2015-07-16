import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Transposer {

	public enum Chord {
		A ("A",		"A",	0),
		A1("Bb",	"A#",	1),
		B ("B",		"B",	2),
		C ("C", 	"C",	3),
		C1("C#",	"Db",	4),
		D ("D", 	"D",	5),
		D1("Eb",	"D#",	6),
		E ("E",		"E",	7),
		F("F",		"F",	8),
		F1("F#",	"Gb",	9),
		G("G",		"G",	10),
		G1("Ab",	"G#",	11);
		
		private final String main;
		private final String alt;
		private final int value;
		private final static int length = 12;
		
		private static final Map<Integer, Chord> lookup = new HashMap<Integer, Chord>();

	    static {
	        for (Chord c : Chord.values()) {
	            lookup.put(c.value(), c);
	        }
	    }
	
		private Chord(String main, String alt, int value){
			this.main = main;
			this.alt = alt;
			this.value = value;
		}
		
		public int value(){
			return value;
		}
		
		public static int length(){
			return length;
		}
		
		public String getMain(){
			return main;
		}
		
		public String getAlt(){
			return alt;
		}
		
		public static Chord get(int value){
			return lookup.get(value);
		}
	}//end of enum Chord
	
	public static String trans(String toTrans, int amount){
		
		//format the string to match the enum
		//toTrans = toTrans.toUpperCase();
		
		String chordToFind = "";
		String endOfChord = "";
		
		if(toTrans.length() > 1){
			
			String firstLetter = toTrans.substring(0,1).toUpperCase();
			
			if(toTrans.charAt(1) == 'b' || toTrans.charAt(1) == '#'){
				chordToFind = firstLetter + toTrans.substring(1,2);
				if(toTrans.length() > 2){
					endOfChord = toTrans.substring(2);
				}
			}
			else{
				endOfChord = toTrans.substring(1);
				chordToFind = firstLetter;
			}
		}
		else{
			chordToFind = toTrans.toUpperCase();
		}
		
		int value = -1;
		
		//iterate over enums, compare to main and alt 
		for(Chord chord: Chord.values()){
			if(chord.getMain().equals(chordToFind) || chord.getAlt().equals(chordToFind)){
				value = chord.value();
			}
		}

		if(value == -1){
			return "Please enter a valid chord";
		}
		
		//shift value to represent the new chord
		value += amount;
		
		//Deal with potential wrap around
		if(value < 0){
			value = value + Chord.length();
		}
		else if(value > Chord.length-1){
			value = value%Chord.length();
		}
		
		//the main value is returned
		return Chord.get(value).main + endOfChord;
	}//end of method trans
}//end of class Transposer
