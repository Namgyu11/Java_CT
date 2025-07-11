package codingTest.preCT_03.preCT_03_01.ct01.ct04.ct05.표현가능한이진트리;


public class Solution {
    public int[] solution(long[] numbers) {
        int[] result = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);
            String fullBinary = makeFullBinaryTree(binary);

            result[i] = isValidTree(fullBinary, 0, fullBinary.length() - 1) ? 1 : 0;
        }

        return result;
    }

    private String makeFullBinaryTree(String binary) {
        int len = binary.length();
        int treeSize = 1;

        while (treeSize - 1 < len) {
            treeSize *= 2;
        }

        int padding = (treeSize - 1) - len;
        return "0".repeat(padding) + binary;
    }

    private boolean isValidTree(String binary, int start, int end) {
        if (start > end) return true;

        int mid = (start + end) / 2;
        char root = binary.charAt(mid);

        if (root == '0') {
            for (int i = start; i <= end; i++) {
                if (binary.charAt(i) == '1') return false;
            }
        }

        return isValidTree(binary, start, mid - 1) && isValidTree(binary, mid + 1, end);
    }
}
