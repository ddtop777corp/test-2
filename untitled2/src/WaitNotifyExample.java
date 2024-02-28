public class WaitNotifyExample {
    public static void main(String[] args) {
        Message message = new Message();

        Thread senderThread = new Thread(new Sender(message));
        Thread receiverThread = new Thread(new Receiver(message));

        senderThread.start();
        receiverThread.start();
    }
}

class Message {
    private String content;
    private boolean isMessageSent = false;

    public synchronized void send(String message) {
        while (isMessageSent) {
            try {
                // Ожидание, если сообщение уже отправлено
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.content = message;
        isMessageSent = true;
        notify(); // Уведомление получателя
    }

    public synchronized String receive() {
        while (!isMessageSent) {
            try {
                // Ожидание, если сообщение еще не отправлено
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        isMessageSent = false;
        notify(); // Уведомление отправителя

        return content;
    }
}

class Sender implements Runnable {
    private Message message;

    public Sender(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"Привет", "Как дела?", "Пока"};

        for (String msg : messages) {
            message.send(msg);
            System.out.println("Отправлено сообщение: " + msg);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Receiver implements Runnable {
    private Message message;

    public Receiver(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            String receivedMessage = message.receive();
            System.out.println("Получено сообщение: " + receivedMessage);
        }
    }
}
