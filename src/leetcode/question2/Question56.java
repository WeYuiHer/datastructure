package leetcode.question2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Question56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        List<Section> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Section section = new Section(intervals[i][0], intervals[i][1]);
            list.add(section);
        }

        Collections.sort(list, (Section a, Section b) -> {
            return a.start - b.start;
        });
        Section pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Section cur = list.get(i);
            if (cur.start <= pre.end && cur.end <= pre.end)
                list.set(i, null);
            else if (cur.start <= pre.end && cur.end > pre.end) {
                cur.start = pre.start;
                list.set(i - 1, null);
                pre = cur;
            } else
                pre = list.get(i - 1);
        }
        Iterator<Section> iterator = list.iterator();
        while (iterator.hasNext()) {
            Section next = iterator.next();
            if (next == null)
                iterator.remove();
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Section s = list.get(i);
            ans[i][0] = s.start;
            ans[i][1] = s.end;
        }
        return ans;
    }

    class Section {
        int start;
        int end;

        public Section(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Question56 question56 = new Question56();
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18},{18,20}};//[1,3],[2,6],[8,10],[15,18]
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};//[1,3],[2,6],[8,10],[15,18]
        int[][] merge = question56.merge(intervals);
        for (int i = 0; i < merge.length; i++)
            System.out.println(merge[i][0] + "  " + merge[i][1]);
    }

}
