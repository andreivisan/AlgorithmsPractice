package io.programminglife.youtube;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    private static List<Integer> result;

    public static List<Integer> spiralOrder(int[][] array) {
        result = new ArrayList<>();
        spiralHelper(array, 0, array.length - 1, 0, array[0].length - 1);
        return result;
    }

    private static void spiralHelper(int[][] array, int startRow, int endRow, int startColumn, int endColumn) {
        if (startRow > endRow || startColumn > endColumn) {
            return;
        }

        for (int column = startColumn; column <= endColumn; column++) {
            result.add(array[startRow][column]);
        }

        for (int row = startRow + 1; row <= endRow; row++) {
            result.add(array[row][endColumn]);
        }

        for (int column = endColumn - 1; column >= startColumn; column--) {
            if (startRow == endRow) {
                break;
            }
            result.add(array[endRow][column]);
        }

        for (int row = endRow - 1; row >= startRow + 1; row--) {
            if (startColumn == endColumn) {
                break;
            }
            result.add(array[row][startColumn]);
        }

        spiralHelper(array, startRow + 1, endRow - 1, startColumn + 1, endColumn - 1);
    }

    public static void main(String[] args) {
        int[][] array = { { 1, 2, 3, 4 }, { 12, 13, 14, 5 }, { 11, 16, 15, 6 }, { 10, 9, 8, 7 } };

        spiralOrder(array);
    }
}
