package chatCounter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Person implements Comparable<Person>{
	String name;
	HashMap<String , List<String>> allChatLog = new HashMap<String , List<String>>();
	int count=0;
	
	public void setData(String name, String time, String str) {
		List<String> chatlog = new ArrayList<String>();
		chatlog.add(str);
		
		this.name = name;
		this.allChatLog.put(time,chatlog);
		
		//for(String key : this.allChatLog.keySet()) {
		//	System.out.println(this.name);
		//	System.out.println("time: "+key+" str "+allChatLog.get(key));
	//	}
		//System.out.println("================================");
		this.count++;
	}
	
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
		//for(String key : this.allChatLog.keySet()) {
	//		System.out.println(this.name);
	//		System.out.println("time: "+key+" str "+allChatLog.get(key));
	//	}
	//	System.out.println("================================");
	}

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
