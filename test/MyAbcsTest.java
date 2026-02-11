import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Simple test harness for MyAbcs puzzler.
 * Verifies the class compiles and runs, and checks output behavior.
 */
public class MyAbcsTest {

    private static int passed = 0;
    private static int failed = 0;

    private static void check(String description, boolean condition) {
        if (condition) {
            System.out.println("  PASS: " + description);
            passed++;
        } else {
            System.err.println("  FAIL: " + description);
            failed++;
        }
    }

    public static void main(String[] args) {
        System.out.println("Running MyAbcs tests:\n");

        // Capture stdout from MyAbcs.main
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream capture = new PrintStream(baos);

        System.setOut(capture);
        try {
            MyAbcs.main(new String[]{});
        } catch (Exception e) {
            System.setOut(originalOut);
            System.err.println("  FAIL: MyAbcs.main threw exception: " + e);
            failed++;
            printSummary(originalOut);
            return;
        }
        System.setOut(originalOut);

        String output = baos.toString();
        System.out.println("Captured output:\n  " + output.replace("\n", "\n  "));
        System.out.println();

        // Tests
        check("Output is not empty", !output.isEmpty());
        check("Output contains ABC song intro", output.contains("Let's sing the ABC's!"));
        check("Output contains alphabet letters", output.contains("a,") && output.contains("z,"));
        check("Output contains closing line", output.contains("Now I know my ABC's!"));

        // The puzzler: str starts as null, so str += i produces "null" prefix
        // and length is 26 letters + 4 chars for "null" = 30
        check("Puzzler: str.length() reports 30 (not 26) due to null concatenation",
              output.contains("30"));

        printSummary(originalOut);
    }

    private static void printSummary(PrintStream out) {
        out.println("\n" + "=".repeat(40));
        out.println(passed + " passed, " + failed + " failed");
        if (failed > 0) {
            System.exit(1);
        }
    }
}
