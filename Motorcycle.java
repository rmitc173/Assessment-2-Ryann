/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

public class Motorcycle extends Vehicle {

        private String plateNumber;

        public Motorcycle (String plateNumber, double engineCapacity, String make, String model, int year, int ownerId) {
                super(plateNumber, engineCapacity, make, model, year, ownerId);
                this.plateNumber = plateNumber;
        }
   

        public Motorcycle() { 
                this("630YH", 3.5, "Yamaha", "YZF-R1M", 2020, 0); //Default constructor
        }

        Motorcycle(Motorcycle motorcycle) {
                this.plateNumber = motorcycle.plateNumber;
        } 

        @Override
        public String getPlateNumber() {
                return plateNumber;
        }
 
        @Override
        public void setPlateNumber(String plateNumber) {
                this.plateNumber = plateNumber;
        }
 
        @Override
        public String toString() {
                return super.toString();
        }

} // End of MOTORCYCLE CLASS

