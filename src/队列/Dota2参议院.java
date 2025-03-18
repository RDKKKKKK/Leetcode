package 队列;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2参议院 {

    /**
     * 贪心思想：每个议员攻击 下一个最快能发起攻击 的对方议员
     * 利用队列 先进先出 实现最近下一个议员的淘汰 （队列存放index）
     * 循环通过 index + senate.length()实现
     */


    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') rQueue.offer(i);
            else dQueue.offer(i);
        }

        while(!rQueue.isEmpty() && !dQueue.isEmpty()){
            int r=rQueue.poll(), d=dQueue.poll();

            if (r<d) rQueue.offer(r+senate.length());
            else dQueue.offer(d+senate.length());
        }

        if (rQueue.isEmpty()) return "Radiant";
        else return "Dire";

    }
}
