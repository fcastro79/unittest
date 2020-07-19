package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturaCalculatorTest{

    public TemperaturaCalculator temperaturaCalculator;

    @BeforeEach
    public void setUp(){
        temperaturaCalculator= new TemperaturaCalculator();
        System.out.println("@BeforeEach => setUp()");
    }
    @AfterEach
    public void tearDown(){
        temperaturaCalculator=null;
        System.out.println("@AfterEach => tearDown()");

    }

    @ParameterizedTest(name = "{index}=> a={0},farenheit={1}")
    @MethodSource("addProviderData")
    public void addParameterizedTest(float a, float farenheit){
        assertEquals(farenheit,temperaturaCalculator.celciusToFarenheit(a));
    }

    private static Stream<Arguments> addProviderData(){
        return Stream.of(
                Arguments.of(0,32),
                Arguments.of(100,212),
                Arguments.of(-100,-148),
                Arguments.of(-50,-58),
                Arguments.of(6,42.8)
        );
    }

}