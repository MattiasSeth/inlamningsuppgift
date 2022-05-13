# Version1
#awk '{if ($7-$6 > 999 && $11-$10 > 999) print $0}' ~/inlamningsuppgift/data/5000.txt |  wc -l  

#Version 2
awk '$7-$6 > 999 && $11-$10 > 999 {++c} END {print c}' ~/inlamningsuppgift/data/5000.txt