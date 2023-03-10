package Task0Pawn;

// класс "Пешка"
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

  public void setCoordinates(int row, int column, Color color) {
    checkCoordinates(row, column);
    checkPawnStep(row, column, color);
    this.row = row;
    this.column = column;
    checkCoordinates(row, column);

    // TODO проверка возможности хода
  }

  private void checkPawnStep(int row, int column, Color color) {
    if (Math.abs(row - getRow()) > 1) {
      throw new IllegalArgumentException("Некорректный новый ход для пешки: " + row);
    }
    if (Math.abs(column - getColumn()) > 1) {
      throw new IllegalArgumentException("Некорректный новый ход для пешки: " + column);
    }
    if ((color == Color.WHITE) && (getColumn() > column)) {
      throw new IllegalArgumentException("Некорректный новый ход для пешки: " + color + column);
    }
    if ((color == Color.BLACK) && (getColumn() < column)) {
      throw new IllegalArgumentException("Некорректный новый ход для пешки: " + color + column);
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

