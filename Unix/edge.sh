#Version 2
echo "Edges:"
awk '$7-$6 > 999 && $11-$10 > 999 {++c} END {print c}' ~/inlamningsuppgift/data/spruce.m4