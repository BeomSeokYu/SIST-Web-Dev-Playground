package javaz.util;

import java.util.LinkedList;
import java.util.Queue;

class Message {
	private String from;
	private String content;
	private String commend;
	
	public Message(String from, String content, String commend) {
		this.from = from;
		this.content = content;
		this.commend = commend;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommend() {
		return commend;
	}
	public void setCommend(String commend) {
		this.commend = commend;
	}
	
	
}

public class QueueMessageTest {

	public static void main(String[] args) {
		Queue<Message> msgQ = new LinkedList<>();
		msgQ.offer(new Message("Lee",	"hi",	"e-mail"));
		msgQ.offer(new Message("Ann",	"hello","sms"));
		msgQ.offer(new Message("Jin",	"bye",	"DM"));
		
		System.out.println("도착 메시지 : " + msgQ.size() + "건");
		System.out.println("-------------------------------");
		while(!msgQ.isEmpty()) {
			Message m = msgQ.poll();
			
			switch (m.getCommend()) {
			case "e-mail": System.out.println("[이메일 수신]\n\t발신자 : " + m.getFrom() 
						+ "\t내용 : "+ m.getContent());
				break;
			case "sms": System.out.println("[SMS 수신]\n\t발신자 : " + m.getFrom() 
						+ "\t내용 : "+ m.getContent());
				break; 
			case "DM": System.out.println("[DM 수신]\n\t발신자 : " + m.getFrom() 
						+ "\t내용 : "+ m.getContent());
				break;
			}
		}
		System.out.println("-------------------------------");
		System.out.println("도착 메시지 : " + msgQ.size() + "건");
	}

}
