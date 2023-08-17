/*Author: Hari Om Chadha
 * This class creates the Dubai page with information about Dubai.
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DubaiPage extends JFrame implements ActionListener {
	
	//declares the labels, button and panels on this window
	JLabel DubaiInfo, DubaiPrices, DubaiImage;
	JButton bookFlightButton;
	JPanel DubaiPanel;

	public DubaiPage() {
		
		//title of the window
		super("Dubai");
		
		//creates a content pane
		Container DubaiScreen = getContentPane();
		DubaiScreen.setLayout(null);
		
		//creates the panel to hold everything
		DubaiPanel = new JPanel();
		DubaiPanel.setLayout(null);
		DubaiPanel.setLocation(0,0);
		DubaiPanel.setSize(300,420);
		DubaiScreen.add(DubaiPanel);
		
		//creates the image and scales it based on the window size
		DubaiImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/Dubai.jpeg")).getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT)));
		DubaiImage.setLayout(null);
		DubaiImage.setLocation(0,0);
		DubaiImage.setSize(300,150);
		DubaiPanel.add(DubaiImage);
		
		//creates the label that holds all the information
		DubaiInfo = new JLabel("<html>Dubai is famous for contemporary sightseeing attractions such as the Burj Khalifa (the world's tallest building) and shopping malls that come complete with mammoth aquariums and indoor ski slopes.<html>");
		DubaiInfo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		DubaiInfo.setLayout(null);
		DubaiInfo.setLocation(10,160);
		DubaiInfo.setSize(280,100);
		DubaiInfo.setForeground(Color.blue);
		DubaiPanel.add(DubaiInfo);
		
		// creates the label that displays the prices of flights
		DubaiPrices = new JLabel("<html>Flight Ticket Prices :<br>Economy: $" + SeatSelectionPage.money.format(BookingPage.economyPrices[1]) + "<br>Business : $" + SeatSelectionPage.money.format(BookingPage.businessPrices[1]) + "<html>");
		DubaiPrices.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		DubaiPrices.setLayout(null);
		DubaiPrices.setLocation(10,270);
		DubaiPrices.setSize(280,50);
		DubaiPrices.setForeground(Color.red);
		DubaiPrices.setHorizontalAlignment(0);
		DubaiPanel.add(DubaiPrices);
				
		// creates the book flight button
		bookFlightButton = new JButton("Book Flight");
		bookFlightButton.setLayout(null);
		bookFlightButton.setLocation(20,330);
		bookFlightButton.setSize(260,60);
		bookFlightButton.addActionListener(this);
		DubaiPanel.add(bookFlightButton);			
	}
	
		//cancels the booking process if it is already in process by calling the CancelBooking method
		//calls the method to open a new booking page and preselects the destination
		public void actionPerformed(ActionEvent e) {
			Menu.bf.CancelBooking();
			if (!Menu.bookingInProgress) {
				Menu.bf.locations.setSelectedIndex(2);
			}
			Menu.OpenBookingProcess();
		}

}

