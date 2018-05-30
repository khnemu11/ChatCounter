package chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataReaderForTXT {
	public void getData(String filename, ArrayList<Person> allPerson) throws IOException {
		File file = new File("example/"+filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		ChatMessageCounter counter = new ChatMessageCounter();
		String resultdate = null;
		
		while(true) {
			String line = reader.readLine();
			String timeresult = null;
			String strresult;
			String nameresult;
			int hourInt = 0;
			
			if(line == null) break;
			//System.out.println(line);
			
			else if(line.matches("---------------\\s(.+)")) {
				String [] date = line.split(" ");
				date[1]=date[1].substring(0,date[1].length()-1);
				date[2]=date[2].substring(0,date[2].length()-1);
				if(date[2].length()==1) {
					date[2]="0"+date[2];
				}
				date[3]=date[3].substring(0,date[3].length()-1);
				if(date[3].length()==1) {
					date[3]="0"+date[3];
				}
				resultdate=date[1]+"-"+date[2]+"-"+date[3];
			}
			
			else if(line.contains("]")){
				String[] parse =line.split("]");
			
				//System.out.println(parse[0].substring(1)); //name
				//System.out.println(parse[1]); //time
				//System.out.println(parse[2].substring(1)); //str
				
				if(parse[1].substring(2,4).equals("오전")&&parse[1].length()==9) {
					String []time = parse[1].substring(5,9).split(":");
					time[0]="0"+time[0];
					timeresult =  time[0] + ":" + time[1];
				}
				else if(parse[1].substring(2,4).equals("오후")&&parse[1].length()==10) {
					String []time = parse[1].substring(5,10).split(":");
					hourInt = Integer.parseInt(time[0]);
					hourInt+=12;
					timeresult =  String.valueOf(hourInt) + ":" + time[1];
				}
				else if(parse[1].substring(2,4).equals("오후") && parse[1].length()==9) {
					String []time = parse[1].substring(5,9).split(":");
					hourInt = Integer.parseInt(time[0]);
					hourInt+=12;
					timeresult =  String.valueOf(hourInt) + ":" + time[1];
				}
				else if(parse[1].length()==10)	timeresult=parse[1].substring(5,10);
				else if(parse[1].length()==9)	timeresult=parse[1].substring(5,9);
				
				nameresult=parse[0].substring(1);
				timeresult=resultdate+" "+timeresult;
				strresult=parse[2].substring(1);
				
			//	System.out.println(timeresult);
				counter.setData(nameresult,timeresult,strresult,allPerson);
			}
		}
	reader.close();
	}
}