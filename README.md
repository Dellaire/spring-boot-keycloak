# spring-boot-keycloak

curl "http://localhost:8081/unprotected"

## Obtain Token

curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=client_credentials&client_id=testclient&client_secret=1a3eb814-5128-4834-9cde-c5c87e016488&username=testuser&password=password" "http://localhost:8080/auth/realms/testrealm/protocol/openid-connect/token"

curl -X POST http://localhost:8080/auth/realms/testrealm/protocol/openid-connect/auth?response_type=code&client_id=testclient&redirect_uri=http://localhost:8081/protected&state=7d517c3c-216c-4e06-988e-c5f799c19889&login=true&scope=openid

## Authenticate

curl -H "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJlOTcyNGFiZS04MGZlLTRmMzUtYjIwMC0xNGY2NmYzZWRjNGIifQ.eyJleHAiOjE1OTg0MDExNzEsImlhdCI6MTU5ODM2NTE3MSwianRpIjoiZDBlYTY3NzctM2RhYS00MTg1LTg2Y2YtZWQ3MTA4ODgyNDc0IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL3Rlc3RyZWFsbSIsInN1YiI6IjI1YzI3NzE3LTc1NzUtNDUwYi04YmQxLWZjODgzN2ZkNjQ2NiIsInR5cCI6IlNlcmlhbGl6ZWQtSUQiLCJzZXNzaW9uX3N0YXRlIjoiMDhlOThiMDYtYjBhZC00YzQyLThmYjAtZGRlYTUxY2I0ZTRmIiwic3RhdGVfY2hlY2tlciI6InVBbjlDRzluaXpfbmV1NmJ5bzl5Z1JQRXdubTZaam9HOFZ0MTZ4Z0FZTGMifQ.eQFzGCav2XOTqpNJ6zqb_cN5pG4E6RLYCW5SQE_JPP0" "http://localhost:8081/protected"

curl -H "Cookie: JSESSIONID=2133EED3BC2FBC46471E8A355C0EE2DD" "http://localhost:8081/protected"

## Further Information

https://blog.codecentric.de/2017/09/keycloak-und-spring-security-teil-2-integration-von-keycloak-in-spring-security/