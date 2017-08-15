public class MyAbcs {

    public static void main (String args[]) {

        System.out.printf("Let's sing the ABC's!\n");

        String str = null;
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.printf("%c,", i);
            str += i;
        }

        System.out.printf("Now I know my ABC's! There are %d letters in the alphabet!\n", str.length());
    }
}