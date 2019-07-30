import java.io.*;
import java.util.Scanner;

public class JarredHawkinsKaneEgan_06 {

	public static void main(String[] args) throws IOException {

		int[] array = new int[100];
		
		int low = 0;
		int high = array.length - 1;

		final String INPUT_FILE = "2050 Project 06_Input.txt";
		final String OUTPUT_FILE1 = "2050 Project 06_Output1.txt";
		final String OUTPUT_FILE2 = "2050 Project 06_Output2.txt";

		FileWriter outputDataFile1 = new FileWriter(OUTPUT_FILE1); // File writer to be used by PrintWriter
		PrintWriter outputFile1 = new PrintWriter(outputDataFile1); // Sets up the Output file

		FileWriter outputDataFile2 = new FileWriter(OUTPUT_FILE2); // File writer to be used by PrintWriter
		PrintWriter outputFile2 = new PrintWriter(outputDataFile2); // Sets up the Output file

		File inputDataFile = new File(INPUT_FILE);
		Scanner inputFile = new Scanner(inputDataFile); // Allows for the program to read the incoming file

		for (int i = 0; i < 100; i++) {
			array[i] = inputFile.nextInt();
		}

		int[] array1 = shellSort(array);

		for (int i = 0; i < array1.length; i++) {
			outputFile1.println(array1[i]);
		}

		int[] array2 = quickSort(array, low, high);

		for (int i = 0; i < array2.length; i++) {
			outputFile2.println(array2[i]);
		}
		
        inputFile.close();
        outputFile1.close();
        outputFile2.close();
	}

	public static int[] shellSort(int[] array) {

		int n = array.length;
		int holder1 = 0;
		int holder2 = 0;
		boolean done = true;

		do {
			done = true;
			for (int gap = n; gap > 0; gap /= 2) {
				int j = 0;
				for (int i = gap - 1; i < n; i++) {
					holder1 = array[i];
					holder2 = array[j];
					if (holder1 < holder2) {
						array[i] = array[j];
						array[j] = holder1;
					}
					j++;
				}
			}
			for (int k = 1; k < n; k++) {
				holder1 = array[k-1];
				holder2 = array[k];
				if (holder1 > holder2) {
					array[k] = holder1;
					array[k-1] = holder2;
				}
			}
			for (int k = 1; k < n; k++) {
				holder1 = array[k-1];
				holder2 = array[k];
				if (holder1 > holder2) {
					done = false;
					break;
				}
			}
		} while (done == false);
		return array;
	}

	public static int[] quickSort(int[] array, int low, int high) {

        if (low < high) {

            int index = partition(array, low, high);

            quickSort(array, low, index - 1);
            quickSort(array, index + 1, high);

		} 
		return array;
    }

    public static int partition(int[] array, int low, int high) {

        int piviot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (array[j] <= piviot) {

                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
			}
		}

            int temp = array[i +1];
            array[i + 1] = array[high];
            array[high] = temp;

		return i + 1;     
    }

}
