package BankApplication;

public class InsufficientException extends Exception {
         public InsufficientException() {
        	 super("Insufficient balance");
         }
}
