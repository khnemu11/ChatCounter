package chatCounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * the base form of data. it has name, allchatlog and count 
 * @author khnem
 *
 */
/**
 * imply comparable list Person to sort its count
 * the allChatLog is hashmap (time, LIst string==chatlog)
 * 
 * @author khnem
 *
 */
public class Person implements Comparable<Person>{
	String name;
	HashMap<String , List<String>> allChatLog = new HashMap<String , List<String>>();
	int count=0;
	/**
	 * set first data
	 * @param name
	 * @param time
	 * @param str
	 */
	public void setData(String name, String time, String str) {
		List<String> chatlog = new ArrayList<String>();
		chatlog.add(str);
		
		this.name = name;
		this.allChatLog.put(time,chatlog);
		this.count++;
	}
	/**
	 * if its data's name is already exist, just save time and string
	 * if the time is already exist, put its hashmap
	 * @param time
	 * @param str
	 */
	public void setTime(String time,String str) {
		List<String> chatlog = new ArrayList<String>();
		chatlog.add(str);
		
		if(this.allChatLog.containsKey(time)) {
			this.allChatLog.get(time).add(str);
			this.count++;
		}
		
		else {
			this.allChatLog.put(time,chatlog);
			this.count++;
		}
	}
	/**
	 * sort person's count
	 */
	public int compareTo(Person person) {
		if (this.count < person.count) {
			return 1;

		} else if (this.count == person.count) {
			return 0;

		} else {
			return -1;

		}
	}
}
