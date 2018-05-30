package chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/**
 * data reader for txt file
 * @author khnem
 *
 */
public class DataReaderForTXT {
	/**
	 * 	
	 * Check it is in the format '-------+other sentence'. if it is correct, go next. 
	 * the doc in csv file is divided into three characters by "[ ]". so it parses using split by "]" and except [ using by substring;the 0 index value is [
	 * if the next sentence doesn't start 2 , the nextreader catch it and attach this sentence and next sentence
	 * if time is 오전, the hour is a single digit but scv file is double digit. so it attaches 0
	 * if time is 오후, plus 12 hour part but the hour part can be single digit. so it check single for double digit using by substring
	 * if not upper case parse; am and doubledigit
	 * finally send information of name,time,string to data counter
	 * @param filename
	 * @param allPerson
	 * @throws IOException
	 */
	
	public void getData(String filename, ArrayList<Person> allPerson) throws IOException {
		File file = new File("example/"+filename);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		BufferedReader nextreader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
		ChatMessageCounter counter = new ChatMessageCounter();
		String resultdate = null;
		
		nextreader.readLine();
		
		while(true) {
			String line = reader.readLine();
			String nextLine = nextreader.readLine();
			String timeresult = null;
			String strresult;
			String nameresult;
			int hourInt = 0;
			
			
			if(line == null) {
				break;
			}
			if(line.matches("---------------\\s(.+)")) {
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
				if(nextLine!=null && nextLine.substring(0,1).equals("[") == false && nextLine.substring(0,1).equals("-")==false) {
					strresult=parse[2].substring(1)+nextLine;
				}
				else {
					strresult=parse[2].substring(1);
				}
				
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
				
				nameresult=parse[0].substring(1);
				timeresult=resultdate+" "+timeresult;
				
				counter.judgeData(nameresult,timeresult,strresult,allPerson);
			}
		}
	reader.close();
	}
}