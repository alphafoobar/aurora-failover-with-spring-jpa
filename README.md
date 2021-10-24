# AWS Aurora failover example 

## Quick start

To run locally, you need two instances of postgresql. The flyway script is configured to load 
some sample data into the WRITER instance. 

Start a WRITER instance on port 5432:

```shell
docker run -e POSTGRES_PASSWORD=password -p 5432:5432 postgres
```

Start a READER instance on port 5433:

```shell
docker run -e POSTGRES_PASSWORD=password -p 5433:5432 postgres
```

The start the spring application by starting the DemoApplication class from the IDE. This will write the sample data 
using flyway. Then edit the `application.yml` to switch the reader and writer ports. And restart the spring application.

You'll then have sample data in the reader instance and a working writer instance.

## Try get

[http://localhost:8080/v1/dinner](http://localhost:8080/v1/dinner)

## Try POST

```shell
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"title":"test meal","description":"something to eat"}' \
  http://localhost:8080/v1/dinner
```
