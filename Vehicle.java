/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

public class Vehicle {

        private String plateNumber;
        private double engineCapacity; 
        private String make;
        private String model;
        private int year;  
        private int ownerId;  

        public Vehicle(String plateNumber, double engineCapacity, String make, String model, int year, int ownerId) {
                this.plateNumber = plateNumber;
                this.engineCapacity = engineCapacity;
                this.make = make;
                this.model = model;
                this.year = year;
                this.ownerId = ownerId;
        }

        public Vehicle() {  
                this("348YNO", 2.0, "Honda", "CRV", 1999, 0);         
        } 

        Vehicle(Vehicle vehicle) { 
                this.plateNumber = vehicle.plateNumber;
                this.engineCapacity = vehicle.engineCapacity;
                this.make = vehicle.make;
                this.model = vehicle.model;
                this.year = vehicle.year;
                this.ownerId = vehicle.ownerId;
        } 
 
        public String getPlateNumber() {
                return plateNumber;
        }
 
        public void setPlateNumber(String plateNumber) {
                this.plateNumber = plateNumber;
        }
 
        public double getEngineCapacity() {
                return engineCapacity;
        }
 
        public void setEngineCapacity(double engineCapacity) {
                this.engineCapacity = engineCapacity;
        }
 
        public String getMake() {
                return make;
        }
 
        public void setMake(String make) {
                this.make = make;
        }
 
        public String getModel() {
                return model;
        }
 
        public void setModel(String model) {
                this.model = model;
        }
 
        public int getYear() {
                return year;
        }
 
        public void setYear(int year) {
                this.year = year;
        }
 
        public int getOwnerId() {
                return ownerId;
        }
 
        public void setOwnerId(int ownerId) {
                this.ownerId = ownerId;
        }
        
         public String getType() {
            return "Vehicle";
        }
 
        @Override
        public String toString() {
                return "Number Plate = " + plateNumber + ", Engine Capacity = " + engineCapacity + ", Make = " + make + ", Model = " + model + ", Year = " + year + ", License Number = " + ownerId;
        }
    
} // End of VEHICLE CLASS

