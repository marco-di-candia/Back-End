--1
select * 
from public.clienti 
where nome = 'mario';

--2
select nome,cognome
from public.clienti
where extract(year from anno_nascita) = 1982;

--3
select count(*)
from public.fatture
where iva = 20;

--4
select *
from public.prodotti
where extract(year from data_attivazione) = 2017 and (in_produzione or in_commercio=true);

--5
select * 
from public.fatture f inner join public.clienti c
on f.id_cliente = c.numero_cliente
where importo <  1000;

--6
select f.numero_fatture, f.importo, f.iva,o.denominazione
from public.fatture f inner join public.fornitori o
on f.numero_fornitore = o.numero_fornitore;

--7
select extract(year from data_fattura) anno,count(*) numero_fatture
from public.fatture
where iva = 20
group by anno;






