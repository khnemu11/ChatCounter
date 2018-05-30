package chatCounter;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatMessageCounter {
	int i;
	int j;
	
	public void setData(String name, String time, String str,ArrayList<Person> allPerson) {
		Person person = new Person();
		
		for(Person p : allPerson) {
			if(p.name.equals(name)) {
				if(p.allChatLog.containsKey(time) && p.allChatLog.get(time).contains(str)) {
						System.out.println("pass same str in same time");
						return;
				}
				else if(p.allChatLog.containsKey(time)){
					if((str.equals("사진")||str.equals("Photo")) && (p.allChatLog.get(time).contains("사진")||p.allChatLog.get(time).contains("Photo"))){
						System.out.println("pass same photo or 사진 in same time");
						return;
					}
					
					else {
						p.setTime(time, str);
						return;
					}
				}
				
				else {
					p.setTime(time, str);
					return;
				}
			}
		}
		
		person.setData(name, time, str);
		allPerson.add(person);
	}
}
