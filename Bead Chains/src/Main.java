//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String test, expected, answer;
        System.out.println("Hello and welcome to this optional exercise!");
        optionalExercise task = new optionalExercise();

        // Exercise 1
        test = "abcdefghijklmnop";
        expected = "ab$de$gh$jk$mn$p";
        answer = task.exercise1(test);
        System.out.printf("Exercise 1 is: %b\n",task.testResponse(answer, expected));

        // Exercise 2
        test = "abacabaabacdcabc";
        expected = "aba$$caba$$aba$$cdcabc";
        answer = task.exercise2(test);
        System.out.printf("Exercise 2 is: %b\n",task.testResponse(answer, expected));

        // Exercise 3
        test = "abacabaabacdcabc";
        expected = "ccdcabc";
        answer = task.exercise3(test);
        System.out.printf("Exercise 3 is: %b\n",task.testResponse(answer, expected));
        // Exercise 3 more complicated
        test = "abacabaabacdcaabc"; // added one 'a' toward the end, in both test and expected
        expected = "ccdcaabc";
        answer = task.exercise3(test);
        System.out.printf("Exercise 3A is: %b\n",task.testResponse(answer, expected));

        // Exercise 4
        System.out.println("Exercise 4");
        test = "the quick brown fox jumped over the lazy bear.";
        task.exercise4(test);
    }
}