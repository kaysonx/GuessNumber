import org.junit.Test;

import static me.cyansong.guessnumber.GuessNumber.compareNumber;
import static me.cyansong.guessnumber.GuessNumber.getPrintInfo;
import static me.cyansong.guessnumber.GuessNumber.getRandomNumber;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuessNumberTest {
    @Test
    public void should_get_random_number_between_1_and_100(){
        int low = 1;
        int high = 100;
        int generatedNumber = getRandomNumber(low, high);
        assertTrue("Error, random is too high", high >= generatedNumber);
        assertTrue("Error, random is too low",  low  <= generatedNumber);
    }

    @Test
    public void should_compare_userInput_with_generated_number_when_guessNumber_is_lessThan(){
        final int generatedNumber = 66;
        int userInput = 19;
        assertEquals(compareNumber(userInput,generatedNumber),-1);
    }

    @Test
    public void should_compare_userInput_with_generated_number_when_is_equal(){
        final int generatedNumber = 66;
        int userInput = 66;
        assertEquals(compareNumber(userInput,generatedNumber),0);
    }

    @Test
    public void should_compare_userInput_with_generated_number_when_guessNumber_is_greaterThan(){
        final int generatedNumber = 66;
        int userInput = 77;
        assertEquals(compareNumber(userInput,generatedNumber),1);
    }

    @Test
    public void should_get_info_when_guessNumber_is_lessThan(){
        String printInfo = getPrintInfo(-1);
        String expectInfo = "你猜的数太小了！";
        assertEquals(printInfo,printInfo);
    }
    @Test
    public void should_get_info_when_guessNumber_is_greaterThan(){
        String printInfo = getPrintInfo(1);
        String expectInfo = "你猜的数太大了！";
        assertEquals(printInfo,printInfo);
    }

    @Test
    public void should_get_info_when_guessNumber_is_equal(){
        String printInfo = getPrintInfo(0);
        String expectInfo = "猜对了！";
        assertEquals(printInfo,printInfo);
    }
}
