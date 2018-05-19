package chatCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataReader drd = new DataReader();
		File dataDir=drd.getDirectory("example");
		File[] files= drd.getLIstOfFilesFromDirectory(dataDir);
		ArrayList<String> filesname = drd.readFiles(files);
		drd.getData(filesname);
	}
}
