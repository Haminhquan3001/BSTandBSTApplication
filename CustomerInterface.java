///**
//* CustomerInterface.java
//* @author Quan Ha 
//* @author Kenneth Dannlyson
//* CIS 22C, Lab 5
//*/
//import java.io.*;
//import java.text.DecimalFormat;
//import java.util.Scanner;
//
//public class CustomerInterface {
//   public static void main(String[] args) {
//      BST<MutualFundAccount> account_value = new BST<>();
//      BST<MutualFundAccount> account_name = new BST<>();
//      List<MutualFund> funds = new List<>();
//
//      String first, last, email, password, mutualName, ticker;
//      double cash, sharePrice, numShares, fee;
//   
//      File file = new File("mutual_funds.txt");
//      Scanner input;
//      
//      try {
//			input = new Scanner(file);
//			while (input.hasNextLine()) {
//				mutualName = input.nextLine();
//				ticker = input.nextLine();
//				sharePrice = Double.parseDouble(input.nextLine());
//				MutualFund dataToAdd = new MutualFund(mutualName, ticker, sharePrice);
//				funds.addLast(dataToAdd);
//			}
//			input.close();
//			System.out.println();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//      System.out.println("Welcome to Mutual Fund InvestorTrack (TM)!\n");
//      
//      NameComparator nameComp = new NameComparator();
//      ValueComparator valComp = new ValueComparator();
//      String option = "";
//      input = new Scanner(System.in);
//      
//      while (option != "X") {
//    	  System.out.println("Please select from the following options: \n");
//    	  System.out.println("A. Purchase a Fund");
//    	  System.out.println("B. Sell a Fund");
//    	  System.out.println("C. Display Your Current Funds");
//    	  System.out.println("X. Exit");
//    	  
//    	  System.out.print("\nEnter your choice: ");
//    	  option = input.nextLine();
//    	  
//    	  if (option.equals("A")) {
//    		  System.out.println("\nPlease select from the options below: \n");
//    		  funds.printNumberList();
//    		  System.out.print("Enter your choice: (1-"+ funds.getLength() + "): ");
//    		  int num = input.nextInt();
//    		  System.out.print("\nEnter the number of shares to purchase: ");
//    		  double share = input.nextDouble();
//    		  funds.iteratorToIndex(num);
//    		  MutualFundAccount temp = new MutualFundAccount(share, funds.getIterator());
//    		  account_value.insert(temp, valComp);
//    		  account_name.insert(temp, nameComp);
//    		  System.out.println();
//    	  }
//    	  
//    	  else if (option.equals("B")) {
//    		  if ((account_value.isEmpty()) || account_name.isEmpty()) {
//					System.out.println("\nYou don't have any funds to sell at this time\n");
//				} else {
//					System.out.println("You own the following mutual funds: ");
//					account_name.inOrderPrint();
//					System.out.print("Enter the name of fund to sell: ");
//					option = input.nextLine();
//					MutualFund temp = new MutualFund(option);
//					MutualFundAccount mfa = new MutualFundAccount(temp,0);
//					account_name.search(mfa, nameComp);
//					MutualFundAccount remove = new MutualFundAccount(
//							account_name.search(mfa, nameComp).getNumShares(), funds.getIterator());
//					System.out.print("Enter the number of shares to sell or \"all\" to sell everything: ");
//					
//					option = input.nextLine();
//					if(option.equals("all")) {
//						account_name.remove(remove, nameComp);
//						account_value.remove(remove, valComp);
//					}else {
//						account_value.remove(remove,valComp);
//						account_name.search(remove, nameComp).updateShares(-Double.parseDouble(option));
//						
//						account_value.insert(account_name.search(remove, nameComp), valComp);
//					}
//					System.out.println();
//					
//				}
//    	  }
//    	  
//    	  else if (option.equals("C")) {
//				if ((account_value.isEmpty()) || account_name.isEmpty()) {
//					System.out.println("\nYou don't have any funds to display at this time\n");
//				} else {
//					System.out.println();
//					System.out.println("View your mutual funds by:\n");
//					System.out.println("1. Name");
//					System.out.println("2. Value");
//					System.out.print("\nEnter your choice: (1 or 2): ");
//					int choice = input.nextInt();
//					System.out.println();
//					if (choice == 1) {
//						account_name.inOrderPrint();
//					} else if (choice == 2) {
//						account_value.inOrderPrint();
//					} else {
//						System.out.println();
//						System.out.println("Invalid choice!\n");
//					}
//				}
//			}
//
//    	  else if (option.equals("X")) {
//    		  System.out.println("\nGoodbye!");
//    		  break;
//    	  }
//    	  else {
//    		  System.out.println("Invalid menu option. Please enter A-C or X to exit.\n");
//    	  }
//    	  
//      }
//
//      input.close();
//   }
//}
/**
* CustomerInterface.java
* @author 
* @authoer PARTNER2_NAME_HERE
* CIS 22C, Lab 5
*/
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CustomerInterface {
   public static void main(String[] args) {
      BST<MutualFundAccount> account_value = new BST<>();
      BST<MutualFundAccount> account_name = new BST<>();
      List<MutualFund> funds = new List<>();

      String first, last, email, password, mutualName, ticker;
      double cash, sharePrice, numShares, fee;
   
      File file = new File("mutual_funds.txt");
     Scanner input;
      
      try {
			input = new Scanner(file);
			while (input.hasNextLine()) {
				mutualName = input.nextLine();
				ticker = input.nextLine();
				sharePrice = Double.parseDouble(input.nextLine());
				MutualFund dataToAdd = new MutualFund(mutualName, ticker, sharePrice);
				funds.addLast(dataToAdd);
			}
			input.close();
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
      System.out.println("Welcome to Mutual Fund InvestorTrack (TM)!\n");
      
      NameComparator nameComp = new NameComparator();
      ValueComparator valComp = new ValueComparator();
      String option = "";
      input = new Scanner(System.in);
      
      while (!option.equals("X")) {
    	  System.out.println("Please select from the following options: \n");
    	  System.out.println("A. Purchase a Fund");
    	  System.out.println("B. Sell a Fund");
    	  System.out.println("C. Display Your Current Funds");
    	  System.out.println("X. Exit");
    	  
    	  System.out.print("\nEnter your choice: ");
    	  option = input.nextLine();
    	  
    	  if (option.equals("A")) {
    		  System.out.println("\nPlease select from the options below: \n");
    		  funds.printNumberList();
    		  System.out.print("Enter your choice: (1-"+ funds.getLength() + "): ");
    		  option = input.nextLine();
    		  funds.iteratorToIndex(Integer.parseInt(option));
    		  System.out.print("\nEnter the number of shares to purchase: ");
    		  option = input.nextLine();
    		  MutualFundAccount temp = new MutualFundAccount(Double.parseDouble(option), funds.getIterator());
    		  account_value.insert(temp, valComp);
    		  account_name.insert(temp, nameComp);
    		  System.out.println();
    	  }
    	  
    	  else if (option.equals("B")) {
    		  if ((account_value.isEmpty()) || account_name.isEmpty()) {
					System.out.println("\nYou don't have any funds to sell at this time\n");
				} else {
					System.out.println("You own the following mutual funds: ");
					account_name.inOrderPrint();
					System.out.print("Enter the name of fund to sell: ");
					option = input.nextLine();
					funds.placeIterator();
					while (option.compareTo(funds.getIterator().getFundName()) != 0) {
						funds.advanceIterator();
					}
					MutualFundAccount temp = new MutualFundAccount(0, funds.getIterator());
					MutualFundAccount rem = new MutualFundAccount(
					account_name.search(temp, nameComp).getNumShares(), funds.getIterator());
					
					System.out.print("Enter the number of shares to sell or \"all\" to sell everything: ");
					option = input.nextLine();
					if (option.equals("all")
							|| account_name.search(temp, nameComp).getNumShares() == Double.parseDouble(option)) {
						account_value.remove(rem, valComp);
						account_name.remove(rem, nameComp);
					} else {
						account_value.remove(rem, valComp);
						account_name.search(rem, nameComp).updateShares(-(Double.parseDouble(option)));
						account_value.insert(account_name.search(rem, nameComp), valComp);
					}
					
				}
    	  }
    	  
    	  else if (option.equals("C")) {
				if ((account_value.isEmpty()) || account_name.isEmpty()) {
					System.out.println("\nYou don't have any funds to display at this time\n");
				} else {
					System.out.println();
					System.out.println("View your mutual funds by:\n");
					System.out.println("1. Name");
					System.out.println("2. Value");
					System.out.print("\nEnter your choice: (1 or 2): ");
					option = input.nextLine();
					System.out.println();
					Integer.parseInt(option);
					if (Integer.parseInt(option) == 1) {
						account_name.inOrderPrint();
					} else if (Integer.parseInt(option) == 2) {
						account_value.inOrderPrint();
					} else {
						System.out.println();
						System.out.println("Invalid choice!\n");
					}
				}
			}

    	  else if (option.equals("X")) {
    		  System.out.println("\nGoodbye!");
    	  }
    	  else {
    		  System.out.println("Invalid menu option. Please enter A-C or X to exit.\n");
    	  }
    	  
      }

      //toString MutualFund and MutualFundAccount, placeIter List
      //input.close();
   }
}


