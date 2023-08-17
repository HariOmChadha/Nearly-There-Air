/* Author: Hari Om Chadha
 * This class creates all the boarding passes
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BoardingPassPage extends JFrame{

	// declares all the labels, seatButtons, panel, etc on this window
	Box box;
	JScrollPane scrollPane;
	
	//declares array lists and other variables to store information
	ArrayList<JLabel> boardingPasses = new ArrayList<JLabel>();
	
	public BoardingPassPage() {
		
		//names the window
		super("Boarding Passes");
				
		//creates a content pane
		Container boardingPassScreen = getContentPane();
		boardingPassScreen.setVisible(true);
		
		//creates a box to add all the boarding passes in
		box = Box.createVerticalBox();
		boardingPassScreen.add(box);
		
		//creates the scroll pane
		JScrollPane scrollPane = new JScrollPane(box, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 	boardingPassScreen.add(scrollPane);
	 	
	 	//creates all the boarding passes
	 	for (int i = 0; i < BookingPage.quantityNumber; i++) {
	 		//creates the boarding pass background
	 		boardingPasses.add(new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/BoardingPassIcon.jpg")).getImage().getScaledInstance(670,277,Image.SCALE_DEFAULT))));
	 		
	 		//adds the first name to the boarding pass
	 		JLabel firstName = new JLabel(PassengerInfoPage.firstNamesList.get(i));
	 		firstName.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		firstName.setLayout(null);
	 		firstName.setForeground(Color.red);
	 		firstName.setSize(185,20);
	 		firstName.setLocation(20,77);
	 		boardingPasses.get(i).add(firstName);
	 		
	 		//adds the last name to the boarding pass
	 		JLabel lastName = new JLabel(PassengerInfoPage.lastNamesList.get(i));
	 		lastName.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		lastName.setLayout(null);
	 		lastName.setForeground(Color.red);
	 		lastName.setSize(185,20);
	 		lastName.setLocation(209,77);
	 		boardingPasses.get(i).add(lastName);
	 		
	 		//adds the age category to the boarding pass
	 		JLabel age = new JLabel(PassengerInfoPage.ageType.get(i));
	 		age.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		age.setLayout(null);
	 		age.setForeground(Color.red);
	 		age.setSize(100,20);
	 		age.setLocation(120,100);
	 		boardingPasses.get(i).add(age);
	 		
	 		//adds the meal type to the boarding pass
	 		JLabel meal = new JLabel(PassengerInfoPage.mealType.get(i));
	 		meal.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		meal.setLayout(null);
	 		meal.setForeground(Color.red);
	 		meal.setSize(100,20);
	 		meal.setLocation(285,100);
	 		boardingPasses.get(i).add(meal);
	 		
	 		//adds the destination to the boarding pass
	 		JLabel location = new JLabel(BookingPage.locationNames[Menu.bf.locations.getSelectedIndex()]);
	 		location.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		location.setLayout(null);
	 		location.setForeground(Color.red);
	 		location.setSize(350,20);
	 		location.setLocation(95,155);
	 		boardingPasses.get(i).add(location);
	 		
	 		//adds the date to departure to the boarding pass
	 		JLabel departure = new JLabel(BookingPage.date[Menu.bf.departureDate.getSelectedIndex()] + " " + BookingPage.months[Menu.bf.departureMonth.getSelectedIndex()] + " " + BookingPage.years[Menu.bf.departureYear.getSelectedIndex()]);
	 		departure.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		departure.setLayout(null);
	 		departure.setForeground(Color.red);
	 		departure.setSize(200,20);
	 		departure.setLocation(140,188);
	 		boardingPasses.get(i).add(departure);
	 		
	 		//adds the time of departure to the boarding pass
	 		JLabel departureTime = new JLabel(BookingPage.timings[Menu.bf.departureTime.getSelectedIndex()]);
	 		departureTime.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		departureTime.setLayout(null);
	 		departureTime.setForeground(Color.red);
	 		departureTime.setSize(200,20);
	 		departureTime.setLocation(320,188);
	 		boardingPasses.get(i).add(departureTime);
	 		
	 		//adds the seat number to the boarding pass
	 		JLabel seat = new JLabel(SeatSelectionPage.seats.get(i));
	 		seat.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		seat.setLayout(null);
	 		seat.setForeground(Color.red);
	 		seat.setSize(70,20);
	 		seat.setLocation(40,240);
	 		boardingPasses.get(i).add(seat);
	 		
	 		//add the seat type to the boarding pass
	 		JLabel seatType = new JLabel(SeatSelectionPage.seatChoice.get(i));
	 		seatType.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
	 		seatType.setLayout(null);
	 		seatType.setForeground(Color.red);
	 		seatType.setSize(150,20);
	 		seatType.setLocation(130,240);
	 		boardingPasses.get(i).add(seatType);
	 		box.add(boardingPasses.get(i));
	 	}
	}
}
