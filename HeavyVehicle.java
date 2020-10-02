/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

public class HeavyVehicle extends Vehicle {

        private String plateNumber;
        private int loadCapacity;

        public HeavyVehicle (String plateNumber, int loadCapacity, double engineCapacity, String make, String model, int year, int ownerId) {
                super(plateNumber, engineCapacity, make, model, year, ownerId);
                this.plateNumber = plateNumber;
                this.loadCapacity = loadCapacity;
        }

        public HeavyVehicle() {
                this("492TSZ", 23000, 8, "Toyota", "Land Cruiser 6x6", 1985, 0);
        }

        HeavyVehicle(HeavyVehicle heavyVehicle) {
                this.plateNumber = heavyVehicle.plateNumber;
        } 

        @Override
        public String getPlateNumber() {
                return plateNumber;
        }

        @Override
        public void setPlateNumber(String plateNumber) {
                this.plateNumber = plateNumber;
        }

        public int getLoadCapacity() {
                return loadCapacity;
        }

        public void setLoadCapacity(int loadCapacity) {
                this.loadCapacity = loadCapacity;
        }

        @Override
        public String toString()  {
                return super.toString() + ", Load Capacity = " + loadCapacity;
        }  
        
        public String getType() {
            return "Heavy Vehicle";
        }
} // End of HEAVY VEHICLE CLASS

