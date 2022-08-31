import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q;
        int n;
        n = sc.nextInt();
        q = sc.nextInt();

        ArrayList<String> lastNames = new ArrayList<>();
        fillLastNames(lastNames, n);

        ArrayList<String> lastNamesOriginalOrder = new ArrayList<>(lastNames);
        Collections.sort(lastNames);

        int queryIndex;
        Pattern pattern;
        for (int k = 0; k < q; k++) {
            queryIndex = sc.nextInt();
            pattern = scanAndMakePattern();
            String lastname = findIndexOfNameByPattern(lastNames, pattern, queryIndex);

            System.out.println(lastNamesOriginalOrder.indexOf(lastname) + 1);

        }
    }

    public static void fillLastNames(ArrayList<String> lastNames, int n) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++) {
            lastNames.add(sc.next());
        }
    }

    public static Pattern scanAndMakePattern() {
        Scanner sc = new Scanner(System.in);
        String queryPrefix;
        String queryPattern;

        queryPrefix = sc.next();
        queryPattern = "^" +  queryPrefix + "\\w*";
        return Pattern.compile(queryPattern);
    }


    public static String findIndexOfNameByPattern(ArrayList<String> lastNames, Pattern pattern, int queryIndex) {
        Matcher matcher;
        int counterForQueryIndex = 0;
        for(String lastname: lastNames) {
            matcher = pattern.matcher(lastname);
            if(matcher.matches()) {
                counterForQueryIndex++;
                if(counterForQueryIndex == queryIndex) {
                    return lastname;
                }
            }
        }
        return null;
    }
}
