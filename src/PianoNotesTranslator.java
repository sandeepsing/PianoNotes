import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;

public class PianoNotesTranslator { 
  
	//private Map<String, String> notesMap = new HashMap<String, String>(36);
	//private static final String[] musicNotes1 = {"C3","C#3","D3","D#3","E3","F3","F#3","G3","G#3","A3","A#3","B3","C4","C#4","D4","D#4","E4","F4","F#4","G4","G#4","A4","A#4","B4","C5","C#5","D5","D#5","E5","F5","F#5","G5","G#5","A5","A#5","B5"};
	//private static final String[] musicNotes3 = {"C2","C#2","D2","D#2","E2","F2","F#2","G2","G#2","A2","A#2","B2","C3","C#3","D3","D#3","E3","F3","F#3","G3","G#3","A3","A#3","B3","C4","C#4","D4","D#4","E4","F4","F#4","G4","G#4","A4","A#4","B4"};
	//private static final String[] alphaNumericNotes1 = {"a","s","d","f","g","h","j","k","l","q","w","e","r","t","y","u","i","o","p","z","x","c","v","b","n","m","1","2","3","4","5","6","7","8","9","0"};
	private static final String[] musicNotes1 = {"C#","C","D#","D","E","F#","F","G#","G","A#","A","B"};
	private static final String[] alphaNumericNotes2 = {"s","a","f","D","g","j","h","l","k","w","q","e"};
	
	
	/*
	 * public PianoNotesTranslator() {
	 * 
	 * super(); for(int i=0;i<musicNotes.length;i++) notesMap.put(musicNotes[i],
	 * alphaNumericNotes[i]);
	 * 
	 * }
	 */
	
	
    //Function to replace notes in file 
    public static void replaceNotes(String filePath) throws IOException 
    {
    	File inputNotesFile = new File(filePath);
    	String fullSongNotesStr = "";
    	BufferedReader reader = new BufferedReader(new FileReader(inputNotesFile));
    	String line = reader.readLine();

    	while (line != null)
    	{
    		fullSongNotesStr = fullSongNotesStr + line + System.lineSeparator();
    	        line = reader.readLine();
    	}
    	
    	for(int i=0;i<musicNotes1.length;i++) 
    		fullSongNotesStr = fullSongNotesStr.replaceAll(musicNotes1[i], alphaNumericNotes2[i]);
		/*
		 * for(int i=0;i<musicNotes2.length;i++) fullSongNotesStr =
		 * fullSongNotesStr.replaceAll(musicNotes2[i], alphaNumericNotes2[i]);
		 */  	
    	FileWriter writer = new FileWriter(filePath+"_mod");
        writer.write(fullSongNotesStr);
        reader.close();
        writer.close();
    } 
  
    public static void main(String[] args) { 
          
         try {
        	 if(args.length==0)
        		 System.out.println("Pass file path");
        	 else
        		 replaceNotes(args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
          
          
    } 
}