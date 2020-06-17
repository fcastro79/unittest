package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;
    @BeforeEach
    public void setUp(){
        calculator= new Calculator();
        System.out.println("@BeforeEach => setUp()");
    }
    @AfterEach
    public void tearDown(){
        calculator=null;
        System.out.println("@AfterEach => tearDown()");

    }

    @Test
    public void calculatorNotNullTest(){
        calculator = new Calculator();
        assertNotNull(calculator,"calculator debe ser no null");
        System.out.println("@Test => calculatorNotNullTest()");
    }

    @Test
    public void calculatorNullATest(){
        assertNull(calculatorNull);
        System.out.println("@Test => calculatorNullTest()");
    }

    @Test
    public void addAssertTest(){
        int resultadoEsperado = 30;
        int resultadoActual;
        resultadoActual=calculator.add(10,20);
        assertEquals(resultadoEsperado,resultadoActual);
        System.out.println("@Test => addAssertTest()");
    }

    @Test
    public void addTest(){
        assertEquals(30,calculator.add(10,20));
        System.out.println("@Test => addTest()");
    }

    @Test
    public void assertTypesTest(){
        assertTrue(1==1);
    }
}