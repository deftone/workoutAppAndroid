package de.deftone.bitsandpizzas.data;

import org.junit.Test;

import java.util.List;

import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_BACK;
import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_BELLY;
import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_LEG;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryBack;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryBelly;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryLegs;
import static org.junit.Assert.*;

/**
 * Created by deftone on 27.12.17.
 */
public class CreatedExerciseTest {
    @Test
    public void generateRandomArrayLeg() throws Exception {

        final int max = 7;
        final int count = 5;
        final int type = TYPE_LEG;

        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type);

        assertEquals(testArray.size(), count);
        for (int i : mandatoryLegs)
            assertTrue(testArray.contains(i));
    }

    @Test
    public void generateRandomArrayBelly() throws Exception {

        final int max = 8;
        final int count = 8;
        final int type = TYPE_BELLY;

        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type);

        assertEquals(testArray.size(), count);
        for (int i : mandatoryBelly)
            assertTrue(testArray.contains(i));
    }

    @Test
    public void generateRandomArrayBack() throws Exception {

        final int max = 8;
        final int count = 8;
        final int type = TYPE_BACK;

        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type);

        assertEquals(testArray.size(), count);
        for (int i : mandatoryBack)
            assertTrue(testArray.contains(i));
    }

    @Test
    public void generateRandomArray_wrongInput() {
        final int max = 5;
        final int count = 7;
        final int type = TYPE_BACK;

        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type);
        assertEquals(testArray.size(), 2);
    }

}