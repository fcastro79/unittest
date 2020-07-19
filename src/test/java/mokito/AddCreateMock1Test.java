package mokito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AddCreateMock1Test {

    private Add add;
    private ValidNumber validNumber;

    @BeforeEach
    public void setUp(){
        //1 - Mockear las dependencias
        validNumber = Mockito.mock(ValidNumber.class);
        add= new Add(validNumber);
    }

    @Test
    public void addTest(){

        //2 - Ejecutar el metodo de la clase bajo Test
        add.add(3,2);
        Mockito.verify(validNumber).checkNumber(3);

    }
}
