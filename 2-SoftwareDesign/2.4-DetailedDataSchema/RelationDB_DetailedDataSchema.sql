-- опис користувача
CREATE TABLE Users( -- створення таблиці користувача
	userno int, -- номер користувача
	full_name VARCHAR(200), -- ПІБ користувача
	date_of_birth DATE, -- Дата народження 
	gender VARCHAR(100) -- Стать 
);

-- опис офісного співробітника
CREATE TABLE OfficeEmployee( -- створення таблиці офісного співробітника
	officeemployeeno int, -- номер офісного співробітника
	full_name VARCHAR(200), -- ПІБ офісного співробітника
	date_of_birth DATE, -- Дата народження 
	gender VARCHAR(100), -- Стать 
	salary DECIMAL, -- Заробітна плата 
	pos_of_employee VARCHAR(100) -- Посада
);

-- опис технічного співробітника
CREATE TABLE TechnicalEmployee( -- створення таблиці технічного співробітника
	technicalemployeeno INT, -- номер технічного співробітника
	full_name VARCHAR(100), -- ПІБ технічного співробітника
	date_of_birth DATE, -- Дата народження
	gender VARCHAR(50), -- Стать
	salary DECIMAL, -- Заробітна плата 
	pos_of_tech_employee VARCHAR(100) -- Посада 
);

-- опис запиту на інформацію
CREATE TABLE InformationRequest( -- створення таблиці запиту на інформацію
	informationrequestno INT, -- номер запиту
	request_title VARCHAR(1000), -- заголовок запиту
	description VARCHAR(2000), -- детальний опис запиту
	format VARCHAR(100), -- формат отримання результату
	date DATE, -- дата відправки запиту
	userno int -- номер користувач, який надіслав запит
);


-- опис відповіді на запит інформації
CREATE TABLE InformationAnswer( -- створення таблиці відповіді на запит інформації
	informationanswerno INT, -- номер відповіді
	answer_title VARCHAR(1000), -- заголовок відповіді
	answer_information VARCHAR(10000), -- відповідь у вигляді інформації
	file VARCHAR(200), -- посилання на місце зберігання файлу з відповіддю 
	date DATE, -- дата надсилання відповіді
	informationrequestno int, -- номер запиту, на який надсилається відповідь
	officeemployeeno int -- номер офісного співробітника, який сформував відповідь
);

-- опис поточного відсотка чистоти повітря
CREATE TABLE AirClear( -- створення таблиці поточного відсотка чистоти повітря
	airclearno int, -- номер показника чистоти повітря
	date DATE, -- дата проведення вимірювань
	time TIME, -- час проведення вимірювань
	airclear_percent DECIMAL, -- відсоток чистоти повітря
	location VARCHAR(200) -- місце проведення вимірювань
);

-- опис зміни чистоти повітря
CREATE TABLE AirClearChange( -- створення таблиці зміни чистоти повітря
	airclearchangeno int,  -- номер зміни чистоти повітря
	new_airclear_percent DECIMAL,  -- значення чистоти повітря, яке встановлюється
	location VARCHAR(100),  -- місце, де змінюється значення чистоти повітря
	technicalemployeeno INT,  -- номер технічного співробітника, який внес зміни
	airclearno int  -- номер попереднього значення чистоти повітря в цьому приміщенні
);

/* Команди обмеження цілісності даних */

/* Первинні ключі */
-- Встановлення обмеження первинного ключа користувача
ALTER TABLE Users ADD CONSTRAINT user_pk
    PRIMARY KEY (userno);
	
-- Встановлення обмеження первинного ключа офісного співробітника
ALTER TABLE OfficeEmployee ADD CONSTRAINT officeemployee_pk
    PRIMARY KEY (officeemployeeno);
	
-- Встановлення обмеження первинного ключа технічного співробітника
ALTER TABLE TechnicalEmployee ADD CONSTRAINT technicalemployee_pk
    PRIMARY KEY (technicalemployeeno);
	
-- Встановлення обмеження первинного ключа запиту на інформацію
ALTER TABLE InformationRequest ADD CONSTRAINT informationrequest_pk
    PRIMARY KEY (informationrequestno);
	
-- Встановлення обмеження первинного ключа відповіді на запит
ALTER TABLE InformationAnswer ADD CONSTRAINT informationanswer_pk
    PRIMARY KEY (informationanswerno);

-- Встановлення обмеження первинного ключа показника поточної чистоти повітря
ALTER TABLE AirClear ADD CONSTRAINT airclear_pk
    PRIMARY KEY (airclearno);
	
-- Встановлення обмеження первинного ключа зміни чистоти повітря
ALTER TABLE AirClearChange ADD CONSTRAINT airclearchange_pk
    PRIMARY KEY (airclearchangeno);
	
/* Зовнішні ключі */	

-- Встановлення обмеження зовнішнього ключа на користувача для таблиці Запит на інформацію
ALTER TABLE InformationRequest ADD CONSTRAINT request_user_fk
    FOREIGN KEY (userno) REFERENCES Users(userno);

-- Встановлення обмеження зовнішнього ключа на запит для таблиці Відповідь на запит
ALTER TABLE InformationAnswer ADD CONSTRAINT answer_request_fk
    FOREIGN KEY (informationrequestno) REFERENCES InformationRequest(informationrequestno);
	
-- Встановлення обмеження зовнішнього ключа на офісного співробітника для таблці Відповідь на запит
ALTER TABLE InformationAnswer ADD CONSTRAINT answer_employee_fk
    FOREIGN KEY (officeemployeeno) REFERENCES OfficeEmployee(officeemployeeno);
	
-- Встановлення обмеження зовнішнього ключа на технічного співробітника для таблиці Зміна чистоти повітря
ALTER TABLE AirClearChange ADD CONSTRAINT airclear_employee_fk
    FOREIGN KEY (technicalemployeeno) REFERENCES TechnicalEmployee(technicalemployeeno);
	
-- Встановлення обмеження зовнішнього ключа на попереднє значення чистоти повітря для таблиці Зміна чистоти повітря
ALTER TABLE AirClearChange ADD CONSTRAINT previous_airclear_fk
    FOREIGN KEY (airclearno) REFERENCES AirClear(airclearno);
	
/* Команди обмеження змісту атрибутів таблиць */

-- Встановлення обмеження вмісту стовпчика зарплатня таблиці Офісні співробітники, більше нуля
ALTER TABLE OfficeEmployee ADD CONSTRAINT office_salary_positive
    CHECK ( salary > 0 );
	
-- Встановлення обмеження вмісту стовпчика зарплатня таблиці Технічні співробітники, більше нуля
ALTER TABLE TechnicalEmployee ADD CONSTRAINT technical_salary_positive
    CHECK ( salary > 0 );
	
-- Встановлення обмеження вмісту стовпчика Формат файлу таблиці Запит на інформацію.
-- Формат має починатися з крапки та мати після неї від 3 до 10 символів, 
-- після цього через пробіл можна вказати ще додатково декілька слів, проте загальна довжина конструкції має бути не більше 50 символів
ALTER TABLE InformationRequest ADD CONSTRAINT request_format_positive
    CHECK ( format SIMILAR TO '^(?=.{1,50}$)\.[a-zA-Z0-9]{3,10}(?: [a-zA-Z ]+)?$');

-- Встановлення обмеження вмісту стовпчика Файл таблиці Відповідь на запит, який містить посилання на файл з інформацією.
-- Посилання має сталу частину https://drive.google.com/drive, після якого через / вказується подальший шлях до файлу.
-- Загальна довжина посилання не має перевищувати 200 символів
ALTER TABLE InformationAnswer ADD CONSTRAINT file_link_format
    CHECK ( file SIMILAR TO '^(?=.{1,200}$)https:\/\/drive\.google\.com\/drive\/(?:[^\/]+\/)[^\/]+(?:\/[^\/]+)*$');
	
-- Встановлення обмеження вмісту стовпчика Показник чистоти повітря таблиці чистоти повітря
ALTER TABLE AirClear ADD CONSTRAINT airclear_range
    CHECK ( airclear_percent BETWEEN 0 AND 100);
	
-- Встановлення обмеження вмісту стовпчика Нове значення чистоти повітря таблиці Зміна чистоти повітря
ALTER TABLE AirClearChange ADD CONSTRAINT new_airclear_range
    CHECK ( new_airclear_percent BETWEEN 0 AND 100);
