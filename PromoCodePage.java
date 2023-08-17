/* Author: Hari Om Chadha
 * This class creates the page that asks the user to add a promo code for discounts
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PromoCodePage extends JFrame implements ActionListener {

	// declares all the labels, seatButtons, panel, etc on this window
	JPanel promoCodePanel;
	JLabel totalLabel, promptLabel, promoCodeLabel, promoCodeImageLabel;
	JTextField promoCodeField;
	JButton cancelButton, continueButton;
	ImageIcon laughingIcon, thumbsUpIcon;
	
	//public static to allow access from other classes
	public static double discount = 0;
	public static String discountType;
	int yes = 0;
	
	public PromoCodePage() {
		
		//names the window
		super("Promo Codes");
		
		//creates a content pane
		Container promoCodeScreen = getContentPane();
		promoCodeScreen.setLayout(null);
		
		//creates the panel to hold everything
		promoCodePanel = new JPanel();
		promoCodePanel.setLayout(null);
		promoCodePanel.setLocation(0,0);
		promoCodePanel.setSize(500,300);
		promoCodeScreen.add(promoCodePanel);
		
		//creates the label to show the current total
		totalLabel = new JLabel("Your current total is $" + SeatSelectionPage.money.format(SeatSelectionPage.totalAmount));
		totalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		totalLabel.setLayout(null);
		totalLabel.setLocation(0,10);
		totalLabel.setSize(500,20);
		totalLabel.setForeground(Color.red);
		totalLabel.setHorizontalAlignment(0);
		promoCodePanel.add(totalLabel);
		
		//creates the label that prompts the user to add a promo code
		promptLabel = new JLabel("<html>Use one of our two promo codes for<br>exclusive discounts on the purchase.<html>");
		promptLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		promptLabel.setLayout(null);
		promptLabel.setLocation(0,35);
		promptLabel.setSize(500,40);
		promptLabel.setForeground(Color.blue);
		promptLabel.setHorizontalAlignment(0);
		promoCodePanel.add(promptLabel);
		
		//creates the promo code label
		promoCodeLabel = new JLabel("Enter promo code here:");
		promoCodeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		promoCodeLabel.setLayout(null);
		promoCodeLabel.setLocation(30,115);
		promoCodeLabel.setSize(200,20);
		promoCodeLabel.setHorizontalAlignment(0);
		promoCodePanel.add(promoCodeLabel);
		
		//creates the text field to add the promo code
		promoCodeField = new JTextField("", 15);
		promoCodeField.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		promoCodeField.setLayout(null);
		promoCodeField.setLocation(30,140);
		promoCodeField.setSize(200,30);
		promoCodeField.setHorizontalAlignment(2);
		promoCodePanel.add(promoCodeField);
		
		//creates the label with the image of the promo code
		promoCodeImageLabel = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/PromoCodes.png")).getImage().getScaledInstance(200,135,Image.SCALE_DEFAULT)));
		promoCodeImageLabel.setLayout(null);
		promoCodeImageLabel.setLocation(270,85);
		promoCodeImageLabel.setSize(200,125);
		promoCodePanel.add(promoCodeImageLabel);
		
		//creates the cancel button
		cancelButton = new JButton("Cancel");
		cancelButton.setLayout(null);
		cancelButton.setLocation(30,220);
		cancelButton.setSize(200,50);
		cancelButton.addActionListener(this);
		promoCodePanel.add(cancelButton);
		
		//creates the continue button
		continueButton = new JButton("Confirm Purchase");
		continueButton.setLayout(null);
		continueButton.setLocation(270,220);
		continueButton.setSize(200,50);
		continueButton.addActionListener(this);
		promoCodePanel.add(continueButton);
		
		//creates the 2 icons for the JOption panes
		laughingIcon = new ImageIcon(new ImageIcon(getClass().getResource("Images/LaughingMan.gif")).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
		thumbsUpIcon = new ImageIcon(new ImageIcon(getClass().getResource("Images/ThumbsUpIcon.jpeg")).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));	
	}
	
	// action listener to assign commands to buttons
	public void actionPerformed(ActionEvent e) {
		//calls the method cancel booking
		if (e.getSource() == cancelButton) {
			Menu.bf.CancelBooking();
		
		//continues after making sure all the information is filled in right
		} if (e.getSource() == continueButton) {
			
			//calculates the new amounts and displays custom JOptionPanes based on the selection
			if (promoCodeField.getText().equals("NoDiscount")) {
				discountType = "-";
				discount = SeatSelectionPage.subTotal * 0.3;
				SeatSelectionPage.taxAmount = (SeatSelectionPage.subTotal - discount)  * 0.13;
				SeatSelectionPage.totalAmount = SeatSelectionPage.subTotal - discount + SeatSelectionPage.taxAmount;
				JOptionPane.showMessageDialog(null,"<html>Thank you for choosing the promo code 'NoDiscount'.<br>You have recieved 30% off on your purchase.<br>Your new total is $" + SeatSelectionPage.money.format(SeatSelectionPage.totalAmount) + "<html>" , "Thank you!", JOptionPane.PLAIN_MESSAGE, thumbsUpIcon);
				Menu.pcOpen = false;
				OpenFinalPages();
				
			//calculates the new amounts and displays custom JOptionPanes based on the selection
			} else if (promoCodeField.getText().equals("ChargeMeDouble")) {
				discountType = "+";
				discount = SeatSelectionPage.subTotal;
				SeatSelectionPage.taxAmount = (SeatSelectionPage.subTotal + discount) * 0.13;
				SeatSelectionPage.totalAmount = SeatSelectionPage.subTotal + discount + SeatSelectionPage.taxAmount;
				JOptionPane.showMessageDialog(null,"<html>Thank you for choosing the promo code 'ChargeMeDouble'.<br>Now you have to pay double the amount you had to pay before.<br>Your new total is $" + SeatSelectionPage.money.format(SeatSelectionPage.totalAmount) + "<html>" , "Thank you!", JOptionPane.PLAIN_MESSAGE, laughingIcon);
				Menu.pcOpen = false;
				OpenFinalPages();
				
			//allows the user to have no promo codes
			} else if (promoCodeField.getText().equals("")) {
				yes = JOptionPane.showConfirmDialog(null,"Are you sure you want to continue without a promo code?" , "No promo code?", JOptionPane.YES_NO_OPTION);
				if (yes == JOptionPane.YES_OPTION) {
					Menu.pcOpen = false;
					OpenFinalPages();
				}
			} else {
				JOptionPane.showMessageDialog(null,"Invalid promo code. Please try again." , "Invalid Promo Code", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//method to open call the boarding pass page and the receipt page
	public void OpenFinalPages() {
		Menu.OpenBookingProcess();
		Menu.bookingInProgress = false;
		
		//creates the receipt page
		ReceiptPage rp = new ReceiptPage();
		rp.setLocation(5,100);
		rp.setSize(465,525);
		rp.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		rp.setVisible(true);
		//creates the JOption pane when the menu is closed
		rp.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null,"Thank you for considering Nearly There Air!", "See you soon!", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
		
		//creates the boarding passes page
		BoardingPassPage bp = new BoardingPassPage();
		bp.setLocation(460,150);
		bp.setSize(705,315);
		bp.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		bp.setVisible(true);
		//creates the JOption pane when the menu is closed
		bp.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null,"Thank you for considering Nearly There Air!", "See you soon!", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
	}
	
}
