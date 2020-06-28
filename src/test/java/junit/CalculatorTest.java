package junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private Calculator calculatorNull;
    private static Calculator calculatorStatic;

    @BeforeAll
    public static void beforeAllTests(){
        calculatorStatic= new Calculator();
    }

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
    @AfterAll
    public static void afterAllTests(){
        calculatorStatic= null;
    }
    @Test
    public void calculatorStaticNotNullTest(){
        assertNotNull(calculatorStatic,"calculator debe ser no null");
        System.out.println("@Test => calculatorNotNullTest()");
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
        assertNull(calculatorNull);
        assertNotNull(calculator);
        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();
        Calculator calculator3 = calculator1;
        assertSame(calculator1,calculator3);
        //assertSame(calculator1,calculator2);
        assertNotSame(calculator1,calculator2);
        assertEquals("Lo que quiero","Lo que quiero");
        assertEquals(1,1.4,0.5);
        //assertEquals(1,1.6,0.5);
    }
    @Test
    public void add_ValidInput_ValidExpected_Test(){
        assertEquals(11,calculator.add(7,4));
    }

    @Test
    public void subtract_ValidInput_ValidExpected_Test(){
        assertEquals(3,calculator.subtract(7,4));
    }

    @Test
    public void subtract_ValidInput_ValidNegativeResultExpected_Test(){
        assertEquals(-10,calculator.subtract(10,20));
    }

    @Test
    public void divide_ValidInput_ValidResultExpected_Test(){
        assertEquals(2,calculator.divide(10,5));
    }

    @Test
    public void divide_InvalidValidInput_Test(){
        fail("Fallo no soportado");
        assertEquals(2,calculator.divide(10,0));

    }

    @Test
    public void divide_InvalidValidInput_ExpectException_Test(){
        assertThrows(ArithmeticException.class,()-> calculator.divideByZero(2,0),"No se puede dividir por cero");

    }

    @Disabled("Until until bug 23 be resolved")
    @Test
    public void divide_invalidInput_Test(){
        assertEquals(2,calculator.divide(5,0));
    }

    @Test
    @DisplayName("Probando un nombre")
    public void addNombreTest(){
        assertEquals(30,calculator.add(10,20));
        System.out.println("@Test => addTest()");
    }
    @Test
    public void add_Assert_All_test(){
        assertAll(
                ()-> assertEquals(30,calculator.add(11,20)),
                ()-> assertEquals(20,calculator.add(10,10)),
                ()-> assertEquals(2,calculator.add(1,1))
        );
    }

    @Nested
    class AddTest{
        @Test
        public void add_Positive_Test(){
            assertEquals(30,calculator.add(15,15));

        }
        @Test
        public void add_Negative_Test(){
            assertEquals(-30,calculator.add(-15,-15));

        }
        @Test
        public void add_Zero_Test(){
            assertEquals(0,calculator.add(0,0));

        }
    }
    @ParameterizedTest(name = "{index}=> a={0},b={1},sum={2}")
    @MethodSource("addProviderData")
    public void addParameterizedTest(int a, int b, int sum){
        assertEquals(sum,calculator.add(a,b));
    }

    private static Stream<Arguments> addProviderData(){
        return Stream.of(
                Arguments.of(6,2,8),
                Arguments.of(-6,-2,-8),
                Arguments.of(6,-2,4),
                Arguments.of(-6,2,-4),
                Arguments.of(6,0,6)
        );
    }

}