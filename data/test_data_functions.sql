USE `customers`;
DROP function IF EXISTS `create_test_data_item`;

USE `customers`;
DROP function IF EXISTS `customers`.`create_test_data_item`;
;

DELIMITER $$
USE `customers`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `create_test_data_item`() RETURNS bigint
    READS SQL DATA
    DETERMINISTIC
BEGIN

	-- 1 declare
	declare v_created_account_id bigint;
    declare v_temp_profile_name varchar(100);
    declare v_created_profile_id bigint;
    
    -- 2 create account, store account_id 
    INSERT INTO `customers`.`account_t` (`type`, `created`, `last_login`, `status`) VALUES ('STANDARD', now(), now(), 'ACTIVE');
    select last_insert_id() into v_created_account_id;
    
    -- 3 generate temporary profile name by appending TEST_<created_account_id>
    select concat('TEST_PROFILE_',v_created_account_id) into v_temp_profile_name;

	-- 4 create profile and store profile id 
    INSERT INTO `customers`.`profile_t` (`name`, `primary_contact`, `email`, `contact_verified`, `email_verified`) VALUES (v_temp_profile_name, '9890784521', 'test@email.com', 0, 0);
    select last_insert_id() into v_created_profile_id;
    
    -- 5 insert into accounts_profile_t (join table) 
	INSERT INTO `customers`.`account_profile_t` ( `account`, `profile`) VALUES (v_created_account_id, v_created_profile_id);
    
    -- 6. create address
    INSERT INTO `customers`.`address_t` (`name`, `unit`, `address_line_1`, `address_line_2`, `city`, `region`, `postal_code`, `account`) 
    VALUES (CONCAT('TEST_ADDRESS',v_created_account_id), 'TEST_UNIT','TEST_ADDRESS_LINE_1', 'TEST_ADDRESS_LINE_2', 'TEST_CITY', 'TEST_REGION', 'TEST_POSTAL_CODE', v_created_account_id);
    
    -- 7. create order
    INSERT INTO `customers`.`order_t` (`type`, `status`, `created`, `account`) VALUES ('STANDARD', 'IN_PROGRESS',now(), v_created_account_id);
    
    -- 8. create some preference
    
    
    -- 9. create entry into test_data_items_t
    INSERT INTO `customers`.`test_data_items_t` (`account`, `profile`, `name`, `type`, `created`) VALUES (v_created_account_id,v_created_profile_id, v_temp_profile_name,'STANDARD', now());
    
RETURN v_created_account_id;
END$$

DELIMITER ;
;

