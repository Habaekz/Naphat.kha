
# Docker Compose with External Volumes for SonarQube and PostgreSQL

To ensure that your SonarQube and PostgreSQL data persist across container restarts, switch from using Docker-managed volumes (internal) to **external volumes**. External volumes are explicitly managed by Docker and are not automatically removed when containers are deleted, helping ensure data persistence.

## Step 1: Modify the `docker-compose.yml`

Here is the updated `docker-compose.yml` to use external volumes:

```yaml
version: '3'

services:
  postgres:
    image: postgres:9.6
    environment:
      POSTGRES_USER: sonar
      POSTGRES_PASSWORD: sonarpasswd
    volumes:
      - postgres_data:/var/lib/postgresql/data  # Use external volume

  sonarqube:
    image: sonarqube:9.9.7-community
    container_name: sonarqube
    ports:
      - "9000:9000"
    environment:
      - SONARQUBE_JDBC_URL=jdbc:postgresql://postgres:5432/sonar
      - SONARQUBE_JDBC_USERNAME=admin
      - SONARQUBE_JDBC_PASSWORD=ad
    depends_on:
      - postgres
    volumes:
      - sonarqube_conf:/var/sonarqube/conf  # Use external volume
      - sonarqube_data:/var/sonarqube/data  # Use external volume
      - sonarqube_extensions:/var/sonarqube/extensions  # Use external volume
      - sonarqube_logs:/var/sonarqube/logs  # Use external volume
      - sonarqube_temp:/var/sonarqube/temp  # Use external volume

volumes:
  postgres_data:
    external: true
  sonarqube_conf:
    external: true
  sonarqube_data:
    external: true
  sonarqube_extensions:
    external: true
  sonarqube_logs:
    external: true
  sonarqube_temp:
    external: true
```

## Step 2: Create the External Volumes

Before running `docker-compose`, create the external volumes manually using the following commands:

```bash
docker volume create --name postgres_data
docker volume create --name sonarqube_conf
docker volume create --name sonarqube_data
docker volume create --name sonarqube_extensions
docker volume create --name sonarqube_logs
docker volume create --name sonarqube_temp
```

## Step 3: Run Docker Compose

Once the external volumes are created, bring up the stack using:

```bash
docker-compose up -d
```

## Explanation:

- **External Volumes**: By specifying `external: true`, Docker Compose will use pre-existing volumes and will not create or delete them automatically. This ensures that data is persistent beyond the lifecycle of the containers.
- **Data Persistence**: External volumes ensure that SonarQube and PostgreSQL data is not lost when containers are stopped, restarted, or recreated.

---

With this setup, your data will persist even when the containers are restarted or removed, preventing data loss.
