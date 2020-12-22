package io.programminglife.algoexpert.easy;

public class RunLengthEncoding {
    
    public static String runLengthEncoding(String string) {
        StringBuffer output = new StringBuffer();
        
        int count = 1;
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i+1) && count < 9) {
                count++;
            } else {
                output.append(count + String.valueOf(string.charAt(i)));
                count = 1;
            }
        }

        output.append(count + String.valueOf(string.charAt(string.length() - 1)));

        return output.toString();
      }

    public static void main(String[] args) {
        String input = "AAAAAAAAAAAABBCCCCDD";

        System.out.println(runLengthEncoding(input));
    }

}
