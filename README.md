# spring-boot-keycloak

curl -X POST -H "Content-Type: application/json" -d "{\"client_id\": \"testclient\", \"username\": \"testuser\", \"password\": \"password\", \"grant_type\": \"password\"}" "http://localhost:8080/auth/realms/master/protocol/openid-connect/token"