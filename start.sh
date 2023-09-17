#!/bin/bash

clear
echo "starting docker for savings-dps"
docker-compose up -d
echo "waiting 5 seconds for docker to come online"
sleep 5
