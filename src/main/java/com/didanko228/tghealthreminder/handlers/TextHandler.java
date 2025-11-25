package com.didanko228.tghealthreminder.handlers;

import com.didanko228.tghealthreminder.ui.Keyboards;
import com.didanko228.tghealthreminder.utils.Logger;
import com.didanko228.tghealthreminder.utils.TranslationManager;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class TextHandler {
    public static void handle(TelegramClient telegramClient, Message msg) {
        String text = msg.getText();
        long chat_id = msg.getChatId();
        int msg_id = msg.getMessageId();

        if (text.equals("/start")) {
            SendMessage message = SendMessage
                    .builder()
                    .chatId(chat_id)
                    .text(TranslationManager.translate(TranslationManager.DEFAULT_LANGUAGE, "msg.start"))
                    .replyToMessageId(msg_id)
                    .replyMarkup(Keyboards.getStartMenu(chat_id))
                    .build();

            try {
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                Logger.error("Error sending msg", e);
            }
        }
    }
}
