package com.syscode.saas_erp.utils;

import java.util.Random;

public class GenerateUuids {
    
    static Random random = new Random();

    public static String genUuid13() {
        
        StringBuilder uuid13 = new StringBuilder();
        String lettersAndNumbers = "0123456789ABCDEFGHIJKLMNOPQRSTUVXYWZ";

        for (int i = 13; i > 0; i--) {
            int nextInt = random.nextInt(35);
            uuid13.append(lettersAndNumbers.substring(nextInt, nextInt + 1));
        }
        return uuid13.toString();
    }

    public static String genUuid26() {
        
        StringBuilder uuid26 = new StringBuilder();
        String lettersAndNumbers = "0123456789ABCDEFGHIJKLMNOPQRSTUVXYWZ";

        for (int i = 26; i > 0; i--) {
            int nextInt = random.nextInt(35);
            uuid26.append(lettersAndNumbers.substring(nextInt, nextInt + 1));
        }
        return uuid26.toString();
    }
}
