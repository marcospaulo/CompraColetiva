package testes.validadores;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.compracoletiva.server.validadores.EmailValidator;
import com.vaadin.data.Validator.InvalidValueException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class EmailValidatorTest {

	@Autowired
	EmailValidator emailValidator;
	private static String email = "marcospaulo.s.d@gmail.com";
	private static String falsoEmail = "marcospaulo.s.d@ lol";

	@Test
	public void testValidate() {
		assertTrue(emailValidator.isValid(email));
		assertFalse(emailValidator.isValid(falsoEmail));
	}
	
	@Test
	@ExpectedException(InvalidValueException.class)
	public void testExceptionValidatte(){
		emailValidator.validate(falsoEmail);
	}

}
