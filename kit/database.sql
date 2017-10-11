CREATE TABLE IF NOT EXISTS equipe (
  equipe_id INT NOT NULL AUTO_INCREMENT,
  equipe_nome VARCHAR(100) NOT NULL,
  PRIMARY KEY (equipe_id));
  
CREATE TABLE IF NOT EXISTS enxadrista (
  enxadrista_id INT NOT NULL AUTO_INCREMENT,
  enxadrista_nome VARCHAR(150) NOT NULL,
  enxadrista_sobrenome VARCHAR(150) NOT NULL,
  PRIMARY KEY (enxadrista_id));
  
CREATE TABLE IF NOT EXISTS equipe_enxadrista (
  equipeenxadrista_id INT NOT NULL AUTO_INCREMENT,
  equipe_equipe_id INT NOT NULL,
  enxadrista_enxadrista_id INT NOT NULL,
  PRIMARY KEY (equipeenxadrista_id),
	FOREIGN KEY (equipe_equipe_id)
	REFERENCES equipe (equipe_id)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION,
    FOREIGN KEY (enxadrista_enxadrista_id)
    REFERENCES enxadrista (enxadrista_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE IF NOT EXISTS rodada (
  rodada_id INT NOT NULL AUTO_INCREMENT,
  rodada_nome VARCHAR(50) NOT NULL,
  rodada_data DATETIME NOT NULL,
  PRIMARY KEY (rodada_id));
  
CREATE TABLE IF NOT EXISTS rodada_enxadrista (
  re_id INT NOT NULL AUTO_INCREMENT,
  enxadrista_w_id INT UNSIGNED NOT NULL,
  enxadrista_b_id INT UNSIGNED NOT NULL,
  rodada_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (re_id),
    FOREIGN KEY (enxadrista_w_id)
    REFERENCES enxadrista (enxadrista_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (enxadrista_b_id)
    REFERENCES enxadrista (enxadrista_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (rodada_id)
    REFERENCES rodada (rodada_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE IF NOT EXISTS rodada_equipe (
  req_id INT NOT NULL AUTO_INCREMENT,
  req_equipe_w_id INT UNSIGNED NOT NULL,
  req_equipe_b_id INT UNSIGNED NOT NULL,
  req_rodada_id INT UNSIGNED NOT NULL,
  PRIMARY KEY (req_id),
    FOREIGN KEY (req_equipe_w_id)
    REFERENCES equipe (equipe_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (req_equipe_b_id)
    REFERENCES equipe (equipe_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (req_rodada_id)
    REFERENCES rodada (rodada_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);