CREATE TABLE IF NOT EXISTS dinnertime.meal
(
    id            uuid NOT NULL,
    title         TEXT NOT NULL,
    description   TEXT NOT NULL,
    created       TIMESTAMP WITH TIME ZONE DEFAULT now(),
    PRIMARY KEY(id)
    );
