/* Author: Hari Om Chadha
 * This class creates the page that asks for the passenger details
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PassengerInfoPage extends JFrame implements ActionListener {
	
	// declares all the labels, buttons, panel, etc on this window
	JPanel passengerInfoPanel;
	JLabel currentPassengerLabel, firstNameLabel, lastNameLabel, ageLabel, mealLabel;
	JTextField firstName, lastName;
	JButton continueButton, cancelButton;
	JRadioButton minor, adult, senior, vegan, veg, nonVeg;
	ButtonGroup ageChoice, mealChoice;
	
	//makes array lists to save information of the passengers
	public static ArrayList <String> firstNamesList = new ArrayList <String>();
	public static ArrayList <String> lastNamesList = new ArrayList <String>();
	public static ArrayList <String> mealType = new ArrayList <String>();
	public static ArrayList <String> ageType = new ArrayList <String>();
	
	//keeps track of what passengers information is being filled
	int currentPassenger = 1;
	
	public PassengerInfoPage() {
		
		//names the window
		super("Passenger Information");
		
		//creates a content pane
		Container passengerInfoScreen = getContentPane();
		passengerInfoScreen.setLayout(null);
		
		//creates the panel to hold everything
		passengerInfoPanel = new JPanel();
		passengerInfoPanel.setLayout(null);
		passengerInfoPanel.setLocation(0,0);
		passengerInfoPanel.setSize(500,300);
		passengerInfoScreen.add(passengerInfoPanel);
		
		//creates the label to show the number of passenger whose info is being filled
		currentPassengerLabel = new JLabel("Passenger #" + currentPassenger);
		currentPassengerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		currentPassengerLabel.setLayout(null);
		currentPassengerLabel.setLocation(150,10);
		currentPassengerLabel.setSize(200,30);
		currentPassengerLabel.setHorizontalAlignment(0);
		currentPassengerLabel.setForeground(Color.red);
		passengerInfoPanel.add(currentPassengerLabel);
		
		//creates the label asking for first name
		firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setLayout(null);
		firstNameLabel.setLocation(40,40);
		firstNameLabel.setSize(100,20);
		passengerInfoPanel.add(firstNameLabel);
		
		//creates the text field for the first name
		firstName = new JTextField("",15);
		firstName.setLayout(null);
		firstName.setLocation(40,65);
		firstName.setSize(200,30);
		passengerInfoPanel.add(firstName);
		
		//creates the label asking for last name
		lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setLayout(null);
		lastNameLabel.setLocation(260,40);
		lastNameLabel.setSize(100,20);
		passengerInfoPanel.add(lastNameLabel);
		
		//creates the text field for the first name
		lastName = new JTextField("",15);
		lastName.setLayout(null);
		lastName.setLocation(260,65);
		lastName.setSize(200,30);
		passengerInfoPanel.add(lastName);
		
		//creates the label asking for age category
		ageLabel = new JLabel("Age Category:");
		ageLabel.setLayout(null);
		ageLabel.setLocation(30,105);
		ageLabel.setSize(150,30);
		ageLabel.setHorizontalAlignment(0);
		passengerInfoPanel.add(ageLabel);
		
		//creates the radio button 'minor'
		minor = new JRadioButton("Minor");
		minor.setLayout(null);
		minor.setLocation(190,105);
		minor.setSize(80,30);
		minor.addActionListener(this);
		passengerInfoPanel.add(minor);
		
		//creates the radio button 'Adult'
		adult = new JRadioButton("Adult");
		adult.setLayout(null);
		adult.setLocation(280,105);
		adult.setSize(80,30);
		adult.isSelected();
		adult.addActionListener(this);
		passengerInfoPanel.add(adult);
		
		//creates the radio button 'Senior'
		senior = new JRadioButton("Senior");
		senior.setLayout(null);
		senior.setLocation(370,105);
		senior.setSize(80,30);
		senior.addActionListener(this);
		passengerInfoPanel.add(senior);
		
		//adds all the age radio buttons to a button group
		ageChoice = new ButtonGroup();
		ageChoice.add(minor);
		ageChoice.add(adult);
		ageChoice.add(senior);
		adult.setSelected(true);
		ageType.add(currentPassenger - 1, "ADULT");
		
		//creates the label asking for meal choice
		mealLabel = new JLabel("Meal Type:");
		mealLabel.setLayout(null);
		mealLabel.setLocation(30,145);
		mealLabel.setSize(150,30);
		mealLabel.setHorizontalAlignment(0);
		passengerInfoPanel.add(mealLabel);
		
		//creates the radio button 'vegan'
		vegan = new JRadioButton("Vegan");
		vegan.setLayout(null);
		vegan.setLocation(190,145);
		vegan.setSize(80,30);
		vegan.addActionListener(this);
		passengerInfoPanel.add(vegan);
				
		//creates the radio button 'veg'
		veg = new JRadioButton("Veg");
		veg.setLayout(null);
		veg.setLocation(280,145);
		veg.setSize(80,30);
		veg.addActionListener(this);
		passengerInfoPanel.add(veg);
				
		//creates the radio button 'nonVeg'
		nonVeg = new JRadioButton("Non-Veg");
		nonVeg.setLayout(null);
		nonVeg.setLocation(370,145);
		nonVeg.setSize(90,30);
		nonVeg.isSelected();
		nonVeg.addActionListener(this);
		passengerInfoPanel.add(nonVeg);
				
		//adds all the meal radio buttons to a button group
		mealChoice = new ButtonGroup();
		mealChoice.add(vegan);
		mealChoice.add(veg);
		mealChoice.add(nonVeg);
		nonVeg.setSelected(true);
		mealType.add(currentPassenger - 1, "NON-VEG");
		
		//creates the cancel button
		cancelButton = new JButton("Cancel Booking");
		cancelButton.setLayout(null);
		cancelButton.setLocation(40,180);
		cancelButton.setSize(200,50);
		cancelButton.addActionListener(this);
		passengerInfoPanel.add(cancelButton);
				
		//creates the continue button
		continueButton = new JButton("Contine >>");
		continueButton.setLayout(null);
		continueButton.setLocation(260,180);
		continueButton.setSize(200,50);
		continueButton.addActionListener(this);
		passengerInfoPanel.add(continueButton);		
	}
	
	// action listener to assign commands to buttons
	public void actionPerformed(ActionEvent e) {
		
		//updates the state of age category
		if (e.getSource() == minor) {
			ageType.add(currentPassenger - 1, "MINOR");
			
		//updates the state of age category
		} else if (e.getSource() == adult) {
			ageType.add(currentPassenger - 1, "ADULT");
			
		//updates the state of age category
		} else if (e.getSource() == senior) {
			ageType.add(currentPassenger - 1, "SENIOR");
			
		//updates the state of meal category
		} else if (e.getSource() == vegan) {
			mealType.add(currentPassenger - 1, "VEGAN");
			
		//updates the state of meal category
		} else if (e.getSource() == veg) {
			mealType.add(currentPassenger - 1, "VEG");
			
		//updates the state of meal category
		} else if (e.getSource() == nonVeg) {
			mealType.add(currentPassenger - 1, "NON-VEG");
			
		//calls method to cancel the booking process
		} else if (e.getSource() == cancelButton) {
			Menu.bf.CancelBooking();
			
		//makes sure all the information is filled in right before continuing the booking process
		//shows a JOptionPane if any information is wrong or missing
		} else if (e.getSource() == continueButton) {
			if (firstName.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please type the first name", "First Name missing", JOptionPane.ERROR_MESSAGE);
				return;
			} if (lastName.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Please type the last name", "Last Name missing", JOptionPane.ERROR_MESSAGE);
				return;
			} else {
				Menu.pi.setVisible(false);
				firstNamesList.add(currentPassenger-1, firstName.getText());
				lastNamesList.add(currentPassenger-1, lastName.getText());
				currentPassenger += 1;
				Menu.pi.firstName.setText(null);
				Menu.pi.lastName.setText(null);
				nonVeg.setSelected(true);
				adult.setSelected(true);
				
				//calls the page again if there are more passengers whose information needs to be filled
				if (currentPassenger <= BookingPage.quantityNumber) {
					currentPassengerLabel.setText("Passenger #" + currentPassenger);
					ageType.add(currentPassenger - 1, "ADULT");
					mealType.add(currentPassenger - 1, "NON-VEG");
					Menu.OpenBookingProcess();
				} else {
					Menu.piOpen = false;
					Menu.ssOpen = true;
					Menu.OpenBookingProcess();
				}
			}
		}
	}
}

