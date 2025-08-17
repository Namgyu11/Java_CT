package ktb_ct.week06.week05.ct02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String table = br.readLine();

        List<Integer> people = new ArrayList<>();
        List<Integer> burgers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (table.charAt(i) == 'P') {
                people.add(i);
            } else if (table.charAt(i) == 'H') {
                burgers.add(i);
            }
        }

        int maxPeople = 0;
        int pIndex = 0, bIndex = 0;

        while (pIndex < people.size() && bIndex < burgers.size()) {
            int person = people.get(pIndex);
            int burger = burgers.get(bIndex);

            if (Math.abs(person - burger) <= K) {
                maxPeople++;
                pIndex++;
                bIndex++;
            } else if (person < burger) {
                pIndex++;
            } else {
                bIndex++;
            }
        }

        System.out.println(maxPeople);
    }
}