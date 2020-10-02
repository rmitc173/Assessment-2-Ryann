/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 * Purpose: Extenstion of Assessment 1, Object Orientated Programming.
 * This assessment is designed to register, store and edit Treffic Accidents
 */


/* 

SHIFT + F6 to RUN PROGRAM

*/
package mvr;

public class Application {

    public static void main(String[] args) {
                MotorVehicleRegistrationFrame myApp = new MotorVehicleRegistrationFrame();
                myApp.setVisible(true);
                myApp.setSize(900, 520);
                myApp.setResizable(false);
                myApp.setDefaultCloseOperation(MotorVehicleRegistrationFrame.DO_NOTHING_ON_CLOSE);
        }   
}
