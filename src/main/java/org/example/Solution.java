package org.example;

import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        HashMap<Character, Integer> lettersCounter = new HashMap<>();

        // Заполняем карту буквами из журнала
        for (char c : magazine.toCharArray()) {
            lettersCounter.put(c, lettersCounter.getOrDefault(c, 0) + 1);
        }

        // Проверяем, достаточно ли букв для конструирования ransomNote
        for (char c : ransomNote.toCharArray()) {
            int count = lettersCounter.getOrDefault(c, 0);
            if (count > 0) {
                lettersCounter.put(c, count - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}