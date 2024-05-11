
-- select test-data-items
select a.id "account_id", a.type "account_type", a.status "account_status",
 a.last_login, p.name "profile_name", ad.postal_code, o.id "order_id", o.status "order_status"  
from account_t a
inner join account_profile_t ap on a.id = ap.account
inner join profile_t p on ap.profile = p.id
left outer join address_t ad on a.id = ad.account
left outer join order_t o on a.id = o.account
where a.id in (select `account` from test_data_items_t);

select create_test_data_item();