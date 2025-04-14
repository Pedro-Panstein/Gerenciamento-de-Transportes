#!/bin/bash

cd ..
docker network create transporte-network # aqui eu crio a network
docker build -t backend-api . # aqui eu faço o build desta minha api para uma imagem no docker
docker run --name mysql-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db_gerenctransp_docker --network transporte-network -d mysql:latest # aqui eu rodo a imagem do mysql
sleep 10 # aqui é um timer para a api roder somente depois do mysql carregar por completo
docker run --name backend-api --network transporte-network -p 8084:8084 backend-api # aqui eu rodo a minha api definindo tudo na mesma network

#Aqui eu tenho uma série de scripts para rodar o meu projeto no docker, conectando eles na mesma network
#A network já está criada neste computador então provavelmente nos logs irá aparecer que a network já existe, porém não tem nada conectado a ela