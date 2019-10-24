#!/bin/bash
DATA=`date +%Y-%m-%d-%H.%M`
ONEDAYAGO=`(date --date '1 day ago' --rfc-3339=seconds)`
DIR_RELATIVO="${0%/*}"
DIR_CHAMADA="${PWD}"
SCRIPT_PATH=$DIR_CHAMADA/$DIR_RELATIVO
#find $SCRIPT_PATH -mtime -1
tar -czP --newer-mtime="$ONEDAYAGO" --recursion -p --file=$DATA.tar $DIR_CHAMADA
echo "Done!"