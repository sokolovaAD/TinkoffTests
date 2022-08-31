import java.util.*;

public class Main {
    static int maxChain = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfLifts = sc.nextInt();
        List<ArrayList<Integer>> liftPairs = new LinkedList<>();
        Integer groundFloor;
        Integer topFloor;

        for(int i=0; i< numberOfLifts; i++) {
            ArrayList<Integer> liftPair = new ArrayList<>();
            groundFloor = sc.nextInt();
            topFloor = sc.nextInt();
            liftPair.add(groundFloor);
            liftPair.add(topFloor);




            liftPairs.add(liftPair);
        }





        List<ArrayList<Integer>> chain = liftPairs.stream()
                .sorted(Comparator.comparing(lift -> lift.get(0)))
                .distinct()
                .toList();


        int currentMaxChain = 0;

        for(ArrayList<Integer> currentChain: chain) {
            currentMaxChain = 1;

            //checkIfChainCouldBeLonger(chain, currentChain);

            List<ArrayList<Integer>> possibleChains = checkIfChainCouldBeLonger(chain, currentChain, currentMaxChain);
            if(!possibleChains.isEmpty()) {
                currentMaxChain++;
                if(currentMaxChain>maxChain) {
                    maxChain = currentMaxChain;
                }
            }
            while(!possibleChains.isEmpty()) {
                for(int k=0; k<possibleChains.size(); k++) {
                    possibleChains = checkIfChainCouldBeLonger(chain, possibleChains.get(k), currentMaxChain);
                    if(!possibleChains.isEmpty()) {
                        currentMaxChain++;
                        if(currentMaxChain>maxChain) {
                            maxChain = currentMaxChain;
                        }
                    }
                }

            }

        }

        System.out.println(maxChain);

    }


    public static List<ArrayList<Integer>> checkIfChainCouldBeLonger( List<ArrayList<Integer>> chain, ArrayList<Integer> currentChain, int currentMaxChain) {
        List<ArrayList<Integer>> possibleChains = new LinkedList<>();
        for(ArrayList<Integer> pair: chain) {
            if (!(pair.equals(currentChain))) {
                if(pair.get(0).equals(currentChain.get(1))) {
                    possibleChains.add(pair);
                }

            }
        }

        return possibleChains;
    }
}
