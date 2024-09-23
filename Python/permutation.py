from itertools import permutations

# Define the characters
characters = ['c', 'a', 't', 'd', 'o', 'g']

# Get all permutations of the characters
perms = permutations(characters)

# Print all possible strings formed by using the characters exactly once
for perm in perms:
    print(''.join(perm))
