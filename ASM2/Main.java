public class Main {
    public static void main(String[] args) {
        int[] numbers = {4, 2, 7, 1, 9, 5, 8};
        int target = 5;

        int index = linearSearch.linearSearch(numbers, target);

        if (index != -1) {
            System.out.println("Target found at index " + index);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}