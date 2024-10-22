// JavaScript program to determine the shortest path in a graph

class Graph {
  constructor() {
    this.nodes = [];
    this.edges = {};
  }

  addNode(node) {
    this.nodes.push(node);
    this.edges[node] = [];
  }

  addEdge(node1, node2, weight) {
    this.edges[node1].push({ node: node2, weight: weight });
    this.edges[node2].push({ node: node1, weight: weight });
  }

  findShortestPath(startNode, endNode) {
    let distances = {};
    let visited = {};
    let previous = {};
    let queue = [];
    let path = [];

    // Initialize distances
    this.nodes.forEach((node) => {
      distances[node] = node === startNode ? 0 : Infinity;
      visited[node] = false;
    });

    queue.push(startNode);

    while (queue.length > 0) {
      let currentNode = queue.shift();
      visited[currentNode] = true;

      this.edges[currentNode].forEach((neighbor) => {
        if (!visited[neighbor.node]) {
          let distance = distances[currentNode] + neighbor.weight;
          if (distance < distances[neighbor.node]) {
            distances[neighbor.node] = distance;
            previous[neighbor.node] = currentNode;
            queue.push(neighbor.node);
          }
        }
      });
    }

    // Reconstruct the path
    let current = endNode;
    while (current) {
      path.unshift(current);
      current = previous[current];
    }

    return { path, distance: distances[endNode] };
  }
}

// Create a map graph of the area where you live
let mapGraph = new Graph();
let locations = ["Home", "Park", "School", "Market", "Gym"];

locations.forEach((location) => {
  mapGraph.addNode(location);
});

mapGraph.addEdge("Home", "Park", 2);
mapGraph.addEdge("Park", "School", 3);
mapGraph.addEdge("Park", "Market", 1);
mapGraph.addEdge("School", "Market", 2);
mapGraph.addEdge("School", "Gym", 4);
mapGraph.addEdge("Market", "Gym", 2);

// Find the shortest path from Home to Gym
let startLocation = "Home";
let endLocation = "Gym";
let shortestPath = mapGraph.findShortestPath(startLocation, endLocation);
console.log(
  "Shortest path from " + startLocation + " to " + endLocation + ":",
  shortestPath
);

// Depth-first search implementation
function depthFirstSearch(graph, currentNode, endNode, visited, path) {
  visited[currentNode] = true;
  path.push(currentNode);

  if (currentNode === endNode) {
    return path;
  }

  for (let neighbor of graph.edges[currentNode]) {
    if (!visited[neighbor.node]) {
      let result = depthFirstSearch(
        graph,
        neighbor.node,
        endNode,
        visited,
        path
      );
      if (result) {
        return result;
      }
    }
  }

  path.pop();
  return null;
}

// Breadth-first search implementation
function breadthFirstSearch(graph, startNode, endNode) {
  let queue = [startNode];
  let visited = {};
  let path = [];

  while (queue.length > 0) {
    let currentNode = queue.shift();
    path.push(currentNode);

    if (currentNode === endNode) {
      return path;
    }

    visited[currentNode] = true;

    for (let neighbor of graph.edges[currentNode]) {
      if (!visited[neighbor.node] && !queue.includes(neighbor.node)) {
        queue.push(neighbor.node);
      }
    }
  }

  return null;
}

// Perform depth-first search
let startNode = "Home";
let endNode = "Gym";
let visitedDFS = {};
let pathDFS = [];
let dfsResult = depthFirstSearch(
  mapGraph,
  startNode,
  endNode,
  visitedDFS,
  pathDFS
);
console.log(
  "Depth-first search path from " + startNode + " to " + endNode + ":",
  dfsResult
);

// Perform breadth-first search
let bfsResult = breadthFirstSearch(mapGraph, startNode, endNode);
console.log(
  "Breadth-first search path from " + startNode + " to " + endNode + ":",
  bfsResult
);
