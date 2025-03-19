FROM openjdk:21-jdk-slim
LABEL authors="pedro_panstein"

# Expor a porta configurada no Spring Boot (8096)
EXPOSE 8096

# Copiar o arquivo JAR para o diretório do container
COPY target/Gerenciamento-de-Transportes-0.0.1-SNAPSHOT.jar /app/geren-transp/geren-transp.jar

# Definir o diretório de trabalho
WORKDIR /app/geren-transp

# Definir o comando para rodar o JAR
ENTRYPOINT ["java", "-jar", "geren-transp.jar"]