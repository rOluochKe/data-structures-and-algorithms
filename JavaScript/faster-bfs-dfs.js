// JavaScript program to determine which type of graph search is faster - breadth-first or depth-first

// Implementing breadth-first search
function breadthFirstSearch(graph, startNode, endNode) {
  let queue = [startNode];
  let visited = new Set();

  while (queue.length > 0) {
    let currentNode = queue.shift();
    if (currentNode === endNode) {
      return true; // endNode found
    }
    visited.add(currentNode);
    graph[currentNode].forEach((neighbor) => {
      if (!visited.has(neighbor)) {
        queue.push(neighbor);
      }
    });
  }

  return false; // endNode not found
}

// Implementing depth-first search
function depthFirstSearch(graph, currentNode, endNode, visited) {
  if (currentNode === endNode) {
    return true; // endNode found
  }

  visited.add(currentNode);
  for (let neighbor of graph[currentNode]) {
    if (!visited.has(neighbor)) {
      if (depthFirstSearch(graph, neighbor, endNode, visited)) {
        return true;
      }
    }
  }

  return false; // endNode not found
}

// Test data for the program
let graph = {
  A: ["B", "C"],
  B: ["D", "E"],
  C: ["F"],
  D: [],
  E: ["F"],
  F: [],
};
let startNode = "A";
let endNode = "F";

// Testing breadth-first search
let bfsStartTime = Date.now();
console.log(
  "Breadth-first search result: " +
    breadthFirstSearch(graph, startNode, endNode)
);
let bfsEndTime = Date.now();
let bfsTimeTaken = bfsEndTime - bfsStartTime;
console.log("Time taken for breadth-first search: " + bfsTimeTaken + "ms");

// Testing depth-first search
let dfsStartTime = Date.now();
console.log(
  "Depth-first search result: " +
    depthFirstSearch(graph, startNode, endNode, new Set())
);
let dfsEndTime = Date.now();
let dfsTimeTaken = dfsEndTime - dfsStartTime;
console.log("Time taken for depth-first search: " + dfsTimeTaken + "ms");
