/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

public class PrivateOwner extends Owner {

        private String dateOfBirth;

        public PrivateOwner (int id, String dateOfBirth, String firstName, String lastName, String address, String phoneNumber) {
                super(id, firstName, lastName, address, phoneNumber);
                this.dateOfBirth = dateOfBirth;
        }

        public PrivateOwner()  { 
                this(0, "26/09/2020", "Ryan", "Sample", "13 Nindii Close \n Cairns Queensland 4869", "0455143828"); 
        } 
 
        PrivateOwner(PrivateOwner privateOwner) {
                this.dateOfBirth = privateOwner.dateOfBirth;
        }  
 
        public String getDateOfBirth() {
                return dateOfBirth;
        }
 
        public void setDateOfBirth(String dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
        }
 
        @Override
        public String toString()  {
                return super.toString() + ", Date of Birth = " + dateOfBirth;
        }
} // End of PRIVATE OWNER CLASS

