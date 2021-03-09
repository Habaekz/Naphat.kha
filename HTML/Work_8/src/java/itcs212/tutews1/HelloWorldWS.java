/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itcs212.tutews1;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.text.DecimalFormat;

/**
 *
 * @author naphatkhajohn-udomrith
 */
@WebService(serviceName = "HelloWorldWS")
public class HelloWorldWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "squareMethod")
    public String squareMethod(@WebParam(name = "number") final int number) {
        //TODO write your implementation code here:
        int result = number*number;
        String strResult = Integer.toString(result); 
        return strResult;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConvertercmToInch")
    public String ConvertercmToInch(@WebParam(name = "cm") final double cm) {
        //TODO write your implementation code here:
        double result = cm*0.39;
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CelsiusToFahrenheit")
    public String CelsiusToFahrenheit(@WebParam(name = "Celsius") final double Celsius) {
        //TODO write your implementation code here:
        double result = Celsius*1.8+32;
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(result);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMydetail")
    public String getMydetail(@WebParam(name = "studentID") final String studentID) {
        //TODO write your implementation code here:
        String FirstName = "Naphat";
        String LastName = "Khajohn-udomrith";
        String MobilePhone = "095-947-4543";
        String Address = "Thailand";
        if(studentID.contains("6188029"))
        {
            return FirstName+","+LastName+","+MobilePhone+","+Address;
        }
        return "Unknown";
    }


    
    
}
