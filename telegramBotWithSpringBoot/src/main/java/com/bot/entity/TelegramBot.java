package com.bot.entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot{
	
	private final String botName;
	
	public TelegramBot(String botName,String botToken) {
		super(botToken);
		this.botName=botName;
	}

	@Override
	public void onUpdateReceived(Update update) {
		if(update.hasMessage() && update.getMessage().hasText()) {
		Message msg=update.getMessage();
		var chatId=msg.getChatId();
		 var msgText=msg.getText();
		//execute(new SendMessage(chatId.toString(),"hello"));
		 
		 SendMessage responseMessage = new SendMessage();
         responseMessage.setChatId(chatId.toString());
         responseMessage.setText("Hello, " + msgText);
         
         try {
             execute(responseMessage); // Sending the message
         } catch (Exception e) {
             e.printStackTrace(); // Log the exception; consider using a logging framework
         }
		}
		
		
	}

	@Override
	public String getBotUsername() {
		
		return this.botName;
	}

}
