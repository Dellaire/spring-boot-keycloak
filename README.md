# spring-boot-keycloak

This is just a sandbox for playing around with Keycloak via Spring Boot Security

## Set up Keycloak

* create realm "testrealm"
* create client "testclient"
* set redirect address of client
* make client confidential
* create user "testuser" with password "password"
* create role "testrole" and assign to user and realm (under "Composite Roles")

## Acquire Access Token

curl -X POST --header "Content-Type: application/x-www-form-urlencoded" --data-urlencode "grant_type=password" --data-urlencode "client_id=testclient" --data-urlencode "client_secret=<client_secret>" --data-urlencode "username=testuser" --data-urlencode "password=password" "http://localhost:8080/auth/realms/testrealm/protocol/openid-connect/token"

## Call protected API

curl -H "Authorization: Bearer <access_token>" "http://localhost:8081/protected"

## Other URLs

### Keycloak Public Key

http://localhost:8080/auth/realms/testrealm/protocol/openid-connect/certs

## Useful Information

* https://medium.com/devops-dudes/securing-spring-boot-rest-apis-with-keycloak-1d760b2004e
* https://stormpath.com/blog/where-to-store-your-jwts-cookies-vs-html5-web-storage