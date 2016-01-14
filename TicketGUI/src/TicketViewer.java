import javax.swing.JFrame;

public class TicketViewer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Ticket event = new Ticket();
		event.setMaxTickets(75);
		event.setAvailable(event.getMaxTickets());
		
		JFrame frame = new TicketFrame(event);
		
		frame .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
