// JavaScript program to store a graph in a file

const fs = require("fs");

// Graph data to be stored
let graph = {
  A: ["B", "C"],
  B: ["D", "E"],
  C: ["F"],
  D: [],
  E: ["F"],
  F: [],
};

// Convert graph object to JSON string
let graphString = JSON.stringify(graph);

// Write the graph data to a file
fs.writeFile("JavaScript/graph_data.json", graphString, "utf8", (err) => {
  if (err) {
    console.error("Error writing to file:", err);
    return;
  }
  console.log("Graph data has been stored in JavaScript/graph_data.json");
});

// Read the graph data from the file
fs.readFile("JavaScript/graph_data.json", "utf8", (err, data) => {
  if (err) {
    console.error("Error reading file:", err);
    return;
  }
  let graphFromFile = JSON.parse(data);
  console.log("Graph data read from file:");
  console.log(graphFromFile);
});
