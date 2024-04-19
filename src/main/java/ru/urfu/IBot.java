package ru.urfu;

/**
 * Интерфейс произвольного бота
 */
public interface IBot
{
    /**
     * Запускает бота
     */
    void start();

    /** Отвтеить пользователю
     * @param chatID  - чат, в который бот отправляет сообщение
     * @param message - сообщение, которое отправляет бот
     * @param baseMessage - константная строка, которая должна содержаться во всех ботах
     */
    void reply(String chatID, String message, String baseMessage);
}
