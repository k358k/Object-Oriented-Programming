package GUIProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPage implements ActionListener {
	
	JFrame frame = new JFrame();
	JButton Sbutton = new JButton("Sales Calculator");
	JButton Rbutton = new JButton ("Repair Calculator");
	JLabel greet = new JLabel ();
	JPanel fpanel = new JPanel();
	
	
	MainPage(){
		
// **** PANEL and LABEL ****
		fpanel.setBorder(BorderFactory.createEmptyBorder(0,0,500,500));
		fpanel.setLayout(null);
		fpanel.setBounds (40,20,350,250);
		fpanel.setVisible(true);

// **** LABEL ****
		Font labelFont = new Font ("Courier New", Font.BOLD, 35);
		greet.setText("Let's Compute!"); // will set text to the label -- can also be direct above from JLabel
		greet.setFont(labelFont);// apply the font style to the label
		greet.setBounds(60, 110, 400, 50);
		
		
		fpanel.add(greet);
		
// **** BUTTONS ****	
	//					( x , y , pixels long , pixels height )
		Sbutton.setBounds(80,300,150,30);
		
	// *whether the button will be highlighted or not
		Sbutton.setFocusable(false);
		
		Sbutton.addActionListener(this);
		
	//		( x , y , pixels long , pixels height )
		Rbutton.setBounds(250,300,150,30);
	
	// *whether the button will be highlighted or not
		Rbutton.setFocusable(false);
	
		Rbutton.addActionListener(this);
		
	
// **** FRAME ****		
	// * It will close the program when you exit *
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	// * it is the size of your frame *	
		frame.setSize(500,500);
		
		frame.setTitle("Start Calculating");
		
	// * whether you can resize the frame or not *	
		frame.setLayout(null);
		
		frame.setVisible(true);
		
	
		
// *** AADING to the frame ****	
	// * adding the elements to your frame *	
		frame.add(fpanel);
		frame.add(Sbutton);
		frame.add(Rbutton);
	//	frame.add(fpanel, BorderLayout.CENTER);

		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// this will be the action performed method when you click on the buttons
		
	// * this will trigger an event or action	
		if(e.getSource()==Sbutton) {
			
		// * this will close the previous window when you click a button *	
			frame.dispose();
			
			SalesPgae salesPgae = new SalesPgae();
			
		}
		
		
		if(e.getSource()==Rbutton) {
			frame.dispose();
			
			RepairSales repairSales = new RepairSales();
		
		}
	}

}
