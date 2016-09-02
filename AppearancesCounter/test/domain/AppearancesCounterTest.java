package domain;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * Created by Clemencio Morales Lucas on 02/09/2016.
 */
public class AppearancesCounterTest {

    private AppearancesCounter appearancesCounter;
    private int[] input;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        this.appearancesCounter = new AppearancesCounter();
        this.input = new int[]{1, 2, 3, 1, 4, 1, 2, 43, 3};
    }

    @Test
    public void testCalculateAppearances(){
        int[][] receivedSolution = appearancesCounter.calculateAppearances(input);
        int [][] expectedSolution = {{1,3},{2,2},{3,2},{4,1},{43,1}};
        assertTrue(Arrays.deepEquals(receivedSolution, expectedSolution));
    }

    @Test
    public void testCalculateAppearancesThrowIllegalArgumentExceptionIfInputIsNull()
            throws IllegalArgumentException {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(AppearancesCounter.THE_INPUT_ARRAY_CANNOT_BE_NULL);
        appearancesCounter.calculateAppearances(null);
    }
}