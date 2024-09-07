package Stock;

import java.util.Scanner;

public class StockTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initializing the variables
        String symbol;
        String name;
        double previousClosingPrice;
        double currentPrice;

        //Read user input for the data
        System.out.print("Enter symbol: ");
        symbol = input.nextLine();
        System.out.print("Enter name: ");
        name = input.nextLine();
        System.out.print("Enter previousClosingPrice: ");
        previousClosingPrice = input.nextDouble();
        System.out.print("Enter currentPrice: ");
        currentPrice = input.nextDouble();

        //Creating a stock object
        Stock stock1 = new Stock();
        System.out.println();
        System.out.println("Stock 1 data: ");

        //Printing the default values
        System.out.println("Symbol: " + stock1.getSymbol());
        System.out.println("Name: " + stock1.getName());
        System.out.println("Current price: " + stock1.getCurrentPrice());
        System.out.println("Previous closing price: " + stock1.getPreviousClosingPrice());

        //Setting the values of the stock object using inputted data
        stock1.setSymbol(symbol);
        stock1.setName(name);
        stock1.setCurrentPrice(currentPrice);
        stock1.setPreviousClosingPrice(previousClosingPrice);

        System.out.println();
        System.out.println("Stock 1 data: ");

        //Printing new stock data
        System.out.println("Symbol: " + stock1.getSymbol());
        System.out.println("Name: " + stock1.getName());
        System.out.println("Current price: " + stock1.getCurrentPrice());
        System.out.println("Previous closing price: " + stock1.getPreviousClosingPrice());

        //Printing the change percent of the stock
        System.out.println("Change percent of stock 1: " + stock1.changePercent() + "%");

        System.out.println();

        //Creating a new stock object using copy constructor (stock 2 receives the sane data as stock 1)
        Stock stock2 = new Stock(stock1);
        System.out.println("Stock 2 data: ");

        System.out.println("Symbol: " + stock2.getSymbol());
        System.out.println("Name: " + stock2.getName());
        System.out.println("Current price: " + stock2.getCurrentPrice());
        System.out.println("Previous closing price: " + stock2.getPreviousClosingPrice());
    }
}
