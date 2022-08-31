import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern patternForEquals;
        Pattern patternForLeftBrackets;
        Pattern patternForRightBrackets;
        Matcher matcher;
        Scanner sc = new Scanner(System.in);
        ArrayList<String> configureStrings = new ArrayList<>();
        HashMap<String, Integer> variableWithoutBracketsMode = new HashMap<>();
        HashMap<String, Integer> variableWithBracketsMode = new HashMap<>();

        while(sc.hasNext()) {
            configureStrings.add(sc.next());
        }

        String equalsPattern = "\\w*=\\w*";
        String leftBracket = "\\{";
        String rightBracket = "}";

        Boolean inBracketsMode = false;
        patternForEquals = Pattern.compile(equalsPattern);
        patternForLeftBrackets = Pattern.compile(leftBracket);
        patternForRightBrackets = Pattern.compile(rightBracket);

        String tempVariableLeft;
        Integer valueFromVariableLeft;
        Integer valueFromVariableRight;
        String tempVariableRight;
        for(String line: configureStrings) {
            matcher = patternForEquals.matcher(line);

            if(matcher.matches()) {
                tempVariableLeft = matcher.toString().split("=", 2)[0];
                /tempVariableRight = matcher.toString();
                if (inBracketsMode) {
                    if(variableWithBracketsMode.containsKey(tempVariableLeft)) {
                        if(variableWithBracketsMode.containsKey(tempVariableRight)) {
                            valueFromVariableRight = variableWithBracketsMode.get(tempVariableRight);
                        }
                        else {
                            valueFromVariableRight = 0;
                        }
                        variableWithBracketsMode.replace(tempVariableLeft,valueFromVariableRight);
                    }
                }
                else {

                }
            }
            else {
                matcher = patternForLeftBrackets.matcher(line);
                if(matcher.matches()) {
                    inBracketsMode = true;
                }
                else {
                    matcher = patternForRightBrackets.matcher(line);
                    if(matcher.matches()) {
                        inBracketsMode = false;
                    }
                }
            }
        }

    }
}
