package mokito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;

class AddTest {
    @InjectMocks
    private Add add;
    @Mock
    private ValidNumber validNumber;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addTest(){
        when(validNumber.checkNumber(3)).thenReturn(false);
        boolean checkNumber = validNumber.checkNumber(3);
        assertEquals(false,checkNumber);

        when(validNumber.checkNumber("A")).thenReturn(true);
        checkNumber = validNumber.checkNumber("A");
        assertEquals(true,checkNumber);
    }


}