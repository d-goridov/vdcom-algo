package org.vdcom.foo_bar;

import java.util.Scanner;

/**
 * Рекурсивное решение
 */
public class RecursionSolution {

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число n большее 0 : ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                printFooBar(1, n);
            } else {
                System.out.println("Число должно быть больше 0.");
            }
        } else {
            System.out.println("Некорректный ввод. Введите целое число.");
        }
    }

    private void printFooBar(int current, int n) {
        if (current > n) {
            return;
        }

        if (current % 3 == 0) {
            System.out.print("Foo");
        }
        if (current % 5 == 0) {
            System.out.print("Bar");
        }
        if (current % 3 != 0 && current % 5 != 0) {
            System.out.print(current);
        }

        System.out.println();
        printFooBar(current + 1, n);
    }
}
