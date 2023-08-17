/*Author: Hari Om Chadha
 * This class creates the Sydney page with information about Sydeny.
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SydneyPage extends JFrame implements ActionListener {
	
	//declares the labels, button and panels on this window
	JLabel SydneyInfo, SydneyPrices, SydneyImage;
	JButton bookFlightButton;
	JPanel SydneyPanel;

	public SydneyPage() {
		
		//title of the window
		super("Sydney");
		
		//creates a content pane
		Container SydneyScreen = getContentPane();
		SydneyScreen.setLayout(null);
				
		//creates the panel to hold everything
		SydneyPanel = new JPanel();
		SydneyPanel.setLayout(null);
		SydneyPanel.setLocation(0,0);
		SydneyPanel.setSize(300,420);
		SydneyScreen.add(SydneyPanel);
				
		//creates the image and scales it based on the window size
		SydneyImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/Sydney.jpeg")).getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT)));
		SydneyImage.setLayout(null);
		SydneyImage.setLocation(0,0);
		SydneyImage.setSize(300,150);
		SydneyPanel.add(SydneyImage);
				
		//creates the label that holds all the information
		SydneyInfo = new JLabel("<html>Sydney is the largest and also most popular city in Australia. The most famous attractions are Sydney Opera House, Harbour Cruise, Taronga Zoo, Sydney Tower Eye, and many more.<html>");
		SydneyInfo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		SydneyInfo.setLayout(null);
		SydneyInfo.setLocation(10,160);
		SydneyInfo.setSize(280,100);
		SydneyInfo.setForeground(Color.blue);
		SydneyPanel.add(SydneyInfo);
			
		// creates the label that displays the prices of flights
		SydneyPrices = new JLabel("<html>Flight Ticket Prices :<br>Economy: $" + SeatSelectionPage.money.format(BookingPage.economyPrices[3]) + "<br>Business : $" + SeatSelectionPage.money.format(BookingPage.businessPrices[3]) + "<html>");
		SydneyPrices.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		SydneyPrices.setLayout(null);
		SydneyPrices.setLocation(10,270);
		SydneyPrices.setSize(280,50);
		SydneyPrices.setForeground(Color.red);
		SydneyPrices.setHorizontalAlignment(0);
		SydneyPanel.add(SydneyPrices);
				
		// creates the book flight button
		bookFlightButton = new JButton("Book Flight");
		bookFlightButton.setLayout(null);
		bookFlightButton.setLocation(20,330);
		bookFlightButton.setSize(260,60);
		bookFlightButton.addActionListener(this);
		SydneyPanel.add(bookFlightButton);			
	}
	
		//cancels the booking process if it is already in process by calling the CancelBooking method
		//calls the method to open a new booking page and preselects the destination
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,Menu.mikeStadiumLabel, "Ad", JOptionPane.PLAIN_MESSAGE, Menu.mikeStadium);
			Menu.bf.CancelBooking();
			if (!Menu.bookingInProgress) {
				Menu.bf.locations.setSelectedIndex(4);
			}
			Menu.OpenBookingProcess();
		}

}
