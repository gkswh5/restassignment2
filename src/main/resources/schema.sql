CREATE TABLE IF NOT EXISTS go_company (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  created_at VARCHAR(30),
  modified_at VARCHAR(30),
  deleted_at VARCHAR(30),
  companyName VARCHAR(255),
  users_total INT,
  users_deleted INT,
  users_use INT,
  service_avail boolean,
  sync boolean,
  sync_kind VARCHAR(20),
  sync_id INT,
  INDEX(companyName)
) engine=InnoDB;

CREATE TABLE IF NOT EXISTS go_account_subject (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  account_system VARCHAR(30),
  account_code VARCHAR(30),
  account_subject_name_detail VARCHAR(30),
  account_subject_name VARCHAR(255),
  division VARCHAR(50),
  relation_code VARCHAR(50),
  relation_account_subject_name_detail VARCHAR(50),
  company_id INT,
  created_at VARCHAR(30),
  modified_at VARCHAR(30),
  deleted_at VARCHAR(30),
  INDEX(id)
) engine=InnoDB;