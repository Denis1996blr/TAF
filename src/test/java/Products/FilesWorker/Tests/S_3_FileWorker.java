package Products.FilesWorker.Tests;

import Products.FilesWorker.FileWorker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class S_3_FileWorker {

    @Test
    public void test_file1_does_not_exist() {
        String pathToNotExistingFile = "C:\\someMagicFile.txt";
        String pathToExistingFile = Objects.requireNonNull(getClass().getClassLoader().getResource("2.txt")).getPath().substring(1);
        Assert.assertThrows(Error.class, () -> new FileWorker().ConcatArrayFromFiles(pathToNotExistingFile, pathToExistingFile));
    }

    @Test
    public void test_file2_does_not_exist() {
        String pathToNotExistingFile = "C:\\someMagicFile.txt";
        String pathToExistingFile = Objects.requireNonNull(getClass().getClassLoader().getResource("2.txt")).getPath().substring(1);

        Assert.assertThrows(Error.class, () -> new FileWorker().ConcatArrayFromFiles(pathToExistingFile, pathToNotExistingFile));
    }

    @Test
    public void test_function_works_as_expected_with_positive_and_test_function_works_expected_with_duplications_data() {
        String pathToFile1 = Objects.requireNonNull(getClass().getClassLoader().getResource("1.txt")).getPath().substring(1);
        String pathToFile2 = Objects.requireNonNull(getClass().getClassLoader().getResource("2.txt")).getPath().substring(1);

        int[] expectedArray = new int[]{1, 2, 3, 5, 6, 7};
        Assert.assertEquals(new FileWorker().ConcatArrayFromFiles(pathToFile1, pathToFile2), expectedArray);
    }

    @Test
    public void test_file1_has_wrong_values() {
        String pathToFileWithWrongData = Objects.requireNonNull(getClass().getClassLoader().getResource("testData/wrongData.txt")).getPath().substring(1);
        String pathToFile2 = Objects.requireNonNull(getClass().getClassLoader().getResource("1.txt")).getPath().substring(1);

        Assert.assertThrows(NumberFormatException.class, () -> new FileWorker().ConcatArrayFromFiles(pathToFileWithWrongData, pathToFile2));
    }

    @Test
    public void test_file2_has_wrong_values() {
        String pathToFile1 = Objects.requireNonNull(getClass().getClassLoader().getResource("1.txt")).getPath().substring(1);
        String pathToFileWithWrongData = Objects.requireNonNull(getClass().getClassLoader().getResource("testData/wrongData.txt")).getPath().substring(1);

        Assert.assertThrows(NumberFormatException.class, () -> new FileWorker().ConcatArrayFromFiles(pathToFile1, pathToFileWithWrongData));
    }
}