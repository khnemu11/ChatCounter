package chatCounter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * make csv file in this file
 * @author khnem
 *
 */
public class DataWriter {
	/**
	 * get our allperson data ,make csv file and save
	 * the csv file's format is ",". so it save data following this format 
	 * 
	 * @param allPerson
	 * @throws IOException
	 */
	public void write(ArrayList<Person> allPerson) throws IOException{
		String fileName = "out.csv"; //The name could be read from the keyboard.
        PrintWriter outputStream = null;
        
        try {
        	FileOutputStream fos = new FileOutputStream(fileName);
        	OutputStreamWriter osw = new OutputStreamWriter(fos, "MS949");
        	BufferedWriter bw = new BufferedWriter(osw);
        	for (int i=0 ; i<allPerson.size() ; i++) {
                bw.write (allPerson.get(i).name + "," + allPerson.get(i).count+"\n");
            }
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println ("Error opening the file " + fileName);
            System.exit (0);
        }
        
        System.out.println ("Those lines were written to " + fileName);
	    }
}
