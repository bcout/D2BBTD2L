CREATE TABLE adminAccount
(
	id INT NOT NULL AUTO_INCREMENT;
	username VARCHAR(200) NOT NULL UNIQUE,
	password VARCHAR(200) NOT NULL UNIQUE,
	PRIMARY KEY id
);

CREATE TABLE studentAccount
(
	id INT NOT NULL AUTO_INCREMENT,
	username VARCHAR(200) NOT NULL UNIQUE,
	password VARCHAR(200) NOT NULL UNIQUE,
	hasUnreadNotifications INT NOT NULL DEFAULT 0,
	PRIMARY KEY id
);

/* TODO taAccount, profAccount */


CREATE TABLE course
(
	id INT NOT NULL AUTO_INCREMENT,
	/* This is a varchar because course "numbers" are CS1073, BIO1001, etc */
	courseNumber VARCHAR(10) NOT NULL UNIQUE,
	PRIMARY KEY id
);

CREATE TABLE courseOfferingInfo
(
	id INT NOT NULL AUTO_INCREMENT,
	/* varchar for same reason as above */
	roomNum VARCHAR(10) NOT NULL AUTO_INCREMENT,
	courseId ID NOT NULL,
	/* todo */
	PRIMARY KEY id,
	FOREIGN KEY courseId REFERENCES course(id)
);

CREATE TABLE courseInfo
(
	id NOT NULL AUTO_INCREMENT,
	title VARCHAR(200) NOT NULL,
	body TEXT,
	courseId INT NOT NULL,
	PRIMARY KEY id,
	FOREIGN KEY courseId REFERENCES course(id)
);

CREATE TABLE assignment
(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(200) NOT NULL,
	file BLOB,
	specifications TEXT NOT NULL,
	PRIMARY KEY id
);

CREATE TABLE assignmentSubmission
(
	id INT NOT NULL AUTO_INCREMENT,
	feedbackRead INT NOT NULL DEFAULT 0,
	studentId INT NOT NULL,
	courseId INT NOT NULL,
	PRIMARY KEY id,
	FOREIGN KEY studentID REFERENCES studentAccount(id),
	FOREIGN KEY courseID REFERENCES course(id)
);

CREATE TABLE message
(
	id INT NOT NULL AUTO_INCREMENT,
	sentTimestamp INT NOT NULL,
	message TEXT NOT NULL,
	studentFrom INT,
	studentTo INT,
	profFrom INT,
	profTo INT,
	taFrom INT,
	taTo INT,
	PRIMARY KEY id,
	FOREIGN KEY studentFrom REFERENCES studentAccount(id),
	FOREIGN KEY studentTo REFERENCES studentAccount(id)
	FOREIGN KEY profFrom REFERENCES profAccount(id),
	FOREIGN KEY profTo REFERENCES profAccount(id),
	FOREIGN KEY taFrom REFERENCES taAccount(id),
	FOREIGN KEY taTo REFERENCES taAccount(id)
);

