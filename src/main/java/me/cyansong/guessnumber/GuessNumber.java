package me.cyansong.guessnumber;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {
    public static void main(String[] args) {
        int count = 0;
        final int maxErrorCount = 5;
        final int generatedNumber = getRandomNumber(1, 100);
        //while (true){
        //    if(maxErrorCount == count){
        //        System.out.println("你已经猜错了"+maxErrorCount+"次，游戏结束！");
        //        break;
        //    }
        //    System.out.println("请输入你猜的数字：");
        //    int userInput = getInputFromConsole();
        //    if(compareNumber(userInput, generatedNumber)){
        //        System.out.println("恭喜你！猜中了，你一共猜了："+count+"次");
        //    }else{
        //        count++;
        //        System.out.println("很遗憾，你猜错了！请重新输入猜的数字：");
        //    }
        //}
    }

    public static int getRandomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static int getInputFromConsole(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()){
            return scanner.nextInt();
        }else{
            return -1;
        }
    }

    public static int compareNumber(int numberA,int numberB){
        if(numberA < numberB){
            return  -1;
        }
        if(numberA > numberB){
            return 1;
        }
        return 0;
    }

    public static void print(String outputInfo){
        System.out.println(outputInfo);
    }

    public static String getPrintInfo(int compareResult){
        if(compareResult < 0){
            return "你猜的数太小了！";
        }
        if(compareResult > 0){
            return  "你猜的数太大了！";
        }
        return "猜对了！";
    }
}
