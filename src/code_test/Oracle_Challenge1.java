package code_test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Oracle_Challenge1 {
    public List<BigDecimal> calculateCoin(BigDecimal target, List<BigDecimal> coinDenominations) {
        int n = coinDenominations.size() - 1;
        BigDecimal sum = new BigDecimal(0);
        List<BigDecimal> res = new ArrayList<>();

        while (n >= 0) {
            BigDecimal cur = coinDenominations.get(n);

            if (sum.add(cur).equals(target)) break;
            else if (sum.add(cur).compareTo(target) < 0) {
                res.add(cur);
                sum = sum.add(cur);
            } else {
                n--;
            }
        }

        res.sort(new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o1.compareTo(o2);
            }
        });

        return null;

    }
}
