from sympy import symbols, diff

# input the polynomial in standard algebraic notation
polynomial_str = input('Enter the polynomial in standard algebraic notation: ')
x = symbols('x')
polynomial = eval(polynomial_str)

# calculate the first derivative
derivative = diff(polynomial, x)
print('The first derivative of the polynomial is: ', derivative)


# test example: x**2 + 3*x + 2
