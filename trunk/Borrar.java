ALTER TABLE adjudicacion ADD COLUMN id_llamado INT;

CREATE SEQUENCE producto_contrataciones_seq INCREMENT 1 MINVALUE -32768 MAXVALUE 32767 START -32768;
CREATE TABLE producto_contrataciones(
	codigo			SMALLINT PRIMARY KEY	DEFAULT nextval( 'producto_contrataciones_seq' )	,
	codigo_contrataciones	TEXT UNIQUE		,
	actual			BOOLEAN	DEFAULT FALSE	,
	codigo_medicamento	BIGINT REFERENCES medicamento( codigo )
);
COMMENT ON TABLE producto_contrataciones IS 'Registra los datos de productos administrados por la Dirección Nacional de Contrataciones';
