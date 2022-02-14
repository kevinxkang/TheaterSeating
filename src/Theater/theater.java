package Theater;

public class theater {
  static int[][] seating;
  private final int numRows;
  private final int numCols;

  public theater(int rows, int cols) {
    this.numRows = rows;
    this.numCols = cols;
    seating = new int[this.numRows][this.numCols];
  }

  public void populateSeats() {
    for (int i = 0; i < this.numRows; i++) {
      for (int j = 0; j < this.numCols; j++) {
        seating[i][j] = 0;
      }
    }
  }

  public int[][] getSeating() {
    return seating;
  }

  public int getNumRows() {
    return this.numRows;
  }

  public int getNumCols() {
    return this.numCols;
  }
}
