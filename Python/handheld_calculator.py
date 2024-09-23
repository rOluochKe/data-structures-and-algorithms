def handheld_calculator():
    result = 0

    while True:
        user_input = input(
            "Enter a number, operator (+, -, *, /), or 'C' to clear: ")

        if user_input == 'C':
            result = 0
        elif user_input in ['+', '-', '*', '/']:
            operator = user_input
            operand = float(input("Enter the operand: "))
            if operator == '+':
                result += operand
            elif operator == '-':
                result -= operand
            elif operator == '*':
                result *= operand
            elif operator == '/':
                result /= operand
        else:
            result = float(user_input)

        print(f"Screen: {result}")


handheld_calculator()
