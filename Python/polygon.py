from abc import ABC, abstractmethod


class Polygon(ABC):
    @abstractmethod
    def area(self):
        pass

    @abstractmethod
    def perimeter(self):
        pass


class Triangle(Polygon):
    def __init__(self, side1, side2, side3):
        self.side1 = side1
        self.side2 = side2
        self.side3 = side3

    def perimeter(self):
        return self.side1 + self.side2 + self.side3

    def area(self):
        # Implement area calculation for a triangle (e.g., using Heron's formula)
        s = self.perimeter() / 2
        return (s * (s - self.side1) * (s - self.side2) * (s - self.side3)) ** 0.5


class Rectangle(Polygon):
    def __init__(self, length, width):
        self.length = length
        self.width = width

    def perimeter(self):
        return 2 * (self.length + self.width)

    def area(self):
        return self.length * self.width

# Implement other polygon classes: Quadrilateral, Pentagon, Hexagon, Octagon, IsoscelesTriangle, EquilateralTriangle, Square


# User input and polygon creation
triangle = Triangle(3, 4, 5)
rectangle = Rectangle(4, 6)

# Output area and perimeter of created polygons
print("Triangle - Area:", triangle.area(), "Perimeter:", triangle.perimeter())
print("Rectangle - Area:", rectangle.area(),
      "Perimeter:", rectangle.perimeter())
