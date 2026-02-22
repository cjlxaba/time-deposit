-- Insert TimeDeposits
INSERT INTO time_Deposits (plan_type, days, balance)
VALUES ('Basic', 30, 1000.00);

INSERT INTO time_Deposits (plan_type, days, balance)
VALUES ('Student', 60, 2000.00);

INSERT INTO time_Deposits (plan_type, days, balance)
VALUES ('Premium', 180, 10000.00);

-- Insert Withdrawals for TimeDeposit ID 1 (Basic)
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (1, 50.00, '2026-02-21 10:00:00');
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (1, 25.00, '2026-02-22 11:30:00');
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (1, 75.00, '2026-02-23 09:15:00');

-- Insert Withdrawals for TimeDeposit ID 2 (Student)
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (2, 100.00, '2026-02-21 12:00:00');
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (2, 50.00, '2026-02-22 13:45:00');
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (2, 150.00, '2026-02-23 15:20:00');

-- Insert Withdrawals for TimeDeposit ID 3 (Premium)
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (3, 500.00, '2026-02-21 14:00:00');
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (3, 250.00, '2026-02-22 16:30:00');
INSERT INTO withdrawals (time_deposit_id, amount, date)
VALUES (3, 1000.00, '2026-02-23 17:45:00');