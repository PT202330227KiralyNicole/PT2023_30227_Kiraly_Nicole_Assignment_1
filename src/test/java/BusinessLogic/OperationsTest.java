package BusinessLogic;
import DataModels.Polynomial;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {
    private Polynomial polynom1=new Polynomial();
    private Polynomial polynom2 = new Polynomial();
    private Operations op = new Operations();

    private static int nrTestsExec = 0;
    private static int nrTestsSucces = 0;

    public OperationsTest()
    {
        System.out.println("Test before an operation!");
    }

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Test Polynomial calculator");
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Test ended Polynomial calculator");
        System.out.println("NrTestsExec: " + nrTestsExec + ", nrTestsSucces: "+ nrTestsSucces);
    }


    @BeforeEach
    void setUp() {
        System.out.println("A new test has started ");
        nrTestsExec++;
    }

    @AfterEach
    void tearDown() {
        System.out.println("The current test has ended");

    }

    @Test
    void addPolynoms() {
        polynom1 = Polynomial.retPolynom("4x^3+5x^2+3x^0");
        polynom2 = Polynomial.retPolynom("3x^2+5x^1+10x^0");
        assertEquals("+4.0x^3+8.0x^2+5.0x+13.0",op.addPolynoms(polynom1, polynom2).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.addPolynoms(polynom1, polynom2).toString() );

        polynom1 = Polynomial.retPolynom("4x^3+5x^2+3x^0");
        polynom2 =  Polynomial.retPolynom("9x^2+1x^1+1x^0");
        assertEquals("+4.0x^3+14.0x^2+1.0x+4.0",op.addPolynoms(polynom1, polynom2).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.addPolynoms(polynom1, polynom2).toString() );
        nrTestsSucces++;
    }

    @Test
    void subPolynoms() {
        polynom1 = Polynomial.retPolynom("4x^3+5x^2+3x^0");
        polynom2 = Polynomial.retPolynom("3x^2+5x^1+10x^0");
        assertEquals("+4.0x^3+2.0x^2-5.0x-7.0",op.subPolynoms(polynom1, polynom2).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.subPolynoms(polynom1, polynom2).toString() );

        polynom1 = Polynomial.retPolynom("4x^3+5x^2+3x^0");
        polynom2 =  Polynomial.retPolynom("9x^2+1x^1+1x^0");
        assertEquals("+4.0x^3-4.0x^2-1.0x+2.0",op.subPolynoms(polynom1, polynom2).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.subPolynoms(polynom1, polynom2).toString() );
        nrTestsSucces++;
    }

    @Test
    void mulPolynoms() {
        polynom1 = Polynomial.retPolynom("4x^3+5x^2+3x^0");
        polynom2 = Polynomial.retPolynom("3x^2+5x^1+1x^0");
        assertEquals("+12.0x^5+35.0x^4+29.0x^3+14.0x^2+15.0x+3.0",op.mulPolynoms(polynom1, polynom2).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.mulPolynoms(polynom1, polynom2).toString() );

        polynom1 = Polynomial.retPolynom("4x^3+5x^2+3x^0");
        polynom2 =  Polynomial.retPolynom("9x^2+1x^1+1x^0");
        assertEquals("+36.0x^5+49.0x^4+9.0x^3+32.0x^2+3.0x+3.0",op.mulPolynoms(polynom1, polynom2).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.mulPolynoms(polynom1, polynom2).toString() );

        nrTestsSucces++;
    }

    @Test
    void divPolynoms() {
        polynom1 = Polynomial.retPolynom("4x^3+1x^2");
        polynom2 = Polynomial.retPolynom("1x^2");
        assertEquals("Quotient: +4.0x+1.0     Remainder: ",op.divPolynoms(polynom1, polynom2).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.divPolynoms(polynom1, polynom2).toString() );

        nrTestsSucces++;
    }

    @Test
    void derivPolynom() {
        polynom1 = Polynomial.retPolynom("4x^3+5x^2+3x^0");
        assertEquals("+12.0x^2+10.0x",op.derivPolynom(polynom1).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.derivPolynom(polynom1).toString() );

        polynom1 = Polynomial.retPolynom("4x^8+5x^9+3x^0");
        assertEquals("+45.0x^8+32.0x^7",op.derivPolynom(polynom1).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.derivPolynom(polynom1).toString() );

        nrTestsSucces++;
    }

    @Test
    void integralPolynom() {
        polynom1 = Polynomial.retPolynom("4x^3+5x^2+3x^0");
        assertEquals("+x^4+1.6666666666666667x^3+3.0x",op.integralPolynom(polynom1).toString());
        assertNotEquals("-4x^3+7x^2+5x+13",op.integralPolynom(polynom1).toString() );

        polynom1 = Polynomial.retPolynom("10x^9");
        assertEquals("+x^10",op.integralPolynom(polynom1).toString());
        assertNotEquals("-4x^3+7x^2+5x^1+13",op.integralPolynom(polynom1).toString() );

        nrTestsSucces++;
    }
}