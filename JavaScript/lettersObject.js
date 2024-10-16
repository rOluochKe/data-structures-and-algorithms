// Create an object to store individual letters in an array and display them as a single word

const lettersObject = {
  letters: [],

  addLetter: function (letter) {
    this.letters.push(letter);
  },

  displayWord: function () {
    return this.letters.join("");
  },
};

// Example usage:
lettersObject.addLetter("H");
lettersObject.addLetter("e");
lettersObject.addLetter("l");
lettersObject.addLetter("l");
lettersObject.addLetter("o");

console.log("Word formed:", lettersObject.displayWord());
