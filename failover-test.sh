#!/bin/bash

# Simple script to send create requests to the localhost while a postgres failover test is running.

COUNTER=1
while [ $COUNTER -le 1000 ]
do
  echo "$COUNTER\n"
  ((COUNTER++))
  curl --header "Content-Type: application/json"   --request POST   --data "{\"title\":\"test with ttl of 5 with aws postgres jdbc in a loop ${COUNTER}\",\"description\":\"something to eat - ${COUNTER}\"}"   http://localhost:8080/v1/dinner
  sleep 1
done
