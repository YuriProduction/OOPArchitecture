package ru.urfu;

/**
 * Класс для запуска приложения
 */
public class Application
{

    public static void main(String[] args)
    {
        Logic logic = new Logic();
        String telegramBotName = System.getenv("telegram_botName");
        String telegramToken = System.getenv("telegram_token");
        new TelegramBot(telegramBotName, telegramToken, logic)
                .start();

        String discordToken = System.getenv("discord_token");
        new DiscordBot(discordToken, logic)
                .start();

    }

}
