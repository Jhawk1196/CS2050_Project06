import java.io.*;
import java.util.Scanner;

public class JarredHawkinsKaneEgan_06 {

	public static void main(String[] args) throws IOException {

		int[] array = new int[100];

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

		array = shellSort(array);

		for (int i = 0; i < array.length; i++) {
			outputFile1.println(array[i]);
		}
		outputFile1.close();
	}

	public static int[] shellSort(int[] array) {

		int n = array.length;
		for (int gap = n; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int temp = array[i];
				int j;
				for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
					array[j] = array[j - gap];
				}
				array[j] = temp;
			}
		}
		return array;
	}

	public static int[] quickSort(int[] array) {

		return array;
	}
}
