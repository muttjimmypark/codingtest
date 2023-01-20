package hiringtest230120.test;

class Result {

    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        for (int i = 0; i < n; i++) {
            makeString(i + 1);
            System.out.println();
        }
    }

    private static void makeString(int n) {
        if (n % 3 != 0
                && n % 5 != 0) {
            System.out.print(n);
        } else {
            if (n % 3 == 0) {
                System.out.print("Fizz");
            }
            if (n % 5 == 0) {
                System.out.print("Buzz");
            }
        }
    }

}