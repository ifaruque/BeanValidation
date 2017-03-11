package com.javaaround;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.javaaround.model.Employee;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Employee employee = new Employee();
        employee.setActive(false);
        
		 try {
		 	employee.setArrageDate(new Date());
            employee.setBirthday(formatter.parse("2017-04-02"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
		

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Employee>> constraints = validator
			.validate(employee);
		if (constraints.isEmpty()) {
			System.out.print("validation data");
		}else{	
			for (ConstraintViolation<Employee> constraint : constraints) {
				System.out.println(constraint.getPropertyPath() + "  "
				+ constraint.getMessage());
			}
		}
    }
}
