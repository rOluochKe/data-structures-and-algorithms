import random


class Bear:
    def __init__(self):
        self.type = "Bear"

    def move(self):

        return random.choice([-1, 0, 1])


class Fish:
    def __init__(self):
        self.type = "Fish"

    def move(self):
        return random.choice([-1, 0, 1])


# Create the river ecosystem
river_size = 10
river = [None] * river_size

# Initialize the river with a few bears and fish
for _ in range(3):
    index = random.randint(0, river_size - 1)
    river[index] = Bear()

for _ in range(3):
    index = random.randint(0, river_size - 1)
    river[index] = Fish()

# Simulation
for _ in range(10):  # Number of time steps
    for i in range(len(river)):
        if isinstance(river[i], Bear) or isinstance(river[i], Fish):
            move = river[i].move()
            new_index = i + move
            if 0 <= new_index < river_size:
                if river[new_index] is None:
                    river[new_index] = river[i]
                    river[i] = None
                elif river[new_index].type == river[i].type:
                    # Randomly decide which one creates a new instance
                    if random.choice([True, False]):
                        river[i] = river[new_index]
                    else:
                        river[new_index] = river[i]
                else:
                    if isinstance(river[i], Fish):
                        river[i] = None

# Display the final state of the river
for i, animal in enumerate(river):
    if animal is None:
        print(f"Position {i}: None")
    else:
        print(f"Position {i}: {animal.type}")
