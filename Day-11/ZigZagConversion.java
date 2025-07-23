public class ZigZagConversion {
    private String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            if (currentRow == 0) {
                goingDown = true;
            } else if (currentRow == numRows - 1) {
                goingDown = false;
            }
            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder zigzagString = new StringBuilder();
        for (StringBuilder row : rows) {
            zigzagString.append(row);
        }

        return zigzagString.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion converter = new ZigZagConversion();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = converter.convert(s, numRows);
        System.out.println(result); // Output: "PAHNAPLSIIGYIR"
    }
}
