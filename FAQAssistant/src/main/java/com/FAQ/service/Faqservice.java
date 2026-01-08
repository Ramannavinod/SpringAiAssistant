package com.FAQ.service;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.FAQ.model.ChatHistory;

     @Service
     public class Faqservice {
	
	//Hardcode FAQ data
    private static final Map<String, String> FAQ_DATA=new HashMap<String, String>();

    private final Map<String, Deque<ChatHistory>> chatMemory = new HashMap<>();

    static {
    FAQ_DATA.put("refund", "We provide refunds within 30 days of purchase.");
    FAQ_DATA.put("working hours", "Our working hours are 9 AM to 6 PM, Monday to Friday.");
    FAQ_DATA.put("contact", "You can contact us at support@company.com.");
    FAQ_DATA.put("location", "Our company is located in Bangalore.");
    FAQ_DATA.put("projects", "We are interacts with Multiple Client projects and some government projects");
   }
    public String getAnswer(String userId, String question) {
        String lowerQuestion = question.toLowerCase();

        String answer = FAQ_DATA.entrySet()
        		//convert content into stream
                .stream()
                //check if question contains keyword
                .filter(entry -> lowerQuestion.contains(entry.getKey()))
                //if contains then it return answer value
                .map(Map.Entry::getValue)
                .findFirst()
                // or else this will execute
                .orElse("Sorry, I couldn't understand your question.");

        storeChat(userId, question, answer);
        return answer;
    }
    private void storeChat(String userId, String question, String answer) {
        chatMemory.putIfAbsent(userId, new ArrayDeque<>());

        Deque<ChatHistory> history = chatMemory.get(userId);

        if (history.size() == 5) {
            history.removeFirst(); // remove oldest
        }

        history.addLast(new ChatHistory(question, answer));
    }

}
