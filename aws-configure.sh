#!/bin/bash

mkdir -p ~/.aws
touch ~/.aws/credentials
touch  ~/.aws/config

chmod 600 ~/.aws/credentials
chmod 600 ~/.aws/config

aws configure set aws_access_key_id "fakeMyKeyId"
aws configure set aws_secret_access_key "fakeMyKeyId"
# aws configure set default_region_name "ap-southeast-1"
aws configure set default_output_format "json"
aws configure set region ap-southeast-1 --profile default
aws configure set profile default


aws configure list
