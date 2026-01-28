CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE cost(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    providedservice_id UUID REFERENCES providedservice(id),
    description VARCHAR(200) NOT NULL,
    amount DECIMAL NOT NULL
)