package ru.urfu;

/**
 * Добавляет какую-то логику к ответам бота пользователю
 */
public class Logic
{

    /**
     * Формирует сообщение в ответ пользователю
     *
     * @param message Входящее сообщение от пользователя
     * @return Новое обоработанное сообщение
     */
    public String createMessage(String message)
    {
        return String.format("Ваше сообщение: '%s'", message);
    }
}
