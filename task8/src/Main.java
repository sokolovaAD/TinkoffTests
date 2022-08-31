import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfDomains;
        int numberOfCostumers;

        numberOfDomains = sc.nextInt();
        numberOfCostumers = sc.nextInt();

        ArrayList<String> domains = new ArrayList<>();
        for(int i=0; i<numberOfDomains; i++) {
            domains.add(sc.next());
        }

        String startOfDomain;
        String endOfDomain;
        String domainPattern;
        Pattern pattern;
        Matcher matcher;
        int counterOfRightDomains;
        for(int k=0; k<numberOfCostumers; k++) {
            startOfDomain = sc.next();
            endOfDomain = sc.next();

            domainPattern = "^" +  startOfDomain + "\\w*" + endOfDomain + "$";
            pattern = Pattern.compile(domainPattern);
            counterOfRightDomains = 0;

            for(String domain: domains) {
                matcher = pattern.matcher(domain);
                if(matcher.matches()) {
                    counterOfRightDomains++;
                }
            }
            System.out.println(counterOfRightDomains);
        }
    }
}
