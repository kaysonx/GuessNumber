import org.junit.Test;

import static me.cyansong.guessnumber.GuessNumber.getRandomNumber;
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

}
