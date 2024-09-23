package com.bot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramConfig {
	@Bean
	public TelegramBot telegramBot(@Value("${bot.name}") String botName,
			@Value("${bot.token}") String botToken) {
		
		
		 LongPollingBot tb = new com.bot.entity.TelegramBot(botName,botToken);
		try {
		var telegramBotApi=new TelegramBotsApi(DefaultBotSession.class);
		telegramBotApi.registerBot((LongPollingBot) tb);
		}catch(TelegramApiException e) {
			
		}
		return tb;
		
	}

}
