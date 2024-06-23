package com.softcominfo.encryption;

import java.util.Scanner;

public class EncryptionKeyCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scanner.nextLine();
        int encryptionKey = calculateEncryptionKey(input);
        System.out.println("Encryption key: " + encryptionKey);
    }

    public static int calculateEncryptionKey(String number) {
        int sum = 0;
        for (char digitChar : number.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            if (!isPrime(digit)) {
                sum += digit;
            }
        }
        return sum;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}