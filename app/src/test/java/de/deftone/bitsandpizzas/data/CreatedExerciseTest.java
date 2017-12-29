package de.deftone.bitsandpizzas.data;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_BACK;
import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_BELLY;
import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_LEG;
import static de.deftone.bitsandpizzas.data.CreatedExercise.countBack;
import static de.deftone.bitsandpizzas.data.CreatedExercise.countBelly;
import static de.deftone.bitsandpizzas.data.CreatedExercise.countLegs;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryBack;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryBelly;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryLegs;
import static org.junit.Assert.*;

/**
 * Created by deftone on 27.12.17.
 */
public class CreatedExerciseTest {
    private static CreatedExercise testExercise;
    private static String name = "titel";
    private static String[] icon = {"\u25CF"};
    private static String[] desc = {"beschreibung"};

    @BeforeClass
    public static void setUp() {
        testExercise = new CreatedExercise(name,
                icon,
                desc,
                R.drawable.faeuste_heben,
                30);
        CreatedExercise.generateRandomExercises();
    }

    @AfterClass
    public static void tearDown() {
        testExercise = null;
        CreatedExercise.CREATED_EXERCISES_LIST = null;
    }

    @Test
    public void getName() throws Exception {
        assertEquals(name, testExercise.getName());
    }

    @Test
    public void getImageResourceId() throws Exception {
        assertEquals(R.drawable.faeuste_heben, testExercise.getImageResourceId());
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals(desc, testExercise.getDescription());
    }

    @Test
    public void getIcon() throws Exception {
        assertEquals(icon, testExercise.getIcon());
    }

    @Test
    public void getSeconds() throws Exception {
        assertEquals(30, testExercise.getSeconds());
    }

    @Test
    public void generateRandomExercises() throws Exception {
        int size_expected = countBack + countBelly + countLegs;
        assertEquals(size_expected, CreatedExercise.CREATED_EXERCISES_LIST.size());
    }

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