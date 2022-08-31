
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> firstCoordinates = new ArrayList<>();
        ArrayList<Integer> secondCoordinates = new ArrayList<>();

        setCoordinates(firstCoordinates);
        setCoordinates(secondCoordinates);

        int[] maxCoordinates = new int[2];
        int[] minCoordinates = new int[2];

        generateBiggestCoordinate(firstCoordinates, secondCoordinates, maxCoordinates);
        generateSmallestCoordinate(firstCoordinates, secondCoordinates, minCoordinates);

        int maxAmplitude = countMaxAmplitude(maxCoordinates, minCoordinates);

        int newZoneSquare = maxAmplitude * maxAmplitude;

        System.out.println(newZoneSquare);
    }

    public static void setCoordinates(ArrayList<Integer> coordinates) {
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<4; i++) {
            coordinates.add(sc.nextInt());
        }
    }

    public static void generateBiggestCoordinate(ArrayList<Integer> firstCoordinates, ArrayList<Integer> secondCoordinates,int[] maxCoordinates) {
        if(firstCoordinates.get(2)>secondCoordinates.get(2)) {
            maxCoordinates[0] = firstCoordinates.get(2);
            }
        else {
            maxCoordinates[0] = secondCoordinates.get(2);
        }

        if(firstCoordinates.get(3)>secondCoordinates.get(3)) {
            maxCoordinates[1] = firstCoordinates.get(3);
        }
        else {
            maxCoordinates[1] = secondCoordinates.get(3);
        }
    }

    public static void generateSmallestCoordinate(ArrayList<Integer> firstCoordinates, ArrayList<Integer> secondCoordinates,int[] minCoordinates) {
        if(firstCoordinates.get(0)<secondCoordinates.get(0)) {
            minCoordinates[0] = firstCoordinates.get(0);
        }
        else {
            minCoordinates[0] = secondCoordinates.get(0);
        }

        if(firstCoordinates.get(1)<secondCoordinates.get(1)) {
            minCoordinates[1] = firstCoordinates.get(1);
        }
        else {
            minCoordinates[1] = secondCoordinates.get(1);
        }
    }

    public static int countMaxAmplitude(int[] maxCoordinates, int[] minCoordinates) {
        return Math.max(maxCoordinates[1] - minCoordinates[1], maxCoordinates[0] - minCoordinates[0]);
    }
}
