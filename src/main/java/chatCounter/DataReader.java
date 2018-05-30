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
/**
 * read data and judge scv or file
 * make list of person that has name, time, string data.
 * @author khnem
 *
 */
public class DataReader {
	/**
	 * judge files type and call right type of object
	 * 
	 * @param filesName
	 * @throws IOException
	 */
	public void getData(ArrayList<String> filesName) throws IOException {
		int i;
		ArrayList<Person> allPerson = new ArrayList<Person>();
		DataReaderForCSV readerCVS = new DataReaderForCSV();
		DataReaderForTXT readerTXT = new DataReaderForTXT();
		DataWriter writer = new DataWriter();
		
		
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
		
		Collections.sort(allPerson);
		
		for(i=0;i<allPerson.size();i++) {
			System.out.println("name: "+allPerson.get(i).name);
			System.out.println("count: "+allPerson.get(i).count);
		}
		
		writer.write(allPerson);
	}
	/**
	 * get directory
	 * @param strDir
	 * @return
	 * @throws FileNotFoundException
	 */
	public File getDirectory(String strDir) throws FileNotFoundException {
		File dataDir = new File(strDir);
		
		return dataDir;
	}
	/**
	 * get list of files from directory
	 * @param dataDir
	 * @return
	 */
	public File[] getLIstOfFilesFromDirectory(File dataDir) {
		File files[]=dataDir.listFiles();
		
		return files;
	}
	/**
	 * for reader pointer files by files 
	 * @param files
	 * @return
	 */
	public ArrayList<String> readFiles(File[] files){
		ArrayList<String> filesName = new ArrayList<String>();
		
		for(int i=0; i<(files.length);i++) {
			filesName.add(files[i].getName());
		}
		
		return filesName;
	}
}
