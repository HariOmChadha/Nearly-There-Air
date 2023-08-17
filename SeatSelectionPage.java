/* Author: Hari Om Chadha
 * This class creates the page that asks the user to select seats and enter payment information
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.awt.event.*;
import java.util.*;

public class SeatSelectionPage extends JFrame implements ActionListener {
	
	// declares all the labels, seatButtons, panel, etc on this window
	JPanel seatsPanel, payingPanel;
	JLabel planeSeats, paymentOptionLabel, visaLabel, masterCardLabel, americanExpressLabel, nameOnCardLabel, cardNumberLabel, expiryDateLabel, securityCodeLabel, pricesLabel, economyCostLabel, businessCostLabel, subTotalLabel, taxLabel, totalLabel, flightTypeLabel;
	JButton clearSelection;
	JTextField nameOnCardField, cardNumberField, securityCodeField;
	JRadioButton visaButton, masterCardButton, americanExpressButton;
	ButtonGroup paymentOptions;
	JComboBox<String> expiryMonth, expiryYear;
	JButton continueButton, cancelButton;
	
	
	//declares array lists and other variables to store information
	public static ArrayList<String> seats = new ArrayList<String>();
	public static ArrayList<String> seatChoice = new ArrayList<String>();
	public static ArrayList<JLabel> seatCodes = new ArrayList<JLabel>();
	public static ArrayList<JButton> seatButtons = new ArrayList<JButton>();
	public static int xLocation = 205, yLocation = 110, currentPassenger = 1, businessSeatsQty = 0, economySeatsQty = 0;
	String seatPosition = "ABCDEFGHIJKLMNOPQRTSUVWXYZ";
	public static String nameOnCard, cardType = "VISA", cardNumber, flightTypeText;
	public static double economyCost = 0, businessCost = 0, subTotal = 0, taxAmount = 0, totalAmount = 0;
	public static DecimalFormat money = new DecimalFormat("00.00");
	
	public SeatSelectionPage() {
		
		//names the window
		super("Seat Selection");
		
		//creates a content pane
		Container seatSelectionScreen = getContentPane();
		seatSelectionScreen.setLayout(null);
		
		//creates the panel to hold the plane layout
		seatsPanel = new JPanel();
		seatsPanel.setLayout(null);
		seatsPanel.setLocation(0,0);
		seatsPanel.setSize(800,350);
		seatSelectionScreen.add(seatsPanel);
		
		//makes the label to hold the image and the seatButtons
		planeSeats = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/PlaneLayout.png")).getImage().getScaledInstance(800,350,Image.SCALE_DEFAULT)));
		planeSeats.setLayout(null);
		planeSeats.setLocation(0,0);
		planeSeats.setSize(800,350);
		seatsPanel.add(planeSeats);
		
		//creates the button to clear the seats selected
		clearSelection = new JButton("Clear Selection");
		clearSelection.setLayout(null);
		clearSelection.setLocation(290,10);
		clearSelection.setSize(200,70);
		clearSelection.addActionListener(this);
		planeSeats.add(clearSelection);
		
		//this creates all the labels that tell the row letter and number
		//changes the x and y values of the location based on the number of the label
		//the labels don't have a name so '.get()' is used to set parameters regarding the label
		for (int i = 0; i < 16; i++) {
			if (i == 15) {
				xLocation = 175;
				yLocation = 145;
				for (int a = 1; a < 5; a++) {
					if (a == 3) {
						yLocation += 3;
					}
					seatCodes.add(new JLabel(Integer.toString(a)));
					seatCodes.get(i+a-1).setLayout(null);
					seatCodes.get(i+a-1).setLocation(xLocation,yLocation);
					seatCodes.get(i+a-1).setSize(25,25);
					seatCodes.get(i+a-1).setForeground(Color.red);
					seatCodes.get(i+a-1).setHorizontalAlignment(0);
					yLocation += 29;
					planeSeats.add(seatCodes.get(i+a-1));
				}
			} else {
				seatCodes.add(new JLabel(Character.toString(seatPosition.charAt(i))));
				seatCodes.get(i).setLayout(null);
				seatCodes.get(i).setLocation(xLocation,yLocation);
				seatCodes.get(i).setSize(25,25);
				seatCodes.get(i).setHorizontalAlignment(0);
				seatCodes.get(i).setForeground(Color.red);
				xLocation += 31;
				planeSeats.add(seatCodes.get(i));
			}	
		}
		
		//this creates all the buttons that act as the seats of the plane
		//changes the x and y values of the location based on the number of the button
		//the buttons don't have a name so '.get()' is used to set parameters regarding the button			
		xLocation = 205;
		yLocation = 145;
		for (int i = 1; i < 61; i ++) {
			seatButtons.add(new JButton());
			seatButtons.get(i-1).setLayout(null);
			seatButtons.get(i-1).setLocation(xLocation,yLocation);
			seatButtons.get(i-1).setSize(25,25);
			planeSeats.add(seatButtons.get(i-1));
			if (i < 21) {
				seatButtons.get(i-1).setOpaque(true);
				seatButtons.get(i-1).setBorderPainted(false);
				seatButtons.get(i-1).setBackground(Color.orange);
				seatButtons.get(i-1).addActionListener(new businessSeats());
			} else {
				seatButtons.get(i-1).setOpaque(true);
				seatButtons.get(i-1).setBorderPainted(false);
				seatButtons.get(i-1).setBackground(Color.blue);
				seatButtons.get(i-1).addActionListener(new economySeats());
			}
			if (i%2 != 0) {
				yLocation += 29;
			} else {
				if (i%4 == 0) {
					xLocation += 31;
					yLocation -= 92;
				} else {
					yLocation += 34;
				}
			}	
		}
		
		//creates the panel to display all the payment prompts
		payingPanel = new JPanel();
		payingPanel.setLayout(null);
		payingPanel.setLocation(0,350);
		payingPanel.setSize(800,250);
		seatSelectionScreen.add(payingPanel);
		
		//creates the label saying 'choose' payment option
		paymentOptionLabel = new JLabel("Choose a payment method:");
		paymentOptionLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		paymentOptionLabel.setLayout(null);
		paymentOptionLabel.setLocation(10,20);
		paymentOptionLabel.setSize(350,20);
		paymentOptionLabel.setHorizontalAlignment(0);
		payingPanel.add(paymentOptionLabel);
		
		//creates the visa radio button
		visaButton = new JRadioButton();
		visaButton.setLayout(null);
		visaButton.setLocation(5,50);
		visaButton.setSize(30,40);
		visaButton.setHorizontalAlignment(0);
		visaButton.setSelected(true);
		visaButton.addActionListener(this);
		payingPanel.add(visaButton);
		
		//creates the visa image
		visaLabel = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/VisaIcon.png")).getImage().getScaledInstance(75,40,Image.SCALE_DEFAULT)));
		visaLabel.setLayout(null);
		visaLabel.setLocation(40,50);
		visaLabel.setSize(75,40);
		visaLabel.setHorizontalAlignment(0);
		payingPanel.add(visaLabel);
		
		//creates the mastercard radio button
		masterCardButton = new JRadioButton();
		masterCardButton.setLayout(null);
		masterCardButton.setLocation(120,50);
		masterCardButton.setSize(30,40);
		masterCardButton.setHorizontalAlignment(0);
		masterCardButton.addActionListener(this);
		payingPanel.add(masterCardButton);
		
		//creates the mastercard image
		masterCardLabel = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/MasterCardIcon.png")).getImage().getScaledInstance(75,40,Image.SCALE_DEFAULT)));
		masterCardLabel.setLayout(null);
		masterCardLabel.setLocation(155,50);
		masterCardLabel.setSize(75,40);
		masterCardLabel.setHorizontalAlignment(0);
		payingPanel.add(masterCardLabel);		
		
		//creates the American express radio button
		americanExpressButton = new JRadioButton();
		americanExpressButton.setLayout(null);
		americanExpressButton.setLocation(235,50);
		americanExpressButton.setSize(30,40);
		americanExpressButton.setHorizontalAlignment(0);
		americanExpressButton.addActionListener(this);
		payingPanel.add(americanExpressButton);
		
		//creates the American express image
		americanExpressLabel = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/AmericanExpressIcon.jpeg")).getImage().getScaledInstance(95,40,Image.SCALE_DEFAULT)));
		americanExpressLabel.setLayout(null);
		americanExpressLabel.setLocation(270,50);
		americanExpressLabel.setSize(75,40);
		americanExpressLabel.setHorizontalAlignment(0);
		payingPanel.add(americanExpressLabel);
		
		//creates a button group for the payment options
		paymentOptions = new ButtonGroup();
		paymentOptions.add(visaButton);
		paymentOptions.add(masterCardButton);
		paymentOptions.add(americanExpressButton);
		
		//creates the label name on card
		nameOnCardLabel = new JLabel("Name on card:");
		nameOnCardLabel.setLayout(null);
		nameOnCardLabel.setLocation(10,100);
		nameOnCardLabel.setSize(100,30);
		nameOnCardLabel.setHorizontalAlignment(0);
		payingPanel.add(nameOnCardLabel);
		
		//creates the text field to add the name on card
		nameOnCardField = new JTextField("", 27);
		nameOnCardField.setLayout(null);
		nameOnCardField.setLocation(115,100);
		nameOnCardField.setSize(230,30);
		nameOnCardField.setHorizontalAlignment(2);
		payingPanel.add(nameOnCardField);
		
		//creates the label for the card number
		cardNumberLabel = new JLabel("Card Number:");
		cardNumberLabel.setLayout(null);
		cardNumberLabel.setLocation(10,140);
		cardNumberLabel.setSize(100,30);
		cardNumberLabel.setHorizontalAlignment(0);
		payingPanel.add(cardNumberLabel);
				
		//creates the text field to add the card number
		cardNumberField = new JTextField("", 16);
		cardNumberField.setLayout(null);
		cardNumberField.setLocation(115,140);
		cardNumberField.setSize(110,30);
		cardNumberField.setHorizontalAlignment(2);
		payingPanel.add(cardNumberField);
		
		//creates the label for the security code
		securityCodeLabel = new JLabel("CVV:");
		securityCodeLabel.setLayout(null);
		securityCodeLabel.setLocation(240,140);
		securityCodeLabel.setSize(65,30);
		securityCodeLabel.setHorizontalAlignment(0);
		payingPanel.add(securityCodeLabel);
				
		//creates the field for the security code
		securityCodeField = new JTextField("", 3);
		securityCodeField.setLayout(null);
		securityCodeField.setLocation(305,140);
		securityCodeField.setSize(40,30);
		securityCodeField.setHorizontalAlignment(0);
		payingPanel.add(securityCodeField);
				
		//creates the expiry date label
		expiryDateLabel = new JLabel("Expiry Date:");
		expiryDateLabel.setLayout(null);
		expiryDateLabel.setLocation(10,180);
		expiryDateLabel.setSize(100,30);
		expiryDateLabel.setHorizontalAlignment(0);
		payingPanel.add(expiryDateLabel);
		
		//creates the drop down menu for the month of expiry date
		expiryMonth = new JComboBox<String>(BookingPage.months);
		expiryMonth.setLocation(115,180);
		expiryMonth.setSize(125,30);
		payingPanel.add(expiryMonth);
		
		//creates the drop down menu for the year of expiry date
		expiryYear = new JComboBox<String>(BookingPage.years);
		expiryYear.setLocation(245,180);
		expiryYear.setSize(100,30);
		payingPanel.add(expiryYear);
		
		//creates the label to show the type of ticket
		flightTypeLabel = new JLabel();
		flightTypeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		flightTypeLabel.setLayout(null);
		flightTypeLabel.setLocation(355,05);
		flightTypeLabel.setSize(340,25);
		flightTypeLabel.setForeground(Color.red);
		flightTypeLabel.setHorizontalAlignment(0);
		payingPanel.add(flightTypeLabel);
		
		//creates the label that shows the price of tickets
		pricesLabel = new JLabel("Economy: $" + money.format(BookingPage.economyPrices[Menu.bf.locations.getSelectedIndex()]) + "    Business: $" + money.format(BookingPage.businessPrices[Menu.bf.locations.getSelectedIndex()]));
		pricesLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		pricesLabel.setLayout(null);
		pricesLabel.setLocation(355,35);
		pricesLabel.setSize(340,25);
		pricesLabel.setForeground(Color.red);
		pricesLabel.setHorizontalAlignment(0);
		payingPanel.add(pricesLabel);
		
		//creates the label that shows the economy tickets quantity and price
		economyCostLabel = new JLabel("Economy Class  x" + economySeatsQty + "   =   $" + money.format(economyCost));
		economyCostLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		economyCostLabel.setLayout(null);
		economyCostLabel.setLocation(355,65);
		economyCostLabel.setSize(280,25);
		economyCostLabel.setHorizontalAlignment(4);
		payingPanel.add(economyCostLabel);
		
		//creates the label that shows the business tickets quantity and price
		businessCostLabel = new JLabel("Business Class  x" + businessSeatsQty + "   =   $" + money.format(businessCost));
		businessCostLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		businessCostLabel.setLayout(null);
		businessCostLabel.setLocation(355,95);
		businessCostLabel.setSize(280,25);
		businessCostLabel.setHorizontalAlignment(4);
		payingPanel.add(businessCostLabel);
		
		//creates the sub total label
		subTotalLabel = new JLabel("Sub Total  =  $" + money.format(subTotal));
		subTotalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		subTotalLabel.setLayout(null);
		subTotalLabel.setLocation(355,125);
		subTotalLabel.setSize(280,25);
		subTotalLabel.setHorizontalAlignment(4);
		payingPanel.add(subTotalLabel);
		
		//creates the tax label
		taxLabel = new JLabel("Tax(13%) =  $" + money.format(taxAmount));
		taxLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		taxLabel.setLayout(null);
		taxLabel.setLocation(355,155);
		taxLabel.setSize(280,25);
		taxLabel.setHorizontalAlignment(4);
		payingPanel.add(taxLabel);
		
		//creates the total label
		totalLabel = new JLabel("Total  =  $" + money.format(totalAmount));
		totalLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		totalLabel.setLayout(null);
		totalLabel.setLocation(355,185);
		totalLabel.setSize(280,25);
		totalLabel.setForeground(Color.red);
		totalLabel.setHorizontalAlignment(4);
		payingPanel.add(totalLabel);
		
		//creates the cancel button
		cancelButton = new JButton("Cancel");
		cancelButton.setLayout(null);
		cancelButton.setLocation(705,10);
		cancelButton.setSize(90,100);
		cancelButton.addActionListener(this);
		payingPanel.add(cancelButton);
		
		//creates the continue button
		continueButton = new JButton("Continue");
		continueButton.setLayout(null);
		continueButton.setLocation(705,120);
		continueButton.setSize(90,100);
		continueButton.addActionListener(this);
		payingPanel.add(continueButton);
		
		
	}
	
	//action listener to deal with all the tasks not related to the plane seat buttons
	public void actionPerformed(ActionEvent e) {
		
		//resets the seat colors and clears all the saved information like seat numbers, quantities, etc.
		if (e.getSource() == clearSelection) {
			for (int i = 0; i < 60; i++) {
				if (i < 20) {
					seatButtons.get(i).setBackground(Color.orange);
				} else {
					seatButtons.get(i).setBackground(Color.blue);
				}
			}
			seats.clear();
			currentPassenger = 1;
			economySeatsQty = 0;
			businessSeatsQty = 0;
			economyCost = 0;
			businessCost = 0;
			subTotal = economyCost + businessCost;
			taxAmount = 0.13 * subTotal;
			totalAmount = subTotal + taxAmount;
			UpdatePrices();
			
		//updates the card type
		} else if (e.getSource() == visaButton) {
			cardType = "VISA";
		
		//updates the card type
		} else if (e.getSource() == masterCardButton) {
			cardType= "MC";
			
		//updates the card type
		} else if (e.getSource() == americanExpressButton) {
			cardType = "AMEX";
			
		//updates the card type
		} else if (e.getSource() == cancelButton) {
			Menu.bf.CancelBooking();
			
		//continues after making sure that everything is working fine
		} else if (e.getSource() == continueButton) {
			if (currentPassenger <= BookingPage.quantityNumber) {
				JOptionPane.showMessageDialog(null,"Please select " + BookingPage.quantityNumber + " seat(s). Clear selection to choose different seats." , "Select seats", JOptionPane.ERROR_MESSAGE);
				return;
			} if (nameOnCardField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter the name on card" , "Name on Card", JOptionPane.ERROR_MESSAGE);
				return;
			} if (cardNumberField.getText().length() != 16) {
				JOptionPane.showMessageDialog(null,"The card number is invalid (Must be 16 characters)" , "Invalid Card Number", JOptionPane.ERROR_MESSAGE);
				return;
			} try {
				Long.parseLong(cardNumberField.getText());
			} catch (Exception a) {
				JOptionPane.showMessageDialog(null,"The card number is invalid" , "Invalid Card Number", JOptionPane.ERROR_MESSAGE);
				return;
			} if (expiryMonth.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null,"Please choose the card's expiry month" , "Expiry Month", JOptionPane.ERROR_MESSAGE);
				return;
			} if (expiryYear.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null,"Please choose the card's expiry year" , "Expiry Year", JOptionPane.ERROR_MESSAGE);
				return;
			} if (securityCodeField.getText().length() != 3) {
				JOptionPane.showMessageDialog(null,"The CVV is invalid" , "Invalid CVV", JOptionPane.ERROR_MESSAGE);
				return;
			} try {
				Integer.parseInt(securityCodeField.getText());
			} catch (Exception a) {
				JOptionPane.showMessageDialog(null,"The CVV is invalid" , "Invalid CVV", JOptionPane.ERROR_MESSAGE);
				return;
			}
			cardNumber = cardNumberField.getText().substring(12);
			Menu.ssOpen = false;
			Menu.pcOpen = true;
			Menu.OpenBookingProcess();
		}
	}
	
	//action listener specific to business class seats.
	//changes the color of the seat and updates the number to selected seats to be used to make the receipt 
	private class businessSeats implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (currentPassenger <= BookingPage.quantityNumber) {
				for (int i = 1; i < 21; i ++) {
					// i=1 means the first button which is at index i-1
					//eg: seat 12 is at index 11
					if (e.getSource() == seatButtons.get(i-1)) {
						if (seatButtons.get(i-1).getBackground() == Color.orange) {
							seatButtons.get(i-1).setBackground(Color.green);
							//uses the seat number NOT the index
							if (i%4 == 0) {
								seats.add(currentPassenger-1, Character.toString(seatPosition.charAt((i/4)-1)) + "4" );
							} else {
								seats.add(currentPassenger-1, Character.toString(seatPosition.charAt((i/4))) + Integer.toString(i%4));
							}
							seatChoice.add(currentPassenger-1, "BUSINESS");
							currentPassenger += 1;
							businessSeatsQty += 1;
							if(BookingPage.oneWayFlight) {
								businessCost = (BookingPage.businessPrices[Menu.bf.locations.getSelectedIndex() - 1] * businessSeatsQty);
							} else {
								businessCost = ((BookingPage.businessPrices[Menu.bf.locations.getSelectedIndex() - 1] * 2 * (1 - 0.05)) * businessSeatsQty);
							}
							subTotal = economyCost + businessCost;
							taxAmount = 0.13 * subTotal;
							totalAmount = subTotal + taxAmount;
							UpdatePrices();
							return;
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,"You can only choose " + BookingPage.quantityNumber + " seat(s). Clear selection to choose different seats." , "Limited seats", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//action listener specific to economy class seats.
	//changes the colour of the seat and updates the number to selected seats to be used to make the receipt
	private class economySeats implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if (currentPassenger <= BookingPage.quantityNumber) {
				for (int i = 21; i < 61; i ++) {
					if (e.getSource() == seatButtons.get(i-1)) {
						if (seatButtons.get(i-1).getBackground() == Color.blue) {
							seatButtons.get(i-1).setBackground(Color.green);
							if (i%4 == 0) {
								seats.add(currentPassenger-1, Character.toString(seatPosition.charAt((i/4)-1)) + "4" );
							} else {
								seats.add(currentPassenger-1, Character.toString(seatPosition.charAt(i/4)) + Integer.toString(i%4));
							}
							seatChoice.add(currentPassenger-1, "ECONOMY");
							currentPassenger += 1;
							economySeatsQty += 1;
							if (BookingPage.oneWayFlight) {
								economyCost = (BookingPage.economyPrices[Menu.bf.locations.getSelectedIndex() - 1] * economySeatsQty);
							}
							economyCost = ((BookingPage.economyPrices[Menu.bf.locations.getSelectedIndex() - 1] * 2 * (1 - 0.05)) * economySeatsQty);
							subTotal = economyCost + businessCost;
							taxAmount = 0.13 * subTotal;
							totalAmount = subTotal + taxAmount;
							UpdatePrices();
							return;
						} else {
							JOptionPane.showMessageDialog(null,"Clear selection to choose different seats." , "Limited seats", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,"You can only choose " + BookingPage.quantityNumber + " seat(s). Clear selection to choose different seats." , "Limited seats", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//updates all the costs and prices on the seat selection window
	public void UpdatePrices() {
		if (BookingPage.oneWayFlight) {
			flightTypeLabel.setText("ONE WAY (OW)");
			flightTypeText = "OW";
			if (Menu.bf.locations.getSelectedIndex() != 0) {
				pricesLabel.setText("Economy: $" + money.format(BookingPage.economyPrices[Menu.bf.locations.getSelectedIndex() - 1]) + "    Business: $" + money.format(BookingPage.businessPrices[Menu.bf.locations.getSelectedIndex() - 1]));
			}
		} else {
			flightTypeLabel.setText("ROUND TRIP (RP)");
			flightTypeText = "RP";
			if (Menu.bf.locations.getSelectedIndex() != 0) {
				pricesLabel.setText("Economy: $" + money.format((BookingPage.economyPrices[Menu.bf.locations.getSelectedIndex() - 1] * 2 * (1 - 0.05))) + "    Business: $" + money.format((BookingPage.businessPrices[Menu.bf.locations.getSelectedIndex() - 1] * 2 * (1 - 0.05))));
			}
		}
		economyCostLabel.setText("Economy Class  x" + economySeatsQty + "   =   $" + money.format(economyCost));
		businessCostLabel.setText("Business Class  x" + businessSeatsQty + "   =   $" + money.format(businessCost));
		subTotalLabel.setText("Sub Total  =  $" + money.format(subTotal));
		taxLabel.setText("Tax(13%) =  $" + money.format(taxAmount));
		totalLabel.setText("Total  =  $" + money.format(totalAmount));
		Menu.pc.totalLabel.setText("Your current total is $" + SeatSelectionPage.money.format(SeatSelectionPage.totalAmount));
	}
	
}
