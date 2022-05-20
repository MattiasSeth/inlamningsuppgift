2022-05-10:  
Read through the assignment and wrote down some notes, also took a quick glance at the problem background and cliques links.
Made an assignment repository on GitHub and downloaded GitHub Desktop on my laptop so I can use both my computers if I want to. 
Downloaded the datafile and created a couple smaller test files with 1000-50000 lines. Looked at the assignment again and decided I will start with edges problem tomorrow.

2022-05-11:
Made a shell script to look how many overlaps were below 1000 in the test files. All my test files gave the same result so I decided to make some larger test files. I ran some more test and noticed that the original file gave the same result as a file one sixth it size.

2022-05-12: 
Continued with the shell script, had some minor problems with the test files and lack of knowledge on shell commands. I got the script to count the numbers of edges with a sufficiently large overlap in the test files but not on the original file. Decided not bother with the larger file now and instead look at the node degree distribution problem.

2022-05-13: 
Noticed that the first shell script (egde.sh) actually did work on the larger file, I must have done something wrong first time I tested it.
Made a shell script (degree.sh) for the degree distribution problem which produces a txt file in this format, “amount” “degree”:
210 1
130 2
140 3
And so on. After that I made a java program which reads the file and returns the Degree, Amount and the Degree distribution. This solution seems to be working on smaller files but not on larger ones, or maybe it does but takes a lot longer. I tested degree.sh on the 7GB file and nothing happened for 30mins.
I think I will return to this problem later and start looking at the number of components of G with at least three vertices instead.

2022-05-14 to 2022-05-15:
I don’t work on the project during the weekend, but I did watch a couple of the recorded videos on hash functions and graphs/DFS.

2022-05-16:
After watching the recorded material I decided to make a hashing program in java to store the vertex identifiers as integers instead of strings.
I made “IntNodeFile.java” which reads the file and implements hashing through hashcode on the vertex identifiers. The program writes the result to a file which I later can read with “degree.sh” to find the degree distribution. I had to make some changes in degree.sh for it to work.
This solution was way faster than the older one. I reused the timing code from Lab-5 on “IntNodeFile.java” and the result was 262000 ms (2.7min) and “degree.sh” is similar. 

2022-05-17
Started with the three vertices problem. Made an adjacency list program in java and tested it with some inputs. Then I read in some lines from the test files and my plan was to make some graphs, but I got nowhere.

2022-05-18:
Added 2 functions to the Graph class, one to get the size of the adjacencylist and one to get the Vertex identifier. After that I remade how I store the vertex identifier from the test files, I now store identifier 1 in one arraylist and identifier 2 in another arraylist.
Now I have to iterate through the id-arrays, connect edges and make the graph. I thought this part would be easier because we had a similar assignment in DA2004 called train, where you read a file with trains stations and made trainlines.  

2022-05-19:
Decided to store the whole graph in a adjacencylist instead of storing all smaller graphs in a lot of adjacencylists because I got nowhere trying to figure out how to do it. So now I have one big adjacencylist with all the vertices and all the edges. 
What’s left is finding the number of components of G with at least three vertices and the cliques.
