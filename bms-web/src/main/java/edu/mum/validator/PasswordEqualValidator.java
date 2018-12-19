package edu.mum.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.mum.domain.Credentials;

public class PasswordEqualValidator implements ConstraintValidator<PasswordsEqualConstraint, Object> {


	@Override
	public void initialize(PasswordsEqualConstraint constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Object target, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		Credentials credential = (Credentials) target;
		System.out.println(credential.getVerifyPassword() + " " +  credential.getPassword() );
		return credential.getPassword().equals(credential.getVerifyPassword());
		
	}

}
