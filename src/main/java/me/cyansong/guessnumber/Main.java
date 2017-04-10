package me.cyansong.guessnumber;

import java.util.Scanner;
import static me.cyansong.guessnumber.GuessResult.*;

public class Main {

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber(1, 10, 5);
        while (true) {
            GuessResult guessResult = guessNumber.guessNumberCore(getInputFromConsole());
            print(getPrintInfo(guessResult));
            if (isQuit(guessResult)) {
                break;
            }
        }
    }

    private static boolean isQuit(GuessResult guessResult) {
        if(guessResult != LESS && guessResult != GREATER){
            return true;
        }
        return false;
    }

    public static String getPrintInfo(GuessResult guessResult) {
        String printInfo = "";
        switch (guessResult) {
            case RIGHT:
                printInfo = "猜对了！";
                break;
            case LESS:
                printInfo = "你猜的数太小了！";
                break;
            case GREATER:
                printInfo = "你猜的数太大了";
                break;
            case RUNOUTCOUNT:
                printInfo = "你的次数已经用完！";
                break;
        }
        return printInfo;
    }

    public static int getInputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception ex) {
            return -1;
        }
    }

    public static void print(String outputInfo) {
        System.out.println(outputInfo);
    }
}
