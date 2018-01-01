package de.deftone.bitsandpizzas.data;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_BACK;
import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_BELLY;
import static de.deftone.bitsandpizzas.data.CreatedExercise.TYPE_LEG;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryBack;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryBelly;
import static de.deftone.bitsandpizzas.data.CreatedExercise.mandatoryLegs;
import static org.junit.Assert.*;

/**
 * Created by deftone on 27.12.17.
 * @Before methode namenskonvention: setUp
 * @After methode namenskonvention: tearDown
 */
public class CreatedExerciseTest {
    private static CreatedExercise testExercise;
    private static String name = "titel";
    private static String[] icon = {"\u25CF", "\u25CF"};
    private static String[] desc = {"beschreibung", "und noch was"};

    @BeforeClass
    public static void startUp() {
        testExercise = new CreatedExercise(name, icon, desc, R.drawable.faeuste_heben, 30);
        CreatedExercise.generateRandomExercises(6, 6, 6, true);
    }

    @AfterClass
    public static void shutDown() {
        testExercise = null;
        CreatedExercise.CREATED_EXERCISES_LIST = null;
    }

    @Test
    public void generateRandomExercises() throws Exception {
        int size_expected = 18; //see above in startUp, 6+6+6 exercises
        assertEquals(size_expected, CreatedExercise.CREATED_EXERCISES_LIST.size());
    }

    @Test
    public void generateRandomArrayLeg() throws Exception {
        final int max = 7;
        final int count = 5;
        final int type = TYPE_LEG;
        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type, true);
        assertEquals(count, testArray.size());
        for (int i : mandatoryLegs)
            assertTrue(testArray.contains(i));
    }

    @Test
    public void generateRandomArrayBelly() throws Exception {
        final int max = 8;
        final int count = 8;
        final int type = TYPE_BELLY;
        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type, true);
        assertEquals(count, testArray.size());
        for (int i : mandatoryBelly)
            assertTrue(testArray.contains(i));
    }

    @Test
    public void generateRandomArrayBack() throws Exception {
        final int max = 8;
        final int count = 8;
        final int type = TYPE_BACK;
        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type, true);
        assertEquals(count, testArray.size());
        for (int i : mandatoryBack)
            assertTrue(testArray.contains(i));
    }

    //thourough unittests also checks failures, i.e. wrong input
    @Test
    public void generateRandomArray_wrongInput_1() {
        final int max = 5;
        final int count = 7;
        final int type = TYPE_BACK;
        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type, false);
        assertEquals(0, testArray.size());
    }

    @Test
    public void generateRandomArray_wrongInput_2() {
        final int max = 5;
        final int count = 7;
        final int type = TYPE_BACK;
        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count, type, true);
        assertEquals(2, testArray.size());
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
        assertArrayEquals(desc, testExercise.getDescription());
    }

    @Test
    public void getIcon() throws Exception {
        assertArrayEquals(icon, testExercise.getIcon());
    }

    @Test
    public void getSeconds() throws Exception {
        assertEquals(30, testExercise.getSeconds());
    }
}