/* Author: Hari Om Chadha
 * This class creates the booking page asks the user about information regarding destination, date of travel, etc.
 * Method to cancel and reset the booking process is at the bottom
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookingPage extends JFrame implements ActionListener {
	
	//declares all the panels, labels, buttons, arrays, etc on the window
	JPanel bookingPanel;
	JLabel flyingFrom, quantityLabel, quantityNumberLabel, departureDateLabel, returnDateLabel, departureTimeLabel, returnTimeLabel, returnNoteLabel;
	JComboBox<String> locations, departureTime, returnTime, departureYear, returnYear, departureMonth, returnMonth, departureDate, returnDate;
	JCheckBox oneWay, roundTrip;
	JButton quantityUp, quantityDown, cancelButton, continueButton;
	
	//public static to allow access from different classes
	public static int quantityNumber = 1, cancel = 0;
	public static boolean oneWayFlight = true;
	public static String [] timings = {"Time","0100","0300","0500","0700","0900","1100","1300","1500","1700","1900","2100","2300"};
	public static String [] years = {"Year", "2023", "2024", "2025", "2026", "2027", "2028"};
	public static String [] months = {"Month","January","Feburary","March","April","May","June","July","August","September","October","November","December"};
	public static String [] date = {"Date","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28"};
	public static String [] locationNames = {"Choose a location", "Beijing Capital International Airport (BJS)","Dubai International Airport (DXB)","London Heathrow Airport (LHR)","Sydney Airport (SYD)","Cuba: Jose Marti International Airport (HAV)"};
	public static double [] economyPrices = {4849.54, 1142.99, 974.62, 1976.99, 625.99};
	public static double [] businessPrices = {10001.99, 2307.03, 1703.54, 4479.21, 1040.69};
	
	public BookingPage() {
		
		//names the window
		super("Flight Booking");
		
		//creates a content pane
		Container bookingScreen = getContentPane();
		bookingScreen.setLayout(null);
		
		//creates panel to contain everything
		bookingPanel = new JPanel();
		bookingPanel.setLayout(null);
		bookingPanel.setLocation(0,0);
		bookingPanel.setSize(650,350);
		bookingScreen.add(bookingPanel);
		
		//creates the label the displays where the user will be flying from
		flyingFrom = new JLabel("From Toronto Pearson International Airport (YYZ) to:");
		flyingFrom.setLayout(null);
		flyingFrom.setLocation(5,10);
		flyingFrom.setSize(330,40);
		flyingFrom.setHorizontalAlignment(0);
		bookingPanel.add(flyingFrom);
		
		//creates the drop down menu with the list of locations
		locations = new JComboBox<String>(locationNames);
		locations.setLocation(330,10);
		locations.setSize(315,40);
		locations.addActionListener(this);
		bookingPanel.add(locations);
		
		//creates the label asking for number of tickets
		quantityLabel = new JLabel("How many tickets would you like to book?");
		quantityLabel.setLayout(null);
		quantityLabel.setLocation(20,60);
		quantityLabel.setSize(380,30);
		quantityLabel.setHorizontalAlignment(0);
		bookingPanel.add(quantityLabel);
		
		//creates the button to decrease quantity
		quantityDown = new JButton("-");
		quantityDown.setLayout(null);
		quantityDown.setLocation(405,60);
		quantityDown.setSize(45,30);
		quantityDown.addActionListener(this);
		bookingPanel.add(quantityDown);
		
		//creates label to show the quantity
		quantityNumberLabel = new JLabel("" + quantityNumber);
		quantityNumberLabel.setLayout(null);
		quantityNumberLabel.setLocation(470,60);
		quantityNumberLabel.setSize(30,30);
		quantityNumberLabel.setHorizontalAlignment(0);
		quantityNumberLabel.setForeground(Color.red);
		bookingPanel.add(quantityNumberLabel);
		
		//creates the button to increase the quantity
		quantityUp = new JButton("+");
		quantityUp.setLayout(null);
		quantityUp.setLocation(515,60);
		quantityUp.setSize(45,30);
		quantityUp.addActionListener(this);
		bookingPanel.add(quantityUp);
		
		//creates the one-way check box
		oneWay = new JCheckBox("One-Way", true);
		oneWay.setLayout(null);
		oneWay.setLocation(150,110);
		oneWay.setSize(175,30);
		oneWay.setHorizontalAlignment(0);
		oneWay.addActionListener(this);
		bookingPanel.add(oneWay);
		
		//creates the round trip check box
		roundTrip = new JCheckBox("Round Trip", false);
		roundTrip.setLayout(null);
		roundTrip.setLocation(325,110);
		roundTrip.setSize(175,30);
		roundTrip.setHorizontalAlignment(0);
		roundTrip.addActionListener(this);
		bookingPanel.add(roundTrip);
		
		//creates the label for the departure date
		departureDateLabel = new JLabel("Date of departure:");
		departureDateLabel.setLayout(null);
		departureDateLabel.setLocation(5,160);
		departureDateLabel.setSize(120,30);
		departureDateLabel.setHorizontalAlignment(0);
		bookingPanel.add(departureDateLabel);
		
		//creates the drop down menu for the year of departure
		departureYear = new JComboBox<String>(years);
		departureYear.setLocation(340,160);
		departureYear.setSize(85,30);
		departureYear.addActionListener(this);
		bookingPanel.add(departureYear);
		
		//creates the drop down menu for the month of departure
		departureMonth = new JComboBox<String>(months);
		departureMonth.setLocation(215,160);
		departureMonth.setSize(120,30);
		departureMonth.addActionListener(this);
		bookingPanel.add(departureMonth);
		
		//creates the drop down menu for the day of departure
		departureDate = new JComboBox<String>(date);
		departureDate.setLocation(125,160);
		departureDate.setSize(80,30);
		departureDate.addActionListener(this);
		bookingPanel.add(departureDate);
		
		//creates the label for the time of departure from Toronto
		departureTimeLabel = new JLabel("Time of Departure:");
		departureTimeLabel.setLayout(null);
		departureTimeLabel.setLocation(425,160);
		departureTimeLabel.setSize(120,30);
		departureTimeLabel.setHorizontalAlignment(0);
		bookingPanel.add(departureTimeLabel);
		
		//creates the drop down menu for flight timings
		departureTime = new JComboBox<String>(timings);
		departureTime.setLocation(550,160);
		departureTime.setSize(95,30);
		departureTime.addActionListener(this);
		bookingPanel.add(departureTime);
		
		//creates label for the departure of the return flight
		returnDateLabel = new JLabel("Date of return:");
		returnDateLabel.setLayout(null);
		returnDateLabel.setLocation(5,210);
		returnDateLabel.setSize(120,30);
		returnDateLabel.setHorizontalAlignment(0);
		bookingPanel.add(returnDateLabel);
		returnDateLabel.setVisible(false);
		
		//creates the drop down menu for the year of return
		returnYear = new JComboBox<String>(years);
		returnYear.setLocation(340,210);
		returnYear.setSize(85,30);
		returnYear.addActionListener(this);
		bookingPanel.add(returnYear);
		returnYear.setVisible(false);
				
		//creates the drop down menu for the month of return
		returnMonth = new JComboBox<String>(months);
		returnMonth.setLocation(215,210);
		returnMonth.setSize(120,30);
		returnMonth.addActionListener(this);
		bookingPanel.add(returnMonth);
		returnMonth.setVisible(false);
				
		//creates the drop down menu for the day of return
		returnDate = new JComboBox<String>(date);
		returnDate.setLocation(125,210);
		returnDate.setSize(80,30);
		returnDate.addActionListener(this);
		bookingPanel.add(returnDate);
		returnDate.setVisible(false);
				
		
		//creates the label for time of departure for return
		returnTimeLabel = new JLabel("Time of Departure:");
		returnTimeLabel.setLayout(null);
		returnTimeLabel.setLocation(425,210);
		returnTimeLabel.setSize(120,30);
		returnTimeLabel.setHorizontalAlignment(0);
		bookingPanel.add(returnTimeLabel);
		returnTimeLabel.setVisible(false);
		
		//creates the drop down menu for flight timings
		returnTime = new JComboBox<String>(timings);
		returnTime.setLocation(550,210);
		returnTime.setSize(95,30);
		returnTime.addActionListener(this);
		bookingPanel.add(returnTime);
		returnTime.setVisible(false);
		
		//creates the label to show the note regarding return flight's seat selection
		returnNoteLabel = new JLabel("NOTE: Seat selection for the return flight will open at a later date.");
		returnNoteLabel.setLayout(null);
		returnNoteLabel.setLocation(10,250);
		returnNoteLabel.setSize(630,20);
		returnNoteLabel.setHorizontalAlignment(0);
		returnNoteLabel.setForeground(Color.red);
		bookingPanel.add(returnNoteLabel);
		returnNoteLabel.setVisible(false);
		
		//creates the cancel button
		cancelButton = new JButton("Cancel Booking");
		cancelButton.setLayout(null);
		cancelButton.setLocation(100,280);
		cancelButton.setSize(200,50);
		cancelButton.addActionListener(this);
		bookingPanel.add(cancelButton);
		
		//creates the continue button
		continueButton = new JButton("Continue >>");
		continueButton.setLayout(null);
		continueButton.setLocation(350,280);
		continueButton.setSize(200,50);
		continueButton.addActionListener(this);
		bookingPanel.add(continueButton);
		
	}
	// action listener to assign commands to buttons
	public void actionPerformed(ActionEvent e) {
		
		//decreases the ticket quantity
		if (e.getSource() == quantityDown && quantityNumber > 1) {
			quantityNumber -= 1;
			quantityNumberLabel.setText("" + quantityNumber);
			
		//increases the ticket quantity
		} else if (e.getSource() == quantityUp && quantityNumber < 60) {
			quantityNumber += 1;
			quantityNumberLabel.setText("" + quantityNumber);
			
		//makes the return date and time invisible if the oneWay check box is selected
		} else if (e.getSource() == oneWay) {
			oneWay.setSelected(true);
			roundTrip.setSelected(false);
			oneWayFlight = true;
			returnDateLabel.setVisible(false);
			returnDate.setVisible(false);
			returnMonth.setVisible(false);
			returnYear.setVisible(false);
			returnTimeLabel.setVisible(false);
			returnTime.setVisible(false);
			returnNoteLabel.setVisible(false);
			
		//makes the return date and time visible if the roundTrip check box is selected
		} else if (e.getSource() == roundTrip) {
			oneWay.setSelected(false);
			roundTrip.setSelected(true);
			oneWayFlight = false;
			returnDateLabel.setVisible(true);
			returnDate.setVisible(true);
			returnMonth.setVisible(true);
			returnYear.setVisible(true);
			returnTimeLabel.setVisible(true);
			returnTime.setVisible(true);
			returnNoteLabel.setVisible(true);
				
		//calls method to cancel the booking process
		} else if (e.getSource() == cancelButton) {
			CancelBooking();
			
		//makes sure all the information is filled in right before continuing the booking process
		//shows a JOptionPane if any information is wrong or missing
		} else if (e.getSource() == continueButton) {
			if (locations.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null,"Please choose a destination", "Destination missing", JOptionPane.ERROR_MESSAGE);
				return;
			} if (departureYear.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null,"Please choose the year of departure", "Year of Departure", JOptionPane.ERROR_MESSAGE);
				return;
			} if (departureMonth.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null,"Please choose the month of departure", "Month of Departure", JOptionPane.ERROR_MESSAGE);
				return;
			} if (departureDate.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null,"Please choose the date of departure", "Date of Departure", JOptionPane.ERROR_MESSAGE);
				return;
			} if (departureTime.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null,"Please choose the time of departure", "Time of Departure", JOptionPane.ERROR_MESSAGE);
				return;
			} if (oneWayFlight) {
				Menu.bf.setVisible(false);
				Menu.bfOpen = false;
				Menu.piOpen = true;
				Menu.ss.UpdatePrices();
				Menu.OpenBookingProcess();
				return;
			} else {
				if (returnYear.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null,"Please choose the year of return", "Year of Return", JOptionPane.ERROR_MESSAGE);
					return;
				} if (returnMonth.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null,"Please choose the month of return", "Month of Return", JOptionPane.ERROR_MESSAGE);
					return;
				} if (returnDate.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null,"Please choose the date of return", "Date of Return", JOptionPane.ERROR_MESSAGE);
					return;
				} if (returnTime.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null,"Please choose the time of return", "time of Return", JOptionPane.ERROR_MESSAGE);
					return;
				} if (returnYear.getSelectedIndex() < departureYear.getSelectedIndex()) {
					JOptionPane.showMessageDialog(null,"Date of return cannot be on or before the Date of departure", "Date of Return", JOptionPane.ERROR_MESSAGE);
					return;
				} if (returnYear.getSelectedIndex() > departureYear.getSelectedIndex()) {
					Menu.bf.setVisible(false);
					Menu.bfOpen = false;
					Menu.piOpen = true;
					Menu.ss.UpdatePrices();
					Menu.OpenBookingProcess();
					return;
				} if (returnYear.getSelectedIndex() == departureYear.getSelectedIndex()) {
					if (returnMonth.getSelectedIndex() < departureMonth.getSelectedIndex()) {
						JOptionPane.showMessageDialog(null,"Date of return cannot be on or before the Date of departure", "Date of Return", JOptionPane.ERROR_MESSAGE);
						return;
					} if (returnMonth.getSelectedIndex() > departureMonth.getSelectedIndex()) {
						Menu.bf.setVisible(false);
						Menu.bfOpen = false;
						Menu.piOpen = true;
						Menu.ss.UpdatePrices();
						Menu.OpenBookingProcess();
						return;
					} if (returnMonth.getSelectedIndex() == departureMonth.getSelectedIndex()) {
						if (returnDate.getSelectedIndex() <= departureDate.getSelectedIndex()) {
							JOptionPane.showMessageDialog(null,"Date of return cannot be on or before the Date of departure", "Date of Return", JOptionPane.ERROR_MESSAGE);
							return;
						} else {
							Menu.bfOpen = false;
							Menu.piOpen = true;
							Menu.ss.UpdatePrices();
							Menu.OpenBookingProcess();
						}
					}
				}
			}
		}
	}
			
	//This method prompts the user if they want to cancel the booking process
	//it calls the reset method if the user wants to cancel the booking process
	public void CancelBooking() {
		if (Menu.bookingInProgress) {
			cancel = JOptionPane.showConfirmDialog(null,"Are you sure you want to cancel your current booking process?","Cancel Booking?",JOptionPane.YES_NO_OPTION);
			if (cancel == JOptionPane.YES_OPTION) {
				ResetEverything();
			}
		} 
		
	}
	
	//resets everything
	public void ResetEverything() {
		//resets the booking page values
		Menu.bf.setVisible(false);
		quantityNumber = 1;
		quantityNumberLabel.setText("" + quantityNumber);
		departureTime.setSelectedIndex(0);
		returnTime.setSelectedIndex(0);
		departureDate.setSelectedIndex(0);
		departureMonth.setSelectedIndex(0);
		departureYear.setSelectedIndex(0);
		returnDate.setSelectedIndex(0);
		returnMonth.setSelectedIndex(0);
		returnYear.setSelectedIndex(0);
		oneWayFlight = true;
		oneWay.setSelected(true);
		roundTrip.setSelected(false);
		returnDateLabel.setVisible(false);
		returnDate.setVisible(false);
		returnMonth.setVisible(false);
		returnYear.setVisible(false);
		returnTimeLabel.setVisible(false);
		returnTime.setVisible(false);
		returnDateLabel.setVisible(false);
		returnTimeLabel.setVisible(false);
		returnTime.setVisible(false);
		returnNoteLabel.setVisible(false);
		cancel = 0;
		//resets all the passenger info page values
		Menu.pi.setVisible(false);
		Menu.bfOpen = false;
		Menu.pi.nonVeg.setSelected(true);
		Menu.pi.adult.setSelected(true);
		Menu.pi.currentPassenger = 1;
		Menu.pi.currentPassengerLabel.setText("Passenger #" + Menu.pi.currentPassenger);
		Menu.pi.firstName.setText("");
		Menu.pi.lastName.setText("");
		PassengerInfoPage.firstNamesList.clear();
		PassengerInfoPage.lastNamesList.clear();
		PassengerInfoPage.ageType.clear();
		PassengerInfoPage.mealType.clear();
		PassengerInfoPage.ageType.add(Menu.pi.currentPassenger - 1, "ADULT");
		PassengerInfoPage.mealType.add(Menu.pi.currentPassenger - 1, "NON-VEG");
		Menu.piOpen = false;
		//resets all the seat selection page values
		Menu.ss.setVisible(false);
		for (int i = 0; i < 60; i++) {
			if (i < 20) {
				SeatSelectionPage.seatButtons.get(i).setBackground(Color.orange);
			} else {
				SeatSelectionPage.seatButtons.get(i).setBackground(Color.blue);
			}
		}
		SeatSelectionPage.seats.clear();
		SeatSelectionPage.currentPassenger = 1;
		SeatSelectionPage.economySeatsQty = 0;
		SeatSelectionPage.businessSeatsQty = 0;
		Menu.ss.visaButton.setSelected(true);
		Menu.ss.nameOnCardField.setText("");
		Menu.ss.cardNumberField.setText("");
		Menu.ss.expiryMonth.setSelectedIndex(0);
		Menu.ss.expiryYear.setSelectedIndex(0);
		Menu.ss.securityCodeField.setText("");
		SeatSelectionPage.seats.clear();
		SeatSelectionPage.seatChoice.clear();
		SeatSelectionPage.economyCost = 0;
		SeatSelectionPage.businessCost = 0;
		SeatSelectionPage.subTotal = SeatSelectionPage.economyCost + SeatSelectionPage.businessCost;
		SeatSelectionPage.taxAmount = 0.13 * SeatSelectionPage.subTotal;
		SeatSelectionPage.totalAmount = SeatSelectionPage.subTotal + SeatSelectionPage.taxAmount;
		Menu.ss.UpdatePrices();
		Menu.ssOpen = false;
		//resets all the values related to the promo code page
		Menu.pc.setVisible(false);
		Menu.pc.promoCodeField.setText("");
		PromoCodePage.discount = 0;
		Menu.pcOpen = false;
		Menu.bookingInProgress = false;
	}

}
