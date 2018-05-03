import java.util.ArrayList;
import java.util.Collections;

public class MergeSort {

	public static void main(String[] args) {

		ArrayList<Integer> S = new ArrayList<>();

		Collections.addAll(S, 5, 1, 4, 8, 4, 7, 3, 6);

		System.out.println(S.toString());

		System.out.println(Sort(S).toString());
	}

	/*
	 * Top-Down Mergesort
	 */
	private static ArrayList<Integer> Sort(ArrayList<Integer> B) {
		if (B.size() <= 1) // BASE CASE
			return B;

		ArrayList<Integer> A = new ArrayList<>(), result = new ArrayList<>();

		/*
		 * for loop will keep calculating B.size() every iteration and thus calculate
		 * exactly half of B's initial size
		 */
		for (int i = 0; i < B.size(); i++) {
			A.add(B.get(0));
			B.remove(0);
		}

		A = Sort(A);
		B = Sort(B);

		while (!A.isEmpty() && !B.isEmpty()) { // Select lowest of each side

			if (A.get(0) <= B.get(0)) {
				result.add(A.get(0));
				A.remove(0);
			} else {
				result.add(B.get(0));
				B.remove(0);
			}
		}

		/*
		 * Only one of these while-loops will execute each recursion
		 */
		while (!A.isEmpty()) { // Finish A
			result.add(A.get(0));
			A.remove(0);
		}
		while (!B.isEmpty()) { // Finish B
			result.add(B.get(0));
			B.remove(0);
		}

		return result; // Merged list of A and B
	}

}
