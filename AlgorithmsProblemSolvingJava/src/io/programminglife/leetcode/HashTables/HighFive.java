package io.programminglife.leetcode.HashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of scores of different students, return the average score of each student's top five scores
 * in the order of each student's id.
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.
 * The average score is calculated using integer division.
 *
 * Example 1:
 *
 * Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation:
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
 */
public class HighFive {

    public static int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> scoresMap = new HashMap<>();

        for(int i = 0; i < items.length; i++) {
            List<Integer> scores = new ArrayList<>();
            if(scoresMap.get(items[i][0]) != null) {
                scores = scoresMap.get(items[i][0]);
            }
            scores.add(items[i][1]);
            scoresMap.put(items[i][0], scores);
        }

        Arrays.sort(scoresMap.keySet().toArray(new Integer[0]));

        int k = 0;
        int[][] topFive = new int[scoresMap.keySet().size()][2];
        for(Integer key : scoresMap.keySet()) {
            Integer[] scoresForStudent = scoresMap.get(key).toArray(new Integer[0]);
            Arrays.sort(scoresForStudent);
            int sum = 0;
            for(int i = scoresForStudent.length - 1;  i >= scoresForStudent.length - 5; i--) {
                sum += scoresForStudent[i];
            }
            topFive[k][0] = key;
            topFive[k][1] = sum / 5;
            k++;
        }

        return topFive;
    }

    public static void main(String[] args) {
        int[][] scores = {{1,91}, {1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] topFive = highFive(scores);

        System.out.print("[");
        for(int i = 0; i < topFive.length; i++) {
            System.out.print("[");
            for(int j = 0; j < topFive[i].length; j++) {
                System.out.print(topFive[i][j] + ", ");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }

}
