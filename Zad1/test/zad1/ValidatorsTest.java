package zad1;

import static org.junit.Assert.*;

import org.junit.*;

public class ValidatorsTest {
	private Validators validator;

	@Before
	public void setUp(){
		validator = new Validators();
	}

	@After
	public void tearDown(){
		validator = null;
	}

	@Test
	public void testUsingSimpleRegex() {
		String  emailAddress = "username@domain.com";
		String  regexPattern = "^(.+)@(\\S+)$";
		assertTrue(validator.patternMatches(emailAddress, regexPattern));
	}

	@Test
	public void testUsingSimpleRegex2() {
		String  emailAddress = "user.1213name@domain.pl";
		String  regexPattern = "^(.+)@(\\S+)$";
		assertTrue(validator.patternMatches(emailAddress, regexPattern));
	}

	@Test
	public void testUsingSimpleRegex3() {
		String  emailAddress = "username";
		String  regexPattern = "^(.+)@(\\S+)$";
		assertFalse(validator.patternMatches(emailAddress, regexPattern));
	}

	@Test
	public void phoneNumberValidator() {
		String phoneNumber = ("202 555 0125");
		assertTrue(validator.phoneNumber(phoneNumber));
	}

	@Test
	public void phoneNumberValidator2() {
		String phoneNumber = ("202-555-0125");
		assertTrue(validator.phoneNumber(phoneNumber));
	}

	@Test
	public void phoneNumberValidator3() {
		String phoneNumber = ("(202) 555-0125");
		assertFalse(validator.phoneNumber(phoneNumber));
	}

	@Test
	public void dateValidator() {
		String date = ("02-03-2023");
		assertTrue(validator.isDateValid(date));
	}

	@Test
	public void dateValidator2() {
		String date = ("13-13-2023");
		assertFalse(validator.isDateValid(date));
	}

	@Test
	public void dateValidator3() {
		String date = ("28-02-2023");
		assertTrue(validator.isDateValid(date));
	}

	@Test
	public void dateValidator4() {
		Boolean valid = false;
		String date = ("29-02-2023");
		assertSame(validator.isDateValid(date), valid);
	}
}
