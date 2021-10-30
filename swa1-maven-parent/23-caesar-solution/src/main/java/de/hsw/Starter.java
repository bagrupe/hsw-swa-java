package de.hsw;

public class Starter {
    public static void main(String[] args) {
        String input = "Otto";
        int a = "a".codePointAt(0);
        int z = "z".codePointAt(0);
        int A = "A".codePointAt(0);
        int Z = "Z".codePointAt(0);

        String ergebnis = "";

        for (int i = 0; i < input.length(); i++) {
            int alt = input.codePointAt(i);
            int neu = input.codePointAt(i) + 13;

            if (alt >= a && alt <= z) {
                if (neu > z) {
                    neu = neu - 26;
                }
            } else if (alt >= A && alt <= Z) {
                if (neu > Z) {
                    neu = neu - 26;
                }
            } else {
                // ???
            }

            char x = (char) neu;

            ergebnis = ergebnis + String.valueOf(x);
        }
        System.out.println(ergebnis);
    }
}
