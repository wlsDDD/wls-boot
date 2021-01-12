package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wls
 * @Date 2020/11/23 10:08
 */
public class Solution452 {
    
    @Test
    public void test01() {
        int[][] points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println("minArrowShots = " + minArrowShots);
    }
    
    /**
     * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，
     * 因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
     * <p>
     * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
     * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，
     * 可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
     * <p>
     * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
     * <p>
     */
    public int findMinArrowShots(int[][] points) {
//        Map<Integer, Integer> map = new HashMap<>(points.length);
//        for (int i = 0; i < points.length; i++) {
//            int[] point = points[i];
//            for (int j = point[0]; j <= point[1]; j++) {
//                Integer integer = map.get(j);
//                if (integer == null) {
//                    map.put(j, 1);
//                } else {
//                    map.put(j, ++integer);
//                }
//            }
//        }
//        map.forEach((integer, integer2) -> );
        
        Arrays.sort(points, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        List<int[]> list = new ArrayList<>(points.length);
        for (int[] point : points) {
            boolean flag = true;
            for (int[] ints : list) {
                if (point[0] >= ints[0] && point[1] <= ints[1]) {
                    ints[0] = point[0];
                    ints[1] = point[1];
                    flag = false;
                    break;
                }
                if (point[0] <= ints[0] && point[1] >= ints[1]) {
                    flag = false;
                    break;
                }
                if (ints[0] <= point[1] && point[1] <= ints[1]) {
                    ints[1] = point[1];
                    flag = false;
                    break;
                }
                if (ints[0] <= point[0] && point[0] <= ints[1]) {
                    ints[0] = point[0];
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(point);
            }
        }
        return list.size();


//        Set<Integer> set1 = new HashSet<>();
//        for (int i = 0; i < points.length; i++) {
//            int[] point = points[i];
//            boolean flag = true;
//            Set<Integer> set = new HashSet<>();
//            for (int j = point[0]; j <= point[1]; j++) {
//                for (Set<Integer> integers : list) {
//                    if (integers.contains(j)) {
//
//                    }
//
//                }
//            }
//            list.add(set);
//        }
//        return list.size();
//        Set<Integer> set = new HashSet<>();
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//        for (int i = 0; i < points.length; i++) {
//            int[] point = points[i];
//            set.clear();
//            boolean flag = true;
//            for (int j = point[0]; j <= point[1]; j++) {
//                set.add(j);
//            }
//            for (Set<Integer> next : map.values()) {
//                Set<Integer> set1 = new HashSet<>(next);
//                Set<Integer> set2 = new HashSet<>(next);
//                if (!set2.addAll(set)) {
//                    flag = false;
//                }
//                if (set1.retainAll(set)) {
//                    if (set1.size() != 0) {
//                        flag = false;
//                        next.retainAll(set);
//                    }
//                }
//            }
//            if (flag) {
//                map.put(i, new HashSet<>(set));
//            }
//        }
//        return map.size();
    }
}
