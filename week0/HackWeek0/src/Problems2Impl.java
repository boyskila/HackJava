import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int x) {
        return ((x & 1) == 1);
        // return number % 2 != 0;
    }

    @Override
    public boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int save = arr[i];
                    arr[i] = arr[j];
                    arr[j] = save;
                }
            }
        }
        return arr;
    }

    @Override
    public int min(int[] array) {
        // Arrays.sort(array);
        return sort(array)[0];
    }

    @Override
    public int kthMin(int k, int[] array) {
        return sort(array)[k - 1];
    }

    @Override
    public float getAverage(int[] array) {
        float avg = 0;
        for (int i : array)
            avg += i;
        return avg / array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        return upperBound == 2 ? 2 : leastCommonMultiple(upperBound, getSmallestMultiple(upperBound - 1));
    }

    private static long leastCommonMultiple(long num1, long num2) {
        return (num1 * num2) / greatestCommonDivisor(num1, num2);
    }

    private static long greatestCommonDivisor(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public long getLargestPalindrome(long N) {
        for (int i = (int) N; i > 10; i--) {
            if (i == Integer.parseInt(reverseMe(i + "")))
                return i;
        }
        return 0;
    }

    @Override
    public int[] histogram(short[][] image) {
        int row = image.length;
        int column = image[0].length;
        int[] result = new int[row * column + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                result[image[i][j]]++;
        }
        return result;
    }

    static long Factorial(long n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++)
            factorial = factorial * i;
        return factorial;
    }

    @Override
    public long doubleFac(int n) {
        return Factorial(Factorial(n));
    }

    @Override
    public long kthFac(int k, int n) {
        long start = 1;
        long end = n;
        long kthFactorial = 1;
        for (int i = 0; i < k; i++) {
            for (long j = start; j <= end; j++)
                kthFactorial *= j;
            start = end + 1;
            end = kthFactorial;
        }
        return kthFactorial;
    }

    @Override
    public int getOddOccurrence(int[] arr) {
        Arrays.sort(arr);
        int number = 0;
        int numbersCount = 0;
        int counter = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (last == arr[i])
                counter++;
            else {
                if (counter % 2 != 0 && counter > numbersCount) {
                    numbersCount = counter;
                    number = last;
                }
                counter = 1;
                last = arr[i];
            }
        }
        return number;
    }

    @Override
    public long pow(int a, int b) {
        long result = 1;
        while (b > 0) {
            if ((isOdd(b)))
                result *= a;
            a *= a;
            b >>= 1;
        }
        return result;
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int result = 0;
        for (int i = 0; i < b.length; i++)
            result += a[i] * b[i];
        return result;
    }

    @Override
    public int maxSpan(int[] array) {
        int result = 0;
        int counter;
        for (int i = 0; i < array.length; i++) {
            counter = 0;
            for (int j = i; j < array.length; j++) {
                counter++;
                if (array[i] == array[j] && result < counter)
                    result = counter;
            }
        }
        return result;
    }

    @Override
    public boolean canBalance(int[] numbers) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers.length % 2 != 0) {
                if (i <= numbers.length / 2)
                    sum1 += numbers[i];
                else
                    sum2 += numbers[i];
            } else {
                if (i < numbers.length / 2)
                    sum1 += numbers[i];
                else
                    sum2 += numbers[i];
            }
        }
        return sum1 == sum2 ? true : false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int[][] newImage = new int[newWidth][newHeight];
        int x = original.length / newWidth;
        int y = original[0].length / newHeight;
        for (int i = 0; i < newImage.length; i++) {
            for (int j = 0; j < newImage[0].length; j++)
                newImage[i][j] = original[i * x][j * y];
        }
        return newImage;
    }

    @Override
    public String reverseMe(String argument) {
        StringBuilder sb = new StringBuilder(argument);
        return sb.reverse().toString();
    }

    @Override
    public String copyEveryChar(String input, int k) {
        char[] ch = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < k; j++) {
                char cha = j > 0 ? Character.toLowerCase(ch[i]) : ch[i];
                sb.append(cha);
            }
        }
        return sb.toString();
    }

    @Override
    public String reverseEveryWord(String arg) {
        String[] str = arg.split(" ");
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < str.length; i++)
            strb.append(reverseMe(str[i]) + " ");
        return strb.toString().trim();
    }

    @Override
    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    @Override
    public boolean isPalindrome(int number) {
        return isPalindrome(number + "");
    }

    @Override
    public int getPalindromeLength(String str) {// ("taz*zad") => 2
        String[] splitedStr = str.split("\\*");
        if (isPalindrome(splitedStr[0] + splitedStr[1]))
            return str.length() / 2;
        for (int i = 0; i < str.length() / 2; i++) {
            if (splitedStr[0].charAt(splitedStr.length - i) != splitedStr[1].charAt(i))
                return i;
        }
        return 0;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        return haystack.split(needle).length - 1;
    }

    @Override
    public String decodeURL(String input) {
        return input.replaceAll("%2O", " ").replaceAll("%3A", ":").replaceAll("%3D", "?").replaceAll("%2F", "/");
    }

    @Override
    public int sumOfNumbers(String input) {
        Matcher matcher = Pattern.compile("-?[0-9]+").matcher(input);
        int sum = 0;
        while (matcher.find())
            sum += Integer.parseInt(matcher.group());
        return sum;
    }

    @Override
    public boolean areAnagrams(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] b2 = b.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b2);
        return Arrays.equals(a1, b2);
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        for (int i = 0; i < string2.length() - 2; i++) {
            String charSequence = string2.subSequence(i, string.length() + i).toString();
            if (areAnagrams(string, charSequence))
                return true;
        }
        return false;
    }
}