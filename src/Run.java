import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Run {

    public static double[][] getDataForGraph(int numberOfSorting, int arrDimStart, int step, int arrDinEnding) throws FileNotFoundException {
        int points = ((arrDinEnding - arrDimStart) / step) + 1;
        double[][] dataForGraph = new double[2][points];
        int[] arr1 = getIntArrayByFile(new File("nums_1.txt"));
        int[] arr2 = getIntArrayByFile(new File("nums_2.txt"));
        int[] arr3 = getIntArrayByFile(new File("nums_3.txt"));

        int arrDimCurrent = arrDimStart;
        Sorting sorting = new Sorting();
        long start;
        long finish;
        for (int i = 0; i < points; i++) {  // Check division!!!
            int[] testArr1 = Arrays.copyOfRange(arr1, 0, arrDimCurrent);
            int[] testArr2 = Arrays.copyOfRange(arr2, 0, arrDimCurrent);
            int[] testArr3 = Arrays.copyOfRange(arr3, 0, arrDimCurrent);
            switch (numberOfSorting) {
                case 0 -> {
                    start = System.nanoTime();

                    sorting.insertionSort(testArr1);
                    sorting.insertionSort(testArr2);
                    sorting.insertionSort(testArr3);

                    finish = System.nanoTime();
                    dataForGraph[0][i] = arrDimCurrent;
                    dataForGraph[1][i] = (finish - start) / 1000000.0;
                }
                case 1 -> {
                    start = System.nanoTime();

                    sorting.bubbleSort(testArr1);
                    sorting.bubbleSort(testArr2);
                    sorting.bubbleSort(testArr3);

                    finish = System.nanoTime();
                    dataForGraph[0][i] = arrDimCurrent;
                    dataForGraph[1][i] = (finish - start) / 1000000.0;
                }
                case 2 -> {
                    start = System.nanoTime();

                    sorting.quickSort(testArr1, 0, testArr1.length - 1);
                    sorting.quickSort(testArr2, 0, testArr2.length - 1);
                    sorting.quickSort(testArr3, 0, testArr3.length - 1);

                    finish = System.nanoTime();
                    dataForGraph[0][i] = arrDimCurrent;
                    dataForGraph[1][i] = (finish - start) / 1000000.0;
                }
                case 3 -> {
                    start = System.nanoTime();

                    sorting.selectionSort(testArr1);
                    sorting.selectionSort(testArr2);
                    sorting.selectionSort(testArr3);

                    finish = System.nanoTime();
                    dataForGraph[0][i] = arrDimCurrent;
                    dataForGraph[1][i] = (finish - start) / 1000000.0;
                }
                case 4 -> {
                    start = System.nanoTime();

                    sorting.heapSort(testArr1);
                    sorting.heapSort(testArr2);
                    sorting.heapSort(testArr3);

                    finish = System.nanoTime();
                    dataForGraph[0][i] = arrDimCurrent;
                    dataForGraph[1][i] = (finish - start) / 1000000.0;
                }
                default -> System.out.println("Incorrect number of sorting!");
            }
            arrDimCurrent += step;
        }

        return dataForGraph;
    }

    public static int[] getIntArrayByFile(File file) throws FileNotFoundException {
        Scanner inFile = new Scanner(file);
        List<Integer> temps = new ArrayList<>();
        while (inFile.hasNext()) {
            int temp = inFile.nextInt();
            temps.add(temp);
        }
        inFile.close();

        int[] array = new int[temps.size()];
        for (int i = 0; i < temps.size(); i++) array[i] = temps.get(i);
        return array;
    }

}
