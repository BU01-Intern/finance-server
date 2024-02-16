# Finance
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2FBU01-Intern%2Ffinance-server.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2FBU01-Intern%2Ffinance-server?ref=badge_shield)


## Setup demo database with docker

```bash
docker run -d --name=mariadb -p 8306:3306 -e MARIADB_ROOT_PASSWORD=123456 -e MARIADB_DATABASE=finance-demo mariadb/server
```

## Start server with Maven

Make sure `mvn` is availible in your PATH, then run the following commands:

```bash
mvn install
mvn spring-boot:run -pl application
```


## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2FBU01-Intern%2Ffinance-server.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2FBU01-Intern%2Ffinance-server?ref=badge_large)