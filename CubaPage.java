/*Author: Hari Om Chadha
 * This class creates the Cuba page with information about Cuba.
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CubaPage extends JFrame implements ActionListener {
	
	//declares the labels, button and panels on this window
	JLabel CubaInfo, CubaPrices, CubaImage;
	JButton bookFlightButton;
	JPanel CubaPanel;

	public CubaPage() {
		
		//title of the window
		super("Cuba");
		
		//creates a content pane
		Container CubaScreen = getContentPane();
		CubaScreen.setLayout(null);
				
		//creates the panel to hold everything
		CubaPanel = new JPanel();
		CubaPanel.setLayout(null);
		CubaPanel.setLocation(0,0);
		CubaPanel.setSize(300,420);
		CubaScreen.add(CubaPanel);
				
		//creates the image and scales it based on the window size
		CubaImage = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/Cuba.jpeg")).getImage().getScaledInstance(300,150,Image.SCALE_DEFAULT)));
		CubaImage.setLayout(null);
		CubaImage.setLocation(0,0);
		CubaImage.setSize(300,150);
		CubaPanel.add(CubaImage);
				
		//creates the label that holds all the information
		CubaInfo = new JLabel("<html>Cuba is the largest of the Caribbean islands and known for its legendary cigars, American vintage cars, stunning beaches, not to mention a few rum distilleries.<html>");
		CubaInfo.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		CubaInfo.setLayout(null);
		CubaInfo.setLocation(10,160);
		CubaInfo.setSize(280,100);
		CubaInfo.setForeground(Color.blue);
		CubaPanel.add(CubaInfo);
			
		// creates the label that displays the prices of flights
		CubaPrices = new JLabel("<html>Flight Ticket Prices :<br>Economy: $" + SeatSelectionPage.money.format(BookingPage.economyPrices[4]) + "<br>Business: $" + SeatSelectionPage.money.format(BookingPage.businessPrices[4]) + "<html>");
		CubaPrices.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		CubaPrices.setLayout(null);
		CubaPrices.setLocation(10,270);
		CubaPrices.setSize(280,50);
		CubaPrices.setForeground(Color.red);
		CubaPrices.setHorizontalAlignment(0);
		CubaPanel.add(CubaPrices);
				
		// creates the book flight button
		bookFlightButton = new JButton("Book Flight");
		bookFlightButton.setLayout(null);
		bookFlightButton.setLocation(20,330);
		bookFlightButton.setSize(260,60);
		bookFlightButton.addActionListener(this);
		CubaPanel.add(bookFlightButton);			
	}
	
		//cancels the booking process if it is already in process by calling the CancelBooking method
		//calls the method to open a new booking page and preselects the destination
		public void actionPerformed(ActionEvent e) {
			Menu.bf.CancelBooking();
			if (!Menu.bookingInProgress) {
				Menu.bf.locations.setSelectedIndex(5);
			}
			Menu.OpenBookingProcess();
		}
}
