package solu.sigmify.locale;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class I18n 
{
    public static void main( String[] args )
    {
    	ApplicationContext ac=null;
    	Locale locale=null;
    	String cap1=null,cap2=null,cap3=null,cap4=null;
    	String lang=null,country=null;
    	Scanner sc=new Scanner(System.in);
        //create IOC Container
    	ac=new ClassPathXmlApplicationContext("solu/sigmify/cfgs/applicationContext.xml");
    	//praepare locale object
    	System.out.print("Enter language : ");
    	lang=sc.next();
    	System.out.print("Enter country : ");
    	country=sc.next();
    	
    	locale=new Locale(lang,country);//args[0]-->language args[1]-country
    	if(lang.equalsIgnoreCase("hi")&&country.equalsIgnoreCase("IN")) {
    	//get messages
    	cap1=ac.getMessage("btn1.cap",null, "msg1", locale);
    	cap2=ac.getMessage("btn2.cap",null,"msg2", locale);
    	cap3=ac.getMessage("btn3.cap", null, "msg3", locale);
    	cap4=ac.getMessage("btn4.cap", null, "msg4", locale);
    	System.out.println(cap1+"\n"+cap2+"\n"+cap3+"\n"+cap4);
    	}else {
    		System.out.println("Enter valid language code and country code");
    	}
    	//System.out.println(ac.getMessage("btn2.cap",null,new Locale("hi","IN")));
    }
}
