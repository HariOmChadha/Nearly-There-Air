/* Author: Hari Om Chadha
 * This class creates the menu page of the program that allows the 
 * user to navigate through the different parts of the program.
 * This class also calls most of the other classes
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
	
	//declares all the panels, labels and buttons on the window
	JPanel titlePanel, explorePanel, bookFlightPanel;
	JLabel title, tagLineLabel, exploreLabel, bookFlightLabel;
	JButton exploreButton, bookFlightButton;
	public static JLabel mikeStadiumLabel;
	public static ImageIcon mikeStadium;
	public static boolean bookingInProgress = false, bfOpen = false, piOpen = false, ssOpen = false, pcOpen = false, bcOpen = false;
	
	//calls all the windows now to be made visible later
	//public static to allow other classes to make the window visible
	//this also allows the program to not open multiple same windows
	public static BeijingPage b = new BeijingPage();
	public static DubaiPage d = new DubaiPage();
	public static LondonPage l = new LondonPage();
	public static SydneyPage s = new SydneyPage();
	public static CubaPage c = new CubaPage();
	public static BookingPage bf = new BookingPage();
	public static ExplorePage ep = new ExplorePage();
	public static PassengerInfoPage pi = new PassengerInfoPage();
	public static SeatSelectionPage ss = new SeatSelectionPage();
	public static PromoCodePage pc = new PromoCodePage();
	
	public Menu() {
		
		//names the window
		super("Nearly There Air");
		
		//creates a content pane
		Container screen = getContentPane();
		screen.setBackground(Color.white);
		screen.setLayout(null);
		
		//creates panel to contain title
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setLocation(0,0);
		titlePanel.setSize(500,200);
		titlePanel.setOpaque(false);
		screen.add(titlePanel);
		
		//creates the title image
		title = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/Logo.png")).getImage().getScaledInstance(500,150,Image.SCALE_DEFAULT)));
		title.setLayout(null);
		title.setLocation(0,0);
		title.setSize(500,150);
		titlePanel.add(title);
		
		//creates the tag line label
		tagLineLabel = new JLabel("We might not get you there but we get you close!");
		tagLineLabel.setFont(new Font("Trebuchent MS", Font.PLAIN, 20));
		tagLineLabel.setLayout(null);
		tagLineLabel.setLocation(0,150);
		tagLineLabel.setSize(500,50);
		tagLineLabel.setHorizontalAlignment(0);
		tagLineLabel.setForeground(Color.blue);
		titlePanel.add(tagLineLabel);
		
		//creates panel to contain the explore option
		explorePanel = new JPanel();
		explorePanel.setLayout(null);
		explorePanel.setLocation(0,200);
		explorePanel.setSize(500,150);
		explorePanel.setOpaque(false);
		screen.add(explorePanel);
		
		//creates the label above the explore button
		exploreLabel = new JLabel("Haven't decided where you want to spend your vacation?");
		exploreLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		exploreLabel.setLayout(null);
		exploreLabel.setLocation(0,0);
		exploreLabel.setSize(500,50);
		exploreLabel.setHorizontalAlignment(0);
		exploreLabel.setForeground(Color.DARK_GRAY);
		explorePanel.add(exploreLabel);
		
		//creates the explore button
		exploreButton = new JButton("Explore NOW!!");
		exploreButton.setLayout(null);
		exploreButton.setLocation(100,50);
		exploreButton.setSize(300,100);
		exploreButton.setHorizontalAlignment(0);
		exploreButton.addActionListener(this);
		explorePanel.add(exploreButton);
		
		
		//creates panel to contain the book ticket option
		bookFlightPanel = new JPanel();
		bookFlightPanel.setLayout(null);
		bookFlightPanel.setLocation(0,350);
		bookFlightPanel.setSize(500,150);
		bookFlightPanel.setOpaque(false);
		screen.add(bookFlightPanel);
		
		//creates the label above the book flights button
		bookFlightLabel = new JLabel("Already know where you want to spend your vacation?");
		bookFlightLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		bookFlightLabel.setLayout(null);
		bookFlightLabel.setLocation(0,0);
		bookFlightLabel.setSize(500,50);
		bookFlightLabel.setHorizontalAlignment(0);
		bookFlightLabel.setForeground(Color.DARK_GRAY);
		bookFlightPanel.add(bookFlightLabel);
			
		//creates the book flights button
		bookFlightButton = new JButton("Book flight NOW!!");
		bookFlightButton.setLayout(null);
		bookFlightButton.setLocation(100,50);
		bookFlightButton.setSize(300,100);
		bookFlightButton.setHorizontalAlignment(0);
		bookFlightButton.addActionListener(this);
		bookFlightPanel.add(bookFlightButton);
		
		//creates the images for pop-up ads
		mikeStadium = new ImageIcon(new ImageIcon(getClass().getResource("Images/stadium.jpg")).getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT));
		
		//creates the labels for the pop-up ads
		mikeStadiumLabel = new JLabel("Visit Mike's soccer stadium for the greatest soccer gameplays ever");
		mikeStadiumLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		
		//creates the JOption pane when the BookingPage is closed
		//having it here avoids recursion
		bf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				bf.CancelBooking();
			}
		});
		
		//creates the JOption pane when the PassengerInfoPage is closed
		//having it here avoids recursion
		pi.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				bf.CancelBooking();
			}
		});
		
		//creates the JOption pane when the PassengerInfoPage is closed
		//having it here avoids recursion
		ss.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				bf.CancelBooking();
			}
		});
		
		//creates the JOption pane when the PassengerInfoPage is closed
		//having it here avoids recursion
		pc.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				bf.CancelBooking();
			}
		});
	}
		// action listener to assign commands to buttons
		public void actionPerformed(ActionEvent e) {
			
				// makes the Explore Page visible and brings it to the front if already visible
				if (e.getSource() == exploreButton) {
					ep.setVisible(false);
					ep.setLocation(10,100);
					ep.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					ep.setSize(215,465);
					ep.setVisible(true);
					
				// makes the flight booking page visible and brings it to the front if already visible
				} else if (e.getSource() == bookFlightButton) {
					bf.CancelBooking();
					if (!bookingInProgress) {
						bf.locations.setSelectedIndex(0);
					}
					OpenBookingProcess();
				}
		}
		
		//starts the booking process
		//can be called from multiple files
		public static void OpenBookingProcess() {
			if (!bookingInProgress || bfOpen) {
				ep.setVisible(false);
				b.setVisible(false);
				d.setVisible(false);
				l.setVisible(false);
				s.setVisible(false);
				c.setVisible(false);
				bf.setVisible(false);
				pi.setVisible(false);
				ss.setVisible(false);
				bf.setLocation(350,100);
				bf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				bf.setSize(665,375);
				bf.setVisible(true);
				bfOpen = true;
				bookingInProgress = true;
			} else if (piOpen) {
				ep.setVisible(false);
				b.setVisible(false);
				d.setVisible(false);
				l.setVisible(false);
				s.setVisible(false);
				c.setVisible(false);
				bf.setVisible(false);
				pi.setVisible(false);
				pi.setLocation(350,100);
				pi.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				pi.setSize(515,285);
				pi.setVisible(true);
			} else if (ssOpen) {
				ep.setVisible(false);
				b.setVisible(false);
				d.setVisible(false);
				l.setVisible(false);
				s.setVisible(false);
				c.setVisible(false);
				bf.setVisible(false);
				pi.setVisible(false);
				ss.setVisible(false);
				ss.setLocation(200,50);
				ss.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				ss.setSize(815,615);
				ss.setVisible(true);
			} else if (pcOpen) {
				ep.setVisible(false);
				b.setVisible(false);
				d.setVisible(false);
				l.setVisible(false);
				s.setVisible(false);
				c.setVisible(false);
				bf.setVisible(false);
				pi.setVisible(false);
				ss.setVisible(false);
				pc.setVisible(false);
				pc.setLocation(350,200);
				pc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				pc.setSize(515,315);
				pc.setVisible(true);
			} else {
				ep.setVisible(false);
				b.setVisible(false);
				d.setVisible(false);
				l.setVisible(false);
				s.setVisible(false);
				c.setVisible(false);
				bf.setVisible(false);
				pi.setVisible(false);
				ss.setVisible(false);
				pc.setVisible(false);
				Main.m.setVisible(false);
			}
		}
		
}
