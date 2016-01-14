import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicketFrame extends JFrame {

	Ticket event;
	private JLabel enter = new JLabel("Enter how many tickets you'd like to purchase (1-6):");
	private JTextField amt = new JTextField(5);
	private JButton purchase = new JButton("Purchase tickets");
	private JLabel result = new JLabel();
	private JLabel result2 = new JLabel();
	int statX;
	StatusBar stat = new StatusBar();

	public TicketFrame(Ticket b) {
		event = b;
		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		stat.setPreferredSize(new Dimension(300, 300));

		p.add(enter);
		p.add(amt);
		p.add(purchase);
		p.add(result);
		p.add(result2);
		p.add(stat);
		add(p);
		setSize(400, 400);

		ActionListener w = new purchaseClickListener();
		purchase.addActionListener(w);
	}

	class purchaseClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			// System.out.println("Purchase Button clicked");
			String tempAmt = amt.getText();
			if (!(tempAmt.equals(""))) {
				try {
					if (event.getPurchased() == event.getMaxTickets()) {
						result.setText("Sold out!");
						amt.setText("");
						result2.setText("");
					} else {
						int ta = Integer.parseInt(tempAmt);
						if (ta < 7) {
							if (event.getAvailable() >= ta) {
								event.purchase(ta);
								result.setText("");
								amt.setText("");
								double tixPur = event.getPurchased();
								double tixMax = event.getMaxTickets();
								double statPct = ((tixPur / tixMax) * 200);
								stat.setNewValues(statPct);
							}
						} else {
							result.setText("6 is the max available per order.");
							amt.setText("");
						}
					}
					result2.setText(event.getAvailable() + " tickets remaining.");
				} catch (NumberFormatException ex) {
					result.setText("Please enter a number only.");
					amt.setText("");
					// ex.printStackTrace();
				}
			} else {
				result.setText("Please enter amount.");
			}
		}

	}

}
