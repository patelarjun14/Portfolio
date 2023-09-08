#!/bin/sh


echo "We are cloning the class repo"

git clone https://github.ccs.neu.edu/CS5008SEASP2022EVENING/Course_Resources


# add git pull, this will update folder
git pull

echo "Folder is up to date"

echo -n "Would you like to add files for git? (y/n) "
read answer

if["$answer" = y];
	echo "Use control+C to end loop" 
	while[0=0];
		echo -n "What files would you like to add?"
		read file;
		git add "$file"
exit



