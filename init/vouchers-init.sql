CREATE TYPE status AS ENUM ('AVAILABLE', 'ALLOCATED', 'REDEEMED', 'EXPIRED', 'CANCELLED');

CREATE TABLE vouchers (
    id UUID PRIMARY KEY,
    supplier VARCHAR(255) NOT NULL,
    certification_id UUID NOT NULL,
    value NUMERIC(10, 2) NOT NULL,
    expiration_date DATE NOT NULL,
    rules TEXT[] NOT NULL,
    status status NOT NULL
);