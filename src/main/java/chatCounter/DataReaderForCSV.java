package chatCounter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * datareader for csv file. 
 * 
 * @author khnem
 *
 */
public class DataReaderForCSV {
	/**
	 * Check it is in the format 'YYYY-MM-DD +other sentence'. if it is correct, do to parse. 
	 * the doc in csv file is divided into three characters by ",". so it parses using split
	 * if the next sentence doesn't start 2 , the nextreader catch it and attach this sentence and next sentence
	 * finally send information of name,time,string to data counter
	 * @param filename
	 * @param allPerson
	 * @throws IOException
	 */
	public void getData(String filename, ArrayList<Person> allPerson) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("example/"+filename));
		BufferedReader nextreader = new BufferedReader(new FileReader("example/"+filename));
		ChatMessageCounter counter = new ChatMessageCounter();
		
		String nextLine = nextreader.readLine();
		
		while(true) {
			String line = reader.readLine();
			String nameresult;
			String timeresult;
			String strresult;
			String cp;
			String cp2= "";
			String [] strsplit;
			
			nextLine = nextreader.readLine();
			
			if(line == null) break;
			if(line.matches("\\d{4}-\\d{2}-\\d{2}\\s(.+)")){
				if(nextLine!=null && nextLine.substring(0,1).equals("2")==false) {
					line= line + nextLine;
				}
				
				String[] nameparse =line.split(",",3);
				nameresult=nameparse[1].substring(1,nameparse[1].length()-1);
				strresult=nameparse[2].substring(1,nameparse[2].length()-1);
				String[] timeparse = nameparse[0].split(" ");
				timeresult=timeparse[0]+" "+timeparse[1].substring(0,5);
				cp=strresult;
				strsplit = cp.split("\"\"");
				
				for(int i=0;i<strsplit.length-1;i++) {
					cp2=cp2+strsplit[i]+"\"";
			
				}
				cp2=cp2+strsplit[strsplit.length-1];
		
				
				counter.judgeData(nameresult,timeresult,cp2,allPerson);
			}
			else	continue;
		}
	reader.close();
	}
}
