class Person {
  constructor(name, gender) {
    this.name = name;
    this.gender = gender;
  }
}

let peopleList = [
  new Person("Alice", "female"),
  new Person("Bob", "male"),
  new Person("Charlie", "male"),
  new Person("Diana", "female"),
  new Person("Eve", "female"),
  new Person("Frank", "male"),
  new Person("Grace", "female"),
  new Person("Hank", "male"),
  new Person("Isabel", "female"),
  new Person("Jack", "male"),
];

function displayPeopleByGender(people, gender) {
  return people.filter((person) => person.gender === gender);
}

console.log(displayPeopleByGender(peopleList, "female"));
console.log(displayPeopleByGender(peopleList, "male"));
