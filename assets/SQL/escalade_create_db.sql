
CREATE SEQUENCE public.membre_id_seq;

CREATE TABLE public.Membre (
                id INTEGER NOT NULL DEFAULT nextval('public.membre_id_seq'),
                pseudo VARCHAR(250) NOT NULL,
                password VARCHAR(250) NOT NULL,
                email VARCHAR(250) NOT NULL,
                compte_valide BOOLEAN DEFAULT false NOT NULL,
                CONSTRAINT membre_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.membre_id_seq OWNED BY public.Membre.id;

CREATE SEQUENCE public.site_id_seq;

CREATE TABLE public.Site (
                id INTEGER NOT NULL DEFAULT nextval('public.site_id_seq'),
                nom VARCHAR(250) NOT NULL,
                presentation VARCHAR(1000) NOT NULL,
                localite VARCHAR(250) NOT NULL,
                code_postal VARCHAR(50) NOT NULL,
                hauteur_min INTEGER,
                hauteur_max INTEGER,
                image VARCHAR(250),
                CONSTRAINT site_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.site_id_seq OWNED BY public.Site.id;

CREATE TABLE public.Topo (
                id INTEGER NOT NULL,
                libelle VARCHAR(250) NOT NULL,
                information VARCHAR(1000) NOT NULL,
                autoriser_location BOOLEAN DEFAULT true NOT NULL,
                site_id INTEGER NOT NULL,
                membre_id INTEGER NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (id)
);


CREATE TABLE public.Location (
                membre_id INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                libre BOOLEAN DEFAULT true NOT NULL,
                debut_location DATE NOT NULL,
                fin_location DATE NOT NULL,
                CONSTRAINT location_pk PRIMARY KEY (membre_id, topo_id)
);


CREATE TABLE public.Secteur (
                id INTEGER NOT NULL,
                nom VARCHAR(250) NOT NULL,
                hauteur INTEGER,
                site_id INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (id)
);


CREATE TABLE public.Voie (
                id INTEGER NOT NULL,
                nom VARCHAR(250) NOT NULL,
                cotation VARCHAR(100),
                secteur_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (id)
);


CREATE TABLE public.Commentaire (
                id INTEGER NOT NULL,
                commentaire VARCHAR(1000) NOT NULL,
                site_id INTEGER NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (id)
);


ALTER TABLE public.Topo ADD CONSTRAINT membre_topo_fk
FOREIGN KEY (membre_id)
REFERENCES public.Membre (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Location ADD CONSTRAINT membre_location_fk
FOREIGN KEY (membre_id)
REFERENCES public.Membre (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Secteur ADD CONSTRAINT site_secteur_fk
FOREIGN KEY (site_id)
REFERENCES public.Site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Topo ADD CONSTRAINT site_topo_fk
FOREIGN KEY (site_id)
REFERENCES public.Site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Commentaire ADD CONSTRAINT site_commentaire_fk
FOREIGN KEY (site_id)
REFERENCES public.Site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Location ADD CONSTRAINT topo_location_fk
FOREIGN KEY (topo_id)
REFERENCES public.Topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.Secteur (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
