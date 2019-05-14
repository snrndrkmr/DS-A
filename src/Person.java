import java.io.*;
import java.util.*;
public class Person {
    private int age;	
  
	public Person(int initialAge) {
  		// Add some more code to run some checks on initialAge
          this.age =initialAge;
          if(initialAge<0){
              System.out.println("Age is not valid, setting age to 0.");
              this.age=0;
          }
	}

	public void amIOld() {
  		// Write code determining if this person's age is old and print the correct statement:
          String statement="";
          if(age<13){
             statement="you are young"; 
          }
          else if(age>=13 && age<18)
          {
              statement="you are teenager"; 
          }
          else{
              statement="you are old"; 
          }
        System.out.println(statement);
	}

	public void yearPasses() {
  		// Increment this person's age.
		age = age+3;
		amIOld();
          
	}
	public static void main(String[] args) {
		Person p = new Person(16);
		p.amIOld();
		p.yearPasses();
		System.out.println();
	}
}
