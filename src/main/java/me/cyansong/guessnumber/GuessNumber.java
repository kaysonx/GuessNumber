package me.cyansong.guessnumber;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {
    public static void main(String[] args) {
        final int maxErrorCount = 5;
        final int generatedNumber = getRandomNumber(1, 100);
        int count = 0;

        while (true){
            print("请输入你猜的数字：");
            CompareResult compareResult = compareNumber(getInputFromConsole(), generatedNumber);
            count++;
            print(getPrintInfo(compareResult, count));
            if(compareResult == CompareResult.EQUAL){
                break;
            }
            if(maxErrorCount == count){
                print("你已经猜错了"+maxErrorCount+"次，正确答案是 "+generatedNumber+" 游戏结束！");
                break;
            }
        }
    }

    public static int getRandomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int getInputFromConsole(){
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        }catch (Exception ex){
            return -1;
        }
    }

    public static void print(String outputInfo){
        System.out.println(outputInfo);
    }

    public static CompareResult compareNumber(int numberA,int numberB){
        if(numberA == numberB){
            return CompareResult.EQUAL;
        }
        return numberA < numberB ? CompareResult.LESS:CompareResult.GREATER;
    }

    public static String getPrintInfo(CompareResult compareResult,int count){
        if(compareResult == CompareResult.LESS){
            return "你猜的数太小了！当前已经猜了："+count+"次";
        }
        if(compareResult == CompareResult.GREATER){
            return  "你猜的数太大了！当前已经猜了："+count+"次";
        }
        return "猜对了！你一共猜了："+count+"次";
    }
}
