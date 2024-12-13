package assign11;
//class name TestStrategyPattern
import java.util.Scanner;

interface PaymentStrategy {
 void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
;
 private String cardHolderName;

 public CreditCardPayment(String cardNumber, String cardHolderName) {
    
     this.cardHolderName = cardHolderName;
 }

 @Override
 public void pay(double amount) {
     System.out.println("paid " + amount + ". card holder: " + cardHolderName);
 }
}

class PayPalPayment implements PaymentStrategy {
 private String email;

 public PayPalPayment(String email) {
     this.email = email;
 }

 @Override
 public void pay(double amount) {
     System.out.println("paid " + amount + ".email: " + email);
 }
}

//Concrete implementation of PaymentStrategy for Bitcoin
class BitcoinPayment implements PaymentStrategy {
 private String walletAddress;

 public BitcoinPayment(String walletAddress) {
     this.walletAddress = walletAddress;
 }

 @Override
 public void pay(double amount) {
     System.out.println("paid " + amount + " .wallet address: " + walletAddress);
 }
}


class ShoppingCart {
 private double totalAmount;

 public ShoppingCart() {
     this.totalAmount = 0.0;
 }

 public void addItem(double price) {
     totalAmount += price;
 }

 public void checkout(PaymentStrategy paymentStrategy) {
     paymentStrategy.pay(totalAmount);
     totalAmount = 0.0; 
 }
}

public class TestStrategyPattern {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     ShoppingCart cart = new ShoppingCart();

     while (true) {
         System.out.println("\n1. add item to cart");
         System.out.println("2. checkout");
         System.out.println("3. exit");
         System.out.print("enter your choice: ");

         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("enter item price: ");
                 double price = scanner.nextDouble();
                 cart.addItem(price);
                 System.out.println("item added to cart.");
                 break;
             case 2:
                 System.out.println("choose payment method:");
                 System.out.println("1. credit card");
                 System.out.println("2. paypal");
                 System.out.println("3. bitcoin");
                 System.out.print("enter your choice: ");
                 int paymentChoice = scanner.nextInt();
                 scanner.nextLine(); 

                 PaymentStrategy paymentStrategy;
                 switch (paymentChoice) {
                     case 1:
                         System.out.print("enter credit card number: ");
                         String cardNumber = scanner.nextLine();
                         System.out.print("enter card holder name: ");
                         String cardHolderName = scanner.nextLine();
                         paymentStrategy = new CreditCardPayment(cardNumber, cardHolderName);
                         break;
                     case 2:
                         System.out.print("enter paypal email: ");
                         String email = scanner.nextLine();
                         paymentStrategy = new PayPalPayment(email);
                         break;
                     case 3:
                         System.out.print("enter bitcoin wallet address: ");
                         String walletAddress = scanner.nextLine();
                         paymentStrategy = new BitcoinPayment(walletAddress);
                         break;
                     default:
                         System.out.println("invalid payment method.");
                         continue;
                 }
                 cart.checkout(paymentStrategy);
                 break;
             case 3:
                 System.out.println("Exiting");
                 scanner.close();
                 return;
             default:
                 System.out.println("invalid");
         }
     }
 }
}
