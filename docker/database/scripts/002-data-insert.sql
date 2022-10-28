INSERT INTO public.vehicle
(plate, color, model)
VALUES('WER-4321', 'Cinza', 'HB20');
INSERT INTO public.vehicle
(plate, color, model)
VALUES('WKB-0348', 'Preto', 'Cobalt');


INSERT INTO public.parking
("exit", paid, "start", plate)
VALUES(NULL, false, '2022-10-28 17:44:46.533', 'WER-4321');
INSERT INTO public.parking
("exit", paid, "start", plate)
VALUES(NULL, false, '2022-10-28 17:44:46.533', 'WKB-0348');
