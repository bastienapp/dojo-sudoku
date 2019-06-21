public class Sudoku {

    public static int[][] sudoku(int[][] puzzle) {

        int n = puzzle.length;
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                int value = puzzle[row][column];
                if (value == 0) {
                    String search = "123456789";
                    int x = row < 3 ? 0 : row < 6 ? 3 : 6;
                    int y = column < 3 ? 0 : column < 6 ? 3 : 6;
                    for (int i = x; i < x + 3; i++) {
                        for (int j = y; j < y + 3; j++) {
                            search = search.replace("" + puzzle[i][j], "");
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        search = search.replace("" + puzzle[row][i], "");
                    }
                    for (int i = 0; i < n; i++) {
                        search = search.replace("" + puzzle[i][column], "");
                    }
                    if (search.length() == 1) {
                        puzzle[row][column] = Integer.parseInt(search);
                        puzzle = sudoku(puzzle);
                    }
                }
            }
        }
        return puzzle;
    }
}
