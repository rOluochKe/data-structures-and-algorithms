package Java;

import java.util.*;

public class RoutingTableBuilder {
  public static void main(String[] args) {
    Map<String, Map<String, String>> routingTables = new HashMap<>();

    // Input connectivity information for nodes
    String[] connectivityInfo = {
        "241.12.31.14 : 241.12.31.15 241.12.31.18 241.12.31.19",
        // Add more connectivity information as needed
    };

    // Build routing tables for each node
    for (String info : connectivityInfo) {
      String[] parts = info.split(" : ");
      String currentNode = parts[0];
      String[] connectedNodes = parts[1].split(" ");

      Map<String, String> routingTable = new HashMap<>();
      for (String node : connectedNodes) {
        String[] ipParts = node.split("\\.");
        int hopCount = calculateHopCount(currentNode, node);

        if (hopCount > 0) {
          routingTable.put(node,
              ipParts[0] + "." + ipParts[1] + "." + ipParts[2] + "." + (Integer.parseInt(ipParts[3]) + 1));
        }
      }

      routingTables.put(currentNode, routingTable);
    }

    // Output the routing tables
    for (Map.Entry<String, Map<String, String>> entry : routingTables.entrySet()) {
      System.out.println("Routing Table for Node " + entry.getKey() + ": ");
      for (Map.Entry<String, String> pair : entry.getValue().entrySet()) {
        System.out.println("(" + pair.getKey() + ", " + pair.getValue() + ")");
      }
    }
  }

  public static int calculateHopCount(String node1, String node2) {
    // Simple hop count calculation based on IP address
    return Math.abs(Integer.parseInt(node1.substring(node1.lastIndexOf(".") + 1))
        - Integer.parseInt(node2.substring(node2.lastIndexOf(".") + 1)));
  }
}