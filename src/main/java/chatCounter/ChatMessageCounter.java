package chatCounter;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * judge variable case for save data
 * @author khnem
 *
 */
public class ChatMessageCounter {
	int i;
	int j;
	/**
	 * judge data is first time for not.
	 * it had full same data(name, time, string)data already ,pass 
	 * it is second time but it had already string data 사진 or photo ,pass
	 * if is second time and dont have this data ,add data
	 * it is first time , make object and save
	 * 
	 * @param name
	 * @param time
	 * @param str
	 * @param allPerson
	 */
	public void judgeData(String name, String time, String str,ArrayList<Person> allPerson) {
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
