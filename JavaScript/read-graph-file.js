// JavaScript program to read a graph from a file

const fs = require("fs");

// Read the graph data from the file
fs.readFile("JavaScript/graph_data.json", "utf8", (err, data) => {
  if (err) {
    console.error("Error reading file:", err);
    return;
  }
  let graph = JSON.parse(data);
  console.log("Graph data read from file:");
  console.log(graph);

  // Test data - perform operations on the graph
  let startNode = "A";
  let endNode = "F";

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

  // Testing breadth-first search on the read graph
  let bfsResult = breadthFirstSearch(graph, startNode, endNode);
  console.log("Breadth-first search result on the read graph: " + bfsResult);
});
