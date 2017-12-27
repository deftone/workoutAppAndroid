package de.deftone.bitsandpizzas.data;

import org.junit.Test;

import java.util.List;

import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_LEG;
import static org.junit.Assert.*;

/**
 * Created by deftone on 27.12.17.
 */
public class CreatedExerciseTest {
    @Test
    public void generateRandomExercises() throws Exception {

        final int max = 7;
        final int count = 5;
        final int type = TYPE_LEG;

        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type);

        assertEquals(testArray.size(), count);
        assertTrue(testArray.contains(0));
    }

}