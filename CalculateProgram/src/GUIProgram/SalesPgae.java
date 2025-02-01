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

public class SalesPgae extends calculateSales implements ActionListener{

	JFrame sales = new JFrame();
	JButton scalculate = new JButton("Calculate");
	JButton bback = new JButton("Back");
	JLabel name = new JLabel ("Product Name: ");
	JLabel price = new JLabel ("Product Price: ");
	JLabel quantity = new JLabel ("Quantity Sold: ");
	JLabel total = new JLabel (" Total Sales: ");
	JLabel rTotal = new JLabel ("  ");
	JTextField nameField = new JTextField ();
	JTextField priceField = new JTextField ();
	JTextField quantityField = new JTextField ();

	
	
// *** the first thing to do ---- create a constructor ***
		SalesPgae() {
	
		// * INPUTfield *
			nameField.setBounds(230, 64, 180, 28);
			nameField.setFont(new Font ("Arial", Font.PLAIN, 15));
			setPlaceholder(nameField, "Enter Product Name");

			
			priceField.setBounds(230, 124, 180, 28);
			priceField.setFont(new Font ("Arial", Font.PLAIN, 15));
			setPlaceholder(priceField, "NUMBER only");

			
			quantityField.setBounds(230, 184, 180, 28);
			quantityField.setFont(new Font ("Arial", Font.PLAIN, 15));
			setPlaceholder(quantityField, "NUMBER only");

			
			
		// * LABELS *
			Font fname = new Font ("Arial", Font.BOLD, 18);
			name.setFont(fname);
			name.setBounds(80, 60, 300, 40);
			
			
			Font fprice = new Font ("Arial", Font.BOLD, 18);
			price.setFont(fprice);
			price.setBounds(80, 120, 300, 40);
			
			Font fquantity = new Font ("Arial", Font.BOLD, 18);
			quantity.setFont(fquantity);
			quantity.setBounds(80, 180, 300, 40);
			
			Font ftotal = new Font ("Arial", Font.BOLD, 18);
			total.setFont(ftotal);
			total.setBounds(80, 240, 300, 40);

			
		// REPAIR total *
			rTotal.setFont(new Font ("Arial", Font.BOLD, 18));
			rTotal.setBounds(230, 240, 300, 40);
			rTotal.setForeground(Color.BLACK );
			
		// * CALCULATE button *	
			scalculate.setBounds(170,320,150,30);
			
			scalculate.setFocusable(false);
			
			scalculate.addActionListener(this);
			
		// * BACK button *	
			bback.setBounds(350, 370, 100,30);
			
			bback.setFocusable(false);
			
	// *** IMPORTANT  so that the button will work and perform the action in tended
			bback.addActionListener(this);
			
			
			
		// * FRAME setup *	
		// * It will close the program when you exit *
		// * the first word is the name of your JFrame
			sales.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			sales.setTitle("Sales Calculator");
			
		// * it is the size of your frame *	
			sales.setSize(500,500);
			
		// * whether you can resize the frame or not *	
			sales.setLayout(null);
			
			sales.setVisible(true);
			
			sales.add(scalculate);
			sales.add(bback);
			sales.add(name);
			sales.add(price);
			sales.add(quantity);
			sales.add(total);
			sales.add(nameField);
			sales.add(priceField);
			sales.add(quantityField);
			sales.add(rTotal);
			
		}



		@Override
		public void actionPerformed(ActionEvent e) {
			// this will be the action performed when you click on the functionable elements
			
			
			if(e.getSource()==bback) {
				
				sales.dispose();
				MainPage mainPage = new MainPage();
				
			}
			
			if(e.getSource()==scalculate) {
				String priceValue = priceField.getText();
				String quantityValue = quantityField.getText();
				
				try {
					double priceInput = Double.parseDouble(priceValue);
					double quantityInput = Double.parseDouble(quantityValue);
					
					double repairSales = calculateSales(priceInput, quantityInput);
					
						rTotal.setText ("₱ " + repairSales);
						rTotal.setForeground(Color.BLACK);
			
					} catch (NumberFormatException ex) {
						rTotal.setText("Invalid Input! ");
						
				
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
		public double calculateSales(double price, double quantity) {
			// TODO Auto-generated method stub
			return price*quantity;
		}
}

