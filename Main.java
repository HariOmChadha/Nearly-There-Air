/*
 * Author: Hari Om Chadha
 * This program is for the airline company: Nearly There Air.
 * It allows the user to book flight tickets to various places like Dubai, London, etc.
 * This program uses an interactive GUI to make the booking process easier for the user.
 * This class creates the 'Menu' window
 */
//imports all the things that might be needed to make the program
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Main {
	
	//public static to allow calling from different classes
	public static Menu m = new Menu ();
	
	public static void main (String[]args) {
		
		//creates the menu window
		m.setLocation(325,50);
		m.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		m.setSize(515,565);
		m.setVisible(true);
		
		//creates the JOption pane when the menu is closed
		//having it here avoids recursion
		m.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (Menu.bookingInProgress) {
					Menu.bf.CancelBooking();
					return;
				}
				JOptionPane.showMessageDialog(null,"Thank you for considering Nearly There Air!", "See you soon!", JOptionPane.PLAIN_MESSAGE);
				System.exit(0);
			}
		});
	}
}