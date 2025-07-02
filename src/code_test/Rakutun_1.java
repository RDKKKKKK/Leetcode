package code_test;

import java.util.HashMap;
import java.util.Map;

public class Rakutun_1 {
    public int solution(int[] numbers) {
        Map<Integer, Integer> firstDigit = new HashMap<>();
        Map<Integer, Integer> lastDigit = new HashMap<>();
        int last = 0, first = 0;
        int res = 0;

        for (int number : numbers) {
            last = number % 10;
            while (number >= 10) {
                number /= 10;
            }
            first = number;
        }

        firstDigit.put(first, firstDigit.getOrDefault(first, 0) + 1);
        lastDigit.put(last, lastDigit.getOrDefault(last, 0) + 1);

        for (int number : numbers) {
            last = number % 10;
            while (number >= 10) {
                number /= 10;
            }
            first = number;

            res += firstDigit.getOrDefault(first, 0);
            res += lastDigit.getOrDefault(last, 0);
        }

        return res;
    }

    }

    /*
import java.util.*;

class Solution {
    public int solution(int N, String S) {
        Map<Integer, Set<Character>> reservedSeats = new HashMap<>();

        if (S != null && !S.isEmpty()) {
            String[] seats = S.split(" ");
            for (String seat : seats) {
                int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
                char col = seat.charAt(seat.length() - 1);
                reservedSeats.putIfAbsent(row, new HashSet<>());
                reservedSeats.get(row).add(col);
            }
        }

        int maxFamilies = 0;

        for (int i = 1; i <= N; i++) {
            Set<Character> reserved = reservedSeats.getOrDefault(i, new HashSet<>());

            boolean left = !(reserved.contains('B') || reserved.contains('C') || reserved.contains('D') || reserved.contains('E'));
            boolean middle = !(reserved.contains('D') || reserved.contains('E') || reserved.contains('F') || reserved.contains('G'));
            boolean right = !(reserved.contains('F') || reserved.contains('G') || reserved.contains('H') || reserved.contains('J'));

            if (left && right) {
                maxFamilies += 2;
            } else if (left || middle || right) {
                maxFamilies += 1;
            }
        }

        return maxFamilies;
    }
}*/
