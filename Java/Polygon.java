package Java;

interface Polygon {
  double area();

  double perimeter();
}

class Triangle implements Polygon {
  // Implement area() and perimeter() methods for Triangle
}

class Quadrilateral implements Polygon {
  // Implement area() and perimeter() methods for Quadrilateral
}

class Pentagon implements Polygon {
  // Implement area() and perimeter() methods for Pentagon
}

class Hexagon implements Polygon {
  // Implement area() and perimeter() methods for Hexagon
}

class Octagon implements Polygon {
  // Implement area() and perimeter() methods for Octagon
}

class IsoscelesTriangle extends Triangle {
  // Implement IsoscelesTriangle class
}

class EquilateralTriangle extends Triangle {
  // Implement EquilateralTriangle class
}

class Rectangle extends Quadrilateral {
  // Implement Rectangle class
}

class Square extends Rectangle {
  // Implement Square class
}

class UserInterface {
  public static void main(String[] args) {
    // Create polygons of different types, input dimensions, and output area and
    // perimeter
  }
}