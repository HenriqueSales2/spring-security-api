-- O "INSERT IGNORE" evita duplicata se o banco já tiver os dados

INSERT INTO tab_user (user_id, name, username, password)
VALUES
    (1, 'Administrator', 'admin', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.AKnt8e2'),
    (2, 'Default User', 'user',  '$2a$10$ByIUiNaRfBKSV8urTKQm4.9kMSCZEoMEMRCBDLF7E1V/fSrBnlDJa')
    ON DUPLICATE KEY UPDATE password = VALUES(password);