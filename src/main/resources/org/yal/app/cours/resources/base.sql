
DROP TABLE IF EXISTS adresse CASCADE;
DROP SEQUENCE IF EXISTS seq_adresse_id;
CREATE SEQUENCE seq_adresse_id;
CREATE TABLE adresse
(
    id bigint DEFAULT nextval('seq_adresse_id') NOT NULL,
    rue text,
    code_postal text,
    ville text,
    fk_client_id bigint,
    CONSTRAINT pk_adresse_id PRIMARY KEY (id),
    CONSTRAINT fk_client_id FOREIGN KEY (fk_client_id)
        REFERENCES public.client (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS client CASCADE;
DROP SEQUENCE IF EXISTS seq_client_id;
CREATE SEQUENCE seq_client_id;
CREATE TABLE client
(
    id bigint DEFAULT nextval('seq_adresse_id') NOT NULL,
    rue text,
    code_postal text,
    ville text,
    fk_client_id bigint,
    CONSTRAINT client_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS facture CASCADE;
DROP SEQUENCE IF EXISTS seq_facture_id;

CREATE SEQUENCE seq_facture_id;
CREATE TABLE facture
(
    id bigint DEFAULT nextval('seq_facture_id') NOT NULL,
    montant bigint NOT NULL,
    tva bigint NOT NULL,
    fk_client_id bigint,
    CONSTRAINT "pk_id_facture" PRIMARY KEY (id),
    CONSTRAINT fk_c_client_id FOREIGN KEY (fk_client_id)
        REFERENCES public.client (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

DROP TABLE IF EXISTS projet CASCADE;
DROP SEQUENCE IF EXISTS seq_projet_id;

CREATE SEQUENCE seq_projet_id;
CREATE TABLE projet
(
    id bigint DEFAULT nextval('seq_projet_id') NOT NULL,
    nom text,
    importance bigint,
    CONSTRAINT "pk_id_projet" PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tj_client_projet CASCADE;

CREATE TABLE tj_client_projet
(
    client_id bigint NOT NULL,
    projet_id bigint NOT NULL,
    nom text,
    importance bigint,
    CONSTRAINT "pk_tj_client_projet" PRIMARY KEY (client_id, projet_id),
    CONSTRAINT fk_tj_client_projet_client_id FOREIGN KEY (client_id) REFERENCES client (id),
    CONSTRAINT fk_tj_projet_projet_client_id FOREIGN KEY (projet_id) REFERENCES projet (id)
);
