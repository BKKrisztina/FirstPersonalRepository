DROP DATABASE IF EXISTS myblog;
​
CREATE DATABASE IF NOT EXISTS myblog;
​
USE myblog;
​
CREATE TABLE IF NOT EXISTS users (
	user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    entitlement ENUM ('admin', 'moderator', 'user', 'visitor') DEFAULT 'visitor',
    reg_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    profil_picture LONGBLOB,
    PRIMARY KEY(user_id)
);
​
CREATE TABLE IF NOT EXISTS blogtemplates (
	-- blogtemplates_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    blogtemplate_name VARCHAR(50) NOT NULL,
    font_colour ENUM ('Red','Cyan','Blue','DarkBlue','LightBlue','Purple','Yellow','Lime','Magenta','Pink','White','Silver','Gray or Grey','Black','Orange','Brown','Maroon','Green','Olive','Aquamarine') DEFAULT 'black',
    font_type ENUM('Westminster','Verdana','Vagabond','Univers Condensed','Univers','Unicorn','Tubular','Tristan','Trebuchet MS','Times New Roman PS','Times New Roman','Times','Tempus Sans ITC','Teletype','Technical','Tahoma','Subway','Storybook','Steamer','Socket','Signboard','Sherwood','Sceptre','Pythagoras','Poster','Pickwick','Pegasus','Old Century','OCR A Extended','News GothicMT','MS LineDraw','Matisse ITC','Market','Marigold','Lucida Sans Unicode','Lucida Sans','Lucida Handwriting','Lucida Console','Long Island','Lithograph Light','Lithograph','Letter Gothic','Jester','Impact','Herald','Helvetica','Heather','Haettenschweiler','Geneva','Garamond','Fransiscan','Denmark','Dauphin','Cuckoo','Courier New','Courier','Coronet','Cornerstone','Copperplate Gothic Light','Copperplate Gothic Bold','Comic Sans MS','Clarendon Condensed','Chaucer','Charlesworth','CG Times','CG Omega','Cezanne','Century Schoolbook','Century Gothic','Calligrapher','Calisto MT','Boulder','Bookman Old Style','Book Antiqua','Bazooka','Arial Narrow','Arial MT','Arial Black','Arial','Antique Olive','Albertus Medium','Abadi MT Condensed Light','Albertus Extra Bold') DEFAULT 'Times New Roman',
    background_image LONGBLOB,
    PRIMARY KEY (blogtemplate_name)
);
​
CREATE TABLE IF NOT EXISTS blog (
	-- blog_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    blog_name VARCHAR(50), 
    creation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    creator_ID INT UNSIGNED NOT NULL,
    blog_template_name VARCHAR(50) NOT NULL, 
    PRIMARY KEY(blog_name),
    FOREIGN KEY(blog_template_name) REFERENCES blogtemplates(blogtemplate_name),
    FOREIGN KEY(creator_ID) REFERENCES users(user_ID)
);
​
CREATE TABLE IF NOT EXISTS blogposts (
	blogposts_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    blogger_id INT UNSIGNED NOT NULL UNIQUE,
    blog_post_name VARCHAR(50),
    blog_post_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    blog_text VARCHAR(5000),
    PRIMARY KEY(blogposts_id),
    FOREIGN KEY (blogger_id) REFERENCES users(user_id),
    FOREIGN KEY (blog_post_name) REFERENCES blog(blog_name)
);
​
CREATE TABLE IF NOT EXISTS comments (
	comment_id INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    comment_text VARCHAR(100),
    comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    comment_status ENUM ('draft', 'published', 'deleted') NOT NULL, 
    commenter_ID INT UNSIGNED NOT NULL,
    blog_ref_ID INT UNSIGNED NOT NULL,
    history_comment_ID INT,
    PRIMARY KEY (comment_id),
    FOREIGN KEY (commenter_ID) REFERENCES users(user_id),
    FOREIGN KEY (blog_ref_ID) REFERENCES blogposts(blogposts_id)
    );
​
INSERT INTO users(user_name, password, email, entitlement, reg_time)
	VALUES 
		('PussyCat', 'taCyssup', "kiscica@citromail.hu",'user', '2021-09-01 01:00:00'),
		('PuppyDog', 'goDyppup', "kiskutya@citromail.hu",'user', '2021-09-01 01:00:00'),
                ('PorkyPig', 'giPykrop', "pinkypig@gmail.com",'user', '2021-09-01 06:00:00'),
                ('PinkPanther', 'rehtnaPknip', "pinkpanther@progmatic.hu",'user', '2021-09-01 05:00:00'),
                ('DaffyDuck', 'kcuDyffad', "daffyduck@gmail.com",'user', '2021-09-01 04:00:00'),
                ('HoneyBunny', 'ynnuByenoh', "honeybunny@gmail.com",'user', '2021-09-01 04:00:00'),
                ('MickeyMouse', 'esuoMyekcim', "mickeymouse@gmail.com",'user', '2021-09-01 03:00:00'),
                ('CharlieBrown', 'nworBeilrahc', "charliebrown@gmail.com",'user', '2021-09-01 03:00:00'),
                ('FredFlintstone', 'enotstnilFderf', "fredflintstone@gmail.com",'user', '2021-09-01 02:00:00'),
                ('SpongeBobSquarePants', 'stnaperauqSbobegnops', "spongebobsquarepants@gmail.com",'user', '2021-09-01 02:00:00'),
                ('KennyMcCormick', 'kcimroccMynnek', "kennykccormick@gmail.com",'user', '2021-09-01 01:00:00'),
		('WhiteSheep', 'peehSetihw', 'feherbari@progmatic.hu', 'moderator', '2021-09-01 01:00:00'),
                ('BlackSheep', 'peehSkcalb', 'feketebari@progmatic.hu', 'admin', '2021-09-01 01:00:00');
​
INSERT INTO blogtemplates (blogtemplate_name, font_colour, font_type)
	VALUES
		('50shadesOfGrey','Gray or Grey','Trebuchet MS'),
		('colorful','Lime','Unicorn'),
                ('dreamer','LightBlue','Tristan'),
                ('greenie','Green','Arial'),
                ('pinkiePie','Magenta','Storybok'),
                ('sporty','Cyan','Albertus Medium');
​
INSERT INTO blog (blog_name, creation_time, creator_ID,blog_template_name) VALUES 
	('cyclist','2021-09-27 21:08:14', 6,'sporty'),
	('doggy', '2021-09-27 21:08:14',2, 'pinkiePie'),
    	('dreamer','2021-09-27 21:08:14', 5, 'dreamer'),
    	('kiddo','2021-09-27 21:08:14', 1, 'colorful'),
	('singlings','2021-09-27 21:08:14', 3, '50shadesOfGrey');
​
INSERT INTO blogposts (blogger_id,blog_post_name, blog_post_time, blog_text)
	VALUES 
		('1','kiddo', '2021-09-01 00:00:00','From day one of wanting to conceive, Ive always owned the belief of trusting my body and trusting the timing of my life. I’ve held faith that my body would do what it was supposed to do when the timing was right. Becoming pregnant was something I’ve always dreamed of but to be honest with you, scared me a little. I never really came across positive birth stories, only ones that warned of labor and delivery perils. Each labor is different, just as every pregnancy is different and I think it’s incredibly important for all stories to be shared. My story is deeply personal and I’m choosing to share in hopes to encourage pregnancy optimism through my positive birthing experience.' ),
                ('2','doggy', '2021-09-02 00:00:00','It all began with Ike, the German Shepherd - Rottweiler my musician daughter Sonya dog shared in Brooklyn. Ike was her neighbors dog. Sonya began jogging and dog sitting Ike and after the neighbor had a baby and moved across town, Ike began to live with Sonya part time. The first time Sonya brought Ike home it was love at first sight. And I had no allergic reaction. So began my new life as a dog person, and the 8 month hunt for OUR dog.'),
                ('3','singlings', '2021-09-03 00:00:00','My years of New York City dating—if you’re counting, there have been 12—have involved a lot of guys, short- and long- and mid-term. My longest relationship lasted two years. My shortest—minus the one-off hookups that we all know aren’t “dates” at all—was somewhere in the range of two weeks. There have been certifiable crazies, like the Eastern European fellow who broke my bedroom window in a fit of rage and told me not to complain that he’d broken my “fucking window.” There was the Jersey boy who worked in women’s handbags; fond memories involve him drunk-puking at the Hilton, then giggling hysterically, running, and “hiding” our soiled comforter in front of someone else’s door down the hall. There was the super-successful corporate honcho with a cardboard box for a nightstand. The best friend with whom I had zero sexual attraction.'),
                ('4','soccerfan', '2021-09-01 00:00:00','Football in its current form arose in England in the middle of the 19th century. But alternative versions of the game existed much earlier and are a part of the football history. The first known examples of a team game involving a ball, which was made out of a rock, occurred in old Mesoamerican cultures for over 3,000 years ago.'),
                ('5','dreamer', '2021-09-01 00:00:00','A place where you have every reason to be glad. The people of Littleton, New Hampshire can always find something to be glad about: their rich history, their beautiful countryside, their hard-working, friendly neighbors. You might call Littleton the worldwide capital of finding things to be glad about. Littleton’s best-known native is the beloved children’s book character, “Pollyanna,” the famously relentless optimist who never let a chance for happiness go to waste.'),
                ('6','cyclist', '2021-09-04 00:00:00','Hi Folks, After six years of written interviews and stories and blog posts and one year of podcasting, it’s time to close the book on The Bicycle Story. I launched this project on Nov 1. 2010 with an interview with Stevil Kinevil. I wasn’t sure exactly what the path forward would be for the site, but the late 2000s bike culture boom was reaching its peak and there were a seemingly endless number of fascinating characters in the bike world about whom I wanted to know more. Luckily, it turned out there were lots of readers who were also interested in the lives of bike racers, adventurers, advocates, industry insiders, dirt bags and wild women and men.');
​
INSERT INTO comments (comment_text, comment_time, comment_status, commenter_ID, blog_ref_ID, history_comment_ID)
	VALUES 
		('congrats', '2021-09-02 10:33:09','published','1','1',NULL),
                ('how cute!', '2021-09-02 10:35:42','published','1','1',NULL),
                ('lovely puppy!', '2021-09-02 10:37:55','published','2','2',NULL),
                ('how cute!', '2021-09-04 07:32:21','published','1','2',NULL),
                ('cheers!', '2021-09-04 12:02:22','published','1','3',NULL),
                ('besties', '2021-09-04 07:21:12','published','2','3',NULL),
                ('you will never walk alone!', '2021-09-05 07:11:34','published','3','3',NULL),
                ('you will never walk alone!', '2021-09-05 08:06:07','published','3','4',NULL),
                ('thank you!', '2021-09-05 11:12:13','published','1','5',NULL),
                ('glad to be here!', '2021-09-06 08:08:48','draft','2','5',NULL), 
                ('bullshit', '2021-09-06 11:43:34','draft','3','5',NULL),
                ('not my cup of tea', '2021-09-07 10:11:12','draft','4','3',NULL),
                ('none of your business', '2021-09-08 06:11:34','deleted','1','3',NULL),
                ('piece of cake', '2021-09-08 07:11:34','published','4','5',NULL),
                ('good work', '2021-09-08 10:11:45','published','1','6',NULL),
                ('best blog ever!', '2021-09-08 11:11:45','published','5','5',NULL),
                ('home sweet home', '2021-09-09 09:09:09','published','5','6',NULL),
​		('thanks', '2021-09-02 12:01:23','published','2','1','1'),
		('best team ever!', '2021-09-05 09:06:07','published','2','4','8'),
		('not a question', '2021-09-05 9:22:07','published','3','4','19'),
		('tell me about ittell me about it', '2021-09-06 12:43:12','published','4','4','20'),
		('go buddy', '2021-09-10 11:11:11','deleted','4','6','15'),
		('well done', '2021-09-10 11:11:45','published','4','6','15'),
		('thank you All', '2021-09-10 12:05:31','published','6','6','15'),
		('indeed', '2021-09-10 12:11:45','published','6','5','16'),
		('totally awesome', '2021-09-10 12:20:13','published','8','5','25'),
		('YabadabaDOOOOOOOOO', '2021-09-10 12:22:30','published','9','5','27'),
		('I feel lonely', '2021-09-10 12:22:30','published','10','3','5'),
		('mmmnmm', '2021-09-10 12:23:55','published','11','3','5'),
		('comment deleted due to naughty word!', '2021-09-11 7:05:55','published','12','3','13'),
		('walk with me', '2021-09-12 8:23:19','published','7','3','7'),
		('sorry, not interested', '2021-09-12 8:51:28','published','3','3','32'),
		('Im in...', '2021-09-12 8:59:23','published','10','3','32'),
		('agree', '2021-09-10 12:12:12','published','7','5','25'),
		('come over!', '2021-09-10 12:33:30','published','11','3','29'),
                