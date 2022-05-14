awk '{print $1"\n"$2}' ~/inlamningsuppgift/data/5000.txt | sort  | uniq -c | awk '{print $1}'  | sort -n | uniq -c > temp.txt
