package me.cyansong.guessnumber;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {
    public static int getRandomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int getInputFromConsole(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
