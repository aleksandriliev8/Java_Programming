public class Probability {
    //function checking if a given digit is between two given numbers
    public static boolean isInRange(int digit, int min, int max){return digit >= min && digit <= max;}

    public static void main(String[] args) {

        int countOfNumbers = 0;
        int countOfNumbersDivisibleBy12 = 0;

        //Loop from the lowest possible number to the biggest possible
        for (int i = 14_311; i <= 68_798; i++) {

            //Saving the digits of each iterated number in new variables

            int fifthD = i % 10;
            int fourthD = (i / 10) % 10;
            int thirdD = (i / 100) % 10;
            int secondD = (i / 1000) % 10;
            int firstD = i / 10_000;

            //checking if each digit is in range
            if (isInRange(firstD, 1, 6) && isInRange(secondD, 4, 8) &&
                    isInRange(thirdD, 3, 7) && isInRange(fourthD, 1, 9) &&
                    isInRange(fifthD, 1, 8)) {

                //checking if the number is divisible by 12
                if (i % 12 == 0) {countOfNumbersDivisibleBy12++;}
                countOfNumbers++;
            }
        }

        double probability = (double)countOfNumbersDivisibleBy12 / (double)countOfNumbers;

        String printCountOfNumbers = String.format("The count of numbers with the given properties: %d", countOfNumbers);
        System.out.println(printCountOfNumbers);
        String printCountOfNumbersDivisibleBy12 = String.format("The count of numbers with given properties divisible by 12: %d", countOfNumbersDivisibleBy12);
        System.out.println(printCountOfNumbersDivisibleBy12);
        String printProbability = String.format("The probability of all numbers with given properties to be divisible by 12: %.2f", probability);
        System.out.println(printProbability);
    }
}
