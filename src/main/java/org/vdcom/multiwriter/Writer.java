package org.vdcom.multiwriter;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Writer {

    private final static Logger LOG = LoggerFactory.getLogger(Writer.class);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        if (number < 0 || number % 2 != 0) {
            System.out.println("Число должно быть больше 0 и кратно 2");
            return;
        }

        try {
            File file = new File("out.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("0");
            fileWriter.close();

            Runnable incrementTask1 = new Task(file, number);
            Runnable incrementTask2 = new Task(file, number);

            Thread thread1 = new Thread(incrementTask1, "Good Thread");
            Thread thread2 = new Thread(incrementTask2, "Mad Thread");

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println("Завершено. Результат записан в файл out.txt.");
        } catch (IOException | InterruptedException e) {
            LOG.error(e.getMessage());
        }
    }

    static class Task implements Runnable {
        public final File file;
        public final int number;

        Task(File file, int number) {
            this.file = file;
            this.number = number;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (file) {
                        int oldValue = readValue();
                        if (oldValue >= number) {
                            break;
                        }
                        int newValue = oldValue + 1;
                        System.out.println("Старое значение: " + oldValue + ", Новое значение: " + newValue +
                                ", Поток: " + Thread.currentThread().getName());
                        writeValue(newValue);
                        file.notify();
                        if (newValue >= number - 1) {
                            break;
                        }
                        file.wait();
                    }
                }
            } catch (IOException | InterruptedException e) {
                LOG.error(e.getMessage());
            }
        }

        private int readValue() throws IOException {
           return Integer.parseInt(Util.readFile(file));
        }

        private void writeValue(int value) throws IOException {
            Util.writeFile(file, Integer.toString(value));
        }
    }
}
