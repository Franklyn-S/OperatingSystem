#!/bin/bash
DATA=`date +%Y-%m-%d-%H.%M`
ONEDAYAGO=`(date --date '1 day ago' --rfc-3339=seconds)`
SCRIPT_PATH="${PWD}"
tar -czP --newer-mtime="$ONEDAYAGO" --recursion -p --file=$DATA.tar $SCRIPT_PATH
echo "Done!"