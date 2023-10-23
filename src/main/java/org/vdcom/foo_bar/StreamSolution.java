package org.vdcom.foo_bar;

import java.util.Scanner;
import java.util.stream.IntStream;


/**
 * Stream решение
 */
public class StreamSolution {
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число n большее 0 : ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            IntStream.rangeClosed(1, n)
                    .mapToObj(i -> (i % 3 == 0 ? "Foo" : "") +
                            (i % 5 == 0 ? "Bar" : "") + (i % 3 != 0 && i % 5 != 0 ? i : ""))
                    .forEach(System.out::println);
        }
    }
}
