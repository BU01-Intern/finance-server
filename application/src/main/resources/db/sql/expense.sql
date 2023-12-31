CREATE TABLE IF NOT EXISTS `expense`(
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `account_number` VARCHAR(20) NOT NULL,
    `type` VARCHAR(255) NULL,
    `is_distributed` TINYINT(1) NULL,
    `status` INT NULL,
    `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    `is_deleted` TINYINT(1) NOT NULL DEFAULT 0
);