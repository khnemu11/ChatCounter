package chatCounter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReaderForCSV {
	public void getData(String filename, ArrayList<Person> allPerson) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("example/"+filename));
		ChatMessageCounter counter = new ChatMessageCounter();
		
		while(true) {
			String line = reader.readLine();
			String nameresult;
			String timeresult;
			String strresult;
			String cp;
			String cp2= "";
			String [] strsplit;
			
			if(line == null) break;
			System.out.println(line);
			if(line.matches("\\d{4}-\\d{2}-\\d{2}\\s(.+)")){
				String[] nameparse =line.split(",",3);
				System.out.println(nameparse[2]);
				nameresult=nameparse[1].substring(1,nameparse[1].length()-1);
				strresult=nameparse[2].substring(1,nameparse[2].length()-1);
				//System.out.println(nameresult); //name
				System.out.println(strresult); //str
				
				String[] timeparse = nameparse[0].split(" ");
				timeresult=timeparse[0]+" "+timeparse[1].substring(0,5);
				//System.out.println(timeresult); //time
				
				//if(nameresult.equals("議곗젙�썕"))
				//System.out.println("name: "+nameresult+" time: "+timeresult+" str:"+strresult);
				cp=strresult;
				strsplit = cp.split("\"\"");
				
				for(int i=0;i<strsplit.length;i++) {
					System.out.println(strsplit[i]);
				}
				for(int i=0;i<strsplit.length-1;i++) {
					cp2=cp2+strsplit[i]+"\"";
					System.out.println(cp2);
				}
				cp2=cp2+strsplit[strsplit.length-1];
				System.out.println(cp2);
				
				
				counter.setData(nameresult,timeresult,cp2,allPerson);
			}
			else	continue;
		}
	reader.close();
	}
}
