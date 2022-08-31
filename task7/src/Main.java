import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputPlan;
        inputPlan = sc.nextLine();
        ArrayList<Character> marketPlan = (ArrayList<Character>) convertStringToCharList(inputPlan);
        int numOfSections = sc.nextInt();

        int leftBorder;
        int rightBorder;
        int moves;
        for(int i=0; i<numOfSections; i++) {
            leftBorder = sc.nextInt();
            rightBorder = sc.nextInt();
            ArrayList<Character> marketPlanClone = (ArrayList<Character>) marketPlan.clone();
            ArrayList<Character> marketPlanCloneForSorted = (ArrayList<Character>) marketPlan.clone();
            List<Character> segmentOfMarket = marketPlanClone.subList(leftBorder-1, rightBorder);
            List<Character> segmentMarketSorted = marketPlanCloneForSorted.subList(leftBorder-1, rightBorder);
            Collections.sort(segmentMarketSorted);

            int currentPositionOfDepartment = 0;
            Character requiredDepartment;
            int positionOfRequiredDepartment = 0;
            moves = 0;
            for (int k=0; k<segmentOfMarket.size(); k++) {
                if(segmentOfMarket.get(k).equals(segmentMarketSorted.get(k))) {
                    if(k != 0) {
                        positionOfRequiredDepartment = k;
                        moves+=positionOfRequiredDepartment-currentPositionOfDepartment;
                        currentPositionOfDepartment = positionOfRequiredDepartment;
                    }
                }
                else {
                    requiredDepartment = segmentMarketSorted.get(k);
                    positionOfRequiredDepartment = segmentOfMarket.indexOf(requiredDepartment);
                    currentPositionOfDepartment = k;
                    if(positionOfRequiredDepartment-currentPositionOfDepartment>0) {
                        moves+=positionOfRequiredDepartment-currentPositionOfDepartment;
                    }
                    else {
                        moves+=segmentOfMarket.size()-(currentPositionOfDepartment-positionOfRequiredDepartment);
                    }
                    currentPositionOfDepartment = positionOfRequiredDepartment;
                }
            }
            System.out.println(moves);
        }
    }


    public static List<Character> convertStringToCharList(String str)
    {
        List<Character> chars = str
                .chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toList());
        return chars;
    }
}
