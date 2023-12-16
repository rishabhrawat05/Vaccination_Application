package com.example.Vaccination;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */
    	Scanner s=new Scanner(System.in);
    	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	System.out.println("Welcome to the Vaccine Application");
    	while(true) {
    	System.out.println("Please choose your vaccine preference");
    	System.out.println("1) Covid \n 2) Polio \n 3) Typhoid");
    	int type=s.nextInt();
    	
    	System.out.println("Whom Do You want to vaccinate");
    	System.out.println("1) Father \n 2) Mother \n 3) Self \n 4) Spouse \n 5) Exit");
    	int type2=s.nextInt();
    	
    	String user="";
    	if(type2 >5 || type2<1) {
    		return;
    	}
    	else {
    		if(type==1 && type2==1) {
    			user="fatherCovid";
    			
    		}
    		else if(type==1 && type2==2) {
    			user="motherCovid";
    		}
    		else if(type==1 && type2==3) {
    			user="selfCovid";
    		}
    		else if(type==1 && type2==4) {
    			user="spouseCovid";
    		}
    		else if(type==1 && type2==5) {
    			return;
    		}
    		else if(type==2 && type2==1) {
    			user="fatherPolio";
    		}
    		else if(type==2 && type2==2) {
    			user="motherPolio";
    		}
    		else if(type==2 && type2==3) {
    			user="selfPolio";
    		}
    		else if(type==2 && type2==4) {
    			user="spousePolio";
    		}
    		else if(type==2 && type2==5) {
    			return;
    		}
    		else if(type==3 && type2==1) {
    			user="fatherTyphoid";
    		}
    		else if(type==3 && type2==2) {
    			user="motherTyphoid";
    		}
    		else if(type==3 && type2==3) {
    			user="selfTyphoid";
    		}
    		else if(type==3 && type2==4) {
    			user="spouseTyphoid";
    		}
    		else if(type==3 && type2==5) {
    			return;
    		}
    		}
    	
    	User us=(User) context.getBean(user);
    	if(us.IsVaccinated()) {
    		System.out.println("User is already vaccinated");
    	
    	}
    	else {
    		System.out.println("Please Enter Details");
        	System.out.println("Name:");
        	String name=s.next();
        	System.out.println("Age:");
        	int age=s.nextInt();
        	
        	System.out.println("Appointment date (YYYY-MM-DD):");
        	String date=s.next();
        	System.out.println("Appointment Time (HH:MM AM/PM):");
        	String time=s.next();
        	
        	System.out.println("Appointment Location:");
        	String location=s.next();
        	TimeAndLocation timeAndLocation=(TimeAndLocation) context.getBean("timeAndlocation");
        	timeAndLocation.setDate(date);
        	timeAndLocation.setTimeSlot(time);
        	timeAndLocation.setLocation(location);
        	us.setUserDetails(name, age,timeAndLocation);
        	us.setAppointment();
    	}
    	System.out.println("Do you want to register for someone Else \n");
    	System.out.println("1) Yes \n 2) No");
    	int opt=s.nextInt();
    	
    	switch(opt) {
    	case 1:{
    		break;
    	}
    	case 2:{
    		System.out.println("Thank You");
    		break;
    	}
    	default:{
    		System.out.println("Wrong");
    	}
    	}
    	}
    }
}