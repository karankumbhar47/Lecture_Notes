#!/bin/bash

# execute after every 10 minute
while true
do
    echo -e "\n======================================\n" 
    # execute the script here
    bash /home/karan09/12140860_Karan_Kumbhar/question1.sh $1 
    echo -e "\n======================================\n"

    # sleep for 10 minutes
    sleep 600
done

