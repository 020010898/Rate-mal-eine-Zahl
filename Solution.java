package rr;

import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static boolean flagWin = false;

    public static void main(String[] args) {
        new Solution().runGame();
    }

    private void runGame() {
        Random random = new Random();
        int secret = random.nextInt(1000);
        int tryNumber = -1;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("versuch %d - rate mal: ", i);
            tryNumber = scanner.nextInt();
            if (tryNumber < secret) {
                if (i < 10)
                    System.out.println("Die Zahl ist größer");
            }
            else if (tryNumber > secret) {
                if (i < 10)
                    System.out.println("Die Zahl ist kleiner");
            }
            else {
                i = stopGame();
                flagWin = true;
            }
        }
        if (flagWin)
            printCongratulations(tryNumber);
        else
            printUpset();
    }

    private void printCongratulations(int number) {
        System.out.println();
        System.out.println("Du hast gewonnen!");
        System.out.println("Verborgene Zahl: " + number);
    }

    private void printUpset() {
        System.out.println();
        System.out.println("Du hast verloren!");
    }

    private int stopGame() {
        return 10;
    }
}
