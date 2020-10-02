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

public class SearchJPanel extends JPanel implements ActionListener, ItemListener {
    
        private static final int OWNER = 1;
        private static final int VEHICLE = 2;
         
        private final int BUTTON_WIDTH;
        private final int BORDER_GAP;
        private final int FIELD_HORIZONTAL_GAP;
        private final int FIELD_VERTICAL_GAP;
        private final int LARGE_FIELD_VERTICAL_GAP;
    
        private int confirmDialogResponse;

        private int ownerArraySize;
        private int vehicleArraySize;
        private static int ownerInstancesFoundInSearch;
        private static int vehicleInstancesFoundInSearch;  
        public static int ownerSearchReferenceIndex;
        public static int vehicleSearchReferenceIndex;
         
        private JComponent searchErrorObjectJComponentContainer;
        private JComponent editAndDeleteErrorJComponentContainer;
        private StringBuilder searchErrorDialogStringBuilder;
        private StringBuilder editAndDeleteErrorDialogStringBuilder;
         
        private final String PROGRAM_TITLE;
         
        private final Font NORMAL_FONT_STYLE;
        private final Font HEADINGTWO_FONT_STYLE;
         
        private final Color WHITE_COLOUR;
         
        private JPanel searchJPanel;
         
        private JLabel searchJLabel;
        private JLabel searchCategoryNameJLabel;
        private JLabel searchTextJLabel;
         
        private String[] searchList;  
         
        private static JComboBox<String> searchCategoryJComboBox;
        private static JComboBox<String> searchTextJComboBox;
         
        private JButton listAllJButton; 
        private JButton searchJButton; 
        private JButton searchClearJButton; 
        private JButton editJButton;
        private JButton deleteJButton;
         
        private static JTextArea searchJTextArea;
        private JScrollPane searchJScrollPane;
         
        private GroupLayout searchLayout;
         
        public SearchJPanel() {
                BUTTON_WIDTH = 130;
                BORDER_GAP = 12;
                FIELD_HORIZONTAL_GAP = 170;
                FIELD_VERTICAL_GAP = 5;
                LARGE_FIELD_VERTICAL_GAP = 24;
                ownerArraySize = MotorVehicleRegistrationFrame.ownerArray.size();
                vehicleArraySize = MotorVehicleRegistrationFrame.vehicleArray.size();
                confirmDialogResponse = 0;
                ownerInstancesFoundInSearch = 0;
                vehicleInstancesFoundInSearch = 0;
                ownerSearchReferenceIndex = 0;
                vehicleSearchReferenceIndex = 0;
                
                searchErrorDialogStringBuilder = new StringBuilder();
                editAndDeleteErrorDialogStringBuilder = new StringBuilder();
                
                PROGRAM_TITLE = "Motor Vehicle Registration Queensland";
        
                NORMAL_FONT_STYLE = new Font("Arial", 4, 12);
                HEADINGTWO_FONT_STYLE = new Font("Arial", 1, 14);
        
                WHITE_COLOUR = new Color(255,255,255);
        
                searchJPanel = new JPanel();
        
                searchJLabel = new JLabel("Search Owners and Vehicles");
                searchCategoryNameJLabel = new JLabel("Search for: ");
                searchTextJLabel = new JLabel("Select a record to search: ");
        
                searchList = new String [] {"...", "Owner by License Number", "Vehicle by Number Plate"}; 
                searchCategoryJComboBox = new JComboBox<>(searchList);
                searchTextJComboBox = new JComboBox<>(); 
                searchTextJComboBox.addItem("...");
                
                listAllJButton = new JButton("List All");
                searchJButton = new JButton("Start Search");
                searchClearJButton = new JButton("Clear Search");
                editJButton = new JButton("Edit");
                deleteJButton = new JButton("Delete");
        
                searchJTextArea = new JTextArea();
                searchJScrollPane = new JScrollPane();
        
                searchCategoryJComboBox.setBackground(WHITE_COLOUR);
                searchTextJComboBox.setBackground(WHITE_COLOUR);
                
                searchJTextArea = new JTextArea(null, "", 6, 5);
                searchJTextArea.setEditable(false);
                searchJScrollPane = new JScrollPane(searchJTextArea);
                searchJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                searchJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                
                setFontStyles();                
                setActionListeners();
                searchLayout = new GroupLayout(searchJPanel);
                setLayout();
        }
 
        private void setFontStyles() {
                searchJLabel.setFont(HEADINGTWO_FONT_STYLE);
                searchCategoryNameJLabel.setFont(NORMAL_FONT_STYLE);
                searchTextJLabel.setFont(NORMAL_FONT_STYLE);
                searchCategoryJComboBox.setFont(NORMAL_FONT_STYLE);
                searchTextJComboBox.setFont(NORMAL_FONT_STYLE);
                listAllJButton.setFont(NORMAL_FONT_STYLE);
                searchJButton.setFont(NORMAL_FONT_STYLE);
                searchClearJButton.setFont(NORMAL_FONT_STYLE);
                editJButton.setFont(NORMAL_FONT_STYLE);
                deleteJButton.setFont(NORMAL_FONT_STYLE);
                searchJTextArea.setFont(NORMAL_FONT_STYLE);
        }
 
        private void setActionListeners() {
                searchCategoryJComboBox.addItemListener(this);
                listAllJButton.addActionListener(this);
                searchJButton.addActionListener(this);
                searchClearJButton.addActionListener(this);
                editJButton.addActionListener(this);
                deleteJButton.addActionListener(this);
        }
 
        private void setLayout()  {
                setLayout(new BorderLayout());
                add(searchJPanel);
                searchJPanel.setLayout(searchLayout);
                
                searchLayout.setHorizontalGroup(searchLayout.createSequentialGroup()
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP)
                                .addGroup(searchLayout.createSequentialGroup()
                                .addGroup(searchLayout.createParallelGroup()
                                        .addComponent(searchJScrollPane, GroupLayout.Alignment.CENTER)
                                .addGroup(searchLayout.createSequentialGroup()
                                .addGroup(searchLayout.createParallelGroup()
                                        .addComponent(searchJLabel)
                                        .addComponent(searchCategoryNameJLabel)
                                        .addComponent(searchTextJLabel)
                                        .addComponent(listAllJButton, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(editJButton, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE))
                                .addGap(FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP)
                                        .addGroup(searchLayout.createSequentialGroup()
                                        .addGroup(searchLayout.createParallelGroup()
                                                .addComponent(searchCategoryJComboBox)
                                                .addComponent(searchTextJComboBox)
                                                .addComponent(searchJButton, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(searchClearJButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(deleteJButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, BUTTON_WIDTH, GroupLayout.PREFERRED_SIZE))))))
                                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP));
                 
                searchLayout.setVerticalGroup(searchLayout.createSequentialGroup()
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP)
                        .addGroup(searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(BASELINE)
                                .addComponent(searchJLabel))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(BASELINE)
                                .addComponent(searchCategoryNameJLabel)
                                .addComponent(searchCategoryJComboBox))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)
                        .addGroup(searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(BASELINE)
                                .addComponent(searchTextJLabel)
                                .addComponent(searchTextJComboBox))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(BASELINE)
                                .addComponent(listAllJButton)
                                .addComponent(searchJButton)
                                .addComponent(searchClearJButton))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(BASELINE)
                                .addComponent(searchJScrollPane))
                                .addGap(LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP, LARGE_FIELD_VERTICAL_GAP)
                        .addGroup(searchLayout.createSequentialGroup()
                        .addGroup(searchLayout.createParallelGroup(BASELINE)
                                .addComponent(editJButton)
                                .addComponent(deleteJButton))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP)))))))
                        .addGap(BORDER_GAP, BORDER_GAP, BORDER_GAP));
                }
 
        public static int getOwnerSearchReferenceIndex() {
                return SearchJPanel.ownerSearchReferenceIndex;
        }
 
        public static int getVehicleSearchReferenceIndex() {
                return SearchJPanel.vehicleSearchReferenceIndex;
        }
 
        private void licenseSearch(int arraySize) {
                for (int searchIndex = 0; searchIndex < arraySize; ++searchIndex)
                        searchTextJComboBox.addItem(MotorVehicleRegistrationFrame.ownerArray.get(searchIndex).getId() + ""); 
        }
 
        private void vehicleSearch(int arraySize) {
                for (int searchIndex = 0; searchIndex < arraySize; ++searchIndex)
                        searchTextJComboBox.addItem(MotorVehicleRegistrationFrame.vehicleArray.get(searchIndex).getPlateNumber()+ ""); 
        }
     
        public static void resetSearchJTextArea() {
                searchJTextArea.setText("");
        }        
 
        public static void resetJComboBox() {
                searchCategoryJComboBox.setSelectedIndex(0);
        }        
 
        public static void resetSearchAndReferenceIndexes() {
                ownerInstancesFoundInSearch = 0;
                vehicleInstancesFoundInSearch = 0;
                ownerSearchReferenceIndex = 0;
                vehicleSearchReferenceIndex = 0;
        }
 
        public static void clear() {
                searchCategoryJComboBox.setSelectedIndex(0);
                searchTextJComboBox.setSelectedIndex(0);
                resetSearchJTextArea();
        }     
 
        private void listAll() {
                ownerArraySize = MotorVehicleRegistrationFrame.ownerArray.size();
                vehicleArraySize = MotorVehicleRegistrationFrame.vehicleArray.size();
                clear();
                resetSearchAndReferenceIndexes();
                displayOwnerHeading();
                for (int listIndex = 0; listIndex < ownerArraySize; ++listIndex)
                        searchJTextArea.append(MotorVehicleRegistrationFrame.ownerArray.get(listIndex).toString() + "\n");
                searchJTextArea.append("\n");
                displayVehicleHeading();
                for (int listIndex = 0; listIndex < vehicleArraySize; ++listIndex)
                        searchJTextArea.append(MotorVehicleRegistrationFrame.vehicleArray.get(listIndex).toString() + "\n");
        }
 
        private void resetSearchPanelAfterDeletion()
	{ 
                listAll();
                MotorVehicleRegistrationFrame.resetVehiclePanelJComboBox();
                MotorVehicleRegistrationFrame.showSearchTab();
	}
 
        public static void displayOwnerHeading() {
                searchJTextArea.append("Owners: \n"); 
        }
  
        public static void displayVehicleHeading() {
                searchJTextArea.append("Vehicles: \n"); 
        }
 
        public static void updateSearchTab() {
                MotorVehicleRegistrationFrame.showSearchTab();
                clear();
        }
 
        public static void newOwner() {
               updateSearchTab();
               searchJTextArea.append("New Owner: \n"); 
               searchJTextArea.append(MotorVehicleRegistrationFrame.ownerArray.get(MotorVehicleRegistrationFrame.ownerArray.size()-1).toString());
               resetSearchAndReferenceIndexes();
        }
 
        public static void editOwner() {
               updateSearchTab();
               searchJTextArea.append("Edited Owner: \n"); 
               searchJTextArea.append(MotorVehicleRegistrationFrame.ownerArray.get(MotorVehicleRegistrationFrame.ownerArray.size()-1).toString());
               resetSearchAndReferenceIndexes();
        }
 
        public static void newVehicle() {
               updateSearchTab();
               searchJTextArea.append("New Vehicle: \n"); 
               searchJTextArea.append(MotorVehicleRegistrationFrame.vehicleArray.get(MotorVehicleRegistrationFrame.vehicleArray.size()-1).toString());
               resetSearchAndReferenceIndexes();
        }
 
        public static void editVehicle() {
               updateSearchTab();
               searchJTextArea.append("Edited Vehicle: \n"); 
               searchJTextArea.append(MotorVehicleRegistrationFrame.vehicleArray.get(SearchJPanel.getVehicleSearchReferenceIndex()).toString());
               resetSearchAndReferenceIndexes();
        }
  
        private void generateConfirmDialog(String messageText) {
               confirmDialogResponse = JOptionPane.showConfirmDialog(null, messageText, PROGRAM_TITLE, JOptionPane.YES_NO_OPTION);
        }
  
        private void generateConfirmEditDialogForTab(String tabName) {
                generateConfirmDialog("Are you sure you wish to edit the selected " + tabName + " record?\n\n"
                            + "This will cause the " + tabName + " tab to switch to edit mode, which\n"
                            + "will replace any text currently contained in the " + tabName + " tab.");
        }
 
        private void generateConfirmDeleteDialog() {
               confirmDialogResponse = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete the selected record?", PROGRAM_TITLE, JOptionPane.YES_NO_OPTION);
        }
 
        private void generateErrorDialog(String messageText) {
                JOptionPane.showMessageDialog(null, messageText, PROGRAM_TITLE, JOptionPane.ERROR_MESSAGE); 
        }
  
        private void generateNotFoundErrorDialog(int instancesFoundInSearch, String searchItem) {
                if(instancesFoundInSearch == 0)
                        generateErrorDialog(searchItem + " not found");
        }
 
        private void generateEditModeDialogForTab(String tabName)  {
                generateErrorDialog("The " + tabName + " tab is currently in edit mode.\n\n"
                            + "Only one " + tabName + " can be edited or deleted at a time.\n"
                            + "To edit or delete another " + tabName + ", please complete\n"
                            + "the editing in the " + tabName + " tab and click on the\n"
                            + "accept changes button. Alternatively, return to the\n"
                            + tabName + " tab and click on the add mode button to exit edit\n"
                            + "mode without accepting changes.");
        }
 
        private void generateDataValidationErrorDialog(JComponent fieldObject, String messageText) {
                generateErrorDialog(messageText);
                fieldObject.requestFocus();
                return; 
        }
 
        private void noInstancesSelectedInSearch() {
                generateDataValidationErrorDialog(searchTextJComboBox, "Please select a record using the search button");
        }
 
        private void multipleInstancesSelectedInSearch() {
                generateDataValidationErrorDialog(searchTextJComboBox, "More than record has ben selected in the search.\nTo use this button, Please refine your search to one record.");
        }
 
        private void generateSearchErrorDataValidationDialog() {
                generateDataValidationErrorDialog(searchErrorObjectJComponentContainer, searchErrorDialogStringBuilder.toString()); 
        }
   
        private void generateEditAndDeleteErrorDataValidationDialog() {
                generateDataValidationErrorDialog(editAndDeleteErrorJComponentContainer, editAndDeleteErrorDialogStringBuilder.toString());
        }
 
        private JComponent getSearchErrorObjectJComponentContainer() {
                return searchErrorObjectJComponentContainer;
        }
 
        private JComponent searchErrorObjectToJComponentContainer(JComponent fieldObject) {
                if(searchErrorObjectJComponentContainer == null) {
                        searchErrorObjectJComponentContainer = fieldObject;
                }
                
                return searchErrorObjectJComponentContainer;
        }
 
        private StringBuilder getSearchErrorDialogStringBuilder() {
                return searchErrorDialogStringBuilder;
        }
 
        private StringBuilder addSearchErrorDialogToStringBuilder(String errorDialog) {
                if(searchErrorDialogStringBuilder.length() == 0) {
                        searchErrorDialogStringBuilder.append(errorDialog);
                }
                
                return searchErrorDialogStringBuilder;
        }
         
        private void validateSearch() {
                searchErrorObjectJComponentContainer = null;
                searchErrorDialogStringBuilder.setLength(0);                
                
                if(searchCategoryJComboBox.getSelectedIndex() == 0) {
                        searchErrorObjectToJComponentContainer(searchCategoryJComboBox);
                        addSearchErrorDialogToStringBuilder("You must select what to search for");
                }
                
                if(searchTextJComboBox.getSelectedIndex() == 0)  {
                        searchErrorObjectToJComponentContainer(searchTextJComboBox);
                        addSearchErrorDialogToStringBuilder("You must select a record to search for.\n\n"
                                + "Alternatively, more records need to be added.");
                }

        } 
 
        private JComponent getEditAndDeleteErrorJComponentContainer() {
                return editAndDeleteErrorJComponentContainer;
        }
 
        private JComponent editAndDeleteErrorToJComponentContainer(JComponent fieldObject) {
                if(editAndDeleteErrorJComponentContainer == null) {
                        editAndDeleteErrorJComponentContainer = fieldObject;
                }
                
                return editAndDeleteErrorJComponentContainer;
        }
 
        private StringBuilder geEditAndDeleteErrorDialogStringBuilder() {
                return editAndDeleteErrorDialogStringBuilder;
        }
 
        private StringBuilder addEditAndDeleteErrorDialogToStringBuilder(String errorDialog) {
                if(editAndDeleteErrorDialogStringBuilder.length() == 0) {
                        editAndDeleteErrorDialogStringBuilder.append(errorDialog);
                }
                
                return editAndDeleteErrorDialogStringBuilder;
        }
         
        private void validateEditAndDelete() {
                editAndDeleteErrorJComponentContainer = null;
                editAndDeleteErrorDialogStringBuilder.setLength(0); 
                
                if(ownerInstancesFoundInSearch == 0 && vehicleInstancesFoundInSearch == 0) {
                        editAndDeleteErrorToJComponentContainer(searchCategoryJComboBox);
                        addEditAndDeleteErrorDialogToStringBuilder("To edit or delete a record, a record must be selected.\n"
                                + "To do this, use the start search button.");
                }
                
                if(ownerInstancesFoundInSearch > 1 || vehicleInstancesFoundInSearch > 1) {
                        editAndDeleteErrorToJComponentContainer(searchCategoryJComboBox);
                        addEditAndDeleteErrorDialogToStringBuilder("More than record has ben selected in the search.\n\n"
                                + "To use this button, Please refine your search to one record.");
                }
        }
 
        private int collectOwnerSearchReferenceIndex(int instanceIndex) {
                ownerSearchReferenceIndex = instanceIndex;
                return instanceIndex;
        }
 
        private int collectVehicleSearchReferenceIndex(int instanceIndex) {
                vehicleSearchReferenceIndex = instanceIndex;
                return instanceIndex;
        }
        
        private String collectAndIincrementOwnerInstancesFoundInSearch(String instanceText) {
                String testString = instanceText;
                if(testString.compareTo("") != 0)
                        ++ownerInstancesFoundInSearch;
                return instanceText;
        }
 
        private String collectAndIncrementVehicleInstancesFoundInSearch(String instanceText) {
                String testString = instanceText;
                if(testString.compareTo("") != 0)
                        ++vehicleInstancesFoundInSearch;
                return instanceText;
        }
 
        private void search() {
                validateSearch();
                
                if(getSearchErrorObjectJComponentContainer() != null && getSearchErrorDialogStringBuilder().length() > 0)
                        generateSearchErrorDataValidationDialog();
            
                else {
                           
                    int license;
                    String numberPlate;
                    license = 0;

                    ownerArraySize = MotorVehicleRegistrationFrame.ownerArray.size();
                    vehicleArraySize = MotorVehicleRegistrationFrame.vehicleArray.size(); 
                    resetSearchAndReferenceIndexes();
                    resetSearchJTextArea();
                        
                if(searchCategoryJComboBox.getSelectedIndex() == OWNER)
                {
                    license = Integer.parseInt(searchTextJComboBox.getItemAt(searchTextJComboBox.getSelectedIndex()));
                    displayOwnerHeading();
                    for (int searchIndex = 0; searchIndex < ownerArraySize; ++searchIndex)
                            if(MotorVehicleRegistrationFrame.ownerArray.get(searchIndex).getId() == license)
                                    searchJTextArea.append(collectAndIincrementOwnerInstancesFoundInSearch(MotorVehicleRegistrationFrame.ownerArray.get(collectOwnerSearchReferenceIndex(searchIndex)).toString()));
                    generateNotFoundErrorDialog(ownerInstancesFoundInSearch, license + "");
                return;
                }
                        
                if(searchCategoryJComboBox.getSelectedIndex() == VEHICLE)
                {
                        numberPlate = searchTextJComboBox.getItemAt(searchTextJComboBox.getSelectedIndex());
                        displayVehicleHeading();
                        for (int searchIndex = 0; searchIndex < vehicleArraySize; ++searchIndex)
                                if(MotorVehicleRegistrationFrame.vehicleArray.get(searchIndex).getPlateNumber().equalsIgnoreCase(numberPlate))
                                        searchJTextArea.append(collectAndIncrementVehicleInstancesFoundInSearch(MotorVehicleRegistrationFrame.vehicleArray.get(collectVehicleSearchReferenceIndex(searchIndex)).toString()));

                        generateNotFoundErrorDialog(vehicleInstancesFoundInSearch, numberPlate);
                        return;
                }
        }  
} 
 
        private void deleteOwner() { 
                MotorVehicleRegistrationFrame.ownerArray.remove(ownerSearchReferenceIndex);
                resetSearchPanelAfterDeletion();
	}
  
        private void deleteVehicle() { 
                MotorVehicleRegistrationFrame.vehicleArray.remove(vehicleSearchReferenceIndex);
                resetSearchPanelAfterDeletion();
	}
 
        @Override
        public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
                
                if(source == searchCategoryJComboBox)
                {
                ownerArraySize = MotorVehicleRegistrationFrame.ownerArray.size();
                vehicleArraySize = MotorVehicleRegistrationFrame.vehicleArray.size();
                searchTextJComboBox.removeAllItems();
                searchTextJComboBox.addItem("...");
                
                if(searchCategoryJComboBox.getSelectedIndex() == OWNER)
                        licenseSearch(ownerArraySize);
                if(searchCategoryJComboBox.getSelectedIndex() == VEHICLE)
                        vehicleSearch(vehicleArraySize);
                }                       
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
            
                if(source == listAllJButton)
                        listAll();
               
                if(source == searchClearJButton) {
                        generateConfirmDialog("Are you sure you wish to clear search details?");
                        if(confirmDialogResponse == JOptionPane.YES_OPTION) {
                                clear();
                                resetSearchAndReferenceIndexes();
                        }
                        else
                            return;
                }
                
                if(source == searchJButton)
                        search();
                
                if(source == editJButton) {
                        validateEditAndDelete();
                
                        if(getEditAndDeleteErrorJComponentContainer() != null && geEditAndDeleteErrorDialogStringBuilder().length() > 0)
                                generateEditAndDeleteErrorDataValidationDialog();
                        else {
                                if(ownerInstancesFoundInSearch > vehicleInstancesFoundInSearch) {
                                        if(OwnerJPanel.editMode == true) {
                                                generateEditModeDialogForTab("owner");
                                                return;
                                        }
                                        else {
                                                generateConfirmEditDialogForTab("owner");
                                                if(confirmDialogResponse == JOptionPane.YES_OPTION) {
                                                        OwnerJPanel.editMode();
                                                        return;
                                                }
                                                else {
                                                        return;
                                                }
                                                
                                        }
                                }                                
                                                
                                if(vehicleInstancesFoundInSearch > ownerInstancesFoundInSearch) {
                                        if(VehicleJPanel.editMode == true) {
                                                generateEditModeDialogForTab("vehicle");
                                                return;
                                        }
                                        else {
                                                generateConfirmEditDialogForTab("vehicle");
                                                if(confirmDialogResponse == JOptionPane.YES_OPTION) {
                                                        VehicleJPanel.editMode();
                                                        return;
                                                }
                                                else {
                                                        return;
                                                }
                                                
                                        }
                                        
                                }

                        }
                
                }
                
                if(source == deleteJButton) {
                        validateEditAndDelete();
                
                        if(getEditAndDeleteErrorJComponentContainer() != null && geEditAndDeleteErrorDialogStringBuilder().length() > 0)
                                generateEditAndDeleteErrorDataValidationDialog();
                        else {
                                if(ownerInstancesFoundInSearch > vehicleInstancesFoundInSearch) {
                                        if(OwnerJPanel.editMode == true) {
                                                generateEditModeDialogForTab("owner");
                                                return;
                                        }
                                        else {
                                                generateConfirmDeleteDialog();
                                                if(confirmDialogResponse == JOptionPane.YES_OPTION) {
                                                        deleteOwner();
                                                        return;
                                                }
                                                else {
                                                        return;
                                                }
                                                
                                        }
                                }                                
                                                
                                if(vehicleInstancesFoundInSearch > ownerInstancesFoundInSearch) {
                                        if(VehicleJPanel.editMode == true) {
                                                generateEditModeDialogForTab("vehicle");
                                                return;
                                        }
                                        else {
                                                generateConfirmDeleteDialog();
                                                if(confirmDialogResponse == JOptionPane.YES_OPTION) {
                                                        deleteVehicle();
                                                        return;
                                                }
                                                else {
                                                        return;
                                                }
                                                
                                        }
                                        
                                }

                        }
                                
                }
                        
        }
                
} // End of SEARCHJPANEL
