package Labs.Laba1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParserTest {
    Parser parser;

    @BeforeEach
    void initialize() {
        String[] strings = {"1.txt", "2.txt", "3.txt", "4.txt"};
        parser = new Parser(strings);
    }

    @Test
    void giveMeAllThreads() {
        Parser parser = mock(Parser.class);
        int result = 0;
        try {
            when(parser.giveMeAllThreads()).thenReturn(440);
            result = parser.giveMeAllThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
        Assertions.assertEquals(440, result);
    }

    @Test
    void giveMeAllThreads2() {
        int result = 0;
        try {
            result = parser.giveMeAllThreads();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Assertions.assertTrue(false);
        }
        Assertions.assertEquals(440, result);
    }
}