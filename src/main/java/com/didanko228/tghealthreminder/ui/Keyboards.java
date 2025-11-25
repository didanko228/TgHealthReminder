package com.didanko228.tghealthreminder.ui;

import com.didanko228.tghealthreminder.utils.Config;
import com.didanko228.tghealthreminder.utils.MongoDriver;
import com.didanko228.tghealthreminder.utils.TranslationManager;
import org.bson.Document;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Keyboards {
    public static InlineKeyboardMarkup getStartMenu(long user_id) {
        List<InlineKeyboardRow> rows = new ArrayList<>();

        Document user = MongoDriver.getOrCreateUser(user_id);
        String userLanguage = user.getString("language");

        rows.add(new InlineKeyboardRow(
                InlineKeyboardButton.builder()
                        .text(TranslationManager.translate(userLanguage, "button.start.appointments"))
                        .callbackData("appointments")
                        .build()
        ));

        rows.add(new InlineKeyboardRow(
                InlineKeyboardButton.builder()
                        .text(TranslationManager.translate(userLanguage, "button.start.med_reminders"))
                        .callbackData("med_reminders")
                        .build()
        ));

        rows.add(new InlineKeyboardRow(
                InlineKeyboardButton.builder()
                        .text(TranslationManager.translate(userLanguage, "button.start.visits"))
                        .callbackData("visits")
                        .build()
        ));

        rows.add(new InlineKeyboardRow(
                InlineKeyboardButton.builder()
                        .text(TranslationManager.translate(userLanguage, "button.start.settings"))
                        .callbackData("settings")
                        .build()
        ));

        if (Config.ADMINS.contains(user_id)) {
            rows.add(new InlineKeyboardRow(
                    InlineKeyboardButton.builder()
                            .text(TranslationManager.translate(userLanguage, "button.start.admin"))
                            .callbackData("admin")
                            .build()
            ));
        }

        return InlineKeyboardMarkup.builder().keyboard(rows).build();
    }
}
