import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberOfDays = scanInt();

        int minSubscription = 0;
        int maxUnsubscription = 0;
        int currentDayStatistics;
        int profit = 0;
        for(int i=0; i<numberOfDays; i++) {
            currentDayStatistics = scanInt();
            if(isEvenDay(i)) {
                minSubscription = countMinSubscription(i, currentDayStatistics, minSubscription);
                profit += countCurrentProfit(i, minSubscription);
            }
            else {
                maxUnsubscription = countMaxUnsubscription(i, currentDayStatistics, maxUnsubscription);
                profit += countCurrentProfit(i, maxUnsubscription);
            }

        }

        profit = profit + 2 * maxUnsubscription - 2 * minSubscription;
        System.out.println(profit);

    }


    public static int scanInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static boolean isEvenDay(int day) {
        return day%2 == 0;
    }

    public static boolean isFirstDay(int day) {
        return day == 0;
    }

    public static boolean isSecondDay(int day) {
        return day == 1 ;
    }

    public static int countMinSubscription(int day, int currentDayStatistics, int minSubscription) {
        if(currentDayStatistics < minSubscription || isFirstDay(day)) {
            return currentDayStatistics;
        }
        return minSubscription;
    }


    public static int countMaxUnsubscription(int day, int currentDayStatistics, int maxUnsubscription) {
        if(currentDayStatistics > maxUnsubscription || isSecondDay(day)) {
            return currentDayStatistics;
        }
        else return maxUnsubscription;
    }

    public static int countCurrentProfit(int day, int todayProfit) {
        if(isEvenDay(day)) {
            return +todayProfit;
        }
        else {
            return -todayProfit;
        }
    }
}
