package org.vdcom.foo_bar;

import java.util.Scanner;

/**
 * Решение в лоб
 */
public class SimpleSolution {

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число n большее 0 : ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                for (int i = 1; i <= n; i++) {
                    String result = (i % 3 == 0 ? "Foo" : "") + (i % 5 == 0 ? "Bar" : "");
                    System.out.println(result.isEmpty() ? i : result);
                }
            } else {
                System.out.println("Число должно быть больше 0.");
            }
        } else {
            System.out.println("Некорректный ввод. Введите целое число.");
        }
    }

}

