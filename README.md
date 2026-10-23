# First-Java-CRUD

Spring Boot + Vaadin CRUD application (Git/GitHub course assignment), based on the
[Spring guide "Creating CRUD UI with Vaadin"](https://spring.io/guides/gs/crud-with-vaadin/).

Customers can be listed, filtered by last name, added, edited and deleted. Data is stored in an
in-memory H2 database using Spring Data JPA.

## Run locally

```bash
./mvnw spring-boot:run
```

Then open http://localhost:8080 (on Windows use `.\mvnw spring-boot:run`).

## Documentation (`doc/`)

| Screenshot | Shows |
|---|---|
| [01-app-running.png](doc/01-app-running.png) | Application running locally |
| [02-crud-create.png](doc/02-crud-create.png) | Creating a new customer |
| [03-crud-update-delete.png](doc/03-crud-update-delete.png) | Editing and deleting a customer |
| [04-startup-logs.png](doc/04-startup-logs.png) | Startup logs ("Started CrudWithVaadinApplication") |
| [05-commit-history.png](doc/05-commit-history.png) | Commit history with my commits and my partner's merged pull request |
