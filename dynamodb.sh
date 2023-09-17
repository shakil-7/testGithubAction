aws dynamodb --endpoint-url http://localhost:4566 create-table --table-name dev-savings-account --attribute-definitions AttributeName=walletId,AttributeType=S AttributeName=savingsId,AttributeType=S AttributeName=fiAccountNo,AttributeType=S AttributeName=fiAccountId,AttributeType=S --key-schema AttributeName=walletId,KeyType=HASH AttributeName=savingsId,KeyType=RANGE --provisioned-throughput ReadCapacityUnits=500,WriteCapacityUnits=500\
  --local-secondary-indexes \
  "[
    {\"IndexName\": \"lsi-fiAccountNo\",\"KeySchema\":[{\"AttributeName\":\"walletId\",\"KeyType\":\"HASH\"}, {\"AttributeName\":\"fiAccountNo\",\"KeyType\":\"RANGE\"}], \"Projection\":{\"ProjectionType\":\"ALL\"}},
    {\"IndexName\": \"lsi-fiAccountId\",\"KeySchema\":[{\"AttributeName\":\"walletId\",\"KeyType\":\"HASH\"}, {\"AttributeName\":\"fiAccountId\",\"KeyType\":\"RANGE\"}], \"Projection\":{\"ProjectionType\":\"ALL\"}}
  ]"
