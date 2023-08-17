/* Author: Hari Om Chadha
 * This class creates the page that prints the receipt
 */
//imports all the things that might be needed to make the program
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReceiptPage extends JFrame {
	
	// declares all the labels, seatButtons, panel, etc on this window
	JLabel receipt, dateLabel, economyPriceLabel, businessPriceLabel, subtotalLabel, promoTypeLabel, promoLabel, 
	taxLabel, economyNumberLabel, businessNumberLabel, totalLabel, cardTypeLabel, cardNumberLabel, flightLabel;
	JPanel receiptPanel;
	
	public ReceiptPage() {
		
		//names the window
		super("Receipt");
		
		//creates a content pane
		Container receiptScreen = getContentPane();
		receiptScreen.setLayout(null);
				
		//creates the panel to hold everything
		receiptPanel = new JPanel();
		receiptPanel.setLayout(null);
		receiptPanel.setLocation(0,0);
		receiptPanel.setSize(450,500);
		receiptScreen.add(receiptPanel);
				
		//creates the label to make the receipt background
		receipt = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("Images/Receipt.jpg")).getImage().getScaledInstance(450,500,Image.SCALE_DEFAULT)));
		receipt.setLayout(null);
		receipt.setLocation(0,0);
		receipt.setSize(450,500);
		receiptPanel.add(receipt);
		
		//creates the label for the current time and date
		dateLabel = new JLabel(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()));
		dateLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		dateLabel.setLayout(null);
		dateLabel.setLocation(105,111);
		dateLabel.setSize(300,20);
		dateLabel.setHorizontalAlignment(0);
		receipt.add(dateLabel);
		
		//creates the label for the flight type heading
		flightLabel = new JLabel("AMT: " + SeatSelectionPage.flightTypeText);
		flightLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		flightLabel.setLayout(null);
		flightLabel.setLocation(320,150);
		flightLabel.setSize(145,20);
		flightLabel.setHorizontalAlignment(2);
		receipt.add(flightLabel);
		
		//creates the label for the number of economy tickets
		economyNumberLabel = new JLabel(Integer.toString(SeatSelectionPage.economySeatsQty));
		economyNumberLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		economyNumberLabel.setLayout(null);
		economyNumberLabel.setLocation(25,176);
		economyNumberLabel.setSize(25,20);
		economyNumberLabel.setHorizontalAlignment(0);
		receipt.add(economyNumberLabel);
		
		//creates the label for the economy price total
		economyPriceLabel = new JLabel(SeatSelectionPage.money.format(SeatSelectionPage.economyCost));
		economyPriceLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		economyPriceLabel.setLayout(null);
		economyPriceLabel.setLocation(275,176);
		economyPriceLabel.setSize(145,20);
		economyPriceLabel.setHorizontalAlignment(4);
		receipt.add(economyPriceLabel);
		
		//creates the label for the number of economy tickets
		businessNumberLabel = new JLabel(Integer.toString(SeatSelectionPage.businessSeatsQty));
		businessNumberLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		businessNumberLabel.setLayout(null);
		businessNumberLabel.setLocation(25,203);
		businessNumberLabel.setSize(25,20);
		businessNumberLabel.setHorizontalAlignment(0);
		receipt.add(businessNumberLabel);
				
		//creates the label for the business price total
		businessPriceLabel = new JLabel(SeatSelectionPage.money.format(SeatSelectionPage.businessCost));
		businessPriceLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		businessPriceLabel.setLayout(null);
		businessPriceLabel.setLocation(275,203);
		businessPriceLabel.setSize(145,20);
		businessPriceLabel.setHorizontalAlignment(4);
		receipt.add(businessPriceLabel);
		
		//creates the label for the business price total
		subtotalLabel = new JLabel(SeatSelectionPage.money.format(SeatSelectionPage.subTotal));
		subtotalLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		subtotalLabel.setLayout(null);
		subtotalLabel.setLocation(275,237);
		subtotalLabel.setSize(145,20);
		subtotalLabel.setHorizontalAlignment(4);
		receipt.add(subtotalLabel);
		
		//creates the label to show if the promo code offer is adding or subtracting price
		promoTypeLabel = new JLabel(PromoCodePage.discountType);
		promoTypeLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		promoTypeLabel.setLayout(null);
		promoTypeLabel.setLocation(272,262);
		promoTypeLabel.setSize(15,20);
		promoTypeLabel.setHorizontalAlignment(4);
		receipt.add(promoTypeLabel);
		
		//creates the label for the promo code offer
		promoLabel = new JLabel(SeatSelectionPage.money.format(PromoCodePage.discount));
		promoLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		promoLabel.setLayout(null);
		promoLabel.setLocation(275,262);
		promoLabel.setSize(145,20);
		promoLabel.setHorizontalAlignment(4);
		receipt.add(promoLabel);
		
		//creates the label for tax
		taxLabel = new JLabel(SeatSelectionPage.money.format(SeatSelectionPage.taxAmount));
		taxLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		taxLabel.setLayout(null);
		taxLabel.setLocation(275,287);
		taxLabel.setSize(145,20);
		taxLabel.setHorizontalAlignment(4);
		receipt.add(taxLabel);
		
		//creates the total Label
		totalLabel = new JLabel(SeatSelectionPage.money.format(SeatSelectionPage.totalAmount));
		totalLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		totalLabel.setLayout(null);
		totalLabel.setLocation(275,325);
		totalLabel.setSize(145,20);
		totalLabel.setHorizontalAlignment(4);
		receipt.add(totalLabel);
		
		//creates the label for card type
		cardTypeLabel = new JLabel(SeatSelectionPage.cardType);
		cardTypeLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		cardTypeLabel.setLayout(null);
		cardTypeLabel.setLocation(235,362);
		cardTypeLabel.setSize(100,20);
		cardTypeLabel.setHorizontalAlignment(0);
		receipt.add(cardTypeLabel);
		
		//creates the card number label
		cardNumberLabel = new JLabel(SeatSelectionPage.cardNumber);
		cardNumberLabel.setFont(new Font("COURIER NEW", Font.PLAIN, 20));
		cardNumberLabel.setLayout(null);
		cardNumberLabel.setLocation(325,386);
		cardNumberLabel.setSize(200,20);
		cardNumberLabel.setHorizontalAlignment(2);
		receipt.add(cardNumberLabel);	
	}
}
