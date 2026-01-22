CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE provider(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(20),
    cpf VARCHAR(11),
    description VARCHAR(200)
)