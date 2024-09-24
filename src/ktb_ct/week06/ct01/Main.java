package ktb_ct.week06.ct01;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oldGrades = br.readLine();
        StringBuilder newGrades = new StringBuilder();
        String prevGrade = "";

        for (int i = 0; i < oldGrades.length(); i++) {
            String currentGrade;

            if (i + 1 < oldGrades.length() && (oldGrades.charAt(i + 1) == '+' || oldGrades.charAt(i + 1) == '-')) {
                currentGrade = oldGrades.substring(i, i + 2);
                i++;
            } else {
                currentGrade = String.valueOf(oldGrades.charAt(i));

                if (currentGrade.equals("A") || currentGrade.equals("B") || currentGrade.equals("C")) {
                    currentGrade += "0";
                }
            }

            String newGrade = "";
            switch (currentGrade) {
                case "C+":
                case "C0":
                case "C-":
                    newGrade = "B";
                    break;
                case "B0":
                case "B-":
                    if (i == 1 || prevGrade.matches("C\\+|C0|C-")) {
                        newGrade = "D";
                    } else {
                        newGrade = "B";
                    }
                    break;
                case "A-":
                case "B+":
                    if (i == 1 || prevGrade.matches("B0|B-|C\\+|C0|C-")) {
                        newGrade = "P";
                    } else {
                        newGrade = "D";
                    }
                    break;
                case "A0":
                    if (i == 1 || prevGrade.matches("A-|B\\+|B0|B-|C\\+|C0|C-")) {
                        newGrade = "E";
                    } else {
                        newGrade = "P";
                    }
                    break;
                case "A+":
                    newGrade = "E";
                    break;
            }

            newGrades.append(newGrade);
            prevGrade = currentGrade;
        }
        System.out.println(newGrades.toString());
        br.close();
    }
}
