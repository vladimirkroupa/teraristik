CREATE SCHEMA terra_test;
CREATE ROLE terra_testuser WITH LOGIN PASSWORD 'terra_testuser';
GRANT ALL PRIVILEGES ON SCHEMA terra_test TO terra_testuser;

CREATE SCHEMA terra;
CREATE ROLE terra_user WITH LOGIN PASSWORD 'terra_user';
GRANT ALL PRIVILEGES ON SCHEMA terra TO terra_user;
