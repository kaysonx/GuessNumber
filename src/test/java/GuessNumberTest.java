import me.cyansong.guessnumber.CompareResult;
import me.cyansong.guessnumber.GuessNumber;
import me.cyansong.guessnumber.GuessResult;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static me.cyansong.guessnumber.Main.getPrintInfo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuessNumberTest {
    GuessNumber guessNumber = null;

    @Before
    public void setUp() {
        int min = 1;
        int max = 10;
        int maxErrorCount = 5;
        guessNumber = new GuessNumber(min, max, maxErrorCount);
    }

    @Test
    public void should_get_random_number_between_1_and_100() {
        int low = 1;
        int high = 10;
        int generatedNumber = guessNumber.getGeneratedNumber();
        assertTrue("Error, random is too high", high >= generatedNumber);
        assertTrue("Error, random is too low", low <= generatedNumber);
    }

    @Test
    public void should_compare_userInput_with_generated_number_when_guessNumber_is_lessThan() {
        final int generatedNumber = 66;
        int userInput = 19;
        assertEquals(guessNumber.compareNumber(userInput, generatedNumber), CompareResult.LESS);
    }

    @Test
    public void should_compare_userInput_with_generated_number_when_is_equal() {
        final int generatedNumber = 66;
        int userInput = 66;
        assertEquals(guessNumber.compareNumber(userInput, generatedNumber), CompareResult.EQUAL);
    }

    @Test
    public void should_compare_userInput_with_generated_number_when_guessNumber_is_greaterThan() {
        final int generatedNumber = 66;
        int userInput = 77;
        assertEquals(guessNumber.compareNumber(userInput, generatedNumber), CompareResult.GREATER);
    }

    @Test
    public void should_get_info_when_guessNumber_is_lessThan() {
        String printInfo = getPrintInfo(GuessResult.LESS, 2);
        String expectInfo = "你猜的数太小了！已经猜了2次";
        assertEquals(printInfo, printInfo);
    }

    @Test
    public void should_get_info_when_guessNumber_is_greaterThan() {
        String printInfo = getPrintInfo(GuessResult.GREATER, 2);
        String expectInfo = "你猜的数太大了！已经猜了2次";
        assertEquals(printInfo, printInfo);
    }

    @Test
    public void should_get_info_when_guessNumber_is_equal() {
        String printInfo = getPrintInfo(GuessResult.RIGHT, 2);
        String expectInfo = "猜对了！你一共猜了2次";
        assertEquals(printInfo, printInfo);
    }

    @Test
    public void should_get_info_when_guessNumber_runout_count() {
        String printInfo = getPrintInfo(GuessResult.RUNOUTCOUNT, 2);
        String expectInfo = "你的次数已经用完！正确答案是" + guessNumber.getCount();
        assertEquals(printInfo, printInfo);
    }

    @Test
    public void should_add_count_when_guessOne() {
        guessNumber.guessNumberCore(12);
        assertEquals(1, guessNumber.getCount());
    }

    @Test
    public void should_get_guessResult_when_guessNumber() {
        GuessResult guessResult = guessNumber.guessNumberCore(9);
        List<GuessResult> guessResults = new ArrayList<GuessResult>();
        guessResults.add(GuessResult.GREATER);
        guessResults.add(GuessResult.LESS);
        guessResults.add(GuessResult.RIGHT);
        assertTrue(guessResults.contains(guessResult));
    }

    @Test
    public void should_get_runout_count() {
        GuessNumber guess = new GuessNumber(1, 10, 1);
        assertEquals(guess.guessNumberCore(20), GuessResult.RUNOUTCOUNT);
    }
}
