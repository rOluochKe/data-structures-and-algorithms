def count_divisions(n):
    count = 0
    while n >= 2:
        n /= 2
        count += 1
    return count


# Take input from the user
num = int(input('Enter a positive integer greater than 2: '))

# Calculate the number of times to divide by 2
result = count_divisions(num)

print(
    f'Number of times to divide {num} by 2 before getting a value less than 2: {result}')
