package getedge;

import graph.Edge;
import graph.Graph;
import graph.Node;

import java.util.List;

public class GetEdge {

    //Static method that takes in a string array of cities to visit and that represents connections between cities
    //Will search the graph to see if a trip to the given cities is possible with direct routes.
    //The return is an int representing the total cost of flights for the trip, or 0 if the trip is not possible with direct routes.
    public static int getEdge(String[] cities, Graph g) {

        //Variables to track which city we are going from and current cost
        Node start = null;
        int cost = 0;

        //Find the node in the graph that should be the start of our trip
        for (Node city : (List<Node>) g.getNodes()) {
            if (city.value == cities[0]) {
                start = city;
            }
        }
        //If we don't find the first city to start from, the trip is already impossible
        if (start == null) {
            return cost;
        }

        //Begin searching the given cities neighbors to see if there is an edge to the next city in the array.
        for (int i = 1; i < cities.length; i++) {
            for (Edge e : (List<Edge>) start.neighbors) {
                //If an edge is there, mover to that city and add the cost onto the running total
                if (e.neighbor.value == cities[i]) {
                    start = e.neighbor;
                    cost += e.weight;
                    break;
                }
            }
            //Check to make sure we found an edge, if we didn't we need to exit the method as the trip is not possible.
            if (start.value != cities[i]) {
                return 0;
            }
        }

        return cost;
    }
}
