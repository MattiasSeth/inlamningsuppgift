sort -n < ~/inlamningsuppgift/data/int_temp.txt | uniq -c | awk '{print $1}'  | sort -n | uniq -c > degree_result.txt
