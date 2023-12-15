#!/bin/bash

# taking first argument (path to file)
filePath=$1

echo "$(echo "$(cat $filePath)" | grep "\$100")"


