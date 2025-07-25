import java.util.Scanner; // Import Scanner for user input

public class EJeepneyCard { // Property of Periña, Nicolas Andrei
	
		private String cardNumber;
		private double balance;
		// EJeepneyCard Constructor to assign values to cardNumber and balance
		public EJeepneyCard() {
			this.balance = 0.0;
			this.cardNumber = "QCJP01";
		}
		// Method for loadMoney to add amount to balance and display it
		public void loadMoney(double amount) {
			this.balance += amount;
			System.out.println("Loaded Php " + amount + ". New balance: Php " + this.balance + ".");
		}
		// Method for fare that checks if the balance is enough for the fare
		public boolean tap(double fare) {
			if (this.balance >= fare) {
				this.balance -= fare;
				System.out.println("Ride successful! Fare: Php " + fare + ". New Balance: Php " + this.balance + ".");
				return true;
			} else {
				System.out.println("Insufficient Balance!"); // Returns insufficient balance if not
				return false;
			}
		}
		// Method for checking current balance by returning balance
		public double checkBalance() {
			return this.balance;
		}
		// Converts card number to String
		public String getCardNumber() {
			return this.cardNumber;
		}
		
		@Override
		public String toString() { // Returns a neat String when card object is printed
			return "Card " + this.cardNumber + ", Balance: Php " + this.balance;
		}
		//Main method for user interaction
		public static void main (String[] navp) {
			Scanner sc = new Scanner(System.in);
			EJeepneyCard card = null;
			boolean exit = false;
			
			System.out.println("Welcome to the QC E-Jeepney Card System!");
			// While loop for menu that loops unless the user chooses to exit
			 while (!exit) {
		            System.out.println("\nMenu:");
		            System.out.println("1. Create a New Card");
		            System.out.println("2. Load Money");
		            System.out.println("3. Tap for Ride");
		            System.out.println("4. Check Balance");
		            System.out.println("5. Exit");
		            System.out.print("Please choose an option (1-5): ");
		            
		            int choice = sc.nextInt();
		    // Switch case for menu choice     
		    switch (choice) {
	                case 1:
	                    // Create a new card
	                    card = new EJeepneyCard();
	                    System.out.println("Successfully created a new card.");
	                    System.out.println("Your card number is: " + card.getCardNumber());
	                    break;
	                    
	                case 2:
	                    // Load money onto the card
	                    if (card != null) {
	                        System.out.print("Enter amount to load: Php ");
	                        double amount = sc.nextDouble();
	                        card.loadMoney(amount);
	                    } else {
	                        System.out.println("Please create a card first.");
	                    }
	                    break;
	                    
	                case 3:
	                    // Tap for a ride
	                    if (card != null) {
	                        System.out.print("Enter fare for the ride: Php ");
	                        double fare = sc.nextDouble();
	                        card.tap(fare);
	                    } else {
	                        System.out.println("Please create a card first.");
	                    }
	                    break;
	                    
	                case 4:
	                    // Check balance
	                    if (card != null) {
	                        System.out.println("Current balance: Php " + card.checkBalance());
	                    } else {
	                        System.out.println("Please create a card first.");
	                    }
	                    break;
	                    
	                case 5:
	                    // Exit the program
	                    exit = true;
	                    System.out.println("Thank you for using the QC E-Jeepney Card System. Goodbye!"); // Exit Message
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please select a valid option (1-5)."); // Message if user chose a wrong number
	            }
	        }
	        sc.close(); // Closing of scanner
	    }
			 
}
