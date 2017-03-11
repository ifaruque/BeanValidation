package com.javaaround.model;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;


import static org.junit.Assert.assertEquals;

public class EmployeeTest {

private static Validator validator;

   @BeforeClass
   public static void setUp() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();
   }

   @Test
   @Ignore
   public void firstNameIsNull() {
      Employee employee = new Employee();
      employee.setId(122);
      //employee.setFirstName("Md.Shamim");
      employee.setSalary(40000.00);

      Set<ConstraintViolation<Employee>> constraintViolations =
      validator.validate( employee );

      assertEquals( 1, constraintViolations.size() );
      assertEquals(
         "firstName may not be null",
         constraintViolations.iterator().next().getMessage()
      );
   }

   @Test
   @Ignore
   public void firstNameSalaryAboveRange() {
      Employee employee = new Employee();
      employee.setId(122);
      employee.setFirstName("Md.Shamim");
      employee.setSalary(600000.00);


      Set<ConstraintViolation<Employee>> constraintViolations =
      validator.validate( employee );

      assertEquals( 1, constraintViolations.size() );
      assertEquals(
         "salary  must be less than or equal to 50000.00",
         constraintViolations.iterator().next().getMessage()
      );
   }
   

   @Test
   @Ignore
   public void employeeFirstNameTooShort() {
      Employee employee = new Employee();
      employee.setId(122);
      employee.setFirstName("M");
      employee.setSalary(400000.00);

      Set<ConstraintViolation<Employee>> constraintViolations =
      validator.validate( employee );

      assertEquals(1, constraintViolations.size() );
      assertEquals(
         "size must be between 5 and 25",
         constraintViolations.iterator().next().getMessage()
      );
   }

   @Test
   @Ignore
   public void employeeFirstNameTooBig() {
      Employee employee = new Employee();
      employee.setId(122);
      employee.setFirstName("Md.Shamimmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
      employee.setSalary(400000.00);

      Set<ConstraintViolation<Employee>> constraintViolations =
      validator.validate( employee );

      assertEquals( 1, constraintViolations.size() );
      assertEquals(
         "size must be between 5 and 25",
         constraintViolations.iterator().next().getMessage()
      );
   }
}