// ALONG, LEE, ALBOR,HAMOC, CALAGO, MATAGONG, LADIGOHON, SENCIL
package unitconvertionapp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConvertionApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Unit Conversion App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(new GridLayout(5,2));
        frame.setVisible(true);
 
        // Components
        JComboBox<String> conversionType = new JComboBox<>(new String[]{" ","Mass", "Volume", "Area", "Length"});
        JComboBox<String> conversionM = new JComboBox<>(new String[]{" ","kg to lbs","lbs to kg","gallons to liters", "liters to gallons","square ft to square m",
        "squre m to square ft","ft to m","m to ft"});
        JTextField inputValue = new JTextField();
        JLabel resultLabel = new JLabel("Result: ");
        JButton convertButton = new JButton("Convert");
        JTextField resultValue = new JTextField();
        resultValue.setEditable(false);

        
        String selectedConversion = (String) conversionType.getSelectedItem();
       
        // Add components to the frame
       frame.add(new JLabel("Select Conversion Type: "));
       frame.add(conversionType);
       frame.add(new JLabel("Convertion:"));
       frame.add(conversionM);
       frame.add(new JLabel("Enter Value: "));
       frame.add(inputValue);
      
       frame.add(new JLabel(""));
       frame.add(convertButton);  
        
       frame.add(resultLabel);
       frame.add(resultValue);
                                
 
        

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedConversion = (String) conversionType.getSelectedItem();
               
                double valueToConvert = Double.parseDouble(inputValue.getText());
                double result = 0;

                if (selectedConversion.equals("Mass")) {
                    
                     String selectedM = (String) conversionM.getSelectedItem();
                     
                    if(selectedM.equals("kg to lbs")){
                    result = valueToConvert * 2.20462;
                    
                    }else if (selectedM.equals("lbs to kg")){
                    result = valueToConvert/2.20462;
              
                    }
                } else if (selectedConversion.equals("Volume")) {
                     String selectedM = (String) conversionM.getSelectedItem();
                    if(selectedM.equals("liters to gallons"))
                    { 
                    result = valueToConvert * 0.264172;
                    }else if (selectedM.equals("gallons to liters")){
                    result = valueToConvert / 0.264172;
                    }
                } else if (selectedConversion.equals("Area")) {
                    // Area Conversion: Square Meters to Square Feet
                    String selectedM = (String) conversionM.getSelectedItem();
                    if(selectedM.equals("square m to square ft")){
                    result = valueToConvert * 10.7639;
                    }else if(selectedM.equals("square ft to square m")){
                    result = valueToConvert / 10.7639;
                    }
                    
                } else if (selectedConversion.equals("Length")) {
                   String selectedM = (String) conversionM.getSelectedItem();
                    if(selectedM.equals("m to ft")){
                    result = valueToConvert * 3.28084;
                    }else if(selectedM.equals("ft to m")){
                     result = valueToConvert /3.28084;
                    }
                    
                }

                // Set the result in the resultValue field
                resultValue.setText(String.valueOf(result));
            }
        });

        frame.pack();
        frame.setVisible(true);
    }
}