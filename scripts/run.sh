#!/bin/bash

cd ..
docker network create transporte-network
docker build -t backend-api .
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db_gerenctransp_docker --network transporte-network -d mysql:latest
sleep 10
docker run --name backend-api --network transporte-network -p 8084:8084 backend-api
