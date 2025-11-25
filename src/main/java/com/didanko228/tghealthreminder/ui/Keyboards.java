package com.didanko228.tghealthreminder.ui;

import com.didanko228.tghealthreminder.utils.TranslationManager;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

public class Keyboards {
    public static InlineKeyboardMarkup getRuKeyboard() {
        return InlineKeyboardMarkup
                .builder()
                .keyboardRow(new InlineKeyboardRow(InlineKeyboardButton
                        .builder()
                        .text(TranslationManager.translate("ru_ru", "ru_ru"))
                        .callbackData("test")
                        .build()))
                .build();
    }

    public static InlineKeyboardMarkup getEnKeyboard() {
        return InlineKeyboardMarkup
                .builder()
                .keyboardRow(new InlineKeyboardRow(InlineKeyboardButton
                        .builder()
                        .text(TranslationManager.translate("en_us", "en_us"))
                        .callbackData("test")
                        .build()))
                .build();
    }
}
