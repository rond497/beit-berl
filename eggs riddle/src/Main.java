public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to the eggs riddle!\n");
        int max = 500;
        boolean found = false;

        System.out.println("Naive approach:");
        for (int i = 1; i <= max; i++) {
            if (i % 3 != 1) continue;
            if (i % 4 != 1) continue;
            if (i % 5 != 1) continue;
            if (i % 7 != 0) continue;
            System.out.println(i + " is a solution!");
            found = true;
            break;
        }
        if (!found)
            System.out.println("There is no solution to the riddle under " + max);

        found = false;
        System.out.println("\nNaive approach, but faster:");
        for (int i = 0; i <= max; i = i + 7) {
            if ((i - 1) % 3 != 0) continue;
            if ((i - 1) % 4 != 0) continue;
            if ((i - 1) % 5 != 0) continue;
            System.out.println(i + " is a solution!");
            found = true;
            break;
        }
        if (!found)
            System.out.println("There is no solution to the riddle under " + max);
        Tmp.TmpClass();
    }
}
