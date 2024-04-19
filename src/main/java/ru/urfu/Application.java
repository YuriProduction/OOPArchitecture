package ru.urfu;

import java.util.List;

/**
 * Класс для запуска приложения
 */
public class Application
{

    public static void main(String[] args)
    {
        String telegramBotName = System.getenv("telegram_botName");
        String telegramToken = System.getenv("telegram_token");
        final String discordToken = System.getenv("discord_token");
        List<IBot> bots = List.of(
                new TelegramBot(telegramBotName, telegramToken),
                new DiscordBot(discordToken)
        );
        for (IBot bot : bots)
            bot.start();

    }

}
