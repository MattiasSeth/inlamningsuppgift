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
