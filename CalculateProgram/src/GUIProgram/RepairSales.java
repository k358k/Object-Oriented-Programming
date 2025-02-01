package GUIProgram;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener; 

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RepairSales extends Repaircalculations implements ActionListener {

	JFrame repair = new JFrame();
	JButton rcalculate = new JButton("Calculate");
	JButton backb = new JButton ("Back");
	JLabel pname = new JLabel("Product Name: ");
	JLabel rate = new JLabel ("Rate/hour: ");
	JLabel num = new JLabel ("Number of hours: ");
	JLabel rtotal = new JLabel ("Total Sales: ");
	JLabel tResult = new JLabel (" ");
	JTextField nameField = new JTextField ();
	JTextField rateField = new JTextField ();
	JTextField hourField = new JTextField ();

	
	RepairSales() {
		
	// * INPUTfield *
		nameField.setBounds(230, 64, 180, 28);
		nameField.setFont(new Font ("Arial", Font.PLAIN, 15));
		setPlaceholder(nameField, "Enter Product Name");
		
		rateField.setBounds(230, 124, 180, 28);
		rateField.setFont(new Font ("Arial", Font.PLAIN, 15));
		setPlaceholder(rateField, "NUMBER only");

		
		hourField.setBounds(230, 184, 180, 28);
		hourField.setFont(new Font ("Arial", Font.PLAIN, 15));
		setPlaceholder(hourField, "NUMBER only");


		
		
	// * LABELS *
		Font pName = new Font ("Arial", Font.BOLD, 18);
		pname.setFont(pName);
		pname.setBounds(60, 60, 300, 40);
		
		
		Font frate = new Font ("Arial", Font.BOLD, 18);
		rate.setFont(frate);
		rate.setBounds(60, 120, 300, 40);
		
		Font fnum = new Font ("Arial", Font.BOLD, 18);
		num.setFont(fnum);
		num.setBounds(60, 180, 300, 40);
		
		Font rTotal = new Font ("Arial", Font.BOLD, 18);
		rtotal.setFont(rTotal);
		rtotal.setBounds(60, 240, 300, 40);

		
	// * RESULT label *
		tResult.setFont(new Font ("Arial", Font.BOLD, 18));
		tResult.setBounds(230, 240, 300, 40);
		tResult.setForeground(Color.BLACK );
		
		
	// * BUTTONS *
// * this will be the size of your button ( the distance x, the distance y, the length of the button, the height of the button	
		rcalculate.setBounds(170,320,150,30);
		
	// * whether the button will be highlighted or not
		rcalculate.setFocusable(false);
		
	// * so that when you click on the button an action will be performed
		rcalculate.addActionListener(this);
		
		backb.setBounds(350, 370, 100,30);
		
		backb.setFocusable(false);
		
		backb.addActionListener(this);
		
		
	// * FRAME *
		repair.setSize(500,500);
		
	// * set the title of your frame *	
		repair .setTitle("Repair Calculator");
		
		repair.setLayout(null);
		
		repair.setVisible(true);
		
	// * ADDING the components to the frame 	
		repair.add(rcalculate);
		repair.add(backb);
		repair.add(pname);
		repair.add(num);
		repair.add(rate);
		repair.add(rtotal);
		repair.add(nameField);
		repair.add(hourField);
		repair.add(rateField);		
		repair.add(tResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// this will be the action performed when you click on a functionable element
		
		if(e.getSource()==backb) {
			
			repair.dispose();
			MainPage mainPage = new MainPage();
	
		}
		
	
		
		if(e.getSource()==rcalculate){
			String rateValue = rateField.getText();
			String hourValue = hourField.getText();
			
			
			try {
			// * changes the string answers into numeric values
				double rateInput = Double.parseDouble(rateValue);
				double hourInput = Double.parseDouble(hourValue);
				
				double totalSales =calculaterepairs(rateInput,hourInput);
			
					tResult.setText ("₱ "+ totalSales);
					tResult.setForeground(Color.BLACK);
			
				} catch (NumberFormatException ex) {
			
						tResult.setText("Invalid Input! ");
			
				}
		}
	}
	
	 // Helper method to set placeholder text in JTextField
    private void setPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);

        // Add focus listener to remove placeholder when focused
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK); // Change text color when typing
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY); // Change color back to gray
                }
            }
        });
    }
    
 
	@Override
	public double calculaterepairs(double rate, double hour) {
		// TODO Auto-generated method stub
		return rate*hour;
	}
}
	
		
		

	
	

