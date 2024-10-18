const fs = require("fs");

class PhoneBook {
  constructor() {
    this.phoneNumbers = {};
  }

  loadFromFile(filename) {
    const data = fs.readFileSync(filename, "utf8");
    const entries = data.split("\n");
    entries.forEach((entry) => {
      const [name, phoneNumber] = entry.split(",");
      this.phoneNumbers[name.trim()] = phoneNumber.trim();
    });
  }

  displayPhoneNumber(name) {
    if (this.phoneNumbers[name]) {
      console.log(`${name}'s phone number: ${this.phoneNumbers[name]}`);
    } else {
      console.log(`Phone number for ${name} not found.`);
    }
  }

  displayAllPhoneNumbers() {
    Object.entries(this.phoneNumbers).forEach(([name, phoneNumber]) => {
      console.log(`${name}: ${phoneNumber}`);
    });
  }

  addPhoneNumber(name, phoneNumber) {
    this.phoneNumbers[name] = phoneNumber;
  }

  removePhoneNumber(name) {
    delete this.phoneNumbers[name];
  }

  clearPhoneNumbers() {
    this.phoneNumbers = {};
  }
}

// Test the PhoneBook class
const phoneBook = new PhoneBook();
phoneBook.loadFromFile("JavaScript/phonebook.txt");

// Test functionality
phoneBook.displayAllPhoneNumbers();
phoneBook.displayPhoneNumber("Alice");
phoneBook.addPhoneNumber("Bob", "123-456-7890");
phoneBook.removePhoneNumber("Alice");
phoneBook.clearPhoneNumbers();
