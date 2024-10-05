//Developers: Alwin Onsay
//			  Dino Radores
//			  Gerald Oraller
//	  		  Mark Angel Concina
//Section   : BSIT-2B
//Filename  : IT2B_5.java
//About     : Welcome to hassle-free banking! Our Queueing System ensures minimal wait times, so you can breeze through your transactions and
//			  get back to what matters most. Your time is valuable, and we're here to make every moment count! 
import java.util.*;
public class IT2B_5 {
	static Scanner scanner = new Scanner(System.in);
	static Queue<String> window1 = new LinkedList<String>();
	static LinkedHashMap <String,String> window2 = new LinkedHashMap<String,String>();
	static LinkedHashMap <String,String> window3 = new LinkedHashMap<String,String>();
	static LinkedHashMap <String,String> window4 = new LinkedHashMap<String,String>();
	static Queue<String> window5 = new LinkedList<String>();
	static int window2TotalTime = 0;
	static int window3TotalTime = 0;
	static int window4TotalTime = 0;
	static final int deposit = 5;
	static final int withdrawal = 10;
	static final int payment = 7;
	static final String depositTime = "(5  minutes)";
	static final String withdrawalTime = "(10 minutes)";
	static final String paymentTime = "(7  minutes)";
	static int input;

    public static void main(String[] args) {
        	windowsDisplay();
            start();    
    }
    static void start(){
    	int customerNum = 1;
    	
    	while(true) {
    		String client = "Client " + customerNum;
    		
	    	System.out.println();
			System.out.println("Please Select a Transaction:");
	        System.out.println("[1] Open/Update account");
	        System.out.println("[2] Deposit");
	        System.out.println("[3] Withdraw");
	        System.out.println("[4] Payment");
	        System.out.println("[5] Loan");
	        System.out.println("[0] Exit");
			System.out.println();
	        System.out.print(client + ": ");
	        try {
	        	input = scanner.nextInt();
	        	
	        	if(input == 1) {
	        		window1.offer(client);
					System.out.println("You will be served by Window 1.");
					System.out.println();
	        		windowsDisplay();
	        	}
	        	else if(input == 2 || input == 3 || input == 4) {
	        		if(window2TotalTime <= window3TotalTime && window2TotalTime <= window4TotalTime) {
	        			
	        			if(input == 2) {
	        				window2TotalTime += deposit;
	        				window2.put(client, depositTime);
	        			}
	        			else if(input == 3) {
	        				window2TotalTime += withdrawal;
	        				window2.put(client, withdrawalTime);
	        			}
	        			else {
	        				window2TotalTime += payment;
	        				window2.put(client, paymentTime);
	        			}
						System.out.println("You will be served by Window 2.");
						System.out.println();
	        			windowsDisplay();
	        		}
	        		else if(window3TotalTime <= window2TotalTime && window3TotalTime <= window4TotalTime) {
	        			
	        			if(input == 2) {
	        				window3TotalTime += deposit;
	        				window3.put(client, depositTime);
	        			}
	        			else if(input == 3) {
	        				window3TotalTime += withdrawal;
	        				window3.put(client, withdrawalTime);	        				
	        			}
	        			else {
	        				window3TotalTime += payment;
	        				window3.put(client, paymentTime);
	        			}
						System.out.println("You will be served by Window 3.");
						System.out.println();
	        			windowsDisplay();
	        		}
	        		else if(window4TotalTime <= window2TotalTime && window4TotalTime <= window3TotalTime) {
	        			if(input == 2) {
	        				window4TotalTime += deposit;
	        				window4.put(client, depositTime);
	        			}
	        			else if(input == 3) {
	        				window4TotalTime += withdrawal;
	        				window4.put(client, withdrawalTime);
	        			}
	        			else {
	        				window4TotalTime += payment;
	        				window4.put(client, paymentTime);
	        			}
						System.out.println("You will be served by Window 4.");
						System.out.println();
	        			windowsDisplay();
	        		}
	        	}
	        	else if(input == 5) {
        			window5.offer(client);
					System.out.println("You will be served by Window 5.");
        			windowsDisplay();
        		}
				else if(input == 0){
					System.out.println("Exiting the program...");
					System.exit(0);
				}
        		else {
        			System.out.println("Invalid input! Please Select (1/2/3/4/5).");
        		}
	        	customerNum++;
	        }
	        catch(Exception e) {
	        	System.err.println("Invalid input! Please Select (1/2/3/4/5).");
	        	scanner.nextLine();
	        }
    	}
    }
    static void windowsDisplay() {
		System.out.println("=====================================================================================================================================================================");
    	System.out.println("\t\t\t\t\t\t\t\tPiggy Bank Queueing System");
        System.out.println("\t\t\t\t\t\t  Welcome to the Piggy Bank, we oink about your savings!\t");
        System.out.println();
        System.out.println("=====================================================================================================================================================================");
        System.out.println("Estimated Time\t\tWindows No.\t\t\t\t\t\t\t\tQueue");
        System.out.println("=====================================================================================================================================================================");
        window1Display();
        System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        window2Display();
        System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        window3Display();
        System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        window4Display();
        System.out.println();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        window5Display();
        System.out.println();
		System.out.println("=====================================================================================================================================================================");
    }
    static void window1Display() {
		System.out.print("     N/A");
    	System.out.print("\t\t Window 1:    ");
    	for(String element: window1) {
    		System.out.print(element + "    ");
    	}
    }
    static void window2Display() {
		System.out.print("  " + window2TotalTime + " minutes");
    	System.out.print("\t\t Window 2:    ");
    	for(String i: window2.keySet()) {
    		System.out.print(i);
    		System.out.print(window2.get(i) + "    ");
    	}
    }
    static void window3Display() {
		System.out.print("  " + window3TotalTime + " minutes");
    	System.out.print("\t\t Window 3:    ");
    	for(String i: window3.keySet()) {
    		System.out.print(i);
    		System.out.print(window3.get(i) + "    ");
    	}
    }
    static void window4Display() {
		System.out.print("  " + window4TotalTime + " minutes");
    	System.out.print("\t\t Window 4:    ");
    	for(String i: window4.keySet()) {
    		System.out.print(i);
    		System.out.print(window4.get(i) + "    ");
    	}
    }
    static void window5Display() {
    	System.out.print("     N/A");
    	System.out.print("\t\t Window 5:    ");
    	for(String element: window5) {
    		System.out.print(element + "    ");
    	}
    }
}
