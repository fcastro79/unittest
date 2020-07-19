package mokito;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidNumberTest {

    private ValidNumber validNumber;

    @BeforeEach
    public void setUp(){

        validNumber= new ValidNumber();
    }

    @AfterEach
    public void tearDown(){
        validNumber= null;
    }

    @Test
    public void checkTest(){
        assertEquals(true,validNumber.checkNumber(5));
    }

    @Test
    public void checkNegativeTest(){

        assertEquals(false,validNumber.checkNumber(-5));
    }

    @Test
    public void checkStringTest(){

        assertEquals(false,validNumber.checkNumber("5"));
    }
}