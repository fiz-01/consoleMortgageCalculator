import java.text.NumberFormat;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Please enter annual interest rate: ");
        float annualInterestRate = scanner.nextFloat();

        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_A_YEAR;

        System.out.print("Period of year: ");
        byte years = (byte) scanner.nextByte();

        int numberOfPayments = years * MONTHS_IN_A_YEAR;

        double mortgage = principal
                            *(monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))
                            /(Math.pow(1+monthlyInterest,numberOfPayments)-1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);



    }
}
