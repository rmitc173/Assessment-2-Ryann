/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

public class Owner {
        private int id;
        private String firstName; 
        private String lastName;
        private String address;
        private String phoneNumber;  

        public Owner(int id, String firstName, String lastName, String address, String phoneNumber) {
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.address = address;
                this.phoneNumber = phoneNumber;
        }
 
        public Owner() {  
                this(0, "Ryan", "Sample", "13 Nindii Close \n Cairns Queensland 4869", "0455143828"); 
        }  
 
        Owner(Owner owner)  { 
                this.id = owner.id;
                this.firstName = owner.firstName;
                this.lastName = owner.lastName;
                this.address = owner.address;
                this.phoneNumber = owner.phoneNumber;
        } 
 
        public int getId() {
                return id;
        }
 
        public void setId(int id) {
                this.id = id;
        }
 
        public String getFirstName() {
                return firstName;
        }
  
        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }
 
        public String getLastName() {
                return lastName;
        }
 
        public void setLastName(String lastName) {
                this.lastName = lastName;
        }
 
        public String getAddress() {
                return address;
        }
 
        public void setAddress(String address)  {
                this.address = address;
        }
 
        public String getPhoneNumber() {
                return phoneNumber;
        }
 
        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }
        
         public String getType() {
            return "Owner";
        }
 
        @Override
        public String toString() {
                return "License Number = " + id + ", First Name = " + firstName + ", Last Name = " + lastName + ", Address = " + address + ", Phone Number = " + phoneNumber;
        }

} // End of OWNER CLASS


