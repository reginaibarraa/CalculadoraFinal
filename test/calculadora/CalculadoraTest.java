
package calculadora;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of revisaParentesis method, of class Calculadora.
     */
    @Test
    public void testRevisaParentesis() {
        System.out.println("revisaParentesis");
        String operacion = "(3+4)*5-(8+7)-(7/6)";
        boolean expResult = true;
        boolean result = Calculadora.revisaParentesis(operacion);
        assertEquals(expResult, result);

    }

    /**
     * Test of noParentesisVacios method, of class Calculadora.
     */
    @Test
    public void testNoParentesisVacios() {
        System.out.println("noParentesisVacios");
        String operacion = "()";
        boolean expResult = false;
        boolean result = Calculadora.noParentesisVacios(operacion);
        assertEquals(expResult, result);

    }

    /**
     * Test of noOperadorInicio method, of class Calculadora.
     */
    @Test
    public void testNoOperadorInicio() {
        System.out.println("noOperadorInicio");
        String operacion = "*8-7";
        boolean expResult = false;
        boolean result = Calculadora.noOperadorInicio(operacion);
        assertEquals(expResult, result);

    }

    /**
     * Test of noOperadorFinal method, of class Calculadora.
     */
    @Test
    public void testNoOperadorFinal() {
        System.out.println("noOperadorFinal");
        String operacion = "9+";
        boolean expResult = false;
        boolean result = Calculadora.noOperadorFinal(operacion);
        assertEquals(expResult, result);

    }

    /**
     * Test of noOperadoresJuntos method, of class Calculadora.
     */
    @Test
    public void testNoOperadoresJuntos() {
        System.out.println("noOperadoresJuntos");
        String operacion = "9*-8";
        boolean expResult = true;
        boolean result = Calculadora.noOperadoresJuntos(operacion);
        assertEquals(expResult, result);

    }

    /**
     * Test of revisaPuntosDecimales method, of class Calculadora.
     */
    @Test
    public void testRevisaPuntosDecimales() {
        System.out.println("revisaPuntosDecimales");
        String operacion = "9..9.98";
        boolean expResult = false;
        boolean result = Calculadora.revisaPuntosDecimales(operacion);
        assertEquals(expResult, result);

    }

    /**
     * Test of revisaSintaxis method, of class Calculadora.
     */
    @Test
    public void testRevisaSintaxis() {
        System.out.println("revisaSintaxis");
        String operacion = "(1*2)-((7-2)+8)";
        boolean expResult = true;
        boolean result = Calculadora.revisaSintaxis(operacion);
        assertEquals(expResult, result);

    }

    /**
     * Test of jerarquia method, of class Calculadora.
     */
    @Test
    public void testJerarquia() {
        System.out.println("jerarquia");
        char operador = '-';
        int expResult = 1;
        int result = Calculadora.jerarquia(operador);
        assertEquals(expResult, result);

    }

    /**
     * Test of funcionDelOperador method, of class Calculadora.
     */
    @Test
    public void testFuncionDelOperador() {
        System.out.println("funcionDelOperador");
        double num1 = 1.0;
        double num2 = 2.0;
        String operador = "-";
        double expResult = -1.0;
        double result = Calculadora.funcionDelOperador(num1, num2, operador);
        assertEquals(expResult, result, 0);

    }

    /**
     * Test of esOperador method, of class Calculadora.
     */
    @Test
    public void testEsOperador() {
        System.out.println("esOperador");
        char car = '-';
        boolean expResult = true;
        boolean result = Calculadora.esOperador(car);
        assertEquals(expResult, result);

    }

    /**
     * Test of esOperador2 method, of class Calculadora.
     */
    @Test
    public void testEsOperador2() {
        System.out.println("esOperador2");
        String car = "7";
        boolean expResult = false;
        boolean result = Calculadora.esOperador2(car);
        assertEquals(expResult, result);

    }




    
}
