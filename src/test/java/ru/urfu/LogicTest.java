package ru.urfu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest
{

    /**
     * Тестируем корректную обработку ботом сообщения
     */
    @Test
    void createMessage()
    {
        final Logic logic = new Logic();
        final String userMessage = "Привет, бот!";
        assertEquals(logic.createMessage(userMessage), "Ваше сообщение: 'Привет, бот!'");
    }
}