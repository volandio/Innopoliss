package September2017.Date_27_09_17.MockExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DelitelTest {
    @Test
    void delit() {
        Kvadrator kvadrator = mock(Kvadrator.class);
        when(kvadrator.kvadrat(2)).thenReturn(4d);
        Delitel.kvadrator = kvadrator;
        double result = Delitel.delit(2);
        Assertions.assertEquals((double) 4/5, result);
    }

}