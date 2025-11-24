package com.didanko228.tghealthreminder.handlers;

import com.didanko228.tghealthreminder.utils.Logger;
import com.didanko228.tghealthreminder.utils.TranslationManager;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class TextHandler {
    public static void handle(TelegramClient telegramClient, Message msg) {
        String text = msg.getText();
        long chat_id = msg.getChatId();

        if (text.equals("ru")) {
            SendMessage message = SendMessage
                    .builder()
                    .chatId(chat_id)
                    .text(TranslationManager.translate("ru_ru", "ru_ru"))
                    .replyMarkup(InlineKeyboardMarkup
                            .builder()
                            .keyboardRow(new InlineKeyboardRow(InlineKeyboardButton
                                    .builder()
                                    .text(TranslationManager.translate("ru_ru", "ru_ru"))
                                    .callbackData("test")
                                    .build()))
                            .build())
                    .build();

            try {
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                Logger.error("Error sending message", e);
            }
        }
        else if (text.equals("en")) {
            SendMessage message = SendMessage
                    .builder()
                    .chatId(chat_id)
                    .text(TranslationManager.translate("en_us", "en_us"))
                    .replyMarkup(InlineKeyboardMarkup
                            .builder()
                            .keyboardRow(new InlineKeyboardRow(InlineKeyboardButton
                                    .builder()
                                    .text(TranslationManager.translate("en_us", "en_us"))
                                    .callbackData("test")
                                    .build()))
                            .build())
                    .build();

            try {
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
