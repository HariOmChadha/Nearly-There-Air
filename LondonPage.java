/*Author: Hari Om Chadha
 * This class creates the London page with information about London.
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LondonPage extends JFrame implements ActionListener {
	
	//declares the labels, button and panels on this window
	JLabel LondonInfo, LondonPrices, LondonImage;
	JButton bookFlightButton;
	JPanel LondonPanel;

	public LondonPage() {
		
		//title of the window
		super("London");
		//creates a content pane
		Container LondonScreen = getContentPane();
		LondonScreen.setLayout(null);
				
		//creates the panel to hold everything
		LondonPanel = new JPanel();
		LondonPanel.setLayout(null);
		LondonPanel.setLocation(0,0);
		LondonPanel.setSize(300,420);
		LondonScreen.add(LondonPanel);
			
		//creates the image and scales it based on the window size
		LondonImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/London.jpeg")).getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT)));
		LondonImage.setLayout(null);
		LondonImage.setLocation(0,0);
		LondonImage.setSize(300,150);
		LondonPanel.add(LondonImage);
				
		//creates the label that holds all the information
		LondonInfo = new JLabel("<html>London is one of the world's most mesmerizing cities.The picturesque streets wind their way around renowned attractions like Buckingham Palace, Westminster Abbey, and the Big Ben.<html>");
		LondonInfo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		LondonInfo.setLayout(null);
		LondonInfo.setLocation(10,160);
		LondonInfo.setSize(280,100);
		LondonInfo.setForeground(Color.blue);
		LondonPanel.add(LondonInfo);
			
		// creates the label that displays the prices of flights
		LondonPrices = new JLabel("<html>Flight Ticket Prices :<br>Economy: $" + SeatSelectionPage.money.format(BookingPage.economyPrices[2]) + "<br>Business: $" + SeatSelectionPage.money.format(BookingPage.businessPrices[2]) + "<html>");
		LondonPrices.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		LondonPrices.setLayout(null);
		LondonPrices.setLocation(10,270);
		LondonPrices.setSize(280,50);
		LondonPrices.setForeground(Color.red);
		LondonPrices.setHorizontalAlignment(0);
		LondonPanel.add(LondonPrices);
			
		// creates the book flight button
		bookFlightButton = new JButton("Book Flight");
		bookFlightButton.setLayout(null);
		bookFlightButton.setLocation(20,330);
		bookFlightButton.setSize(260,60);
		bookFlightButton.addActionListener(this);
		LondonPanel.add(bookFlightButton);			
	}
	
		//cancels the booking process if it is already in process by calling the CancelBooking method
		//calls the method to open a new booking page and preselects the destination
		public void actionPerformed(ActionEvent e) {
			Menu.bf.CancelBooking();
			if (!Menu.bookingInProgress) {
				Menu.bf.locations.setSelectedIndex(3);
			}
			Menu.OpenBookingProcess();
		}

}

