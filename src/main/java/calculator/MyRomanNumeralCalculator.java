package calculator;

public class MyRomanNumeralCalculator implements RomanNumeralCalculator {
    String[] millionString = {"M"};
    String[] hundredThousandsString = {"C", "CC", "CCC", "D", "CD", "DC", "DCC", "DCCC", "CM"};
    String[] tenThousandsString = {"X", "XX", "XXX", "L", "XL", "LX", "LXX", "LXXX", "XC"};
    String[] thousandsString = {"m", "mm", "mmm", "V", "mV", "Vm", "Vmm", "Vmmm", "mX"};
    String[] hundredsString = {"c", "cc", "ccc", "d", "cd", "dc", "dcc", "dccc", "cm"};
    String[] tensString = {"x", "xx", "xxx", "l", "xl", "lx", "lxx", "lxxx", "xc"};
    String[] onesString = {"i", "ii", "iii", "v", "iv", "vi", "vii", "viii", "ix"};
    String[][] romanNumeralString = {onesString, tensString, hundredsString, thousandsString, tenThousandsString, hundredThousandsString, millionString};
    int[] numbers = {1, 2, 3, 5, 4, 6, 7, 8, 9, 10};

    @Override
    public String compute(String romanNumeralOne, String romanNumeralTwo, Operator operation) {
        int a = romanNumeralToNumber(romanNumeralOne);
        int b = romanNumeralToNumber(romanNumeralTwo);
        int result = 0;

        if (operation.equals(Operator.add)) {
            result = a + b;
        }
        else if (operation.equals(Operator.subtract)) {
            result = a - b;
        }
        else if (operation.equals(Operator.multiply)) {
            result = a * b;
        }
        return numberToRomanNumeral(result);
    }

    public int romanNumeralToNumber(String romanNumeral) {
        int sign = 1;
        int sum = 0;
        int[] digits = new int[7];

        if (romanNumeral.contains("-")) {
            sign = -1;
        }

        for (int a = 0; a < romanNumeralString.length; a++) {
            for (int x = 0; x < romanNumeralString[a].length; x++) {
                if (romanNumeral.contains(romanNumeralString[a][x])) {
                    if (x == 0 && a !=0 && a != romanNumeralString.length) {
                        if (romanNumeral.contains(romanNumeralString[a--][8])) {
                            continue;
                        }
                    }
                    digits[a] = numbers[x];
                }
            }
        }

        for (int a = 0; a < digits.length; a++) {
            sum += digits[a] * Math.pow(10, a);
        }
        return sum;
    }

    public String numberToRomanNumeral(int number) {
        String sign = "";
        int[] digits = new int[7];
        String[] RN = new String[7];

        if (number < 0) {
            sign = "-";
            number *= -1;
        }

        for (int a = digits.length - 1; a >= 0; a--) {
            digits[a] = (int)(number / Math.pow(10, a));
            number %= Math.pow(10, a);
        }

        String endNumber = "";
        for (int a = RN.length - 1; a >= 0; a--) {
            if (digits[a] != 0) {
                endNumber += romanNumeralString[a][getIndex(digits[a])];
            }
        }

        return endNumber;
    }

    public int getIndex(int x) {
        for (int a = 0; a < numbers.length; a++) {
            if (x == numbers[a]) {
                return a;
            }
        }
        return -1;
    }
}