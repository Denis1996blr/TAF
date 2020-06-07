package Products.FilesWorker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FileWorker {

    public int[] ConcatArrayFromFiles(String pathToFile1, String pathToFile2) {
        String[] arrayFromFirstFile;
        String[] arrayFromSecondFile;
        boolean isFirstFileExist = false;
        try {
            var dataFromFile1 = new ArrayList<>(Files.readAllLines(Path.of(pathToFile1)));
            isFirstFileExist = true;
            var dataFromFile2 = new ArrayList<>(Files.readAllLines(Path.of(pathToFile2)));
            arrayFromFirstFile = dataFromFile1.get(0).split(" ");
            arrayFromSecondFile = dataFromFile2.get(0).split(" ");
        } catch (IOException e) {
            throw new Error(String.format("File not found by path '%s'", isFirstFileExist ? pathToFile2 : pathToFile1));
        }

        var intArrayFromFirstFile = getIntArray(arrayFromFirstFile, pathToFile1);
        var intArrayFromSecondFile = getIntArray(arrayFromSecondFile, pathToFile2);

        var temp = new int[intArrayFromFirstFile.length + intArrayFromSecondFile.length];

        System.arraycopy(intArrayFromFirstFile, 0, temp, 0, intArrayFromFirstFile.length);
        System.arraycopy(intArrayFromSecondFile, 0, temp, intArrayFromFirstFile.length, intArrayFromSecondFile.length);

        var resultArray = getArrayWithoutDuplicateElements(temp);
        Arrays.sort(resultArray);

        return resultArray;
    }

    private static int[] getIntArray(String[] array, String pathToFile) {
        var intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            try {
                intArray[i] = Integer.parseInt(array[i]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(String.format("Cannot parse data from array to int. Please recheck data in file '%s'", pathToFile));
            }
        }
        return intArray;
    }

    private static int[] getArrayWithoutDuplicateElements(int[] array) {

        Set<Integer> set = new HashSet<>();

        for (int value : array) {
            set.add(value);
        }
        var actualArray = new int[set.size()];

        int i = 0;
        for (int value : set) {
            actualArray[i++] = value;
        }

        return actualArray;
    }
}