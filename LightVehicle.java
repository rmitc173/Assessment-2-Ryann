/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

public class LightVehicle extends Vehicle {

        private String plateNumber;
        private int numberOfSeats;

        public LightVehicle (String plateNumber, int numberOfSeats, double engineCapacity, String make, String model, int year, int ownerId) {
                super(plateNumber, engineCapacity, make, model, year, ownerId);
                this.plateNumber = plateNumber;
                this.numberOfSeats = numberOfSeats;
        }
   
        public LightVehicle() {
                this("348YNO", 5, 2.0, "Honda", "CRV", 1999, 0);
        }

        LightVehicle(LightVehicle lightVehicle) {
                this.plateNumber = lightVehicle.plateNumber;
        } 

        @Override
        public String getPlateNumber() {
                return plateNumber;
        }

        @Override
        public void setPlateNumber(String plateNumber) {
                this.plateNumber = plateNumber;
        }

        public int getNumberOfSeats() {
                return numberOfSeats;
        }
        
        

        public void setNumberOfSeats(int numberOfSeats) {
                this.numberOfSeats = numberOfSeats;
        }

        public String getType() {
            return "Light Vehicle";
        }
        
        @Override
        public String toString() {
                return super.toString() + ", Number of Seats = " + numberOfSeats;
        }
               
} // End of LIGHT VEHICLE CLASS

