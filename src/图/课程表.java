package 图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 使用ist<List<Integer>>储存每个课程的后续课程
 * 用队列进行BFS来取保所有课都能上：入度为0时入队，出队时后续节点入度-1
 *
 */

public class 课程表 {

    List<List<Integer>> edges = new ArrayList<>();
    int[] inDegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        inDegree = new int[numCourses];

        for (int[] each : prerequisites){
            edges.get(each[0]).add(each[1]);
            inDegree[each[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<numCourses; i++){
            if (inDegree[i] == 0)
                queue.offer(i);
        }

        int visit = 0;
        while (!queue.isEmpty()){
            visit++;
            int cur = queue.poll();
            for (int pre : edges.get(cur)){
                inDegree[pre]--;
                if (inDegree[pre] == 0)
                    queue.offer(pre);
            }
        }

        return visit == numCourses;
    }
}
