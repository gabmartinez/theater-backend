#!/usr/bin/env bash

# Stoping if exist a container started
docker stop mysql-server || true

# Removing if exist a container started
docker rm mysql-server || true

# Launching a 5.7 version container created
docker run --name mysql-server --env-file=.docker/.mysql.env  -p 3306:3306 -d mysql/mysql-server:5.7