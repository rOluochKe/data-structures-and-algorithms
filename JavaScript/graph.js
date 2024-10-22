function Graph(v) {
  this.vertices = v;
  this.edges = 0;
  this.adj = [];
  this.vertexList = []; // Initialize vertex list
  for (var i = 0; i < this.vertices; i++) {
    this.adj[i] = [];
  }
  this.addEdge = addEdge;
  this.showGraph = showGraph;
  this.dfs = dfs;
  this.marked = [];
  for (var i = 0; i < this.vertices; ++i) {
    this.marked[i] = false;
  }
  this.bfs = bfs;
  this.edgeTo = [];
  this.hasPathTo = hasPathTo;
  this.pathTo = pathTo;
  this.topSortHelper = topSortHelper;
  this.topSort = topSort;
}

function addEdge(v, w) {
  this.adj[v].push(w);
  this.adj[w].push(v);
  this.edges++;
}

function showGraph() {
  var visited = [];
  for (var i = 0; i < this.vertices; ++i) {
    console.log(this.vertexList[i] + " -> ");
    visited.push(this.vertexList[i]);
    for (var j = 0; j < this.adj[i].length; ++j) {
      // Iterate over adjacency list
      let neighbor = this.adj[i][j];
      if (visited.indexOf(this.vertexList[neighbor]) < 0) {
        console.log(this.vertexList[neighbor] + " ");
      }
    }
    console.log();
    visited.pop();
  }
}

function dfs(v) {
  this.marked[v] = true;
  console.log("Visited vertex: " + this.vertexList[v]);
  for (let w of this.adj[v]) {
    // Fix: Use `for-of` loop
    if (!this.marked[w]) {
      this.dfs(w);
    }
  }
}

function bfs(s) {
  var queue = [];
  this.marked[s] = true;
  queue.unshift(s);
  while (queue.length > 0) {
    var v = queue.shift();
    console.log("Visited vertex: " + this.vertexList[v]);
    for (let w of this.adj[v]) {
      // Fix: Use `for-of` loop
      if (!this.marked[w]) {
        this.edgeTo[w] = v;
        this.marked[w] = true;
        queue.unshift(w);
      }
    }
  }
}

function pathTo(v) {
  var source = 0;
  if (!this.hasPathTo(v)) {
    return undefined;
  }
  var path = [];
  for (var i = v; i !== source; i = this.edgeTo[i]) {
    path.push(i);
  }
  path.push(source);
  return path;
}

function hasPathTo(v) {
  return this.marked[v];
}

// Topology
function topSort() {
  var stack = [];
  var visited = [];
  for (var i = 0; i < this.vertices; i++) {
    visited[i] = false;
  }
  for (var i = 0; i < this.vertices; i++) {
    if (visited[i] == false) {
      this.topSortHelper(i, visited, stack);
    }
  }
  for (var i = 0; i < stack.length; i++) {
    if (stack[i] != undefined && stack[i] != false) {
      console.log(this.vertexList[stack[i]]);
    }
  }
}

function topSortHelper(v, visited, stack) {
  visited[v] = true;
  for (let w of this.adj[v]) {
    if (!visited[w]) {
      this.topSortHelper(w, visited, stack);
    }
  }
  stack.push(v);
}

// Test the graph
console.log("Load Graph");
var g = new Graph(5);
g.vertexList = ["A", "B", "C", "D", "E"]; // Initialize vertex names
g.addEdge(0, 1);
g.addEdge(0, 2);
g.addEdge(1, 3);
g.addEdge(2, 4);
g.showGraph();
g.bfs(0); // Perform BFS from vertex 0

var vertex = 4;
var paths = g.pathTo(vertex);
if (paths) {
  while (paths.length > 0) {
    if (paths.length > 1) {
      console.log(g.vertexList[paths.pop()] + "-");
    } else {
      console.log(g.vertexList[paths.pop()]);
    }
  }
} else {
  console.log("No path found to vertex " + g.vertexList[vertex]);
}

console.log();

console.log("Graph 2");
g = new Graph(6);
g.addEdge(1, 2);
g.addEdge(2, 5);
g.addEdge(1, 3);
g.addEdge(1, 4);
g.addEdge(0, 1);
g.vertexList = [
  "CS1",
  "CS2",
  "Data Structures",
  "Assembly Language",
  "Operating Systems",
  "Algorithms",
];
g.showGraph();
g.topSort();
