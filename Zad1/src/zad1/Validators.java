package zad1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Validators {
	public boolean patternMatches(String emailAddress, String regexPattern) {
		return Pattern.compile(regexPattern)
				.matcher(emailAddress)
				.matches();
	}
	public boolean phoneNumber(String phoneNumber) {
		return Pattern.compile("^(\\d{3}[- .]?){2}\\d{4}$")
				.matcher(phoneNumber)
				.matches();
	}

	public boolean isDateValid(String date){
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

}
