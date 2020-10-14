
import java.util.Scanner;

public class Sample {
	
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int race = 0;
		race = initRaceNumber(race, s);
		String[] names = new String[race];
		double[] times = new double[race];
		initRaceDetails(names, times, race, s);

		System.out.println("=======================");
		while (true) {
			printInstructions();
			int choice = s.nextInt();
			switch (choice) {
			case 1:

				displayAverageRaceTime(race, times); // This line call method to
														// display average race
														// times
				break;

			case 2:
				double fastest = 0;
				displayFastestTime(race, times, fastest);

				break;

			case 3:
				// initial value giving as a higher value. since the allowed
				// completion time
				// 0.00 & 10.00
				double slowest = 99;
				displaySlowestTime(race, times, slowest);
				break;

			case 4:
				SortAndDisplayRaceTime(times);

				break;
			case 5:
				searchParticipants(names, race, times, s);
				break;

			default:
				break;
			}
			System.out.println("=======================");

		}

	}
	
	/**
	 * initRaceDetails - initialize Race data for processing
	 */
	public static void initRaceDetails(String[] names, double[] times, int race, Scanner s) {

		for (int i = 0; i < race; i++) {
			System.out.println("Enter " + (i + 1) + "  race participants name ");
			String name = s.next();
			names[i] = name;

			double time = 0;
			while (time <= 0 || time > 10) {
				System.out.println(name + "  race participants completion time  (a value between 0.00 & 10.00 mins.) ");
				time = s.nextDouble();
				if (time < 0 || time > 10) {
					System.out.println("Invalid number enter. Allowed value are between 0.00 & 10.00 \n ");

				}

			}

			times[i] = time;
		}
	}
	
	

	/**
	 * printInstructions
	 */
	public static void printInstructions() {
		System.out.println("Display average race completion time - 1");
		System.out.println("Display the fastest race completion time - 2 ");
		System.out.println("Display slowest race completion time - 3 ");
		System.out.println("Sort & Display the race times in descending order - 4");
		System.out.println("Search for an individual race participant by name - 5");
	}
	
	/**
	 * Display average race completion time - press 1
	 * 
	 * @param race
	 * @param times
	 */

	public static void displayAverageRaceTime(int race, double[] times) {
		double sum = 0;
		for (int i = 0; i < race; i++) {
			sum = sum + times[i];
		}
		System.out.println("Average race completion time =" + (sum / race));
	}
	
	/**
	 * displayFastestTime
	 * 
	 * @param race
	 * @param times
	 * @param fastest
	 */
	public static void displayFastestTime(int race, double times[], double fastest) {
		for (int i = 0; i < race; i++) {
			fastest = times[i];
			if (fastest > times[i]) {
				fastest = times[i];
			}
		}
		System.out.println("Fastest race completion time=" + (fastest));
	}
	/**
	 * initRaceNumber - initializr number of race results
	 */
	public static int initRaceNumber(int race, Scanner s) {
		do {

			System.out.println("Enter number of race results ( 2 - 10): ");
			race = s.nextInt();
			if (race < 2 || race > 10) {
				System.out.println("Invalid number enter. Allowed value are between 2 to 10\n ");

			}

		} while (race < 2 || race > 10);

		return race;
	}
	
	/**
	 * displaySlowestTime
	 * 
	 * @param race
	 * @param times
	 * @param slowest
	 */
	public static void displaySlowestTime(int race, double times[], double slowest) {

		for (int i = 0; i < race; i++) {
			slowest = times[i];
			if (slowest < times[i]) {
				slowest = times[i];
			}
		}
		System.out.println("Slowest race completion time=" + (slowest));
	}
	
	/**
	 * SortAndDisplayRaceTime
	 * 
	 * @param times
	 */
	public static void SortAndDisplayRaceTime(double times[]) {
		double[] desArray = new double[times.length];
		// Copying array to dummy array
		System.arraycopy(times, 0, desArray, 0, times.length);
		double temp = 0;
		for (int i = 0; i < desArray.length; i++) {
			for (int j = i + 1; j < times.length; j++) {
				if (desArray[i] < desArray[j]) {
					temp = desArray[i];
					desArray[i] = desArray[j];
					desArray[j] = temp;
				}
			}
		}
		System.out.println("Descending  Order:");

		for (int i = 0; i < desArray.length; i++) {
			System.out.println(desArray[i]);
		}
		System.out.println("=========================");
	}
	
	/**
	 * searchParticipants
	 * 
	 * @param names
	 * @param race
	 * @param times
	 * @param s
	 */
	public static void searchParticipants(String names[], int race, double times[], Scanner s) {

		System.out.println("Enter race participant name");
		String nameQuery = s.next();
		boolean blnFound = false;
		for (int i = 0; i < race; i++) {
			if (names[i].equalsIgnoreCase(nameQuery)) {
				System.out.println(names[i] + " race time = " + times[i]);
				blnFound = true;
			}
		}
		if (!blnFound) {
			System.out.println(nameQuery + " not found in the race ");
		}
	}

}

