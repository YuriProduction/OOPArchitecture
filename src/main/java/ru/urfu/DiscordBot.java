package ru.urfu;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

/**
 * Дискорд бот
 */
public class DiscordBot implements IBot {

    private final String token;

    private GatewayDiscordClient client;

    public DiscordBot(String token) {
        this.token = token;
    }

    public void start() {
        client = DiscordClient.create(token).login().block();
        if (client == null) {
            throw new RuntimeException("Ошибка при входе в Discord");
        }
        client.on(MessageCreateEvent.class)
                .doOnError(throwable -> {
                    throw new RuntimeException("Ошибка при работе Discord бота", throwable);
                })
                .subscribe(event -> {
                    Message eventMessage = event.getMessage();
                    if (eventMessage.getAuthor().map(user -> !user.isBot()).orElse(false)) {
                        String chanelID = eventMessage.getChannelId().asString();
                        String messageFromUser = eventMessage.getContent();
                        reply(chanelID,messageFromUser,ConstantBotMessagesKeeper.necessaryReplyMessage);
                    }
                });
        System.out.println("Discord бот запущен");
        client.onDisconnect().block();
    }

    @Override
    public void reply(String chatID, String message, String baseMessage)
    {
        this.sendMessage(chatID, message, baseMessage);
    }

    /**
     * Отправить сообщение
     * @param chatId идентификатор чата
     * @param message текст сообщения
     */
    public void sendMessage(String chatId, String message, String baseMessage) {
        Snowflake channelId = Snowflake.of(chatId);
        MessageChannel channel = client.getChannelById(channelId).ofType(MessageChannel.class).block();
        if (channel != null) {
            channel.createMessage(baseMessage + "'" + message + "'" + ".").block();
        } else {
            System.err.println("Канал не найден");
        }
    }
}
