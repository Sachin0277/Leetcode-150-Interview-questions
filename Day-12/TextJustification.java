import java.util.ArrayList;
import java.util.List;

public class TextJustification {
  /*
   * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
   */
  public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        String[] justifiedText = fullJustify(words, maxWidth);
        
        for (String line : justifiedText) {
            System.out.println(line);
        }
        //optimized version
        List<String> optimizedJustifiedText = fullJustifyOptimized(words, maxWidth);
        for (String line : optimizedJustifiedText) {
            System.out.println(line);
        }
    }

    public static String[] fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + word.length() + currentLine.size() > maxWidth) {
                result.add(justifyLine(currentLine, currentLength, maxWidth));
                currentLine.clear();
                currentLength = 0;
            }
            currentLine.add(word);
            currentLength += word.length();
        }

        // Last line is left-justified
        StringBuilder lastLine = new StringBuilder(String.join(" ", currentLine));
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result.toArray(new String[0]);
    }

    public static String justifyLine(List<String> words, int length, int maxWidth) {
        if (words.size() == 1) {
            return words.get(0) + " ".repeat(maxWidth - length);
        }

        int totalSpaces = maxWidth - length;
        int spaceBetweenWords = totalSpaces / (words.size() - 1);
        int extraSpaces = totalSpaces % (words.size() - 1);

        StringBuilder justifiedLine = new StringBuilder();
        
        for (int i = 0; i < words.size(); i++) {
            justifiedLine.append(words.get(i));
            if (i < words.size() - 1) {
                int spacesToAdd = spaceBetweenWords + (i < extraSpaces ? 1 : 0);
                justifiedLine.append(" ".repeat(spacesToAdd));
            }
        }
        
        return justifiedLine.toString();
    }

    public static List<String> fullJustifyOptimized(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i=0;
        while(i < n){
            int j = i+1;
            int c = words[i].length();
            int wc = words[i].length();
            while(j < n && c+words[j].length()+1 <= maxWidth){
                c += words[j].length()+1;
                wc += words[j].length();
                j++;
            }
            if(j == n || j-i == 1){
                StringBuilder s = new StringBuilder();
                for(int p=i;p<j;p++){
                    s.append(words[p]);
                    if(p != j-1){
                        s.append(' ');
                    }
                }
                int ts = maxWidth - s.length();
                for(int k = 0;k<ts;k++){
                    s.append(' ');
                }
                res.add(s.toString());
                i=j-1;
            }
            else{
                int tw = j-i;
                int ts = maxWidth-wc;
                int es = ts/(tw-1);
                int extra = ts%(tw-1);
                StringBuilder s = new StringBuilder();
                for(int p = i;p<j;p++){
                    s.append(words[p]);
                    if(extra > 0){
                        s.append(' ');
                        extra--;
                    }
                    if(p != j-1){
                        for(int k=0;k<es;k++){
                            s.append(' ');
                        }
                    }
                }
                res.add(s.toString());
                i= j-1;
            }
            i++;
        }
        return res;
    }
            
}
