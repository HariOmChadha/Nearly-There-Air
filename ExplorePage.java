/* Author: Hari Om Chadha
 * This class makes the explore page with a list of locations
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExplorePage extends JFrame implements ActionListener{
	//declares the panel and button used on this window
	JPanel locationsPanel;
	JButton BeijingButton, DubaiButton, LondonButton, SydneyButton, CubaButton;
	
	public ExplorePage() {
		//names the window
		super("Explore Locations");
		//creates a content pane
		Container screen = getContentPane();
		screen.setLayout(null);
		
		//creates a panel to contain the locations
		locationsPanel = new JPanel();
		locationsPanel.setLayout(null);
		locationsPanel.setLocation(0,0);
		locationsPanel.setSize(300,430);
		screen.add(locationsPanel);
		
		//creates the Beijing button
		BeijingButton = new JButton("Beijing");
		BeijingButton.setLayout(null);
		BeijingButton.setLocation(25,20);
		BeijingButton.setSize(150,70);
		BeijingButton.setHorizontalAlignment(0);
		BeijingButton.addActionListener(this);
		locationsPanel.add(BeijingButton);
		
		//creates the Dubai button
		DubaiButton = new JButton("Dubai");
		DubaiButton.setLayout(null);
		DubaiButton.setLocation(25,100);
		DubaiButton.setSize(150,70);
		DubaiButton.setHorizontalAlignment(0);
		DubaiButton.addActionListener(this);
		locationsPanel.add(DubaiButton);
		
		//creates the London button
		LondonButton = new JButton("London");
		LondonButton.setLayout(null);
		LondonButton.setLocation(25,180);
		LondonButton.setSize(150,70);
		LondonButton.setHorizontalAlignment(0);
		LondonButton.addActionListener(this);
		locationsPanel.add(LondonButton);
						
		//creates the Sydney button
		SydneyButton = new JButton("Sydney");
		SydneyButton.setLayout(null);
		SydneyButton.setLocation(25,260);
		SydneyButton.setSize(150,70);
		SydneyButton.setHorizontalAlignment(0);
		SydneyButton.addActionListener(this);
		locationsPanel.add(SydneyButton);
		
		//creates the Cuba button
		CubaButton = new JButton("Cuba");
		CubaButton.setLayout(null);
		CubaButton.setLocation(25,340);
		CubaButton.setSize(150,70);
		CubaButton.setHorizontalAlignment(0);
		CubaButton.addActionListener(this);
		locationsPanel.add(CubaButton);
	}
		public void actionPerformed(ActionEvent e) {
			
			//makes the Beijing page visible and brings it to the front if it is already visible
			if (e.getSource() == BeijingButton) {
				Menu.b.setVisible(false);
				Menu.b.setLocation(220,10);
				Menu.b.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Menu.b.setSize(315,435);
				Menu.b.setVisible(true);
				
			//makes the Dubai page visible and brings it to the front if it is already visible
			} else if (e.getSource() == DubaiButton) {
				Menu.d.setVisible(false);
				Menu.d.setLocation(530,10);
				Menu.d.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Menu.d.setSize(315,435);
				Menu.d.setVisible(true);
				
			//makes the London page visible and brings it to the front if it is already visible
			} else if (e.getSource() == LondonButton) {
				JOptionPane.showMessageDialog(null,Menu.mikeStadiumLabel, "Ad", JOptionPane.PLAIN_MESSAGE, Menu.mikeStadium);
				Menu.l.setVisible(false);
				Menu.l.setLocation(840,10);
				Menu.l.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Menu.l.setSize(315,435);
				Menu.l.setVisible(true);
				
			//makes the Sydney page visible and brings it to the front if it is already visible
			} else if (e.getSource() == SydneyButton) {
				Menu.s.setVisible(false);
				Menu.s.setLocation(365,300);
				Menu.s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Menu.s.setSize(315,435);
				Menu.s.setVisible(true);
				
			//makes the Cuba page visible and brings it to the front if it is already visible
			} else if (e.getSource() == CubaButton) {
				Menu.c.setVisible(false);
				Menu.c.setLocation(675,300);
				Menu.c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Menu.c.setSize(315,435);
				Menu.c.setVisible(true);
			}
		}
}
