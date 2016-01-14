
public class Ticket {

	int maxTickets;
	int available;
	int purchased = 0;
	
	public void purchase (double amount){
		purchased+= amount;
		available-= amount;
	}
	
	public int getMaxTickets() {
		return maxTickets;
	}
	public void setMaxTickets(int maxTickets) {
		this.maxTickets = maxTickets;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getPurchased() {
		return purchased;
	}
	public void setPurchased(int purchased) {
		this.purchased = purchased;
	}
	
	
}
