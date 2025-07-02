package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 重新安排行程 {


    /**
     * int index = tickets.indexOf(ticket); 重复机票只取第一个满足的，有误
     */
    LinkedList<String> path = new LinkedList<>();
    List<String> res;
    boolean[] used;
    int lastTkt;

    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        backtrack(tickets, -1);
        res.add(tickets.get(lastTkt).get(1));
        return res;
    }

    public void backtrack(List<List<String>> tickets, int pre) {
        if (path.size() == tickets.size()) {
            // 比较当前 path 和 res 字符串大小，得到字典序更小的行程
            if (res != null) {
                String pathStr = String.join("", path);
                String resStr = String.join("", res);
                if (pathStr.compareTo(resStr) > 0) {
                    return;
                }
            }
            res = new ArrayList<>(path);
            lastTkt = pre;
            return;
        }

        // 不要 for-each + indexOf，而用普通的 for 循环
        for (int i = 0; i < tickets.size(); i++) {
            if (used[i]) continue;

            List<String> ticket = tickets.get(i);
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (pre == -1) {
                // 从 JFK 出发
                if (!from.equals("JFK")) continue;
                path.add(from);
                used[i] = true;
                backtrack(tickets, i);
                path.removeLast();
                used[i] = false;
            } else {
                // 根据前一张票的目的地来匹配
                String prevDest = tickets.get(pre).get(1);
                if (from.equals(prevDest)) {
                    path.add(from);
                    used[i] = true;
                    backtrack(tickets, i);
                    path.removeLast();
                    used[i] = false;
                }
            }
        }
    }
}
