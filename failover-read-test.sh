#!/bin/bash

# Simple script to send create requests to the localhost while a postgres failover test is running.

COUNTER=1
while [ $COUNTER -le 1000 ]
do
  echo "$COUNTER\n"
  ((COUNTER++))
  curl --header "Content-Type: application/json" --request GET http://localhost:8080/v1/dinner
  sleep 1
done
