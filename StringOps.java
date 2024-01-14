public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(capVowelsLowRest("yellow"));
        System.out.println(camelCase("  intrO   To   ComPUter SCience"));
        
    }

    public static String capVowelsLowRest (String string) {
        String answer = "";
        char newChar = ' ';
        for (int i = 0; i < string.length(); i++) {
            boolean isUpperVowel;
            switch (string.charAt(i)) {
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    isUpperVowel = true;
                    newChar = string.charAt(i);
                    break;
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    newChar =(char)(string.charAt(i) + 'A' - 'a');
                    isUpperVowel = true;
                    break;
                default:
                    isUpperVowel = false;
                    newChar = string.charAt(i);
                    break;
            }
            if ((string.charAt(i) > 'A' &&  string.charAt(i) <= 'Z') && !isUpperVowel) {
                newChar = (char)(string.charAt(i) + 'a' - 'A');
            } 
            answer += newChar;
        }
        return answer;
    }

    public static String camelCase (String string) {
        String answer = "";
        String word = "";
        int wordCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                word += string.charAt(i);
            } else if (word != ""){
                if (wordCount == 0) {
                    word = lowerCase(word);
                    wordCount++;
                }
                else {
                    word = onlyFirstLetterUpperCase(word);
                    wordCount++;
                }
                answer += word;
                word = "";
            }
        }
        // process last word
        if (word.length() > 0) {
            if (wordCount == 0) {
                word = lowerCase(word);
            } else {
                word = onlyFirstLetterUpperCase(word);
            }
            answer += word;
        }
        return answer;
    }

    public static int[] allIndexOf (String string, char chr) {
        // Write your code here:
        return new int[1];
    }

    // helper function
    public static String onlyFirstLetterUpperCase(String string) {
        String word = "";
        char newChar;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z' && i != 0) {
                newChar = (char) (string.charAt(i) + 'a' - 'A');
            } else if ( i == 0) {
                newChar = (char) (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z'
                          ? string.charAt(i) : (char) (string.charAt(i) + 'A' - 'a'));
            } else {
                newChar = string.charAt(i);
            }
            word += newChar;
        }
        return word;
    }
    // helper function
    public static String lowerCase(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++ ) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char lowerCase = (char)(s.charAt(i) + ('a' -'A')); 
                answer += lowerCase;
            } else {
                answer += s.charAt(i);
            }
        }
        return answer;
    }
}
