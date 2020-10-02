/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.BASELINE;

public class OwnerJPanel extends JPanel implements ActionListener, ItemListener {
        private final int NO_OWNER_SELECTED;
        private static final int CORPORATE_OWNER = 1;
        private static final int PRIVATE_OWNER = 2;
         
        private final int BUTTON_WIDTH;
        private final int BORDER_GAP;
        private final int FIELD_HORIZONTAL_GAP;
        private final int FIELD_VERTICAL_GAP;
        private final int LARGE_FIELD_VERTICAL_GAP;
        private final int JEXTFIELD_COLUMN_WIDTH;
         
        private int confirmDialogResponse;
         
        private int licenseNumber;
         
        public static boolean editMode;
         
        private String firstName;
        private String lastName;
        private String address;
        private String phoneNumber;
         
        private String [] selectOwnerTypeJComboBoxList;
         
        private String [] digits;
         
        private StringBuilder numberFinderStringBuilder;
         
        private final int MAX_DATE_OF_BIRTH_PANELS;
        private static int currentDateOfBirthJPanel;
        private static DateOfBirthJPanel [] dateOfBirthArray;
        
        private final int MAX_ABN_PANELS;
        private static int currentABNJPanel;
        private static ABNJPanel [] aBNArray;
         
        private final String PROGRAM_TITLE;
         
        private JComponent commonFieldObjectJComponentContainer;
        private StringBuilder commonErrorDialogStringBuilder;
        private JComponent dateOfBirthFieldObjectJComponentContainer;
        private StringBuilder dateOfBirthErrorDialogStringBuilder;
        private JComponent aBNFieldObjectJComponentContainer;
        private StringBuilder aBNErrorDialogStringBuilder;
         
        private final Font NORMAL_FONT_STYLE;
        private final Font HEADINGTWO_FONT_STYLE;
         
        private final Color WHITE_COLOUR;
         
        private JPanel ownerJPanel;
         
        private static JLabel ownerJLabel;
         
        private JLabel selectOwnerTypeJLabel;
        private static JComboBox<String> selectOwnerTypeJComboBox;
         
        private static JLabel enterOwnerDetailsJLabel;
        private JLabel aBNJLabel; 
        private JLabel dateOfBirthJLabel;
        private JLabel firstNameJLabel;
        private JLabel lastNameJLabel;
        private JLabel addressJLabel;
        private JLabel phoneNumberJLabel;
        //JLables for the GUI
 
        private static JTextField firstNameJTextField;
        private static JTextField lastNameJTextField;
        private static JTextArea addressJTextArea;
        private JScrollPane addressScrollPane;
        private static JTextField phoneNumberJTextField;
        
        private static JButton ownerJButton;
        private static JButton addModeJButton;
        private JButton clearJButton;
        // Declared the 'JButtons' for the frame
        
        private GroupLayout ownerLayout;
        
        public OwnerJPanel() {
                NO_OWNER_SELECTED = 0;
                BUTTON_WIDTH = 130;
                BORDER_GAP = 12;
                FIELD_HORIZONTAL_GAP = 18;
                FIELD_VERTICAL_GAP = 5;
                LARGE_FIELD_VERTICAL_GAP = 24;
                JEXTFIELD_COLUMN_WIDTH = 40;
                confirmDialogResponse = 0;
                licenseNumber = 0;
                editMode = false;
                
                selectOwnerTypeJComboBoxList = new String [] {"...", "Corporate", "Private"}; 
                digits = new String [] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
                MAX_DATE_OF_BIRTH_PANELS = 1;
                currentDateOfBirthJPanel = 0;
                dateOfBirthArray = new DateOfBirthJPanel[MAX_DATE_OF_BIRTH_PANELS];
                
                MAX_ABN_PANELS = 1;
                currentABNJPanel = 0;
                aBNArray = new ABNJPanel[MAX_ABN_PANELS];  
                
                numberFinderStringBuilder = new StringBuilder();
                commonErrorDialogStringBuilder = new StringBuilder();
                aBNErrorDialogStringBuilder = new StringBuilder();
                dateOfBirthErrorDialogStringBuilder = new StringBuilder();
                
                PROGRAM_TITLE = "Motor Vehicle Registration Application";               
                NORMAL_FONT_STYLE = new Font("Arial", 4, 12);
                HEADINGTWO_FONT_STYLE = new Font("Arial", 1, 14);               
                WHITE_COLOUR = new Color(255,255,255);
                
                ownerJPanel = new JPanel();              
                ownerJLabel = new JLabel("Add Owner");
                selectOwnerTypeJLabel = new JLabel("Select owner type: ");
                enterOwnerDetailsJLabel = new JLabel("Enter Owner Details");
                
                aBNJLabel = new JLabel("ABN: ");
                dateOfBirthJLabel = new JLabel("Date of Birth: ");
                dateOfBirthArray[currentDateOfBirthJPanel] = new DateOfBirthJPanel();
                firstNameJLabel = new JLabel("First Name: ");
                lastNameJLabel = new JLabel("Last Name: ");
                addressJLabel = new JLabel("Address: ");
                phoneNumberJLabel = new JLabel("Phone Number: ");
                
                selectOwnerTypeJComboBox = new JComboBox<>(selectOwnerTypeJComboBoxList);
                selectOwnerTypeJComboBox.setBackground(WHITE_COLOUR);
                aBNArray[currentABNJPanel] = new ABNJPanel();
                firstNameJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);
                lastNameJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);
                addressJTextArea = new JTextArea(null, "", 6, 5);
                
                addressScrollPane = new JScrollPane(addressJTextArea);
                addressScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                addressScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                phoneNumberJTextField = new JTextField(JEXTFIELD_COLUMN_WIDTH);  
                
                ownerJButton = new JButton("Add Owner");
                addModeJButton = new JButton("Add Mode");
                clearJButton = new JButton("Clear");                
                addModeJButton.setVisible(false);
                
                setFontStyles();               
                ownerLayout = new GroupLayout(ownerJPanel);
                setLayout();
                setActionListeners();
                setEntryAreaInvisible();
        }

        private void setFontStyles() {
                ownerJLabel.setFont(HEADINGTWO_FONT_STYLE);
                selectOwnerTypeJLabel.setFont(NORMAL_FONT_STYLE);
                enterOwnerDetailsJLabel.setFont(HEADINGTWO_FONT_STYLE);
                aBNJLabel.setFont(NORMAL_FONT_STYLE);
                dateOfBirthJLabel.setFont(NORMAL_FONT_STYLE);
                firstNameJLabel.setFont(NORMAL_FONT_STYLE);
                lastNameJLabel.setFont(NORMAL_FONT_STYLE);
                addressJLabel.setFont(NORMAL_FONT_STYLE);
                phoneNumberJLabel.setFont(NORMAL_FONT_STYLE);
                selectOwnerTypeJComboBox.setFont(NORMAL_FONT_STYLE);
                firstNameJTextField.setFont(NORMAL_FONT_STYLE);
                lastNameJTextField.setFont(NORMAL_FONT_STYLE);
                addressJTextArea.setFont(NORMAL_FONT_STYLE);
                phoneNumberJTextField.setFont(NORMAL_FONT_STYLE);
                ownerJButton.setFont(NORMAL_FONT_STYLE);
                addModeJButton.setFont(NORMAL_FONT_STYLE);
                clearJButton.setFont(NORMAL_FONT_STYLE);
        }

        private void setActionListeners() {
                selectOwnerTypeJComboBox.addItemListener(this);
                ownerJButton.addActionListener(this);
                addModeJButton.addActionListener(this);
                clearJButton.addActionListener(this);
        }

        private void setLayout() {
                setLayout(new BorderLayout());
                add(ownerJPanel);
                ownerJPanel.setLayout(ownerLayout);

                ownerLayout.setHorizontalGroup(ownerLayout.createSequentialGroup()
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP)
                                .addGroup(ownerLayout.createSequentialGroup()
                                .addGroup(ownerLayout.createParallelGroup()
                                        .addComponent(ownerJButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addModeJButton, GroupLayout.Alignment.CENTER, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearJButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                .addGroup(ownerLayout.createSequentialGroup()
                                .addGroup(ownerLayout.createParallelGroup()
                                        .addComponent(ownerJLabel)
                                        .addComponent(selectOwnerTypeJLabel)
                                        .addComponent(enterOwnerDetailsJLabel)
                                        .addComponent(aBNJLabel)
                                        .addComponent(dateOfBirthJLabel)
                                        .addComponent(firstNameJLabel)
                                        .addComponent(lastNameJLabel)
                                        .addComponent(addressJLabel)
                                        .addComponent(phoneNumberJLabel))
                                .addGap(FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP)
                                        .addGroup(ownerLayout.createSequentialGroup()
                                        .addGroup(ownerLayout.createParallelGroup()
                                                .addComponent(selectOwnerTypeJComboBox)
                                                .addComponent(aBNArray[currentABNJPanel])
                                                .addComponent(dateOfBirthArray[currentDateOfBirthJPanel])
                                                .addComponent(firstNameJTextField)
                                                .addComponent(lastNameJTextField)
                                                .addComponent(addressScrollPane)
                                                .addComponent(phoneNumberJTextField))))))
                                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP));
                
                ownerLayout.setVerticalGroup(ownerLayout.createSequentialGroup()
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP)
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(ownerJLabel))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(selectOwnerTypeJLabel)
                                .addComponent(selectOwnerTypeJComboBox))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(enterOwnerDetailsJLabel))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(aBNJLabel)
                                .addComponent(aBNArray[currentABNJPanel]))
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(dateOfBirthJLabel, GroupLayout.Alignment.CENTER)
                                .addComponent(dateOfBirthArray[currentDateOfBirthJPanel]))
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(firstNameJLabel)
                                .addComponent(firstNameJTextField))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(lastNameJLabel)
                                .addComponent(lastNameJTextField))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(addressJLabel)
                                .addComponent(addressScrollPane))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(phoneNumberJLabel)
                                .addComponent(phoneNumberJTextField))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(ownerLayout.createSequentialGroup()
                        .addGroup(ownerLayout.createParallelGroup(BASELINE)
                                .addComponent(ownerJButton)
                                .addComponent(addModeJButton)
                                .addComponent(clearJButton))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)))))))))))
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP));
        }

        private void setCommonFieldsVisible() {
                enterOwnerDetailsJLabel.setVisible(true);
                firstNameJLabel.setVisible(true);
                firstNameJTextField.setVisible(true);
                lastNameJLabel.setVisible(true);
                lastNameJTextField.setVisible(true);
                addressJLabel.setVisible(true);
                addressScrollPane.setVisible(true);
                phoneNumberJLabel.setVisible(true);
                phoneNumberJTextField.setVisible(true);
                ownerJButton.setVisible(true);
                clearJButton.setVisible(true);   
                if(getEditMode() == true)
                        addModeJButton.setVisible(true);
        }

        private void setCommonFieldsInvisible() {
                enterOwnerDetailsJLabel.setVisible(false);
                firstNameJLabel.setVisible(false);
                firstNameJTextField.setVisible(false);
                lastNameJLabel.setVisible(false);
                lastNameJTextField.setVisible(false);
                addressJLabel.setVisible(false);
                addressScrollPane.setVisible(false);
                phoneNumberJLabel.setVisible(false);
                phoneNumberJTextField.setVisible(false);
                ownerJButton.setVisible(false);
                clearJButton.setVisible(false);   
                addModeJButton.setVisible(false);
        }

        private void setCorporateOwnerFieldsInvisible() {
                aBNJLabel.setVisible(false);
                aBNArray[currentABNJPanel].setVisible(false);
        }

        private void setPrivateOwnerFieldsInvisible() {
                dateOfBirthJLabel.setVisible(false);
                dateOfBirthArray[currentDateOfBirthJPanel].setVisible(false); 
        }

        private void setEntryAreaInvisible() {
                setCommonFieldsInvisible(); 
                setCorporateOwnerFieldsInvisible();
                setPrivateOwnerFieldsInvisible();
        }

        private void SelectOwnerType() {
                if(selectOwnerTypeJComboBox.getSelectedIndex() == NO_OWNER_SELECTED) {
                        setEntryAreaInvisible();           
                }

                if(selectOwnerTypeJComboBox.getSelectedIndex() == CORPORATE_OWNER) {
                        setCommonFieldsVisible(); 
                        aBNJLabel.setVisible(true);
                        aBNArray[currentABNJPanel].setVisible(true);
                        setPrivateOwnerFieldsInvisible();
                }
                                
                if(selectOwnerTypeJComboBox.getSelectedIndex() == PRIVATE_OWNER) {
                        setCommonFieldsVisible(); 
                        setCorporateOwnerFieldsInvisible();
                        dateOfBirthJLabel.setVisible(true);
                        dateOfBirthArray[currentDateOfBirthJPanel].setVisible(true);
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

        private void generateDateOfBirthFieldDataValidationErrorDialog()  {
                generateDataValidationErrorDialog(dateOfBirthFieldObjectJComponentContainer, dateOfBirthErrorDialogStringBuilder.toString()); 
        }

        private void generateABNFieldDataValidationErrorDialog() {
                generateDataValidationErrorDialog(aBNFieldObjectJComponentContainer, aBNErrorDialogStringBuilder.toString()); 
        }

        private void generateCommonFieldDataValidationErrorDialog() {
                generateDataValidationErrorDialog(commonFieldObjectJComponentContainer, commonErrorDialogStringBuilder.toString()); 
        }

        private StringBuilder findNumbersInText(JTextField fieldObject) {
                numberFinderStringBuilder.setLength(0);

                for(int numberIndex = 0; numberIndex < digits.length; numberIndex++) {
                        if(fieldObject.getText().contains(digits[numberIndex]))  {
                                numberFinderStringBuilder.append(digits[numberIndex]);     
                        }       
                }
                return numberFinderStringBuilder;
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

        private void validateCommonOwnerFields() {
                
                commonFieldObjectJComponentContainer = null;
                commonErrorDialogStringBuilder.setLength(0);
                if(firstNameJTextField.getText().compareTo("") == 0) {
                        addCommonFieldObjectToJComponentContainer(firstNameJTextField);
                        addCommonErrorDialogToStringBuilder("You must enter a first name");
                }
                
                else if(findNumbersInText(firstNameJTextField).length() > 0) {
                        addCommonFieldObjectToJComponentContainer(firstNameJTextField);
                        addCommonErrorDialogToStringBuilder("The first name must not contain a number");
                }
                
                else if(lastNameJTextField.getText().compareTo("") == 0) {
                        addCommonFieldObjectToJComponentContainer(lastNameJTextField);
                        addCommonErrorDialogToStringBuilder("You must enter a last name");
                }
                                    
                else if(findNumbersInText(lastNameJTextField).length() > 0) {
                        addCommonFieldObjectToJComponentContainer(lastNameJTextField);
                        addCommonErrorDialogToStringBuilder("The last name must not contain a number");
                }
                
                else if(addressJTextArea.getText().compareTo("") == 0) {
                        addCommonFieldObjectToJComponentContainer(addressJTextArea);
                        addCommonErrorDialogToStringBuilder("You must enter an address");
                }

                else if(phoneNumberJTextField.getText().compareTo("") == 0) {
                        addCommonFieldObjectToJComponentContainer(phoneNumberJTextField);
                        addCommonErrorDialogToStringBuilder("You must enter a phone number");
                }
        }

        private JComponent getDateOfBirthFieldObjectJComponentContainer() {
                return dateOfBirthFieldObjectJComponentContainer;
        }
 
        private JComponent addDateOfBirthFieldObjectToJComponentContainer(JComponent fieldObject) {
                if(dateOfBirthFieldObjectJComponentContainer == null) {
                        dateOfBirthFieldObjectJComponentContainer = fieldObject;
                }
                return dateOfBirthFieldObjectJComponentContainer;
        }
 
        private StringBuilder getDateOfBirthErrorDialogStringBuilder() {
                return dateOfBirthErrorDialogStringBuilder;
        }
  
        private StringBuilder addDateOfBirthErrorDialogToStringBuilder(String errorDialog) {
                if(dateOfBirthErrorDialogStringBuilder.length() == 0) {
                        dateOfBirthErrorDialogStringBuilder.append(errorDialog);
                }               
                return dateOfBirthErrorDialogStringBuilder;
        }
 
        private void validateDateOfBirthField() {
                dateOfBirthFieldObjectJComponentContainer = null;
                dateOfBirthErrorDialogStringBuilder.setLength(0);
                
                if(dateOfBirthArray[currentDateOfBirthJPanel].dateOfBirthDayIndexSelected() == 0)  {
                        addDateOfBirthFieldObjectToJComponentContainer(dateOfBirthArray[currentDateOfBirthJPanel].getDateOfBirthDayJComboBox());
                        addDateOfBirthErrorDialogToStringBuilder("You must enter a day of birth");
                }
            
                else if(dateOfBirthArray[currentDateOfBirthJPanel].dateOfBirthMonthIndexSelected() == 0) {
                        addDateOfBirthFieldObjectToJComponentContainer(dateOfBirthArray[currentDateOfBirthJPanel].getDateOfBirthMonthJComboBox());
                        addDateOfBirthErrorDialogToStringBuilder("You must enter a month of birth");
                }
                
                if(dateOfBirthArray[currentDateOfBirthJPanel].dateOfBirthYearIndexSelected() == 0)  {
                        addDateOfBirthFieldObjectToJComponentContainer(dateOfBirthArray[currentDateOfBirthJPanel].getDateOfBirthYearJComboBox());
                        addDateOfBirthErrorDialogToStringBuilder("You must enter a year of birth");
                }
        }
 
        private JComponent getABNFieldObjectJComponentContainer()  {
                return aBNFieldObjectJComponentContainer;
        }
 
        private JComponent addABNFieldObjectToJComponentContainer(JComponent fieldObject) {
                if(aBNFieldObjectJComponentContainer == null)  {
                        aBNFieldObjectJComponentContainer = fieldObject;
                }
                return aBNFieldObjectJComponentContainer;
        }
 
        private StringBuilder getABNErrorDialogStringBuilder() {
                return aBNErrorDialogStringBuilder;
        }
 
        private StringBuilder addABNErrorDialogToStringBuilder(String errorDialog) {
                if(aBNErrorDialogStringBuilder.length() == 0) {
                        aBNErrorDialogStringBuilder.append(errorDialog);
                }               
                return aBNErrorDialogStringBuilder;
        }
 
        private void validateABNField() {
                aBNFieldObjectJComponentContainer = null;
                aBNErrorDialogStringBuilder.setLength(0);
                int aBNInteger;
                aBNInteger = 0;
                
                if(aBNArray[currentABNJPanel].getFirstABNJTextFieldText().length() != 2) {
                        addABNFieldObjectToJComponentContainer(aBNArray[currentABNJPanel].getFirstABNJTextField());
                        addABNErrorDialogToStringBuilder("The first ABN box should contain two digits");
                }
            
                try {
                        aBNInteger = Integer.parseInt(aBNArray[currentABNJPanel].getFirstABNJTextFieldText());
                }
                
                catch(NumberFormatException e) {
                        addABNFieldObjectToJComponentContainer(aBNArray[currentABNJPanel].getFirstABNJTextField());
                        addABNErrorDialogToStringBuilder("The first ABN box should contain two digits");
                }
                
                if(aBNArray[currentABNJPanel].getSecondABNJTextFieldText().length() != 3) {
                        addABNFieldObjectToJComponentContainer(aBNArray[currentABNJPanel].getSecondABNJTextField());
                        addABNErrorDialogToStringBuilder("The second ABN box should contain three digits");
                }
            
                try  {
                        aBNInteger = Integer.parseInt(aBNArray[currentABNJPanel].getSecondABNJTextFieldText());
                }
                
                catch(NumberFormatException e)  {
                        addABNFieldObjectToJComponentContainer(aBNArray[currentABNJPanel].getSecondABNJTextField());
                        addABNErrorDialogToStringBuilder("The second ABN box should contain three digits");
                }
                
                if(aBNArray[currentABNJPanel].getThirdABNJTextFieldText().length() != 3)  {
                        addABNFieldObjectToJComponentContainer(aBNArray[currentABNJPanel].getThirdABNJTextField());
                        addABNErrorDialogToStringBuilder("The third ABN box should contain three digits");
                }
            
                try {
                        aBNInteger = Integer.parseInt(aBNArray[currentABNJPanel].getThirdABNJTextFieldText());
                }
                
                catch(NumberFormatException e)  {
                        addABNFieldObjectToJComponentContainer(aBNArray[currentABNJPanel].getThirdABNJTextField());
                        addABNErrorDialogToStringBuilder("The third ABN box should contain three digits");
                }
                
                if(aBNArray[currentABNJPanel].getFourthABNJTextFieldText().length() != 3) {
                        addABNFieldObjectToJComponentContainer(aBNArray[currentABNJPanel].getFourthABNJTextField());
                        addABNErrorDialogToStringBuilder("The fourth ABN box should contain three digits");
                }
            
                try  {
                        aBNInteger = Integer.parseInt(aBNArray[currentABNJPanel].getFourthABNJTextFieldText());
                }
                
                catch(NumberFormatException e) {
                        addABNFieldObjectToJComponentContainer(aBNArray[currentABNJPanel].getFourthABNJTextField());
                        addABNErrorDialogToStringBuilder("The fourth ABN box should contain three digits");
                }
        }
 
        public static void resetJComboBox() {
                selectOwnerTypeJComboBox.setSelectedIndex(0);
        }

        private static void clear() {
                resetJComboBox();
                aBNArray[currentABNJPanel].resetABNJTextFields();
                dateOfBirthArray[currentDateOfBirthJPanel].resetDateOfBirthJComboBoxes();
                firstNameJTextField.setText("");
                lastNameJTextField.setText("");
                addressJTextArea.setText("");
                phoneNumberJTextField.setText("");
        }
 
        private static void resetGUI() {
                clear();
                MotorVehicleRegistrationFrame.resetJComboBoxes();
        }
 
        private static void resetGUIAndShowNewOwnerHeading() {
                SearchJPanel.newOwner();
                resetGUI();
        }
   
        private static void resetGUIAndShowEditOwnerHeading() {
                SearchJPanel.editOwner();
                resetGUI();
        }
 
        private int generateNewLicenseNumber() {
                    int license = licenseNumber;
                    licenseNumber++;
                    return license;
        }
       
        private String calculateDateOfBirth()  {
                String day;
                String month;
                String year;
                
                day = dateOfBirthArray[currentDateOfBirthJPanel].getDay();
                month = dateOfBirthArray[currentDateOfBirthJPanel].getMonth();
                year = dateOfBirthArray[currentDateOfBirthJPanel].getYear();
                
                return day + "/" + month + "/" + year;
        }
 
        private String calculateABN() {
                String aBNText;
                
                aBNText = aBNArray[currentABNJPanel].getFirstABNJTextFieldText() + " " + aBNArray[currentABNJPanel].getSecondABNJTextFieldText() + " " + aBNArray[currentABNJPanel].getThirdABNJTextFieldText() + " " + aBNArray[currentABNJPanel].getFourthABNJTextFieldText();
                
                return aBNText;
        }
 
        private String getFirstName()  {
                firstName = firstNameJTextField.getText();
                return firstName;
        }   
 
        private static void setFirstName() {
                firstNameJTextField.setText(MotorVehicleRegistrationFrame.ownerArray.get(SearchJPanel.getOwnerSearchReferenceIndex()).getFirstName());
        } 
 
        private String getLastName() {
                lastName = lastNameJTextField.getText();
                return lastName;
        }  
   
        private static void setLastName() {
                lastNameJTextField.setText(MotorVehicleRegistrationFrame.ownerArray.get(SearchJPanel.getOwnerSearchReferenceIndex()).getLastName());
        } 
 
        private String getAddress()  {
                address = addressJTextArea.getText();
                return address;
        }     
   
        private static void setAddress() {
                addressJTextArea.setText(MotorVehicleRegistrationFrame.ownerArray.get(SearchJPanel.getOwnerSearchReferenceIndex()).getAddress());
        } 
  
        private String getPhoneNumber() {
                phoneNumber = phoneNumberJTextField.getText();
                return phoneNumber;
        }  
  
        private static void setPhoneNumber()  {
                phoneNumberJTextField.setText(MotorVehicleRegistrationFrame.ownerArray.get(SearchJPanel.getOwnerSearchReferenceIndex()).getPhoneNumber());
        } 
  
        private void addPrivateOwner() {   
                validateCommonOwnerFields();
                validateDateOfBirthField();

                if(getDateOfBirthFieldObjectJComponentContainer() != null && getDateOfBirthErrorDialogStringBuilder().length() > 0)
                        generateDateOfBirthFieldDataValidationErrorDialog();
                
                else if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();

                else {
                        MotorVehicleRegistrationFrame.ownerArray.add( new PrivateOwner (generateNewLicenseNumber(), calculateDateOfBirth(), getFirstName(), getLastName(), getAddress(), getPhoneNumber()));
                        resetGUIAndShowNewOwnerHeading();
                }
	}
 
        private void addCorporateOwner() {   
                validateABNField();
                validateCommonOwnerFields();
                
                if(getABNFieldObjectJComponentContainer() != null && getABNErrorDialogStringBuilder().length() > 0)
                        generateABNFieldDataValidationErrorDialog();

                else if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();

                else {
                        MotorVehicleRegistrationFrame.ownerArray.add( new CorporateOwner (generateNewLicenseNumber(), calculateABN(), getFirstName(), getLastName(), getAddress(), getPhoneNumber()));
                        resetGUIAndShowNewOwnerHeading();
                }
	}
 
        private static void setCommonFields() {
                OwnerJPanel.setFirstName();
                OwnerJPanel.setLastName();
                OwnerJPanel.setAddress();
                OwnerJPanel.setPhoneNumber();
        }
  
        private static void setCorporateOwnerFields() {
                ABNJPanel.setABN();
                selectOwnerTypeJComboBox.setSelectedIndex(CORPORATE_OWNER);
        }
 
        private static void setPrivateOwnerFields() {
                DateOfBirthJPanel.setDateOfBirth();
                selectOwnerTypeJComboBox.setSelectedIndex(PRIVATE_OWNER);
        }
 
        private static void setFieldsBasedOnOwnerObjctType() {
                Owner objectTypeValue;
                objectTypeValue = MotorVehicleRegistrationFrame.ownerArray.get(SearchJPanel.getOwnerSearchReferenceIndex());
                
                setCommonFields();
                
                if(objectTypeValue instanceof CorporateOwner)
                        setCorporateOwnerFields(); 
                else
                        setPrivateOwnerFields();
        }
 
        public static void editMode() {
                ownerJLabel.setText("Edit Owner");
                enterOwnerDetailsJLabel.setText("Edit Owner Details");
                ownerJButton.setText("Accept Changes");
                addModeJButton.setVisible(true);
                editMode = true;
                MotorVehicleRegistrationFrame.showEditOwnerTab();
                setFieldsBasedOnOwnerObjctType();
        }
 
        public static boolean getEditMode() {
            return editMode;
        }
 
        private static void addMode()  {
                ownerJLabel.setText("Add Owner");
                enterOwnerDetailsJLabel.setText("Enter Owner Details");
                ownerJButton.setText("Add Owner");
                addModeJButton.setVisible(false);
                editMode = false;
                
                clear();
                MotorVehicleRegistrationFrame.showAddOwnerTab();
                MotorVehicleRegistrationFrame.showSearchTab();
                SearchJPanel.resetSearchAndReferenceIndexes();
        }
 
        private int getLicenseNumber() {
                return MotorVehicleRegistrationFrame.ownerArray.get(SearchJPanel.getOwnerSearchReferenceIndex()).getId();
        }
 
        private void acceptChangesPrivateOwner() { 
                validateDateOfBirthField();
                validateCommonOwnerFields();
                        
                if(getDateOfBirthFieldObjectJComponentContainer() != null && getDateOfBirthErrorDialogStringBuilder().length() > 0)
                        generateDateOfBirthFieldDataValidationErrorDialog();
                
                else if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();
                
                else {
                        MotorVehicleRegistrationFrame.ownerArray.set(SearchJPanel.getOwnerSearchReferenceIndex(), new PrivateOwner (getLicenseNumber(), calculateDateOfBirth(), getFirstName(), getLastName(), getAddress(), getPhoneNumber()));
                        resetGUIAndShowEditOwnerHeading();
                        addMode();
                }
	}
 
        private void acceptChangesCorporateOwner() { 
                validateABNField();
                validateCommonOwnerFields();
                        
                if(getABNFieldObjectJComponentContainer() != null && getABNErrorDialogStringBuilder().length() > 0)
                        generateABNFieldDataValidationErrorDialog();
                
                else if(getCommonFieldObjectJComponentContainer() != null && getCommonErrorDialogStringBuilder().length() > 0)
                        generateCommonFieldDataValidationErrorDialog();
                
                else {
                        MotorVehicleRegistrationFrame.ownerArray.set(SearchJPanel.getOwnerSearchReferenceIndex(), new CorporateOwner (getLicenseNumber(), calculateABN(), getFirstName(), getLastName(), getAddress(), getPhoneNumber()));
                        resetGUIAndShowEditOwnerHeading();
                        addMode();
                }
	}
 
        @Override
        public void itemStateChanged(ItemEvent e) {
                Object source = e.getSource();

                if(source == selectOwnerTypeJComboBox)
                        SelectOwnerType();
        }
 
        @Override
        public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                Object source = e.getSource();

                if(command.equals("Add Owner")) {
                        if(selectOwnerTypeJComboBox.getSelectedIndex() == CORPORATE_OWNER) {
                                addCorporateOwner();
                        }
                   
                        else if(selectOwnerTypeJComboBox.getSelectedIndex() == PRIVATE_OWNER) {
                                addPrivateOwner();
                        }
                } 
                
                if(command.equals("Accept Changes")) {
                        if(selectOwnerTypeJComboBox.getSelectedIndex() == CORPORATE_OWNER) {
                                acceptChangesCorporateOwner();
                        }
                    
                        else if(selectOwnerTypeJComboBox.getSelectedIndex() == PRIVATE_OWNER)  {
                                acceptChangesPrivateOwner();
                        }
                } 
                
                else if(source == addModeJButton) {
                        generateConfirmDialog("You have selected edit mode, would you like to return to add mode?\n\n"
                        + "There are no further edits that are able to be completed if you return to add mode");
                        
                        if(confirmDialogResponse == JOptionPane.YES_OPTION)
                                addMode();
                        else
                                return;
                }
                
                else if(source == clearJButton) {
                        generateConfirmDialog("Are you sure you wish to clear text from the fields in this option?");
                        if(confirmDialogResponse == JOptionPane.YES_OPTION)
                                clear();
                        else
                                return;
                }
        }               
} //End of OWNERJPANEL
