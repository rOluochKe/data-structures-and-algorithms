function Dictionary() {
  this.add = add;
  this.dataStore = new Array();
  this.find = find;
  this.remove = remove;
  this.showAll = showAll;
  this.count = count;
  this.clear = clear;
}

function add(key, value) {
  this.dataStore[key] = value;
}

function find(key) {
  return this.dataStore[key];
}

function remove(key) {
  delete this.dataStore[key];
}

function showAll() {
  Object.keys(this.dataStore)
    .sort()
    .forEach((key) => {
      console.log(key + " -> " + this.dataStore[key]);
    });
}

function count() {
  var n = 0;
  Object.keys(this.dataStore).forEach(() => {
    n++;
  });
  return n;
}

function clear() {
  Object.keys(this.dataStore).forEach((key) => {
    delete this.dataStore[key];
  });
}

var pbook = new Dictionary();
pbook.add("Mike", "123");
pbook.add("David", "345");
pbook.add("Cynthia", "456");
console.log("David's extension: " + pbook.find("David"));
pbook.remove("David");
pbook.showAll();

console.log();

var nums = new Array();
nums[0] = 1;
nums[1] = 2;
console.log(nums.length);

var pbook = new Array();
pbook["David"] = 1;
pbook["Jennifer"] = 2;
console.log(pbook.length);

console.log();

var pbook = new Dictionary();
pbook.add("Raymond", "123");
pbook.add("David", "345");
pbook.add("Cynthia", "456");
console.log("Number of entries: " + pbook.count());
console.log("David's extension: " + pbook.find("David"));
pbook.showAll();
pbook.clear();
console.log("Number of entries: " + pbook.count());

console.log();

var a = new Array();
a[0] = "Mike";
a[1] = "David";
console.log(a);
a.sort();
console.log(a);

console.log();

var pbook = new Dictionary();
pbook.add("Raymond", "123");
pbook.add("David", "345");
pbook.add("Cynthia", "456");
pbook.add("Mike", "723");
pbook.add("Jennifer", "987");
pbook.add("Danny", "012");
pbook.add("Jonathan", "666");
pbook.showAll();
