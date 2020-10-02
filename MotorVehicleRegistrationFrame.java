/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MotorVehicleRegistrationFrame extends JFrame implements ActionListener {
        private static final int TABBED_PANE_OWNER = 0;
        private static final int TABBED_PANE_VEHICLE = 1;
        private static final int TABBED_PANE_SEARCH = 2;
        private static final int TABBED_PANE_ACCIDENT = 3;
      
         
        private final String PROGRAM_TITLE;
        
        private int confirmDialogResponse;

        public static ArrayList<Owner> ownerArray;
        public static ArrayList<Vehicle> vehicleArray;
        public static ArrayList<Accident> accidentArray;
        
        public static int numMotorcycles;
        public static int numHeavyOrLightVehicles;
      
        private final Font HEADINGONE_FONT_STYLE;
        private JPanel mainPanel;
        public static JTabbedPane tabbedPane;
        private JLabel titleLabel;
        
        private JMenuBar MotorVehicleRegistrationMenuBar;
	private JMenu menuBarFile;
	private JMenuItem menuBarFileExit;

        public MotorVehicleRegistrationFrame() {
                super("Motor Vehicle Registration Queensland");
                PROGRAM_TITLE = "Motor Vehicle Registration Queensland";
                ownerArray = new ArrayList<Owner>();
                vehicleArray = new ArrayList<Vehicle>();
                accidentArray = new ArrayList<Accident>();
                
                HEADINGONE_FONT_STYLE = new Font("Arial", 1, 24);
              
                mainPanel = new JPanel();
                mainPanel.setLayout(new BorderLayout()); 
                
                tabbedPane = new JTabbedPane();   
                tabbedPane.addTab("Add Owner", new OwnerJPanel());
                tabbedPane.addTab("Add Vehicle", new VehicleJPanel());
                tabbedPane.addTab("Search", new SearchJPanel());
                tabbedPane.addTab("Record Accident", new AccidentJPanel());
              
                titleLabel = new JLabel("Motor Vehicle Registration");  
                MotorVehicleRegistrationMenuBar = new JMenuBar();
                
                menuBarFile = new JMenu("File");
                menuBarFileExit = new JMenuItem("Exit");
                setFontStyles();
                this.setLayout(new BorderLayout());
                add(mainPanel);
                setLayout();
                setActionListeners();
                addWindowListener(
                        
		new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                        exit();
                }
             }
        );                       
}

        private void setFontStyles() {
                titleLabel.setFont(HEADINGONE_FONT_STYLE);
        }
 
        private void setActionListeners() {
                menuBarFileExit.addActionListener(this);
        }
 
        private void setLayout() {
                mainPanel.add(titleLabel,BorderLayout.NORTH);
                mainPanel.add(tabbedPane,BorderLayout.CENTER);
                setJMenuBar(MotorVehicleRegistrationMenuBar);
                MotorVehicleRegistrationMenuBar.add(menuBarFile);
                menuBarFile.add(menuBarFileExit);      
        }

        public static void showSearchTab() {
                tabbedPane.setSelectedIndex(TABBED_PANE_SEARCH);
        }
        
        public static void showAddOwnerTab() {
                tabbedPane.setTitleAt(TABBED_PANE_OWNER, "Add Owner");
                tabbedPane.setSelectedIndex(TABBED_PANE_OWNER);
        }        

        public static void showEditOwnerTab() {
                tabbedPane.setTitleAt(TABBED_PANE_OWNER, "Edit Owner");
                tabbedPane.setSelectedIndex(TABBED_PANE_OWNER);
        }  

        public static void showAddVehicleTab() {
                tabbedPane.setTitleAt(TABBED_PANE_VEHICLE, "Add Vehicle");
                tabbedPane.setSelectedIndex(TABBED_PANE_VEHICLE);
        }        

        public static void showEditVehicleTab() {
                tabbedPane.setTitleAt(TABBED_PANE_VEHICLE, "Edit Vehicle");
                tabbedPane.setSelectedIndex(TABBED_PANE_VEHICLE);
        }
 
        public static void resetVehiclePanelJComboBox() {
                VehicleJPanel.resetJComboBox();
        }

        public static void resetJComboBoxes() {
                OwnerJPanel.resetJComboBox();
                resetVehiclePanelJComboBox();
                SearchJPanel.resetJComboBox();
        }

        private void generateThankYouMessage() {
                JOptionPane.showMessageDialog(null, "Thank you for using the Motor Vehicle Registration Queensland Application " );
        } 
  
        private void generateConfirmDialog(String messageText) {
               confirmDialogResponse = JOptionPane.showConfirmDialog(null, messageText, PROGRAM_TITLE, JOptionPane.YES_NO_OPTION);
        }

	private void exit() {
                generateConfirmDialog("Are you sure you wish to exit?"); 
                    if(confirmDialogResponse == JOptionPane.YES_OPTION) {
                        generateThankYouMessage();
                        System.exit(0);
                    }
                else {
                        return;               
                }   
        }  
        
        public void readVehicleFile() {
        FileReader reader = null;
        System.out.println("Opening file");
        try {
            int count = 0;
            String inLine;
            reader = new FileReader("vehicles.txt");
            Scanner fileIn = new Scanner(reader);
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                count++;
                Scanner lineIn = new Scanner(line);
                while (lineIn.hasNext()) {
                    String type = lineIn.next();
                    double engineCapacity = lineIn.nextDouble();
                    String plateNumber = lineIn.next();
                    String make = lineIn.next();
                    String model = lineIn.next();
                    int year = lineIn.nextInt();
                    int ownerID = lineIn.nextInt();
                    
                    //create new Vehicle object, add to vehicleArray
                    if (type.equals("H")) {
                        int loadCapacity = lineIn.nextInt();
                        vehicleArray.add(new HeavyVehicle(plateNumber, loadCapacity, engineCapacity, make, model, year, ownerID));
                        numHeavyOrLightVehicles ++;
                    }
                    else if (type.equals("L")) {
                        int numSeats = lineIn.nextInt();
                        vehicleArray.add(new LightVehicle(plateNumber, numSeats, engineCapacity, make, model, year, ownerID));
                        numHeavyOrLightVehicles ++;
                    }
                    else {
                        vehicleArray.add(new Motorcycle(plateNumber, engineCapacity, make, model, year, ownerID));
                        numMotorcycles++;
                    }
                }
            }
            System.out.println(vehicleArray);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void readOwnerFile() {
        FileReader reader = null;
        try {
            reader = new FileReader("owner.txt");
            Scanner fileIn = new Scanner(reader);
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                Scanner lineIn = new Scanner(line);
                while (lineIn.hasNext()) {
                    String type = lineIn.next();
                    int id = lineIn.nextInt();
                    String firstName = lineIn.next();
                    String lastName = lineIn.next();
                    String address = lineIn.next();
                    String phoneNumber = lineIn.next();
                    if (type.equals("P")) {
                        String DOB = lineIn.next();
                        ownerArray.add(new PrivateOwner(id, DOB, firstName, lastName, address, phoneNumber));
                    }
                    else
                    {
                        String ABN = lineIn.next() + " " + lineIn.next() + " " + lineIn.next() + " " + lineIn.next();
                        ownerArray.add(new CorporateOwner(id, ABN, firstName, lastName, address, phoneNumber));
                    }

                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void readAccidentFile() {
        FileReader reader = null;
        try {
            reader = new FileReader("accident.txt");
            Scanner fileIn = new Scanner(reader);
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                Scanner lineIn = new Scanner(line);
                while (lineIn.hasNext()) {
                    String type = lineIn.next();
                    String accidentID = lineIn.next();
                    String location = lineIn.next();
                    String date = lineIn.next();
                    String comment = lineIn.next();
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void writeVehicleFile() {

        try {
            FileWriter out = new FileWriter("vehicle.txt");
            int arraySize = MotorVehicleRegistrationFrame.vehicleArray.size();
      
            for (int searchIndex = 0; searchIndex < arraySize; ++searchIndex) {
                    //replace with Vehicle.getType()
                    if (vehicleArray.get(searchIndex).getType().equals("Heavy Vehicle")) {
                        //write 'type' code
                        out.write("H");
                    }
                    else if (vehicleArray.get(searchIndex).getType().equals("Light Vehicle")) {
                        //write 'type' code
                        out.write("L");
                    }
                    else {
                        //write 'motorcycle type'
                        out.write("M");
                    }
                    out.write(vehicleArray.get(searchIndex).getPlateNumber() + " ");
                    out.write(vehicleArray.get(searchIndex).getEngineCapacity() + " ");
                    out.write(vehicleArray.get(searchIndex).getMake() + " ");
                    out.write(vehicleArray.get(searchIndex).getModel() + " ");
                    out.write(vehicleArray.get(searchIndex).getYear() + " ");
                    out.write(vehicleArray.get(searchIndex).getOwnerId() + " ");
                    
                     if (vehicleArray.get(searchIndex).getType().equals("H")) {
                        out.write(((HeavyVehicle)vehicleArray.get(searchIndex)).getLoadCapacity() + " ");
                        }
                    else if (vehicleArray.get(searchIndex).getType().equals("Light Vehicle")) {
                        out.write(((LightVehicle)vehicleArray.get(searchIndex)).getNumberOfSeats() + " ");
                    }
                }
            
        }catch (IOException ex) {
            Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeOwnerFile() {
        try {
            FileWriter out = new FileWriter("owner.txt");
            int arraySize = MotorVehicleRegistrationFrame.ownerArray.size();
            for (int searchIndex = 0; searchIndex < arraySize; ++searchIndex) {
                
                if (ownerArray.get(searchIndex).getType().equals("Private"))
                {
                 
                    out.write("P ");
                }
                else
                {
                    out.write("C ");
                }
                out.write(ownerArray.get(searchIndex).getId() + " ");
                out.write(ownerArray.get(searchIndex).getFirstName() + " ");
                out.write(ownerArray.get(searchIndex).getLastName() + " ");
                out.write(ownerArray.get(searchIndex).getAddress() + " ");
                out.write(ownerArray.get(searchIndex).getPhoneNumber() + " ");
                if (ownerArray.get(searchIndex).getType().equals("Private"))
                {
                    out.write(((PrivateOwner)ownerArray.get(searchIndex)).getDateOfBirth());
                }
                else
                {
                    out.write(((CorporateOwner)ownerArray.get(searchIndex)).getAustralianBusinessNumber());
                }
                if (searchIndex < arraySize -1 )
                {
                    out.write("\n");
                }
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeAccidentFile() {
        try {
            FileWriter out = new FileWriter("accident.txt");
            int arraySize = MotorVehicleRegistrationFrame.accidentArray.size();
            for (int searchIndex = 0; searchIndex < arraySize; ++searchIndex) {
                out.write(accidentArray.get(searchIndex).getAccidentID() + " ");
                out.write(accidentArray.get(searchIndex).getLocation() + " ");
                out.write(accidentArray.get(searchIndex).getDate() + " ");
                out.write(accidentArray.get(searchIndex).getComment() + " ");
            }
            }catch (IOException ex) {
            Logger.getLogger(MotorVehicleRegistrationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.compareTo("Exit") == 0) {
            exit();
        }
    }   
} // End of Motor Vehicle Registration Queensland Frame

