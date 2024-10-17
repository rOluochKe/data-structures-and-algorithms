function insertIfSmaller(list, element) {
  if (typeof element === "number") {
    let min = Math.min(...list);
    if (element < min) {
      list.push(element);
    }
  } else if (typeof element === "string") {
    let min = list.reduce((a, b) => (a < b ? a : b), "");
    if (element < min) {
      list.push(element);
    }
  }
  return list;
}

let numericList = [5, 10, 15];
let textList = ["kiwi", "orange", "pear"];

console.log(insertIfSmaller(numericList, 2)); // Output: [5, 10, 15, 2]
console.log(insertIfSmaller(textList, "apple")); // Output: ['kiwi', 'orange', 'pear', 'apple']
