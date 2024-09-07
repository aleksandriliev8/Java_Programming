package Stock;

public class Stock {
    //The symbol of this stock
    private String symbol;
    //The name of this stock
    private String name;
    //The previousClosingPrice of this stock
    private double previousClosingPrice;
    //The currentPrice of this stock
    private double currentPrice;

    //Constructors:
    //Default constructor
    public Stock(){
        this.symbol = "none";
        this.name = "none";
        this.previousClosingPrice = 0.0;
        this.currentPrice = 0.0;
    }

    //Copy constructor
    public Stock(Stock stock){
        this.symbol = stock.symbol;
        this.name = stock.name;
        this.previousClosingPrice = stock.previousClosingPrice;
        this.currentPrice = stock.currentPrice;
    }

    //Parameterized constructor
    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }

    /////////////////////////////////////////////////

    //Getters:
    //Returns the symbol of this stock
    public String getSymbol() {
        return symbol;
    }

    //Returns the name of this stock
    public String getName() {
        return name;
    }

    //Returns the previous closing price of this stock
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    //Returns the current price of this stock
    public double getCurrentPrice() {
        return currentPrice;
    }

    /////////////////////////////////////////////////

    //Setters:
    //Sets the symbol of this stock
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    //Sets the name of this stock
    public void setName(String name) {
        this.name = name;
    }

    //Sets the previous closing price of this stock
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    //Sets the current price of this stock
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    /////////////////////////////////////////////////

    //Returns the percentage of change of this stock
    public double changePercent(){
        return ((currentPrice - previousClosingPrice) / previousClosingPrice) * 100;
    }
}
