package com.didanko228.tghealthreminder;

import com.didanko228.tghealthreminder.handlers.TextHandler;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class TgHealthReminder implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;

    public TgHealthReminder(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            TextHandler.handle(telegramClient, update.getMessage());
        }
    }
}
