````
  redmine:
    image: redmine:3.4.6-passenger
    restart: always
    expose:
      - 3000
    environment:
      - VIRTUAL_HOST=${REDMINE_HOST}
      - VIRTUAL_PORT=3000
      - LETSENCRYPT_HOST=${REDMINE_HOST}
      - LETSENCRYPT_EMAIL=${LETSENCRYPT_EMAIL}
      - REDMINE_DB_MYSQL=
      - REDMINE_DB_PASSWORD=
      - TZ="Asia/Bangkok"
    volumes:
      - ./data/redmine/plugins:/usr/src/redmine/plugins
      - ./data/redmine/themes:/usr/src/redmine/public/themes
      - ./data/redmine/files:/usr/src/redmine/files
      - ./data/redmine/config/configuration.yml:/usr/src/redmine/config/configuration.yml
      - ./data/redmine/config/locales/en.yml:/usr/src/redmine/config/locales/en.yml
````
