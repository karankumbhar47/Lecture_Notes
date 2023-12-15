#!/bin/bash

echo "$(sudo lsof -iTCP -sTCP:LISTEN | awk '{print $2}')"
