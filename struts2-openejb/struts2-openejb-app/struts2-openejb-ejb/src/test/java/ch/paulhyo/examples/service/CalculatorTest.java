package ch.paulhyo.examples.service;

import static org.junit.Assert.assertEquals;

import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.apache.openejb.api.LocalClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@LocalClient
public class CalculatorTest {

	@EJB
	private CalculatorService calculator;

	private EJBContainer ejbContainer;

	@Before
	public void setUp() throws NamingException {
		final Properties p = new Properties();
		p.setProperty("java.naming.factory.initial",
				"org.apache.openejb.client.LocalInitialContextFactory");
		p.setProperty("openejb.validation.output.level", "verbose");
		// p.setProperty("openejb.deployments.classpath.include",".*paulhyo.*");
		ejbContainer = EJBContainer.createEJBContainer(p);
		// Injection des ressources.
		ejbContainer.getContext().bind("inject", this);
	}

	@After
	public void tearDown() {
		ejbContainer.close();
	}

	/*
	 * @BeforeClass public static void startTheContainer() { ejbContainer =
	 * EJBContainer.createEJBContainer(); }
	 * 
	 * @AfterClass public static void stopTheContainer() { if (ejbContainer !=
	 * null) { ejbContainer.close(); } }
	 */

	/**
	 * Test Add method
	 */
	@Test
	public void testAdd() {
		assertEquals(10, calculator.add(4, 6));
	}

	/**
	 * Test Subtract method
	 */
	@Test
	public void testSubtract() {
		assertEquals(-2, calculator.subtract(4, 6));
	}

	/**
	 * Test Multiply method
	 */
	@Test
	public void testMultiply() {
		assertEquals(24, calculator.multiply(4, 6));
	}

	/**
	 * Test Divide method
	 */
	@Test
	public void testDivide() {
		assertEquals(2, calculator.divide(12, 6));
	}

	/**
	 * Test Remainder method
	 */
	@Test
	public void testRemainder() {
		assertEquals(4, calculator.remainder(46, 6));
	}

}
