import java.text.NumberFormat;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        final byte MONTHS_IN_A_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

//Global variables
        int principal = 0;
        float monthlyInterest = 0.0f;
        int numberOfPayments = 0;

        while (true){
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal>=1000 && principal<=1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true){
            System.out.print("Please enter annual interest rate: ");
            float annualInterestRate = scanner.nextFloat();
            if(annualInterestRate>=1 && annualInterestRate<=30) {
                monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_A_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
        }

        while (true){
            System.out.print("Period of year: ");
            byte years = (byte) scanner.nextByte();
            if (years>=1 && years<=30){
                numberOfPayments = years * MONTHS_IN_A_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30.");

        }


        double mortgage = principal
                            *(monthlyInterest*Math.pow(1+monthlyInterest,numberOfPayments))
                            /(Math.pow(1+monthlyInterest,numberOfPayments)-1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.print("Mortgage: " + mortgageFormatted);



    }
}
