def calculator():
    result = 0
    operator = ''
    operand = 0

    while True:
        user_input = input("Enter a number or operator (+, -, *, /, =): ")

        if user_input in ['+', '-', '*', '/']:
            operator = user_input
        elif user_input == '=':
            if operator == '+':
                result += operand
            elif operator == '-':
                result -= operand
            elif operator == '*':
                result *= operand
            elif operator == '/':
                result /= operand
            print(f"Result: {result}")
            break
        else:
            operand = float(user_input)


calculator()
