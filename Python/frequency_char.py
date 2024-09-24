import matplotlib.pyplot as plt
from collections import Counter

# Input the document
document = input('Enter the document: ')

# Count the frequencies of each alphabet character
counter = Counter(char for char in document if char.isalpha())

# Create the bar chart plot
plt.bar(counter.keys(), counter.values())
plt.xlabel('Alphabet Characters')
plt.ylabel('Frequency')
plt.title('Frequency of Alphabet characters in the Document')
plt.show()
