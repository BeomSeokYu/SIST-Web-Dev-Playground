package javaz.util;

import java.util.ArrayList;
import java.util.List;

public class StreamMessageTest {

	public static void main(String[] args) {
		List<Message> msgList = new ArrayList<>();
		msgList.add(new Message("Lee",	"hi",	"e-mail"));
		msgList.add(new Message("Ann",	"hello","sms"));
		msgList.add(new Message("Jin",	"bye",	"katalk"));
		
		for (Message msg : msgList) {
			if(msg.getCommend().equals("katalk")) {
				System.out.println("\t발신자 : "+ msg.getFrom() 
									+ "\t내용 : "+ msg.getContent());
			}
		}
		msgList.stream()
			.filter(o -> o.getCommend().equals("sms"))
			.forEach(o -> System.out.println("발신자 : "+ o.getFrom() 
							+ "\t내용 : "+ o.getContent()));
	}
}
