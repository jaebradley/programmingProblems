#!/bin/bash

echo "Running Maven clean package for errors"
# running maven clean test
mvn clean package
if [ $? -ne 0 ]; then
  "Error while running mvn clean package"
  # go back to current working dir
  cd $CWD
  exit 1
fi
# go back to current working dir
cd $CWD
exit 0