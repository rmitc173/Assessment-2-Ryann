/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.BASELINE;

public class VehicleJPanel extends JPanel implements ActionListener, ItemListener {
        private final int NO_VEHICLE_SELECTED;
        private static final int MOTORCYCLE = 1;
        private static final int LIGHT_VEHICLE = 2;
        private static final int HEAVY_VEHICLE = 3;
         
        private final int BUTTON_WIDTH;
        private final int BORDER_GAP;
        private final int FIELD_HORIZONTAL_GAP;
        private final int FIELD_VERTICAL_GAP;
        private final int LARGE_FIELD_VERTICAL_GAP;
        private final int JEXTFIELD_COLUMN_WIDTH;
         
        private int confirmDialogResponse;
         
        private int currentLightAndHeavyVehicleNumberPlate;
        private int currentMotorcycleNumberPlate;
         
        public static boolean editMode;
         
        int numberOfSeats;
        int loadCapacity;
        double engineCapacity;
        String make;
        String model;
        int year;
        int ownerId;
         
        private String [] selectVehicleTypeJComboBoxList;
         
        private final String PROGRAM_TITLE;
         
        private JComponent commonFieldObjectJComponentContainer;
        private StringBuilder commonErrorDialogStringBuilder;
        private JComponent numberOfSeatsFieldObjectJComponentContainer;
        private StringBuilder numberOfSeatsErrorDialogStringBuilder;
        private JComponent loadCapacityFieldObjectJComponentContainer;
        private StringBuilder loadCapacityErrorDialogStringBuilder;
          
        private final Font NORMAL_FONT_STYLE;
        private final Font HEADINGTWO_FONT_STYLE;
         
        private final Color WHITE_COLOUR;
         
        private JPanel vehicleJPanel;
         
        private static JLabel vehicleJLabel;
         
        private JLabel selectVehicleTypeJLabel;
        private static JComboBox<String> selectVehicleTypeJComboBox;
         
        private static JLabel enterVehicleDetailsJLabel;
        private JLabel loadCapacityJLabel; 
        private JLabel numberOfSeatsJLabel;
        private JLabel engineCapacityJLabel;
        private JLabel makeJLabel;
        private JLabel modelJLabel;
        private JLabel yearJLabel;
        private JLabel ownerIdJLabel;
         
        private static JTextField loadCapacityJTextField;
        private static JTextField numberOfSeatsJTextField;
        private static JTextField engineCapacityJTextField;
        private static JTextField makeJTextField;
        private static JTextField modelJTextField;
        private static JTextField yearJTextField;
        private static JComboBox<String> ownerIdJComboBox;
         
        private static JButton vehicleJButton;
        private static JButton addModeJButton;
        private JButton clearJButton;
         
        private static final int OWNER_ID_REFERENCE_INDEX = 0;
         
        private StringBuilder ownerIdStringBuilder;
         
        private static ArrayList<LightVehicle> lightVehicleArray;
        private static ArrayList<HeavyVehicle> heavyVehicleArray;
          
        private int numberOfCharacterIndexesInNumberPlate;
        private int [] combinationValues;
        private int [] combinationAccummulatingTotal;
        private int [] maximumNumberPlaceValues;
        private int [] minimumNumberPlaceValues;
        private int [] flipppedMinimumNumberPlaceValues;
        private int [] remainder;
        private int [] quantityInNumberPlace;
        private int amount;
        private StringBuilder characterIndexesInNumberPlate;
         
        private GroupLayout vehicleLayout;
         
        public VehicleJPanel() {
                JEXTFIELD_COLUMN_WIDTH = 40;
        
                NO_VEHICLE_SELECTED = 0;
                BUTTON_WIDTH = 130;
                BORDER_GAP = 12;
                FIELD_HORIZONTAL_GAP = 18;
                FIELD_VERTICAL_GAP = 5;
                LARGE_FIELD_VERTICAL_GAP = 24;
                confirmDialogResponse = 0;
                editMode = false;
                lightVehicleArray = new ArrayList<>();
                heavyVehicleArray = new ArrayList<>();
                
                numberOfSeats = 0;
                loadCapacity = 0;
                engineCapacity = 0;
                year = 0;
                ownerId = 0;
                
                selectVehicleTypeJComboBoxList = new String [] {"...", "Motorcycle", "Light Vehicle", "Heavy Vehicle"}; 

                currentLightAndHeavyVehicleNumberPlate = 0;
                currentMotorcycleNumberPlate = 521000;
                
                numberOfCharacterIndexesInNumberPlate = 6;
                combinationValues = new int [numberOfCharacterIndexesInNumberPlate];
                combinationAccummulatingTotal = new int [numberOfCharacterIndexesInNumberPlate];
                maximumNumberPlaceValues = new int [numberOfCharacterIndexesInNumberPlate];
                minimumNumberPlaceValues = new int [numberOfCharacterIndexesInNumberPlate];
                flipppedMinimumNumberPlaceValues = new int [numberOfCharacterIndexesInNumberPlate];
                remainder = new int [numberOfCharacterIndexesInNumberPlate];
                quantityInNumberPlace = new int [numberOfCharacterIndexesInNumberPlate];
                amount = 0;
                characterIndexesInNumberPlate = new StringBuilder();
                ownerIdStringBuilder = new StringBuilder();
                
                commonErrorDialogStringBuilder = new StringBuilder();
                numberOfSeatsErrorDialogStringBuilder = new StringBuilder();
                loadCapacityErrorDialogStringBuilder = new StringBuilder();
                
                
                PROGRAM_TITLE = "Motor Vehicle Registration Queensland";
                
                NORMAL_FONT_STYLE = new Font("Arial", 4, 12);
                HEADINGTWO_FONT_STYLE = new Font("Arial", 1, 14);                
                WHITE_COLOUR = new Color(255,255,255);             
                vehicleJPanel = new JPanel();
                
                vehicleJLabel = new JLabel("Add Vehicle");
                selectVehicleTypeJLabel = new JLabel("Select vehicle type: ");
                enterVehicleDetailsJLabel = new JLabel("Enter Vehicle Details");
                loadCapacityJLabel = new JLabel("Load Capacity: ");
                numberOfSeatsJLabel = new JLabel("Number of Seats: ");
                engineCapacityJLabel = new JLabel("Engine Capacity: ");
                makeJLabel = new JLabel("Make: ");
                modelJLabel = new JLabel("Model: ");
                yearJLabel = new JLabel("Year: ");
                ownerIdJLabel = new JLabel("License Number: ");
                
                selectVehicleTypeJComboBox = new JComboBox<>(selectVehicleTypeJComboBoxList);
                selectVehicleTypeJComboBox.setBackground(WHITE_COLOUR);
                loadCapacityJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);
                numberOfSeatsJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);
                engineCapacityJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);
                makeJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);
                modelJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);
                yearJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);
                ownerIdJComboBox = new JComboBox<>();
                ownerIdJComboBox.setBackground(WHITE_COLOUR);
                 
                vehicleJButton = new JButton("Add Vehicle");
                addModeJButton = new JButton("Add Mode");
                clearJButton = new JButton("Clear");               
                addModeJButton.setVisible(false);               
                setFontStyles();
                vehicleLayout = new GroupLayout(vehicleJPanel);
                setLayout();
                setActionListeners();
                setEntryAreaInvisible();
        }
 
        private void setFontStyles() {
                vehicleJLabel.setFont(HEADINGTWO_FONT_STYLE);
                selectVehicleTypeJLabel.setFont(NORMAL_FONT_STYLE);
                enterVehicleDetailsJLabel.setFont(HEADINGTWO_FONT_STYLE);
                loadCapacityJLabel.setFont(NORMAL_FONT_STYLE);
                numberOfSeatsJLabel.setFont(NORMAL_FONT_STYLE);
                engineCapacityJLabel.setFont(NORMAL_FONT_STYLE);
                makeJLabel.setFont(NORMAL_FONT_STYLE);
                modelJLabel.setFont(NORMAL_FONT_STYLE);
                yearJLabel.setFont(NORMAL_FONT_STYLE);
                ownerIdJLabel.setFont(NORMAL_FONT_STYLE);
                selectVehicleTypeJComboBox.setFont(NORMAL_FONT_STYLE);
                loadCapacityJTextField.setFont(NORMAL_FONT_STYLE);
                numberOfSeatsJTextField.setFont(NORMAL_FONT_STYLE);
                engineCapacityJTextField.setFont(NORMAL_FONT_STYLE);
                makeJTextField.setFont(NORMAL_FONT_STYLE);
                modelJTextField.setFont(NORMAL_FONT_STYLE);
                yearJTextField.setFont(NORMAL_FONT_STYLE);
                ownerIdJComboBox.setFont(NORMAL_FONT_STYLE);
                vehicleJButton.setFont(NORMAL_FONT_STYLE);
                addModeJButton.setFont(NORMAL_FONT_STYLE);
                clearJButton.setFont(NORMAL_FONT_STYLE);   
        }
  
        private void setActionListeners() {
                selectVehicleTypeJComboBox.addItemListener(this);
                vehicleJButton.addActionListener(this);
                addModeJButton.addActionListener(this);
                clearJButton.addActionListener(this);
        }
 
        private void setLayout() {
                setLayout(new BorderLayout());
                add(vehicleJPanel);
                vehicleJPanel.setLayout(vehicleLayout);
                
                vehicleLayout.setHorizontalGroup(vehicleLayout.createSequentialGroup()
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP)
                                .addGroup(vehicleLayout.createSequentialGroup()
                                .addGroup(vehicleLayout.createParallelGroup()
                                        .addComponent(vehicleJButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addModeJButton, GroupLayout.Alignment.CENTER, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearJButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addGroup(vehicleLayout.createSequentialGroup()
                                .addGroup(vehicleLayout.createParallelGroup()
                                        .addComponent(vehicleJLabel)
                                        .addComponent(selectVehicleTypeJLabel)
                                        .addComponent(enterVehicleDetailsJLabel)
                                        .addComponent(loadCapacityJLabel)
                                        .addComponent(numberOfSeatsJLabel)
                                        .addComponent(engineCapacityJLabel)
                                        .addComponent(makeJLabel)
                                        .addComponent(modelJLabel)
                                        .addComponent(yearJLabel)
                                        .addComponent(ownerIdJLabel))
                                .addGap(FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP)
                                        .addGroup(vehicleLayout.createSequentialGroup()
                                        .addGroup(vehicleLayout.createParallelGroup()
                                                .addComponent(selectVehicleTypeJComboBox)
                                                .addComponent(loadCapacityJTextField)
                                                .addComponent(numberOfSeatsJTextField)
                                                .addComponent(engineCapacityJTextField)
                                                .addComponent(makeJTextField)
                                                .addComponent(modelJTextField)
                                                .addComponent(yearJTextField)
                                                .addComponent(ownerIdJComboBox))))))
                                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP));
                 
                vehicleLayout.setVerticalGroup(vehicleLayout.createSequentialGroup()
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(vehicleJLabel))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(selectVehicleTypeJLabel)
                                .addComponent(selectVehicleTypeJComboBox))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(enterVehicleDetailsJLabel))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(loadCapacityJLabel)
                                .addComponent(loadCapacityJTextField))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(numberOfSeatsJLabel, GroupLayout.Alignment.CENTER)
                                .addComponent(numberOfSeatsJTextField))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(engineCapacityJLabel)
                                .addComponent(engineCapacityJTextField))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(makeJLabel)
                                .addComponent(makeJTextField))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(modelJLabel)
                                .addComponent(modelJTextField))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(yearJLabel)
                                .addComponent(yearJTextField))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(ownerIdJLabel)
                                .addComponent(ownerIdJComboBox))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(vehicleLayout.createSequentialGroup()
                        .addGroup(vehicleLayout.createParallelGroup(BASELINE)
                                .addComponent(vehicleJButton)
                                .addComponent(addModeJButton)
                                .addComponent(clearJButton)))))))))))))
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP));
                }
 
        private void setCommonFieldsVisible() {
                enterVehicleDetailsJLabel.setVisible(true);
                engineCapacityJLabel.setVisible(true);
                makeJLabel.setVisible(true);
                modelJLabel.setVisible(true);
                yearJLabel.setVisible(true);
                ownerIdJLabel.setVisible(true);
                engineCapacityJTextField.setVisible(true);
                makeJTextField.setVisible(true);
                modelJTextField.setVisible(true);
                yearJTextField.setVisible(true);
                ownerIdJComboBox.setVisible(true);
                vehicleJButton.setVisible(true);
                clearJButton.setVisible(true);
                
                if(getEditMode() == true)
                    addModeJButton.setVisible(true);
        }
                
        private void setCommonFieldsInvisible() {
                enterVehicleDetailsJLabel.setVisible(false);
                engineCapacityJLabel.setVisible(false);
                makeJLabel.setVisible(false);
                modelJLabel.setVisible(false);
                yearJLabel.setVisible(false);
                ownerIdJLabel.setVisible(false);
                engineCapacityJTextField.setVisible(false);
                makeJTextField.setVisible(false);
                modelJTextField.setVisible(false);
                yearJTextField.setVisible(false);
                ownerIdJComboBox.setVisible(false);
                vehicleJButton.setVisible(false);
                clearJButton.setVisible(false);  
                addModeJButton.setVisible(false);
        }
 
        private void setLightVehicleFieldsInvisible() {
                numberOfSeatsJLabel.setVisible(false);
                numberOfSeatsJTextField.setVisible(false); 
        }
  
        private void setHeavyVehicleFieldsInvisible() {
                loadCapacityJLabel.setVisible(false);
                loadCapacityJTextField.setVisible(false);
        }
 
        private void setEntryAreaInvisible() {
                setCommonFieldsInvisible(); 
                setHeavyVehicleFieldsInvisible();
                setLightVehicleFieldsInvisible();
        }
        
        private void SelectVehicleType() {
                if(selectVehicleTypeJComboBox.getSelectedIndex() == NO_VEHICLE_SELECTED) {
                        setEntryAreaInvisible();           
                }
                
                if(selectVehicleTypeJComboBox.getSelectedIndex() == MOTORCYCLE) {
                        setCommonFieldsVisible(); 
                        setLightVehicleFieldsInvisible();
                        setHeavyVehicleFieldsInvisible();
                }
                
                if(selectVehicleTypeJComboBox.getSelectedIndex() == LIGHT_VEHICLE) {
                        setCommonFieldsVisible(); 
                        numberOfSeatsJLabel.setVisible(true);
                        numberOfSeatsJTextField.setVisible(true);
                        setHeavyVehicleFieldsInvisible();
                }
                                
                if(selectVehicleTypeJComboBox.getSelectedIndex() == HEAVY_VEHICLE) {
                        setCommonFieldsVisible(); 
                        loadCapacityJLabel.setVisible(true);
                        loadCapacityJTextField.setVisible(true);
                        setLightVehicleFieldsInvisible();
                }        
        }
 
        private void generateConfirmDialog(String messageText) {
               confirmDialogResponse = JOptionPane.showConfirmDialog(null, messageText, PROGRAM_TITLE, JOptionPane.YES_NO_OPTION);
        }
  
        private void generateErrorDialog(String messageText) {
                JOptionPane.showMessageDialog(null, messageText, PROGRAM_TITLE, JOptionPane.ERROR_MESSAGE); 
        }
 
        private void generateDataValidationErrorDialog(JComponent fieldObject, String messageText) {
                generateErrorDialog(messageText);
                fieldObject.requestFocus();
                return;  
        }
 
        private void generateNumberOfSeatsFieldDataValidationErrorDialog() {
                generateDataValidationErrorDialog(numberOfSeatsFieldObjectJComponentContainer, numberOfSeatsErrorDialogStringBuilder.toString()); 
        }
 
        private void generateLoadCapacityFieldDataValidationErrorDialog() {
                generateDataValidationErrorDialog(loadCapacityFieldObjectJComponentContainer, loadCapacityErrorDialogStringBuilder.toString()); 
        }
 
        private void generateCommonFieldDataValidationErrorDialog() {
                generateDataValidationErrorDialog(commonFieldObjectJComponentContainer, commonErrorDialogStringBuilder.toString()); 
        }
  
        private JComponent getCommonFieldObjectJComponentContainer() {
                return commonFieldObjectJComponentContainer;
        }
 
        private JComponent addCommonFieldObjectToJComponentContainer(JComponent fieldObject) {
                if(commonFieldObjectJComponentContainer == null) {
                        commonFieldObjectJComponentContainer = fieldObject;
                }               
                return commonFieldObjectJComponentContainer;
        }
 
        private StringBuilder getCommonErrorDialogStringBuilder() {
                return commonErrorDialogStringBuilder;
        }
 
        private StringBuilder addCommonErrorDialogToStringBuilder(String errorDialog) {
                if(commonErrorDialogStringBuilder.length() == 0) {
                        commonErrorDialogStringBuilder.append(errorDialog);
                }               
                return commonErrorDialogStringBuilder;
        }
 
        private void validateCommonVehicleFields() {
                commonFieldObjectJComponentContainer = null;
                commonErrorDialogStringBuilder.setLength(0);
                int integerTestField;
                double doubleTestField;
                boolean isFieldLargerThanZero;
                integerTestField = 0;
                doubleTestField = 0;
                isFieldLargerThanZero = false;

                try {
                        doubleTestField = Double.parseDouble(engineCapacityJTextField.getText());
                }
                
                catch(NumberFormatException e) {
                        addCommonFieldObjectToJComponentContainer(engineCapacityJTextField);
                        addCommonErrorDialogToStringBuilder("You must enter an engine capacity.\n\n"
                                + "This must be a number.");
                }
            
                try {
                        isFieldLargerThanZero = Double.parseDouble(engineCapacityJTextField.getText()) > 0;
                }
                
                catch(NumberFormatException e) {
                        addCommonFieldObjectToJComponentContainer(engineCapacityJTextField);
                        addCommonErrorDialogToStringBuilder("The engine capacity should be larger than zero");
                }
                
                if(makeJTextField.getText().compareTo("") == 0) {
                        addCommonFieldObjectToJComponentContainer(makeJTextField);
                        addCommonErrorDialogToStringBuilder("You must enter a make for the vehicle");
                }
                                    
                else if(modelJTextField.getText().compareTo("") == 0) {
                        addCommonFieldObjectToJComponentContainer(modelJTextField);
                        addCommonErrorDialogToStringBuilder("You must enter a model for the vehicle");
                }

                else if(yearJTextField.getText().compareTo("") == 0) {
                        addCommonFieldObjectToJComponentContainer(yearJTextField);
                        addCommonErrorDialogToStringBuilder("You must enter a year of production for the vehicle");
                }
                
                else if(yearJTextField.getText().length() != 4) {
                        addCommonFieldObjectToJComponentContainer(yearJTextField);
                        addCommonErrorDialogToStringBuilder("The year of production should contain four characters");
                }
                
                try  {
                        integerTestField = Integer.parseInt(yearJTextField.getText());
                }
                
                catch(NumberFormatException e) {
                        addCommonFieldObjectToJComponentContainer(yearJTextField);
                        addCommonErrorDialogToStringBuilder("The year of production should be a number");
                }

                if(ownerIdJComboBox.getSelectedIndex() == 0 && getEditMode() == false) {
                        addCommonFieldObjectToJComponentContainer(ownerIdJComboBox);
                        addCommonErrorDialogToStringBuilder("You must select the license number of the vehicle owner.\n\n"
                                + "Howerver, the license number you are searching for\n"
                                + "may not be listed because it is already assigned to another\n"
                                + "vehicle.");
                }              
        }
 
        private JComponent getNumberOfSeatsFieldObjectJComponentContainer() {
                return numberOfSeatsFieldObjectJComponentContainer;
        }
    
        private JComponent numberOfSeatsFieldObjectToJComponentContainer(JComponent fieldObject) {
                if(numberOfSeatsFieldObjectJComponentContainer == null) {
                        numberOfSeatsFieldObjectJComponentContainer = fieldObject;
                }                
                return numberOfSeatsFieldObjectJComponentContainer;
        }        
 
        private StringBuilder getNumberOfSeatsErrorDialogStringBuilder() {
                return numberOfSeatsErrorDialogStringBuilder;
        }
 
        private StringBuilder addNumberOfSeatsErrorDialogToStringBuilder(String errorDialog) {
                if(numberOfSeatsErrorDialogStringBuilder.length() == 0) {
                        numberOfSeatsErrorDialogStringBuilder.append(errorDialog);
                }               
                return numberOfSeatsErrorDialogStringBuilder;
        }
        
        private void validateNumberOfSeatsField() {
                numberOfSeatsFieldObjectJComponentContainer = null;
                numberOfSeatsErrorDialogStringBuilder.setLength(0);
                int numberOfSeats;
                boolean isNumberOfSeatsLargerThanZero;
                numberOfSeats = 0;
                isNumberOfSeatsLargerThanZero = false;
                
                try {
                        numberOfSeats = Integer.parseInt(numberOfSeatsJTextField.getText());
                }
                
                catch(NumberFormatException e) {
                        numberOfSeatsFieldObjectToJComponentContainer(numberOfSeatsJTextField);
                        addNumberOfSeatsErrorDialogToStringBuilder("You must enter a number of seats");
                }
            
                try {
                        isNumberOfSeatsLargerThanZero = Integer.parseInt(numberOfSeatsJTextField.getText()) > 0;
                }
                
                catch(NumberFormatException e) {
                        numberOfSeatsFieldObjectToJComponentContainer(numberOfSeatsJTextField);
                        addNumberOfSeatsErrorDialogToStringBuilder("The number of seats should be larger than zero");
                }
        }
 
        private JComponent getLoadCapacityFieldObjectJComponentContainer()
        {
                return loadCapacityFieldObjectJComponentContainer;
        }
         
        private JComponent loadCapacityFieldObjectToJComponentContainer(JComponent fieldObject) {
                if(loadCapacityFieldObjectJComponentContainer == null) {
                        loadCapacityFieldObjectJComponentContainer = fieldObject;
                }               
                return loadCapacityFieldObjectJComponentContainer;
        }
 
        private StringBuilder getLoadCapacityErrorDialogStringBuilder() {
                return loadCapacityErrorDialogStringBuilder;
        }        
 
        private StringBuilder addLoadCapacityErrorDialogToStringBuilder(String errorDialog) {
                if(loadCapacityErrorDialogStringBuilder.length() == 0) {
                        loadCapacityErrorDialogStringBuilder.append(errorDialog);
                }              
                return loadCapacityErrorDialogStringBuilder;
        }
        
        private void validateLoadCapacityField() {
                loadCapacityFieldObjectJComponentContainer = null;
                loadCapacityErrorDialogStringBuilder.setLength(0);
                int loadCapacity;
                boolean isLoadCapacityLargerThanZero;
                loadCapacity = 0;
                isLoadCapacityLargerThanZero = false;
                
                try {
                        loadCapacity = Integer.parseInt(loadCapacityJTextField.getText());
                }
                
                catch(NumberFormatException e) {
                        loadCapacityFieldObjectToJComponentContainer(loadCapacityJTextField);
                        addLoadCapacityErrorDialogToStringBuilder("You must enter a load capacity");
                }
            
                try {
                        isLoadCapacityLargerThanZero = Integer.parseInt(loadCapacityJTextField.getText()) > 0;
                }
                
                catch(NumberFormatException e) {
                        loadCapacityFieldObjectToJComponentContainer(loadCapacityJTextField);
                        addLoadCapacityErrorDialogToStringBuilder("The load capacity should be larger than zero");
                }
        }
 
        public int roundDown(double number) { 
               number = Math.floor(number); 
               return (int)number;
        }
 
        private void generateCombinationAccummulatingTotal() {
                combinationAccummulatingTotal[0] = combinationValues[0];
                for(int accumulationIndex = 1; accumulationIndex < numberOfCharacterIndexesInNumberPlate; accumulationIndex++)
                        combinationAccummulatingTotal[accumulationIndex] = combinationAccummulatingTotal[accumulationIndex - 1] * combinationValues[accumulationIndex];
        }
  
        private void generateMaximumNumberPlaceValues() {
                for(int numberPlateCharacterIndex = 0; numberPlateCharacterIndex < numberOfCharacterIndexesInNumberPlate; numberPlateCharacterIndex++)
                        maximumNumberPlaceValues[numberPlateCharacterIndex] = combinationAccummulatingTotal[numberPlateCharacterIndex] - 1;
        }
 
        private void generateMinimumNumberPlaceValues()  {
                minimumNumberPlaceValues[0] = 1;
                for(int numberPlateCharacterIndex = 1; numberPlateCharacterIndex < numberOfCharacterIndexesInNumberPlate; numberPlateCharacterIndex++)
                        minimumNumberPlaceValues[numberPlateCharacterIndex] = maximumNumberPlaceValues[numberPlateCharacterIndex - 1] + 1;
        }
  
        private void generateFlippedMinimumIndexes() {
                for(int flippedMinimumIndex = 0; flippedMinimumIndex < numberOfCharacterIndexesInNumberPlate; flippedMinimumIndex++)
                        flipppedMinimumNumberPlaceValues[flippedMinimumIndex] = minimumNumberPlaceValues[numberOfCharacterIndexesInNumberPlate - 1 - flippedMinimumIndex];
        }
 
        private void generateNumberPlateValues(int currentNumberPlate) {
                remainder[0] = currentNumberPlate;
                
                quantityInNumberPlace[0] = roundDown(remainder[0] / flipppedMinimumNumberPlaceValues[0]);
                amount = flipppedMinimumNumberPlaceValues[0] * quantityInNumberPlace[0];
                if(1 < numberOfCharacterIndexesInNumberPlate)
                        remainder[1] = remainder[0] - amount;
               
                for (int calculationIndex = 0; calculationIndex < numberOfCharacterIndexesInNumberPlate; calculationIndex++) {
                        quantityInNumberPlace[calculationIndex] = roundDown(remainder[calculationIndex] / flipppedMinimumNumberPlaceValues[calculationIndex]);
                        amount = flipppedMinimumNumberPlaceValues[calculationIndex] * quantityInNumberPlace[calculationIndex];
                        if(calculationIndex + 1 < numberOfCharacterIndexesInNumberPlate)
                                remainder[calculationIndex + 1] = remainder[calculationIndex] - amount;
                }
        }

        private void assignNumberPlateArrays() {
                generateCombinationAccummulatingTotal();
                generateMaximumNumberPlaceValues();
                generateMinimumNumberPlaceValues();
                generateFlippedMinimumIndexes();
        }

        private void organiseLightAndHeavyVehicleNumberPlateValues() {
                characterIndexesInNumberPlate.append(quantityInNumberPlace[3]).append(quantityInNumberPlace[4]).append(quantityInNumberPlace[5]).append(integerToUpperCaseAlphatbeticalCharacterConversion(quantityInNumberPlace[1])).append(integerToUpperCaseAlphatbeticalCharacterConversion(quantityInNumberPlace[2])).append(quantityInNumberPlace[0]);
        }
   
        private void organiseMotorcycleNumberPlateValues() {
                characterIndexesInNumberPlate.append(quantityInNumberPlace[2]).append(quantityInNumberPlace[3]).append(quantityInNumberPlace[4]).append(integerToUpperCaseAlphatbeticalCharacterConversion(quantityInNumberPlace[0]-1)).append(integerToLowerCaseAlphatbeticalCharacterConversion(quantityInNumberPlace[1]-1));
        }
 
        public String integerToUpperCaseAlphatbeticalCharacterConversion(int number) { 
                String [] result;
                result = new String [] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"}; 
                return result[number]; 
        } 
 
        public String integerToLowerCaseAlphatbeticalCharacterConversion(int number) { 
                String [] result;
                result = new String [] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"}; 
                return result[number]; 
        } 
 
        public String generateLightAndHeavyVehicleNumberPlate() {
                numberOfCharacterIndexesInNumberPlate = 6;
                String numberPlateText;
        
                combinationValues[0] = 10;
                combinationValues[1] = 10;
                combinationValues[2] = 10;
                combinationValues[3] = 26;
                combinationValues[4] = 26;
                combinationValues[5] = 10;
                
                assignNumberPlateArrays();
                generateNumberPlateValues(currentLightAndHeavyVehicleNumberPlate);              
                organiseLightAndHeavyVehicleNumberPlateValues();               
                numberPlateText = characterIndexesInNumberPlate.toString();               
                characterIndexesInNumberPlate.setLength(0);               
                currentLightAndHeavyVehicleNumberPlate++;                
                return numberPlateText;
        }   

        public String generateMotorcycleNumberPlate() {
                numberOfCharacterIndexesInNumberPlate = 5;
                String numberPlateText;

                combinationValues[0] = 10;
                combinationValues[1] = 10;
                combinationValues[2] = 10;
                combinationValues[3] = 26;
                combinationValues[4] = 26;

                assignNumberPlateArrays();
                generateNumberPlateValues(currentMotorcycleNumberPlate);               
                organiseMotorcycleNumberPlateValues();               
                numberPlateText = characterIndexesInNumberPlate.toString();
                
                characterIndexesInNumberPlate.setLength(0);              
                currentMotorcycleNumberPlate++;              
                return numberPlateText;
        } 
 
        private String getNumberPlate() {
                return MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()).getPlateNumber();
        }
 
        private String checkLightAndHeavyVehicleNumberPlate() {
                Vehicle objectTypeValue;
                String currentNumberPlate;
                String generatedNumberPlate;
                objectTypeValue = MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex());
                currentNumberPlate = getNumberPlate();
                generatedNumberPlate = generateLightAndHeavyVehicleNumberPlate();
                
                if(objectTypeValue instanceof LightVehicle || objectTypeValue instanceof HeavyVehicle) {
                        currentLightAndHeavyVehicleNumberPlate--;
                        return currentNumberPlate; 
                }
                else
                        return generatedNumberPlate;
        }
 
        private String checkMotorcycleNumberPlate() {
                String currentNumberPlate;
                String generatedNumberPlate;
                currentNumberPlate = getNumberPlate();
                generatedNumberPlate = generateMotorcycleNumberPlate();
                if(currentNumberPlate.length() == generatedNumberPlate.length()) {
                        currentMotorcycleNumberPlate--;
                        return currentNumberPlate;
                }
                else 
                        return generatedNumberPlate;
        }
 
        private static void clear() {
                resetJComboBox();
                loadCapacityJTextField.setText("");
                numberOfSeatsJTextField.setText("");
                engineCapacityJTextField.setText("");
                makeJTextField.setText("");
                modelJTextField.setText("");
                yearJTextField.setText("");
                ownerIdJComboBox.setSelectedIndex(0);
        }

        private static void resetGUIAndShowNewVehicleHeading() {
                SearchJPanel.newVehicle();
                clear();
        }
 
        private static void resetGUIAndShowEditVehicleHeading() {
                SearchJPanel.editVehicle();
                clear();
        }
 
        public static void resetJComboBox() {
                int selection;
                selection = selectVehicleTypeJComboBox.getSelectedIndex();
                if(getEditMode() == false)
                        selectVehicleTypeJComboBox.setSelectedIndex(0);
                else {
                        selectVehicleTypeJComboBox.setSelectedIndex(0);
                        selectVehicleTypeJComboBox.setSelectedIndex(selection);
                }
        }
 
        private int getNumberOfSeats() {
                numberOfSeats = Integer.parseInt(numberOfSeatsJTextField.getText());
                return numberOfSeats;
        }
 
        public static void setNumberOfSeats() {
                lightVehicleArray.add((LightVehicle) MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()));
                numberOfSeatsJTextField.setText(lightVehicleArray.get(0).getNumberOfSeats() + "");
                lightVehicleArray.remove(0);
        }
 
        private int getLoadCapacity() {
                loadCapacity = Integer.parseInt(loadCapacityJTextField.getText());
                return loadCapacity;
        }
 
        public static void setLoadCapacity() {
                heavyVehicleArray.add((HeavyVehicle) MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()));
                loadCapacityJTextField.setText(heavyVehicleArray.get(0).getLoadCapacity() + "");
                heavyVehicleArray.remove(0);
        }
 
        private double getEngineCapacity() {
                engineCapacity = Double.parseDouble(engineCapacityJTextField.getText());
                return engineCapacity;
        }    
 
        private static void setEngineCapacity() {
                engineCapacityJTextField.setText(MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()).getEngineCapacity() + "");
        } 
 
        private String getMake() {
                make = makeJTextField.getText();
                return make;
        }   
 
        private static void setMake() {
                makeJTextField.setText(MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()).getMake());
        }      
 
        private String getModel() {
                model = modelJTextField.getText();
                return model;
        }
  
        private static void setModel() {
                modelJTextField.setText(MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()).getModel());
        } 
 
        private int getYear() {
                year = Integer.parseInt(yearJTextField.getText());
                return year;
        }
 
        private static void setYear() {
                yearJTextField.setText(MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()).getYear() + "");
        }
  
        private int getOwnerId() {
                ownerId = Integer.parseInt(ownerIdJComboBox.getItemAt(ownerIdJComboBox.getSelectedIndex()));
                return ownerId;
        }     
 
        private int searchForOwnerID(int indexToSearch) {
                ownerIdStringBuilder.setLength(0);
                int vehicleArraySize;
                vehicleArraySize = MotorVehicleRegistrationFrame.vehicleArray.size();
                for (int searchIndex = 0; searchIndex < vehicleArraySize; ++searchIndex)
                        if(indexToSearch == MotorVehicleRegistrationFrame.vehicleArray.get(searchIndex).getOwnerId())
                                ownerIdStringBuilder.append(indexToSearch);
                return ownerIdStringBuilder.length();
        }
 
        private void setOwnerId() {
                int ownerArraySize;
                int vehicleArraySize;
                ownerArraySize = MotorVehicleRegistrationFrame.ownerArray.size();
                vehicleArraySize = MotorVehicleRegistrationFrame.vehicleArray.size();
                AddOwnerIdStartingElements();
                for (int searchIndex = 0; searchIndex < ownerArraySize; ++searchIndex)
                {
                        if(vehicleArraySize == 0)
                                ownerIdJComboBox.addItem(MotorVehicleRegistrationFrame.ownerArray.get(searchIndex).getId() + ""); 
                        else
                        {
                                if(searchForOwnerID(searchIndex) == 0)
                                        ownerIdJComboBox.addItem(MotorVehicleRegistrationFrame.ownerArray.get(searchIndex).getId() + ""); 
                        }
                }
                if(getEditMode() == true)
                        ownerIdJComboBox.setSelectedIndex(OWNER_ID_REFERENCE_INDEX);
        }
 
        private void AddOwnerIdStartingElements() {
                ownerIdJComboBox.removeAllItems();
                if(getEditMode() == false)
                        ownerIdJComboBox.addItem("...");
                else if(getEditMode() == true)
                        ownerIdJComboBox.addItem(MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()).getOwnerId() + "");
        }
 
        private void addMotorcycle() {   
                validateCommonVehicleFields();
                
                if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();

                else {
                        MotorVehicleRegistrationFrame.vehicleArray.add( new Motorcycle (generateMotorcycleNumberPlate(), getEngineCapacity(), getMake(), getModel(), getYear(), getOwnerId()));
                        resetGUIAndShowNewVehicleHeading();
                        return;
                }
	}
 
        private void addLightVehicle() {   
                validateNumberOfSeatsField();
                validateCommonVehicleFields();
                
                if(getNumberOfSeatsFieldObjectJComponentContainer() != null && getNumberOfSeatsErrorDialogStringBuilder().length() > 0)
                        generateNumberOfSeatsFieldDataValidationErrorDialog();
                
                else if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();

                else {
                        MotorVehicleRegistrationFrame.vehicleArray.add( new LightVehicle (generateLightAndHeavyVehicleNumberPlate(), getNumberOfSeats(), getEngineCapacity(), getMake(), getModel(), getYear(), getOwnerId()));
                        resetGUIAndShowNewVehicleHeading();
                        return;
                }

	}
 
        private void addHeavyVehicle() {   
                validateLoadCapacityField();
                validateCommonVehicleFields();
                
                if(getLoadCapacityFieldObjectJComponentContainer() != null && getLoadCapacityErrorDialogStringBuilder().length() > 0)
                        generateLoadCapacityFieldDataValidationErrorDialog();
                
                else if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();

                else {
                        MotorVehicleRegistrationFrame.vehicleArray.add( new HeavyVehicle (generateLightAndHeavyVehicleNumberPlate(), getLoadCapacity(), getEngineCapacity(), getMake(), getModel(), getYear(), getOwnerId()));
                        resetGUIAndShowNewVehicleHeading();
                        return;
                }
	}
 
        private static void setCommonFields() {
                VehicleJPanel.setEngineCapacity();
                VehicleJPanel.setMake();
                VehicleJPanel.setModel();
                VehicleJPanel.setYear();
        }
  
        private static void setMotorcycleFields() {
                selectVehicleTypeJComboBox.setSelectedIndex(MOTORCYCLE);
        }
 
        private static void setLightVehicleFields() {
                VehicleJPanel.setNumberOfSeats();
                selectVehicleTypeJComboBox.setSelectedIndex(LIGHT_VEHICLE);
        }
  
        private static void setHeavyVehicleFields() {
                VehicleJPanel.setLoadCapacity();
                selectVehicleTypeJComboBox.setSelectedIndex(HEAVY_VEHICLE);
        }
 
        private static void setFieldsBasedOnVehicleObjctType() {
                Vehicle objectTypeValue;
                objectTypeValue = MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex());
                setCommonFields();
                
                if(objectTypeValue instanceof Motorcycle)
                        setMotorcycleFields(); 
                else if(objectTypeValue instanceof LightVehicle)
                        setLightVehicleFields();
                else
                        setHeavyVehicleFields();
        }
 
        public static void editMode() {
                vehicleJLabel.setText("Edit Owner");
                enterVehicleDetailsJLabel.setText("Edit Owner Details");
                vehicleJButton.setText("Accept Changes");
                addModeJButton.setVisible(true);
                editMode = true;
                MotorVehicleRegistrationFrame.resetVehiclePanelJComboBox();
                MotorVehicleRegistrationFrame.showEditVehicleTab();
                setFieldsBasedOnVehicleObjctType();
        }
 
        public static boolean getEditMode() {
            return editMode;
        }
 
        private static void addMode() {
                vehicleJLabel.setText("Add Vehicle");
                enterVehicleDetailsJLabel.setText("Enter Vehicle Details");
                vehicleJButton.setText("Add Vehicle");
                addModeJButton.setVisible(false);
                editMode = false;
                clear();
                MotorVehicleRegistrationFrame.showAddVehicleTab();
                MotorVehicleRegistrationFrame.showSearchTab();
                SearchJPanel.resetSearchAndReferenceIndexes();
        }
 
        private void acceptChangesMotorcycle() { 
                validateCommonVehicleFields();
                
                if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();
                
                else {
                        MotorVehicleRegistrationFrame.vehicleArray.set(SearchJPanel.getVehicleSearchReferenceIndex(), new Motorcycle (checkMotorcycleNumberPlate(), getEngineCapacity(), getMake(), getModel(), getYear(), getOwnerId()));
                        resetGUIAndShowEditVehicleHeading();
                        addMode();
                }
	}

        private void acceptChangesLightVehicle() { 
                validateNumberOfSeatsField();
                validateCommonVehicleFields();
                        
                if(getNumberOfSeatsFieldObjectJComponentContainer() != null && getNumberOfSeatsErrorDialogStringBuilder().length() > 0)
                        generateNumberOfSeatsFieldDataValidationErrorDialog();
                
                else if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();
                
                else {
                        MotorVehicleRegistrationFrame.vehicleArray.set(SearchJPanel.getVehicleSearchReferenceIndex(), new LightVehicle (checkLightAndHeavyVehicleNumberPlate(), getNumberOfSeats(), getEngineCapacity(), getMake(), getModel(), getYear(), getOwnerId()));
                        resetGUIAndShowEditVehicleHeading();
                        addMode();
                }
	}
 
        private void acceptChangesHeavyVehicle() { 
                validateLoadCapacityField();
                validateCommonVehicleFields();
                        
                if(getLoadCapacityFieldObjectJComponentContainer() != null && getLoadCapacityErrorDialogStringBuilder().length() > 0)
                        generateLoadCapacityFieldDataValidationErrorDialog();
                
                else if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();
                
                else {
                        MotorVehicleRegistrationFrame.vehicleArray.set(SearchJPanel.getVehicleSearchReferenceIndex(), new HeavyVehicle (checkLightAndHeavyVehicleNumberPlate(), getLoadCapacity(), getEngineCapacity(), getMake(), getModel(), getYear(), getOwnerId()));
                        resetGUIAndShowEditVehicleHeading();
                        addMode();
                }
	}
 
        @Override
        public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                Object source = e.getSource();

                if(command.equals("Add Vehicle")) {
                        if(selectVehicleTypeJComboBox.getSelectedIndex() == MOTORCYCLE) {
                               addMotorcycle();
                        }
                   
                        if(selectVehicleTypeJComboBox.getSelectedIndex() == LIGHT_VEHICLE) {
                               addLightVehicle();
                        }
                       
                        if(selectVehicleTypeJComboBox.getSelectedIndex() == HEAVY_VEHICLE) {
                               addHeavyVehicle();
                        }
                } 
                
                if(command.equals("Accept Changes")) {
                        if(selectVehicleTypeJComboBox.getSelectedIndex() == MOTORCYCLE) {
                               acceptChangesMotorcycle();
                        }
                   
                        if(selectVehicleTypeJComboBox.getSelectedIndex() == LIGHT_VEHICLE) {
                               acceptChangesLightVehicle();
                        }
                       
                        if(selectVehicleTypeJComboBox.getSelectedIndex() == HEAVY_VEHICLE) {
                               acceptChangesHeavyVehicle();
                        }
                } 
                
                else if(source == addModeJButton) {
                        generateConfirmDialog("You are currently in edit mode, would you like to return to the add mode?\n\n"
                                + "No further edits can be performed if you return to add mode.");
                        if(confirmDialogResponse == JOptionPane.YES_OPTION)
                                addMode();
                        else
                                return;
                }
                
                else if(source == clearJButton) {
                        generateConfirmDialog("Are you sure you wish to clear text from the fields in this tab?");
                        if(confirmDialogResponse == JOptionPane.YES_OPTION)
                                clear();
                        else
                            return;
                }
        }
 
        @Override
        public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
                
                if(source == selectVehicleTypeJComboBox)
                {
                        setOwnerId();
                        SelectVehicleType();
                }
        }
                
} // End of VEHICLE JPANEL

