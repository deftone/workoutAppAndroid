package de.deftone.bitsandpizzas.data;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import de.deftone.bitsandpizzas.R;

import static de.deftone.bitsandpizzas.activities.MainActivity.ALL_LEG_EXERCISES;
import static de.deftone.bitsandpizzas.data.ExerciseTypes.LEG;
import static org.junit.Assert.*;

/**
 * Created by deftone on 27.12.17.
 * @Before methode namenskonvention: setUp
 * @After methode namenskonvention: tearDown
 */
public class CreatedExerciseTest {
    private static CreatedExercise testExercise;
    private static int id = 33;
    private static ExerciseTypes type = LEG;
    private static String name = "titel";
    private static String[] icon = {"\u25CF", "\u25CF"};
    private static String[] desc = {"beschreibung", "und noch was"};
    private static int[] weight = {2};

    @BeforeClass
    public static void startUp() {
        testExercise = new CreatedExercise(id, type, name, icon, desc, R.drawable.faeuste_heben, 30, weight);
        CreatedExercise.generateRandomExercises(3,
                3,
                3,
                3,
                3);
    }

    @AfterClass
    public static void shutDown() {
        testExercise = null;
        CreatedExercise.CREATED_EXERCISES_LIST = null;
    }

    @Test
    public void generateRandomExercises() throws Exception {
        int size_expected = 15; //see above in startUp, 5x3 exercises
        assertEquals(size_expected, CreatedExercise.CREATED_EXERCISES_LIST.size());
    }

    @Test
    public void generateRandomArrayLeg() throws Exception {
        final int count = 5;
        List<Integer> testArray = CreatedExercise.generateRandomArray(count, ALL_LEG_EXERCISES.size());
        assertEquals(count, testArray.size());
    }

    //thourough unittests also checks failures, i.e. wrong input
    @Test
    public void generateRandomArray_wrongInput_1() {
        final int max = 5;
        final int count = 7;
        List<Integer> testArray = CreatedExercise.generateRandomArray(max, count);
        assertEquals(0, testArray.size());
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

    @Test
    public void getWeight() throws Exception{
        assertArrayEquals(weight, testExercise.getWeight());
    }
}