package Laba1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ParserTest {
    Parser parser2;

    @BeforeEach
    void initialize() {
        String[] strings = {"1.txt", "2.txt", "3.txt", "4.txt"};
        parser2 = new Parser(strings);
    }

    @Test
    void giveMeAllThreads() throws InterruptedException {
        Parser parser = mock(Parser.class);
        when(parser.giveMeAllThreads()).thenReturn(440);
        int result = parser.giveMeAllThreads();
        Assertions.assertEquals(440, result);
    }

    @Test
    void giveMeAllThreads2() throws InterruptedException {
        int result = parser2.giveMeAllThreads();
        Assertions.assertEquals(440, result);
    }
}