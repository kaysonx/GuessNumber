package me.cyansong.guessnumber;

import java.util.concurrent.ThreadLocalRandom;

public class GuessNumber {
    private final int generatedNumber;
    private final int maxErrorCount;
    private int count = 0;

    public GuessNumber(int min, int max, int maxErrorCount){
        this.generatedNumber = this.getRandomNumber(min, max);
        this.maxErrorCount = maxErrorCount;
        this.count = 0;
    }

    public GuessResult guessNumberCore(int inputNumber){
        CompareResult compareResult = compareNumber(inputNumber, generatedNumber);
        this.count++;
        if(compareResult == CompareResult.EQUAL){
            return GuessResult.RIGHT;
        }
        if(checkGuessNumber(this.count, this.maxErrorCount)){
            return GuessResult.RUNOUTCOUNT;
        }
        return compareResult == CompareResult.LESS?GuessResult.LESS:GuessResult.GREATER;
    }

    private boolean checkGuessNumber(int count, int maxErrorCount){
        if(count == maxErrorCount){
            return true;
        }
        return false;
    }

    private int getRandomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public CompareResult compareNumber(int numberA,int numberB){
        if(numberA == numberB){
            return CompareResult.EQUAL;
        }
        return numberA < numberB ? CompareResult.LESS:CompareResult.GREATER;
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }

    public int getCount() {
        return count;
    }
}
