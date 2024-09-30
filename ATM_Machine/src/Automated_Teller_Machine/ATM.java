package Automated_Teller_Machine;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		 
		int pin = 12345;
		int balance = 50000;
		
		int AddAmount = 0;
		int TakeAmount = 0;
		
		
		String Name;
		Scanner sc = new Scanner(System.in);
		
		// we have to take input from the user
		System.out.println("Enter your PIN : ");
		int password = sc.nextInt();
		
		if(password == pin ) {
			System.out.println("<-------------------- Welcome to XYZ Bank Account ----------------------->");
			
			while(true){
				System.out.println("Press 1 to Check Your Balance");
				System.out.println("press 2 to Deposit Money");
				System.out.println("Press 3 to Withdraw Money");
				System.out.println("Press 4 to Take rescept");
				System.out.println("Press 5 to Exit the Transaction");
				
				int opt = sc.nextInt();
				switch(opt) {
				
				case(1):
					System.out.println("Your current balance is : " + balance);
					break;
					
				case(2):
					System.out.println("Enetr the Ammout do You Want to ADD to YOur Account : ");
					AddAmount = sc.nextInt();
					System.out.println("Successfully Credited!!!!!!");
					balance = balance + AddAmount;
					break;
					
				case(3):
					System.out.println("Enter the Amount you want to Withdraw");
					TakeAmount = sc.nextInt();
					if(TakeAmount>balance){
						System.out.println("Insufficient Funds!!!!!");
					}
					else {
						System.out.println("Successfully Withdrawn");
						balance = balance - TakeAmount;
					}
					break;
					
				case(4):
					System.out.println("<----------Welcome to XYZ Bank------------>");
					System.out.println("available balance is : " + balance);
					System.out.println("amout deposited      : " + AddAmount);
					System.out.println("amout Withdrawn      : " + TakeAmount);
					System.out.println(" <----------Thanks For Coming -----------> ");
					break;

				default:
					System.out.println("press the number below 5");
					break;
				}
				if(opt == 5) {
					System.out.println("<-----------THANKYOU----------->");
					break;
				}
			}
			
		}
		else {
			System.out.println("Please Enter a Valid PIN");
		}
	}

}
