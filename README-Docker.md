# Docker Deployment Guide

## Prerequisites
- Docker
- Docker Compose

## Quick Start

### 1. Build and Run with Docker Compose
```bash
# Build and start all services
docker-compose up --build

# Run in background
docker-compose up -d --build
```

### 2. Access the Application
- **Spring Boot App**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **MySQL Database**: localhost:3306

### 3. Database Credentials
- **Database**: huynhgiafarm
- **Username**: huynhgia
- **Password**: huynhgia123
- **Root Password**: admin

## Docker Commands

### Build the application
```bash
docker build -t huynhgia-app .
```

### Run only the application (requires MySQL)
```bash
docker run -p 8080:8080 --network huynhgia-be_huynhgia-network huynhgia-app
```

### Run only MySQL
```bash
docker run -d \
  --name huynhgia-mysql \
  -e MYSQL_ROOT_PASSWORD=admin \
  -e MYSQL_DATABASE=huynhgiafarm \
  -e MYSQL_USER=huynhgia \
  -e MYSQL_PASSWORD=huynhgia123 \
  -p 3306:3306 \
  mysql:8.0
```

### Stop all services
```bash
docker-compose down
```

### Stop and remove volumes
```bash
docker-compose down -v
```

### View logs
```bash
# All services
docker-compose logs

# Specific service
docker-compose logs app
docker-compose logs mysql
```

## Environment Variables

### Application Environment Variables
- `SPRING_DATASOURCE_URL`: Database connection URL
- `SPRING_DATASOURCE_USERNAME`: Database username
- `SPRING_DATASOURCE_PASSWORD`: Database password
- `SPRING_JPA_HIBERNATE_DDL_AUTO`: Hibernate DDL mode
- `SPRING_PROFILES_ACTIVE`: Active Spring profile

### MySQL Environment Variables
- `MYSQL_ROOT_PASSWORD`: Root password
- `MYSQL_DATABASE`: Database name
- `MYSQL_USER`: Database user
- `MYSQL_PASSWORD`: Database password

## Volumes
- `mysql_data`: Persistent MySQL data storage

## Networks
- `huynhgia-network`: Internal network for service communication

## Troubleshooting

### Application won't start
1. Check if MySQL is running: `docker-compose logs mysql`
2. Verify database connection: `docker-compose exec mysql mysql -u huynhgia -p`
3. Check application logs: `docker-compose logs app`

### Database connection issues
1. Ensure MySQL container is healthy
2. Check network connectivity: `docker network ls`
3. Verify environment variables in docker-compose.yml

### Port conflicts
- Change ports in docker-compose.yml if 8080 or 3306 are already in use 