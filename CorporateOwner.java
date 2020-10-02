/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

public class CorporateOwner extends Owner {

        private String australianBusinessNumber;

        public CorporateOwner (int id, String australianBusinessNumber, String firstName, String lastName, String address, String phoneNumber) {
                super(id, firstName, lastName, address, phoneNumber);
                this.australianBusinessNumber = australianBusinessNumber;
        }
 
        public CorporateOwner() {
                this(0, "0", "Ryan", "Sample", "13 Nindii Close \n Cairns Queensland 4869", "0455143828");
        }

        CorporateOwner(CorporateOwner corporateOwner) {
                this.australianBusinessNumber = corporateOwner.australianBusinessNumber;
        }  

        public String getAustralianBusinessNumber() {
                return australianBusinessNumber;
        }

        public void setAustralianBusinessNumber(String australianBusinessNumber) {
                this.australianBusinessNumber = australianBusinessNumber;
        }

        @Override
        public String toString() {
                return super.toString() + ", Australian Business Number = " + australianBusinessNumber;
        }
} // End of CORPORATE OWNER OPTION

