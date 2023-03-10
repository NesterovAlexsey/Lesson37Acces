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