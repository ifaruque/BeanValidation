package com.javaaround;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import com.javaaround.model.Employee;
import com.javaaround.model.EmployeeDetails;
import com.javaaround.model.Address;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import java.lang.reflect.Method;
import javax.validation.executable.ExecutableValidator;
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
        employee.setAge(100);
	 	employee.setEmail("shamim.ict0754gmail.com");

	 	Address add1 = new Address();
	 	add1.setStreet("");
	 	add1.setCity("Tangail");
	 	add1.setPostcode("1900");

	 	Address add2 = new Address();
	 	add1.setStreet("1220");
	 	add1.setCity("Tangail");
	 	add1.setPostcode(null);
	 	List<Address> addressList = new ArrayList<Address>();
	 	addressList.add(add1);
	 	addressList.add(add2);
	 	employee.setAddressList(addressList);

		/*ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();*/
		Validator validator = Validation.byDefaultProvider()
		.configure()
		.messageInterpolator(
				new ResourceBundleMessageInterpolator(
						new PlatformResourceBundleLocator( "messages" )
				)
		)
		.buildValidatorFactory()
		.getValidator();

		Set<ConstraintViolation<Employee>> constraints = validator
			.validate(employee);
		if (constraints.isEmpty()) {
			System.out.print("valid data");
		}else{	
			for (ConstraintViolation<Employee> constraint : constraints) {
				System.out.println(constraint.getMessageTemplate() + constraint.getPropertyPath() + "  "
				+ constraint.getMessage());
			}
		}
		
		
    }
}
