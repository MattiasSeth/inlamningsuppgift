Report:

1. The number of edges in G representing a sufficiently large overlap:

To find the edges I made a shell script with a awk command. I choose awk because I had some experience using this command earlier in the course and I remembered it to be very effective.
No other algorithms were considered. 

2. The node degree distribution of G as an informative histogram.

I made java program with hashcode which translates the vertices identifiers to integers. in the assignment we were recommended to this. I have never used hashcode or any other hashing algorithm before but I noticed a huge difference compared to using the original identifiers.

I stored the new identifiers in a text file which I read with a shell script. Like in assignment 1 I used the awk command. The shell scripted produces a text file with the degree and the amount o vertices of that degree. Lastly I made a java program to show the result.
No other algorithms were considered. 


3. The number of components of G with at least three vertices.

The program Graph.java reads a file with one integer per line. Each line represents a vertex. And each consecutive lines represent an edge. Meaning line 1 and 2 is an edge and line 3 and 4 is an edge and so on.

Creating the data structure

I tried and thought a lot of what kind of data structure to use: adjacency list or a matrix. I understood that the matrix would be too large and I also had more experience working with something similar to an adjacency list. After some trial and error, I choose the one described below.

Before the calculations starts the data structure has to be created. That is a process of several steps that I don’t’ describe here. The end result of this is a data structure:  ArrayList<LinkedList<Vertex>>.

The length of the ArrayList is the same as the number of unique nodes in the file.
All LinkedList’s in the ArrayList has a unique node at position zero, and the consecutive positions in that LinkedList contains the nodes that the node at position zero is directly connected to.

And all positions in the linked list’s is represented by a Vertex object containing the node identifier.
Computing the result
For several reasons I choose to use the Dept First Search (DFS(2) algorithm described in the lectures.
The DFS(2) consist of two methods in the program:
public ArrayList<Set<Integer>> dfs2() and a helper method: private Set<Integer> dfs_visit2(int v, boolean[] visited)

dfs2()
The method dfs2() keeps track of which unique node id that has been visited or not. It also keeps track of the set of identifiers in each component of G.

For each unique node id that has not visited dfs2() make a call to dfs_visit2 with parameters containing:

The index of the unvisited node id and the list containing information about which node IDs that has been visited or not. The visit2 method returns a set with all components.

First dfs_visit2 marks the incoming node id as visited. And creates two variables:
Set<Integer> r = new HashSet<Integer>();
Set<Integer> s = new HashSet<Integer>();
Then the incoming node identifier is added to s.
Then there are two nested for loops.
The outer For loop, loops over all neighbours.
The inner For loop, loops all Unique nodes skipping the ones that are marked as visited.
The inner For loop makes a recursive call saving with the result to r
Then then a union of r and s is return to dfs2().

Adjacency matrix, breath first search and dfs with a stack was considered in this assignment. I list because storage space and a choose dfs with a helper function mainly because it felt more comfortable for me to work with.


Skip below if you are not testing the code.
_________________________________________________________________________


Short info how to test the code:


There is 2 shell scripts and both reads files from “~/inlamningsuppgift/data/” this works for me but maybe not for you depending on operating systems. So you might have to change this in code for the script to work. I tried changing this to $filename so a command like “bash edge.sh filename.txt” would work but it always failed.
Same with the scanners in the java files, I will write down the lines in the java code here:
Graph.java line: 147-148.
IntNodeFile.java line: 11-15
Histogram.java line: 12-13
Histogram2.java line: 16-17



1.Number of edges with sufficient large overlap:
In unix go to ~/inlamningsuppgift/Unix and give the command: bash edge.sh
In files: 10000.txt, 25000.txt and spruce.m4 


2. The node degree distribution of G as an informative histogram:
Start by running IntNodeFile.java. This program is preset to read “25000.txt”.
Now in unix go to ~/inlamningsuppgift/Unix and give the command: bash degree.sh
Lastly run Histogram2.java to get the result in the console.

In files:
IntNodeFile.java: 10000.txt ,25000.txt , spruce.m4
Degree.sh: int_temp.txt
Histogram.java: degree_result.txt
Out files:
IntNodeFile.java: int_temp.txt
Degree.sh: degree_result.txt


3. The number of components of G with at least three vertices.
Run Graph.java to get result in the console.
In files:
Int_temp.txt , test1.txt , test2.txt
