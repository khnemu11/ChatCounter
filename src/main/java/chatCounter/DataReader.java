package chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DataReader {
	public void getData(ArrayList<String> filesName) throws IOException {
		int i;
		ArrayList<Person> allPerson = new ArrayList<Person>();
		DataReaderForCSV readerCVS = new DataReaderForCSV();
		DataReaderForTXT readerTXT = new DataReaderForTXT();
		
		for(i=0;i<filesName.size();i++) {
			String filename = filesName.get(i);
			
			System.out.println("---------"+filename+"---------");
			
			if(filename.contains(".csv")) {
				readerCVS.getData(filename,allPerson);
			}
			else if(filename.contains(".txt")) {
				readerTXT.getData(filename,allPerson);
			}
			else {
				System.out.println("can't open the file");
			}
		}
		
		for(Person p : allPerson) {
			if(p.name.equals("조정훈")) {
			for(String key : p.allChatLog.keySet()) {
				for(int i1=0;i1<p.allChatLog.get(key).size();i1++) {
					System.out.println("name: "+p.name+" time: "+key+" str: "+p.allChatLog.get(key).get(i1));		
				}
			}
			}
		}
		
		Collections.sort(allPerson);
		
		for(i=0;i<allPerson.size();i++) {
			System.out.println("name: "+allPerson.get(i).name);
			System.out.println("count: "+allPerson.get(i).count);
		}
		
	}
	public File getDirectory(String strDir) throws FileNotFoundException {
		File dataDir = new File(strDir);
		
		return dataDir;
	}
	
	public File[] getLIstOfFilesFromDirectory(File dataDir) {
		File files[]=dataDir.listFiles();
		
		return files;
	}
	
	public ArrayList<String> readFiles(File[] files){
		ArrayList<String> filesName = new ArrayList<String>();
		
		for(int i=0; i<(files.length);i++) {
			filesName.add(files[i].getName());
		}
		
		return filesName;
	}
}
