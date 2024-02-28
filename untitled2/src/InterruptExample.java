public class InterruptExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new MyRunnable());

        // Запускаем поток
        myThread.start();

        try {
            // Ждем 2 секунды
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Прерываем поток
        myThread.interrupt();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Поток работает...");
                try {
                    // Задержка на 500 миллисекунд
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // Обработка исключения прерывания
                    System.out.println("Поток прерван!");
                    // Выход из потока
                    return;
                }
            }
        }
    }
}
