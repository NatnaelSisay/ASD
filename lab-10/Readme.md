## Lab 10: Containerization

### Lessons

#### - Database connection

- `?createDatabaseIfNotExist=true` on connection string will prevent error on databse connection
- should use environment variable for database host value
- always include dialect for hibernate jpa even if it don't show error on dev

#### - Spring boot

- database connection in docker-compose use service name as host address
