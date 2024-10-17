function insertIfLarger(list, element) {
  if (typeof element === "number") {
    let max = Math.max(...list);
    if (element > max) {
      list.push(element);
    }
  } else if (typeof element === "string") {
    let max = list.reduce((a, b) => (a > b ? a : b), "");
    if (element > max) {
      list.push(element);
    }
  }
  return list;
}

let numericList = [3, 6, 9];
let textList = ["apple", "banana", "cherry"];

console.log(insertIfLarger(numericList, 12)); // Output: [3, 6, 9, 12]
console.log(insertIfLarger(textList, "kiwi")); // Output: ['apple', 'banana', 'cherry', 'kiwi']
