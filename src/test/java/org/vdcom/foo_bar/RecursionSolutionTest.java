package org.vdcom.foo_bar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RecursionSolutionTest {

    public static final String ln = System.lineSeparator();

    @Test
    public void testExecuteWithNumberFive()  {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String input = "5" + ln;
        System.setIn(new ByteArrayInputStream(
                input.getBytes()
        ));
        System.setOut(new PrintStream(out));

        RecursionSolution fooBar = new RecursionSolution();
        fooBar.execute();

        String expectedOutput = "Введите целое число n большее 0 : " +
                "1" + ln +
                "2" + ln +
                "Foo" + ln +
                "4" + ln +
                "Bar";

        assertThat(out.toString().trim()).isEqualTo(expectedOutput.trim());

    }

    @Test
    public void testExecuteWithNumberIsNull()  {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String input = "0" + ln;
        System.setIn(new ByteArrayInputStream(
                input.getBytes()
        ));
        System.setOut(new PrintStream(out));

        RecursionSolution fooBar = new RecursionSolution();
        fooBar.execute();

        String expectedOutput = "Введите целое число n большее 0 : " +
                "Число должно быть больше 0.";

        assertThat(out.toString().trim()).isEqualTo(expectedOutput.trim());
    }

    @Test
    public void testExecuteWithNumberIsFifteen()  {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String input = "15" + ln;
        System.setIn(new ByteArrayInputStream(
                input.getBytes()
        ));
        System.setOut(new PrintStream(out));

        RecursionSolution fooBar = new RecursionSolution();
        fooBar.execute();

        String expectedOutput = "Введите целое число n большее 0 : " +
                "1" + ln +
                "2" + ln +
                "Foo" + ln +
                "4" + ln +
                "Bar" + ln +
                "Foo" + ln +
                "7" + ln +
                "8" + ln +
                "Foo" + ln +
                "Bar" + ln +
                "11" + ln +
                "Foo" + ln +
                "13" + ln +
                "14" + ln +
                "FooBar";

        assertThat(out.toString().trim()).isEqualTo(expectedOutput.trim());
    }

    @Test
    public void testExecuteWithNumberIsDouble()  {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String input = "1.5" + ln;
        System.setIn(new ByteArrayInputStream(
                input.getBytes()
        ));
        System.setOut(new PrintStream(out));

        SimpleSolution fooBar = new SimpleSolution();
        fooBar.execute();

        String expectedOutput = "Введите целое число n большее 0 : " +
                "Некорректный ввод. Введите целое число.";

        assertThat(out.toString().trim()).isEqualTo(expectedOutput.trim());
    }
}