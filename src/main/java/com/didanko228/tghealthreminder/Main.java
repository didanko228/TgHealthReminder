package com.didanko228.tghealthreminder;

import com.didanko228.tghealthreminder.utils.Config;
import com.didanko228.tghealthreminder.utils.Logger;
import com.didanko228.tghealthreminder.utils.TranslationManager;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

public class Main {
    public static String PROJECT_NAME = "TgHealthReminder";
    public static String PROJECT_ID = PROJECT_NAME.toLowerCase();

    static void main() {
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(Config.BOT_TOKEN, new TgHealthReminder(Config.BOT_TOKEN));
            TranslationManager.loadTranslations();

            Logger.info("Started!");

            Thread.currentThread().join();
        } catch (Exception e) {
            Logger.error("Error for start bot", e);
        }
    }
}
