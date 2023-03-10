//Задача 1
//Создайте по аналогии с пешкой класс Ладья (Rook), в который добавьте все необходимые методы.

package Task1Rook;

public class Rook {
  public enum Color {
    WHITE,
    BLACK,
  }

  private Color color;

  private int row;

  private int column;

  public Rook(Color color, int row, int column) {
    this.color = color;

    checkCoordinates(row, column);
    this.row = row;
    this.column = column;
  }

  public int getRow(){
    return row;
  }
  public int getColumn(){
    return column;
  }

  public void setCoordinates(int row, int column) {
    checkCoordinates(row, column);
    checkRookStep(row, column);
    this.row = row;
    this.column = column;
  }

  private void checkRookStep(int row, int column) {
    if (!(row == getRow()) && !(column == getColumn())) {
      throw new IllegalArgumentException(
          String.format("Некорректный ход для Ладьи: %d %d%n", row, column));
    }
    if (row == getRow() && column == getColumn()) {
      throw new IllegalArgumentException(
          String.format("Фигура не может оставаться на том же месте: %d %d%n", row, column));
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