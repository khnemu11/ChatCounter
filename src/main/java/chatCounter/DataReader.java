package chatCounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {
	public void getData(ArrayList<String> filesName) throws IOException {
		int i;
		for(i=0;i<filesName.size();i++) {
			BufferedReader reader = new BufferedReader(new FileReader("example/"+filesName.get(i)));
			System.out.println("*********************File no."+(i+1)+"*********************");
			while(true) {
				String line = reader.readLine();
				if(line == null) break;
				System.out.println(line);
			}
		reader.close();
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
