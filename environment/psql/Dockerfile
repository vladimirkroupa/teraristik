#FROM timms/postgres-logging:11.1 to log all queries
FROM postgres:alpine
COPY psql_ddl.sql /docker-entrypoint-initdb.d/
