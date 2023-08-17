/* Author: Hari Om Chadha
 * This class creates the Beijing page with information about Beijing.
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BeijingPage extends JFrame implements ActionListener {
	
	// declares all the labels, button and panels on this window
	JLabel BeijingInfo, BeijingPrices, BeijingImage;
	JButton bookFlightButton;
	JPanel BeijingPanel;
	
	public BeijingPage() {
		
		//title of the window
		super("Beijing");
		
		//creates a content pane
		Container BeijingScreen = getContentPane();
		BeijingScreen.setLayout(null);
		
		//creates the panel to organize everything
		BeijingPanel = new JPanel();
		BeijingPanel.setLayout(null);
		BeijingPanel.setLocation(0,0);
		BeijingPanel.setSize(300,420);
		BeijingScreen.add(BeijingPanel);
		
		//creates the image and scales it based on the window size
		BeijingImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/Beijing.jpeg")).getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT)));
		BeijingImage.setLayout(null);
		BeijingImage.setLocation(0,0);
		BeijingImage.setSize(300,150);
		BeijingPanel.add(BeijingImage);
		
		//creates the label that holds all the information
		BeijingInfo = new JLabel("<html>Beijing, China is home to some of the country's best-known tourist attractions, such as the Great Wall of China, the Forbidden City, the Temple of Heaven, and the Summer Palace.<html>");
		BeijingInfo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		BeijingInfo.setLayout(null);
		BeijingInfo.setLocation(10,160);
		BeijingInfo.setSize(280,100);
		BeijingInfo.setForeground(Color.blue);
		BeijingPanel.add(BeijingInfo);
		
		//round trip: x2 - 5%
		// creates the label that displays the prices of flights
		BeijingPrices = new JLabel("<html>Flight Ticket Prices :<br>Economy: $" + SeatSelectionPage.money.format(BookingPage.economyPrices[0]) + "<br>Business: $" + SeatSelectionPage.money.format(BookingPage.businessPrices[0]) + "<html>");
		BeijingPrices.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		BeijingPrices.setLayout(null);
		BeijingPrices.setLocation(10,270);
		BeijingPrices.setSize(280,50);
		BeijingPrices.setForeground(Color.red);
		BeijingPrices.setHorizontalAlignment(0);
		BeijingPanel.add(BeijingPrices);
		
		// creates the book flight button
		bookFlightButton = new JButton("Book Flight");
		bookFlightButton.setLayout(null);
		bookFlightButton.setLocation(20,330);
		bookFlightButton.setSize(260,60);
		bookFlightButton.addActionListener(this);
		BeijingPanel.add(bookFlightButton);			
	}
	
		//cancels the booking process if it is already in process by calling the CancelBooking method
		//calls the method to open a new booking page and preselects the destination
		public void actionPerformed(ActionEvent e) {
			
			//displays an ad
			JOptionPane.showMessageDialog(null,Menu.mikeStadiumLabel, "Ad", JOptionPane.PLAIN_MESSAGE, Menu.mikeStadium);
			Menu.bf.CancelBooking();
			if (!Menu.bookingInProgress) {
				Menu.bf.locations.setSelectedIndex(1);
			}
			Menu.OpenBookingProcess();
		}

}
