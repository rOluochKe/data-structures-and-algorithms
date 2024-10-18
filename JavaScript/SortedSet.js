function SortedSet() {
  this.dataStore = [];
  this.add = add;
  this.remove = remove;
  this.size = size;
  this.show = show;
}

function add(data) {
  if (!this.dataStore.includes(data)) {
    this.dataStore.push(data);
    this.dataStore.sort((a, b) => a - b); // Sort the dataStore after adding
    return true;
  } else {
    return false;
  }
}

function remove(data) {
  var pos = this.dataStore.indexOf(data);
  if (pos > -1) {
    this.dataStore.splice(pos, 1);
    return true;
  } else {
    return false;
  }
}

function size() {
  return this.dataStore.length;
}

function show() {
  return this.dataStore;
}

// Test program
var sortedSet = new SortedSet();
sortedSet.add(5);
sortedSet.add(2);
sortedSet.add(8);
sortedSet.add(3);
sortedSet.add(5); // Trying to add a duplicate
sortedSet.add(1);

console.log("Sorted Set Elements:", sortedSet.show());
