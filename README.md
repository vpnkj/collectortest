# Collector Test Project

## Gradle build
```
gradle build
```
Gradle build with more logging
```
gradle build -info --rerun-tasks --console=plain
```

## Docker
#### Start Docker container in development mode
```
docker build -t collector:1.0 .
docker run -d -p 8888:8888 collector:1.0
```

#### See running Docker containers
```
docker ps
```

#### Kill Docker container
```
docker kill <Container NAME or ID>
```
