DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = '${username}') THEN
      CREATE USER ${username} WITH password '${password}';
END IF;
END
$$;

CREATE SCHEMA IF NOT EXISTS dinnertime;

GRANT USAGE ON SCHEMA dinnertime TO ${username};
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL tables IN SCHEMA dinnertime TO ${username};
ALTER DEFAULT PRIVILEGES IN SCHEMA dinnertime GRANT SELECT, INSERT, UPDATE, DELETE ON tables TO ${username};
ALTER DEFAULT PRIVILEGES IN SCHEMA dinnertime GRANT SELECT, USAGE ON SEQUENCES TO ${username};
