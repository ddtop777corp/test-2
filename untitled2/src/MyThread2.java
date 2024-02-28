public class MyThread2 extends Thread {
    public void run() {
        try {
            // Выполняем какую-то работу
            while (!Thread.interrupted()) {
                // Работа потока
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2();
        myThread2.start(); // Запускаем поток

        // Через некоторое время прерываем поток
        try {
            Thread.sleep(2000);
            myThread2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

