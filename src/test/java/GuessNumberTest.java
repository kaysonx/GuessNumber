import org.junit.Test;

import static me.cyansong.guessnumber.GuessNumber.compareNumber;
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
    public void should_compare_userInput_with_generated_number_when_not_equal(){
        final int generatedNumber = 66;
        int userInput = 19;
        assertEquals(compareNumber(generatedNumber,userInput),false);
    }

    @Test
    public void should_compare_userInput_with_generated_number_when_is_equal(){
        final int generatedNumber = 66;
        int userInput = 66;
        assertEquals(compareNumber(generatedNumber,userInput),true);
    }
}
