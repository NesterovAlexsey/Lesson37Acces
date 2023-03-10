package Task0Pawn;

public class Pawn {
  public enum Color {
    WHITE,
    BLACK,
  }

  private Color color;
  private int row;
  private int column;

  public Pawn(Color color, int row, int column) {
    this.color = color;

    checkCoordinates(row, column);
    this.row = row;
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public Color getColor() {
    return color;
  }

  public void setCoordinates(int row, int column) {
    checkCoordinates(row, column);
    checkPawnStep(row, column);
    this.row = row;
    this.column = column;
  }

  private void checkPawnStep(int row, int column) {
    if (Math.abs(row - getRow()) > 1) {
      throw new IllegalArgumentException(
          String.format("Некорректный ход для пешки: %d %d%n", row, column));
    }
    if (Math.abs(column - getColumn()) > 1) {
      throw new IllegalArgumentException(
          String.format("Некорректный ход для пешки: %d %d%n", row, column));
    }
    if (getColor() == Color.WHITE) {
      if (!(column > getColumn())) {
        throw new IllegalArgumentException(
            String.format("Некорректный ход для пешки: %d %d%n", row, column));
      }
    }
    if (getColor() == Color.BLACK) {
      if (column >= getColumn()) {
        throw new IllegalArgumentException(
            String.format("Некорректный ход для пешки: %d %d%n", row, column));
      }
    }
  }

  private static void checkCoordinates(int row, int column) {
    if (row < 1 || row > 8) {
      throw new IllegalArgumentException("Некорректный номер строки: " + row);
    }

    if (column < 1 || column > 8) {
      System.out.println("Некорректный номер столбца: " + column);
      throw new IllegalArgumentException();
    }
  }
}

