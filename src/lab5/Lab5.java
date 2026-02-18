package lab5;

public class Lab5 {
    public static void main (String[] args) {
        //task1
        String text = "Метод сортировки слиянием весьма сложен для понимания неподготовленным умам, вроде моего";
        String longest = longestWord(text);
        System.out.println("Самое длинное слово: " + longest);

        System.out.println("---");//task2
        String word1 = "Шалаш";
        String word2 = "Главрыба";
        System.out.println(word1 + " — палиндром? " + isPalindrome(word1));
        System.out.println(word2 + " — палиндром? " + isPalindrome(word2));

        System.out.println("---");//task3
        String uncensored = "Этот текст содержит слово бяка. Эта бяка сидит тут, а та бяка — там. Бяка!";
        String censor = "бяка";
        String replacement = "[вырезано цензурой]";
        String result = censorWithStringBuilder(uncensored, censor, replacement);
        System.out.println("Результат цензуры:");
        System.out.println(result);

        System.out.println("---");//task4
        String source = "ООП — это круто. ООП — это мощно. ООП — это самообман.";
        String searchTarget = "ООП";
        System.out.println("Строка: " + source);
        System.out.println("Подстрока: " + searchTarget);
        int count = countOccurrences(source, searchTarget);
        System.out.println("Количество вхождений: " + count);

        System.out.println("---");//task5
        String input = "This is a test string";
        System.out.println("The given string is: " + input);
        String reverse = reverseEachWord(input);
        System.out.println("The string reversed word by word is:");
        System.out.println(reverse);
    }

    //task1
    public static String longestWord(String text) {
        String[] words = text.split("[\\s,.;!?—]+");
        String result = "";
        for (String word : words) {
            if (word.length() > result.length()) {
                result = word;
            }
        }
        return result;
    }

    //task2
    public static boolean isPalindrome(String word) {
        String lowerCaseWord = word.toLowerCase();
        int length = lowerCaseWord.length();
        boolean result = true;
        for (int i = 0; i < length / 2; i++) {
            if (lowerCaseWord.charAt(i) != lowerCaseWord.charAt(length - 1 - i)) {
                result = false;
                break;
            }
        }
        return result;
    }

    //task3
    public static String censorWithStringBuilder(String text, String target, String replacement) {
        StringBuilder sb = new StringBuilder(text);
        String lowerText = text.toLowerCase();
        String lowerTarget = target.toLowerCase();
        int index = lowerText.indexOf(lowerTarget);
        int offset = 0;
        while (index != -1) {
            int realIndex = index + offset;
            sb.replace(realIndex, realIndex + target.length(), replacement);
            offset += (replacement.length() - target.length());
            index = lowerText.indexOf(lowerTarget, index + target.length());
        }
        return sb.toString();
    }

    //task4
    public static int countOccurrences(String source, String target) {
        if (target.isEmpty() || source.isEmpty()) {
            return 0;
        }
        String lowerSource = source.toLowerCase(); //It is unclear to me if a comparison should be case-sensitive or not
        String lowerTarget = target.toLowerCase(); //If it isn't - then this 2 strings should be deleted...
        int count = 0;
        int index = 0;
        while ((index = lowerSource.indexOf(lowerTarget, index)) != -1) { //..and vars renamed
            count++;
            index += lowerTarget.length();
        }
        return count;
    }

    //task5
    public static String reverseEachWord(String text) {
        String[] words = text.split(" ");
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(words[i]);
            String reversedWord = wordBuilder.reverse().toString();
           finalResult.append(reversedWord);
            if (i < words.length - 1) {
                finalResult.append(" ");
            }
        }
        return finalResult.toString();
    }
}
