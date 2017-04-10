package me.cyansong.guessnumber;

import java.util.Scanner;
import static me.cyansong.guessnumber.GuessResult.*;

public class Main {
    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber(1, 10, 5);
        while (true) {
            print("请输入你猜的数：");
            GuessResult guessResult = guessNumber.guessNumberCore(getInputFromConsole());
            print(getPrintInfo(guessResult, guessNumber.getCount()));
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

    public static String getPrintInfo(GuessResult guessResult, int count) {
        String printInfo = "";
        switch (guessResult) {
            case RIGHT:
                printInfo = "猜对了！你一共猜了"+count+"次";
                break;
            case LESS:
                printInfo = "你猜的数太小了！已经猜了"+count+"次";
                break;
            case GREATER:
                printInfo = "你猜的数太大了！已经猜了"+count+"次";
                break;
            case RUNOUTCOUNT:
                printInfo = "你的次数已经用完！正确答案是："+count;
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
