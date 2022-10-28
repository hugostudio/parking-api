-- public.vehicle definition

-- Drop table

-- DROP TABLE public.vehicle;

CREATE TABLE public.vehicle (
	plate varchar(8) NOT NULL,
	color varchar(15) NULL,
	model varchar(25) NULL,
	CONSTRAINT vehicle_pkey PRIMARY KEY (plate)
);


-- public.parking definition

-- Drop table

-- DROP TABLE public.parking;

CREATE TABLE public.parking (
	id serial4 NOT NULL,
	"exit" timestamp NULL,
	paid bool NULL DEFAULT false,
	"start" timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	plate varchar(8) NOT NULL,
	CONSTRAINT parking_pkey PRIMARY KEY (id),
	CONSTRAINT fkbrl20t39asyi3hsbjs80qsw4x FOREIGN KEY (plate) REFERENCES public.vehicle(plate)
);