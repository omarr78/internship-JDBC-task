CREATE TABLE admin(
  admin_id INT AUTO_INCREMENT,
  admin_name VARCHAR(30) NOT NULL,
  admin_email VARCHAR(30) NOT NULL,
  admin_password VARCHAR(30) NOT NULL,
  CONSTRAINT PRIMARY KEY(admin_id)
)