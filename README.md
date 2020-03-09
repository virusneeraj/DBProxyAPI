# DBProxyAPI
curl -X POST "http://localhost:8085/sql/mysql/select" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"query\": \"select * from user\"}"

{
  "query": "select * from user"
}
