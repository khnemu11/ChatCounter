package chatCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
/**
 * main object of message counter
 * @author khnem
 *
 */
public class Main {
	/**
	 * set messeage data directory and call parsing object
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		DataReader drd = new DataReader();
		File dataDir=drd.getDirectory("example");
		File[] files= drd.getLIstOfFilesFromDirectory(dataDir);
		ArrayList<String> filesname = drd.readFiles(files);
		drd.getData(filesname);
	}
}
