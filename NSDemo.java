package nspack;
import java.util.Scanner;

public class NSDemo {
    private static final String LETTERS = "ABCDEF";

    private int in, i, i2;

    public static void main(String args[]){
        NSDemo nsd = new NSDemo();
        Scanner scr = new Scanner(System.in);

        System.out.println("Enter the number: ");
        String input = scr.nextLine();

        try {

            Integer.parseInt(input);

            System.out.println("Ur hex number: " + nsd.getHex(input));
            System.out.println("Ur bin number: " + nsd.getBin(input));

        } catch (Exception e){
            System.out.print("The number should be integer! Try again.");
        }

    }


    private String getHex (String s) {
        StringBuilder sb = new StringBuilder();
        in = Integer.parseInt(s);

        while (in >= 16){
            i = in;

            in = in / 16;
            i2 = i - (in * 16); // остаток от деления

            if (i2 < 16) {

                if (i2 >= 10){
                    i2 = i2 - 10;

                    for (int j = LETTERS.indexOf('A'); j < LETTERS.length(); j++){
                        if (i2 == j){
                            char letter = LETTERS.charAt(j);
                            sb.append(letter);
                        }
                    }

                } else {
                    sb.append(i2);
                }
            }
        }

        if (in < 16) {

            if (in >= 10){
                in = in - 10;

                for (int j = LETTERS.indexOf('A'); j < LETTERS.length(); j++){
                    if (in == j){
                        char letter = LETTERS.charAt(j);
                        sb.append(letter);
                    }
                }

            } else {
                sb.append(in);
            }
        }

        return sb.reverse().toString();
    }

    private String getBin(String s){
        StringBuilder sb = new StringBuilder();
        in = Integer.parseInt(s);

        while (in >= 2){
            i = in;

            in = in / 2;
            i2 = i - (in * 2); // остаток от деления

            if (i2 <= 1){
                sb.append(i2);
            }

            if (in <= 1) {
                sb.append(in);
            }
        }

        return sb.reverse().toString();
    }
}
