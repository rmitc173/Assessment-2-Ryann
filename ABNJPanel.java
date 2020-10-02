/*
 * Name: Ryan Mitchell
 * Student Number: 12139496
 * Date: 26/09/2020
 */
package mvr;

import java.awt.*;
import java.util.ArrayList;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import javax.swing.*;

public class ABNJPanel extends JPanel {
        private final int FIELD_HORIZONTAL_GAP;
        private final int FIELD_VERTICAL_GAP;
        
        
        private final int JEXTFIELD_TWO_DIGIT_COLUMN_WIDTH;
        private final int JEXTFIELD_THREE_DIGIT_COLUMN_WIDTH;  
        private final Font NORMAL_FONT_STYLE;        
        private static JPanel aBNJPanel;     
        private static JTextField firstABNJTextField;
        private static JTextField secondABNJTextField;
        private static JTextField thirdABNJTextField;
        private static JTextField fourthABNJTextField;
        
        private static ArrayList<CorporateOwner> aBNArray;
         
        private GroupLayout ABNLayout;
    
    
    public ABNJPanel() {
                FIELD_HORIZONTAL_GAP = 12;
                FIELD_VERTICAL_GAP = 5;
                JEXTFIELD_TWO_DIGIT_COLUMN_WIDTH = 20;
                JEXTFIELD_THREE_DIGIT_COLUMN_WIDTH = 27;
                NORMAL_FONT_STYLE = new Font("Arial", 4, 12);               
                aBNJPanel = new JPanel();
                
                firstABNJTextField = new JTextField();
                secondABNJTextField = new JTextField();
                thirdABNJTextField = new JTextField();
                fourthABNJTextField = new JTextField();
                setFontStyles(); 
                 
                aBNArray = new ArrayList<>();             
                ABNLayout = new GroupLayout(aBNJPanel);
                setLayout();
        }
        
        private void setFontStyles() {
                firstABNJTextField.setFont(NORMAL_FONT_STYLE);
                secondABNJTextField.setFont(NORMAL_FONT_STYLE);
                thirdABNJTextField.setFont(NORMAL_FONT_STYLE);
                fourthABNJTextField.setFont(NORMAL_FONT_STYLE);
        }

        private void setLayout() {        
                setLayout(new BorderLayout());
                setAlignmentX(aBNJPanel.LEFT_ALIGNMENT);
                add(aBNJPanel, BorderLayout.WEST);

                aBNJPanel.setLayout(ABNLayout);
                ABNLayout.setHorizontalGroup(ABNLayout.createSequentialGroup()
                        .addGroup(ABNLayout.createSequentialGroup()
                        .addGroup(ABNLayout.createParallelGroup()
                                .addComponent(firstABNJTextField, javax.swing.GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, JEXTFIELD_TWO_DIGIT_COLUMN_WIDTH, GroupLayout.PREFERRED_SIZE))
                                .addGap(FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP)
                        .addGroup(ABNLayout.createSequentialGroup()
                        .addGroup(ABNLayout.createParallelGroup()
                                .addComponent(secondABNJTextField, javax.swing.GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, JEXTFIELD_THREE_DIGIT_COLUMN_WIDTH, GroupLayout.PREFERRED_SIZE))
                                .addGap(FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP)
                        .addGroup(ABNLayout.createSequentialGroup()
                        .addGroup(ABNLayout.createParallelGroup()
                                .addComponent(thirdABNJTextField, javax.swing.GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, JEXTFIELD_THREE_DIGIT_COLUMN_WIDTH, GroupLayout.PREFERRED_SIZE))
                                .addGap(FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP, FIELD_HORIZONTAL_GAP)
                        .addGroup(ABNLayout.createSequentialGroup()
                        .addGroup(ABNLayout.createParallelGroup()
                                .addComponent(fourthABNJTextField, javax.swing.GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, JEXTFIELD_THREE_DIGIT_COLUMN_WIDTH, GroupLayout.PREFERRED_SIZE)))))));

                ABNLayout.setVerticalGroup(ABNLayout.createSequentialGroup()
                        .addGroup(ABNLayout.createSequentialGroup()
                        .addGroup(ABNLayout.createParallelGroup(BASELINE)
                                .addComponent(firstABNJTextField)
                                .addComponent(secondABNJTextField)
                                .addComponent(thirdABNJTextField)
                                .addComponent(fourthABNJTextField)))
                                .addGap(FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP, FIELD_VERTICAL_GAP));
                }

        public String getFirstABNJTextFieldText() {
                return firstABNJTextField.getText();
        }

        public String getSecondABNJTextFieldText() {
                return secondABNJTextField.getText();
        }

        public String getThirdABNJTextFieldText() {
                return thirdABNJTextField.getText();
        }

        public String getFourthABNJTextFieldText() {
                return fourthABNJTextField.getText();
        }

        public JTextField getFirstABNJTextField() {
                return firstABNJTextField;
        }

        public JTextField getSecondABNJTextField() {
                return secondABNJTextField;
        }

        public JTextField getThirdABNJTextField() {
                return thirdABNJTextField;
        }

        public JTextField getFourthABNJTextField() {
                return fourthABNJTextField;
        }

        public void resetABNJTextFields() {
                firstABNJTextField.setText("");
                secondABNJTextField.setText("");
                thirdABNJTextField.setText("");
                fourthABNJTextField.setText("");
        }    
        
        public static String extractABNValuesFromText() {
                String extractedString;
                aBNArray.add((CorporateOwner) MotorVehicleRegistrationFrame.ownerArray.get(SearchJPanel.ownerSearchReferenceIndex));
                extractedString = aBNArray.get(0).getAustralianBusinessNumber() + "";
                return extractedString;
        }

        public static String extractFirstABNJTextField() {
                int firstIndex;
                int lastIndex;
                String firstBoxText;
                firstIndex = 0;
                lastIndex = 2;
                firstBoxText = extractABNValuesFromText().substring(firstIndex, lastIndex);
                return firstBoxText;
        }

        public static void setFirstABNJTextField() {
                firstABNJTextField.setText(extractFirstABNJTextField());
        }

        public static String extractSecondABNJTextField() {
                int firstIndex;
                int lastIndex;
                String secondBoxText;
                firstIndex = 3;
                lastIndex = 6;
                secondBoxText = extractABNValuesFromText().substring(firstIndex, lastIndex);
                return secondBoxText;
        }

        public static void setSecondABNJTextField() {
                secondABNJTextField.setText(extractSecondABNJTextField());
        }

        public static String extractThirdABNJTextField() {
                int firstIndex;
                int lastIndex;
                String thirdBoxText;
                firstIndex = 7;
                lastIndex = 10;
                thirdBoxText = extractABNValuesFromText().substring(firstIndex, lastIndex);
                return thirdBoxText;
        }

        public static void setThirdABNJTextField() {
                thirdABNJTextField.setText(extractThirdABNJTextField());
        }

        public static String extractFourthABNJTextField() {
                int firstIndex;
                int lastIndex;
                String fourthBoxText;
                firstIndex = 11;
                lastIndex = 14;
                fourthBoxText = extractABNValuesFromText().substring(firstIndex, lastIndex);
                return fourthBoxText;
        }

        public static void setFourthABNJTextField() {
                fourthABNJTextField.setText(extractFourthABNJTextField());
        }        

        public static void setABN() {
                setFirstABNJTextField();
                setSecondABNJTextField();
                setThirdABNJTextField();
                setFourthABNJTextField();
        }
} // End of ABNJPANEL

