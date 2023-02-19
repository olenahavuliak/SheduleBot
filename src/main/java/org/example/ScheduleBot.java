package org.example;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ScheduleBot extends TelegramLongPollingBot {

  public ScheduleBot(DefaultBotOptions options) {
    super(options);
  }
  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      String messageText = update.getMessage().getText();
      long chatId = update.getMessage().getChatId();
      SendMessage message = new SendMessage();
      message.setChatId(String.valueOf(chatId));

      // Перевірка текстового повідомлення
      if (messageText.equalsIgnoreCase("/start")) {

        message.setText("Hello Katia :)\n"
            + "Choose the day of week:\n"
            + "/monday\n"
            + "/tuesday\n"
            + "/wednesday\n"
            + "/thursday\n"
            + "/friday\n");
      } else if (messageText.equalsIgnoreCase("/monday")) {
        // Відправка розкладу на понеділок
        message.setText("Розклад на понеділок:\n" +
            "1. [08:30] Теорія та методика журналістської творчості (Лаб)\n" +
            "2. [10:10] Організація роботи в ЗМІ (Практ)\n" +
            "3. [11:50] Іноземна мова (Практ)\n" +
            "4. [13:30] Іноземна мова (Практ)\n");
      } else if (messageText.equalsIgnoreCase("/tuesday")) {
        // Відправка розкладу на вівторок
        message.setText("Розклад на вівторок:\n" +
            "1. [08:30] Теорія комунікації \n" +
            "2. [10:10] Література ТІУЛ (Лекц) \n" +
            "3. [11:50] Організація роботи в ЗМІ (Лекц)\n");
      } else if (messageText.equalsIgnoreCase("/wednesday")) {
        // Відправка розкладу на середу
        message.setText("Розклад на середу:\n" +
            "4. [13:30] Література ТІУЛ (Практ)\n");
      } else if (messageText.equalsIgnoreCase("/thursday")) {
        // Відправка розкладу на середу
        message.setText("Розклад на четвер:\n" +
            "1. [08:30] Теорія комунікації (Практ) \n" +
            "2. [10:10] Практична стилістика укр. мови (Практ)\n");
      } else if (messageText.equalsIgnoreCase("/friday")) {
        // Відправка розкладу на середу
        message.setText("Розклад на п'ятницю:\n" +
            "1. [09:30] Фізкультура \n" +
            "3. [11:50] Теорія і практика реклами (Лекц) \n" +
            "4. [13:30] Теорія та методика журналістики (Лекц) \n" +
            "5. [15:05] Практична стилістика укр.мови (Лекц)\n");
      } else {
        // Якщо повідомлення не співпадає з жодним із попередніх
        message.setText("Невідома команда, спробуйте ще раз.");
      }

      try {
        execute(message);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public String getBotUsername() {
    return "Schedule_11c_bot";
  }

  @Override
  public String getBotToken() {
    return "6159299094:AAGQnEDluNS3aWVOY_MGCh05vBppesTySX4";
  }
}

