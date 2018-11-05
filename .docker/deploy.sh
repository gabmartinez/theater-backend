#!/usr/bin/env bash

# Building the container using Dockerfile configuration
docker build --file=.docker/Dockerfile -t theater-service .

# Stoping if exist a container started
docker stop theater-service || true

# Launching a latest container created
docker run --rm --env-file=.docker/.env -d --name theater-service -p 5001:8080 theater-service:latest