To run project: `./mvnw spring-boot:run`

To run query: POST to `localhost:8080/graphql` with body
```
{
    teamByName(name: "Yankees") {
        id
        name
        players {
            firstName
            lastName
            position
            number
        }
    }
}
```
