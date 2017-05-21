
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Table_For_Datas {

	public static void main(String[] args) throws ClassNotFoundException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://dijkstra2.ug.bcc.bilkent.edu.tr/emir_acimis","emir.acimis","xcqjgigkp");	
			Statement statement = con.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS Publish");
			statement.executeUpdate("DROP TABLE IF EXISTS Injury");
			statement.executeUpdate("DROP TABLE IF EXISTS Transfer");
			statement.executeUpdate("DROP TABLE IF EXISTS Plays");
			statement.executeUpdate("DROP TABLE IF EXISTS Game");
			statement.executeUpdate("DROP TABLE IF EXISTS Team");
			statement.executeUpdate("DROP TABLE IF EXISTS Statistics");
			statement.executeUpdate("DROP TABLE IF EXISTS Post");
			statement.executeUpdate("DROP TABLE IF EXISTS User");
			statement.executeUpdate("DROP TABLE IF EXISTS Coach");
			statement.executeUpdate("DROP TABLE IF EXISTS Player");
			statement.executeUpdate("DROP TABLE IF EXISTS Agent");
			statement.executeUpdate("DROP TABLE IF EXISTS Admin");
			statement.executeUpdate("CREATE TABLE User" +
					"(user_id INT, name VARCHAR(20), birth_date DATE, password INT, PRIMARY KEY(user_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Coach" +
					"(coach_id FLOAT, name VARCHAR(20), birth_date DATE, salary FLOAT, PRIMARY KEY(coach_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Player" +
					"(player_id FLOAT, name VARCHAR(30), position VARCHAR(20), team VARCHAR(20), value INT, PRIMARY KEY(player_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Agent" +
					"(agent_id FLOAT, name VARCHAR(20), position VARCHAR(20), PRIMARY KEY(agent_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Admin" +
					"(admin_id FLOAT, name VARCHAR(20), position VARCHAR(20), PRIMARY KEY(admin_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Post" +
					"(post_id FLOAT, topic VARCHAR(20), text VARCHAR(512), PRIMARY KEY(post_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Statistics" +
					"(player_id FLOAT, no_of_games INT, no_of_goals INT, no_of_assists INT, no_of_passes INT, no_of_shoots INT,PRIMARY KEY(player_id),FOREIGN KEY(player_id) REFERENCES Player(player_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Team" +
					"(team_id FLOAT,name VARCHAR(30), stadium VARCHAR(30), colors VARCHAR(20), date_of_establish INT, city VARCHAR(20), budget INT, overall_wage INT,PRIMARY KEY(team_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Game" +
					"(game_id FLOAT, stadium VARCHAR(20), date DATE, no_of_spectators INT, home_id FLOAT, away_id FLOAT, score VARCHAR(5), PRIMARY KEY(game_id),FOREIGN KEY(home_id) REFERENCES Team(team_id), FOREIGN KEY(away_id) REFERENCES Team(team_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Plays" +
					"(game_id FLOAT, player_id FLOAT, date DATE, no_of_assists INT, no_of_goals INT, no_of_passes INT, no_of_shots INT, PRIMARY KEY(game_id),FOREIGN KEY(game_id) REFERENCES Game(game_id), FOREIGN KEY(player_id) REFERENCES Player(player_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Transfer" +
					"(transfer_id FLOAT, value_offered INT, wage_offered INT, start_date DATE, end_date DATE, current_team_id FLOAT, next_team_id FLOAT, coach_id FLOAT, PRIMARY KEY(transfer_id), FOREIGN KEY(current_team_id) REFERENCES Team(team_id), FOREIGN KEY(next_team_id) REFERENCES Team(team_id), FOREIGN KEY(coach_id) REFERENCES Coach(coach_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Injury" +
					"(player_id FLOAT, date DATE, duration INT, cause VARCHAR(20),PRIMARY KEY(player_id), FOREIGN KEY(player_id) REFERENCES Player(player_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Publish" +
					"(post_id FLOAT, user_id INT, text VARCHAR(512), date DATE,PRIMARY KEY(post_id), FOREIGN KEY(post_id) REFERENCES Post(post_id), FOREIGN KEY(user_id) REFERENCES User(user_id))ENGINE=INNODB;");
			
			//Team Table Insertions Done
			
			statement.executeUpdate("INSERT INTO Team (team_id, name, stadium, colors, date_of_establish, city, budget, overall_wage)" + 
					"VALUES    ('01', 'Adanaspor','5 Ocak Stadium','Orange-White','1954','Adana','678000','18300000')" +
							", ('02', 'Akhisar Bel. Spor','Manisa 19 Mayýs Stadium','Green-Black','1970','Manisa','1120000','29000000') " +
							", ('03', 'Antalyaspor','Akdeniz Stadium','Red-White','1966','Antalya','1160000','31280000') " +
							", ('04', 'Atikey Konyaspor','Torku Arena','Green-White','1981','Konya','1260000','31500000') " +
							", ('05', 'Aytemiz Alanyaspor','Alanya Oba Stadium','Orange-Green','1948','Alanya','1120000','30350000') " +
							", ('06', 'Besiktas JK','Vodafone Arena','Black-White','1903','Istanbul','4290000','120250000') " +
							", ('07', 'Bursaspor','Timsah Arena','Green-White','1963','Bursa','1530000','44300000') " +
							", ('08', 'Çaykur Rizespor','Çaykur Didi Stadium','Blue-Green','1953','Rize','934000','26150000') " +
							", ('09', 'Fenerbahce SK','Ulker Arena','Yellow-Navyblue','1907','Istanbul','5100000','137650000') " +
							", ('10', 'Galatasaray SK','Turk Telekom Arena','Yellow-Red','1905','Istanbul','3580000','100100000') " +
							", ('11', 'Gaziantepspor','Gaziantep Arena','Red-Black','1969','Gaziantep','988000','25700000') " +
							", ('12', 'Gençlerbirliði','Ankara 19 Mayýs Stadium','Red-Black','1923','Ankara','872000','22680000') " +
							", ('13', 'Kardemir Karabükspor','Dr. Necmettin Seyhoðlu Stadium','Blue-Red','1969','Karabük','902000','23450000') " +
							", ('14', 'Kasýmpasa SK','Recep Tayyip Erdoðan Stadium','Blue-White','1921','Istanbul','1160000','34900000') " +
							", ('15', 'Kayserispor','Kadir Has Stadium','Red-Yellow','1966','Kayseri','1150000','26350000') " +
							", ('16', 'Medipol Basaksehir SK','Fatih Terim Stadium','Navyblue-Orange','1990','Istanbul','2190000','59050000') " +
							", ('17', 'Osmanlýspor FK','Osmanlý Stadium','Purple-White','1978','Ankara','1880000','50650000') " +
							", ('18', 'Trabzonspor','Medicalpark Arena','Blue-Claret Red','1966','Trabzon','2230000','58050000') " );
			
			
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Player Table Insertions
			
			statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100001','Charles Itandje','Goal Keeper','Adanaspor','0')" +
							", ('100002','Hayrullah Mert Akyuz','Goal Keeper','Adanaspor','0') " +
							", ('100003','Goran Karacic','Goal Keeper','Adanaspor','0') " +
							", ('100004','Irfan Can Egribayat','Goal Keeper','Adanaspor','0') " +
							", ('100005','Mauricio Ramos','Defence','Adanaspor','0') " +
							", ('100006','Renan Foguinho','Defence','Adanaspor','0') " +
							", ('100007','Ousmane Viera','Defence','Adanaspor','0') " +
							", ('100008','Yigitcan Golboyu','Defence','Adanaspor','0') " +
							", ('100009','Ethem Ercan Pulgir','Defence','Adanaspor','0') " +
							", ('100010','Didi','Defence','Adanaspor','0') " +
							", ('100011','Diago','Defence','Adanaspor','0') " +
							", ('100012','Halil Ibrahim Pehlivan','Defence','Adanaspor','0') " +
							", ('100013','Emre Ugur Uruc','Defence','Adanaspor','0') " +
							", ('100014','Renan Diniz','Defence','Adanaspor','0') " +
							", ('100015','Vladimir Koman','Midfield','Adanaspor','0') " +
							", ('100016','Tevfik Altindag','Midfield','Adanaspor','0') " +
							", ('100017','Bekir Yilmaz','Midfield','Adanaspor','0') " +
							", ('100018','Samican Keskin','Midfield','Adanaspor','0') " +
							", ('100019','Ahmet Bahcivan','Midfield','Adanaspor','0') " +
							", ('100020','Yusuf Firat Kaplan','Midfield','Adanaspor','0') " +
							", ('100021','Serbay Can','Midfield','Adanaspor','0') " +
							", ('100022','Burak Yildir','Midfield','Adanaspor','0') " +
							", ('100023','Magaye Gueye','Forward','Adanaspor','0') " +
							", ('100024','Baris Memis','Forward','Adanaspor','0') " +
							", ('100025','Reynaldo','Forward','Adanaspor','0') " +
							", ('100026','Vinicius','Forward','Adanaspor','0') " +
							", ('100027','Cem Ozdemir','Forward','Adanaspor','0') " +
							", ('100028','Ahmet Dereli','Forward','Adanaspor','0') " +
							", ('100029','Roni Gleison','Forward','Adanaspor','0') ");

	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100030','Milan Lukac','Goal Keeper','Akhisar Genclikspor','0')" +
							", ('100031','Bora Kork','Goal Keeper','Akhisar Genclikspor','0') " +
							", ('100032','Fatih Ozturk','Goal Keeper','Akhisar Genclikspor','0') " +
							", ('100033','Berker Oncu','Goal Keeper','Akhisar Genclikspor','0') " +
							", ('100034','Miguel Lopes','Defence','Akhisar Genclikspor','0') " +
							", ('100035','Kadir Keles','Defence','Akhisar Genclikspor','0') " +
							", ('100036','Orhan Tasdelen','Defence','Akhisar Genclikspor','0') " +
							", ('100037','Mustafa Yumlu','Defence','Akhisar Genclikspor','0') " +
							", ('100038','Caner Osmanpasa','Defence','Akhisar Genclikspor','0') " +
							", ('100039','Miral Samardzic','Defence','Akhisar Genclikspor','0') " +
							", ('100040','Tolga Unlu','Defence','Akhisar Genclikspor','0') " +
							", ('100041','Onur Akdeniz','Defence','Akhisar Genclikspor','0') " +
							", ('100042','Enoch Kofi Adu','Midfield','Akhisar Genclikspor','0') " +
							", ('100043','Abdoul Sissoko','Midfield','Akhisar Genclikspor','0') " +
							", ('100044','Mervan Celik','Midfield','Akhisar Genclikspor','0') " +
							", ('100045','Custodio','Midfield','Akhisar Genclikspor','0') " +
							", ('100046','Ozer Hurmaci','Midfield','Akhisar Genclikspor','0') " +
							", ('100047','Olcan Adin','Midfield','Akhisar Genclikspor','0') " +
							", ('100048','Somer Aydogdu','Midfield','Akhisar Genclikspor','0') " +
							", ('100049','Aykut Ceviker','Midfield','Akhisar Genclikspor','0') " +
							", ('100050','Alper Uludag','Midfield','Akhisar Genclikspor','0') " +
							", ('100051','Omer Bayram','Midfield','Akhisar Genclikspor','0') " +
							", ('100052','Hasan Ali Adiguzel','Midfield','Akhisar Genclikspor','0') " +
							", ('100053','Ricardo Vaz Te','Forward','Akhisar Genclikspor','0') " +
							", ('100054','Daniel Larsson','Forward','Akhisar Genclikspor','0') " +
							", ('100055','Jeremy Bokila','Forward','Akhisar Genclikspor','0') " +
							", ('100056','Mugdat Celik','Forward','Akhisar Genclikspor','0') " +
							", ('100057','Sokol Cikalleshi','Forward','Akhisar Genclikspor','0') " +
							", ('100058','Onur Ayik','Forward','Akhisar Genclikspor','0') ");

	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100059','Saso Fornezzi','Goal Keeper','Antalyaspor','0')" +
							", ('100060','Ferhat Kaplan','Goal Keeper','Antalyaspor','0') " +
							", ('100061','Ozan Evrim Ozenc','Goal Keeper','Antalyaspor','0') " +
							", ('100062','Ramon Motta','Defence','Antalyaspor','0') " +
							", ('100063','Diego Angelo','Defence','Antalyaspor','0') " +
							", ('100064','Sakib Aytac','Defence','Antalyaspor','0') " +
							", ('100065','Ondrej Celustka','Defence','Antalyaspor','0') " +
							", ('100066','Salih Dursun','Defence','Antalyaspor','0') " +
							", ('100067','Kenan Horic','Defence','Antalyaspor','0') " +
							", ('100068','Yusuf Celik','Defence','Antalyaspor','0') " +
							", ('100069','Oguzhan Kolak','Defence','Antalyaspor','0') " +
							", ('100070','Jean Makoun','Midfield','Antalyaspor','0') " +
							", ('100071','Sandro','Midfield','Antalyaspor','0') " +
							", ('100072','Charles Fernando','Midfield','Antalyaspor','0') " +
							", ('100073','Chico','Midfield','Antalyaspor','0') " +
							", ('100074','Serdar Ozkan','Midfield','Antalyaspor','0') " +
							", ('100075','Yekta Kurtulus','Midfield','Antalyaspor','0') " +
							", ('100076','Zeki Yildirim','Midfield','Antalyaspor','0') " +
							", ('100077','Danilo Campos','Midfield','Antalyaspor','0') " +
							", ('100078','Atakan Cangoz','Midfield','Antalyaspor','0') " +
							", ('100079','Anil Koc','Midfield','Antalyaspor','0') " +
							", ('100080','Dogukan Sinik','Midfield','Antalyaspor','0') " +
							", ('100081','Harun Alpsoy','Midfield','Antalyaspor','0') " +
							", ('100082','Sammuel Etoo','Forward','Antalyaspor','0') " +
							", ('100083','Mostapha El Kabir','Forward','Antalyaspor','0') " +
							", ('100084','Serge Mbilla Etame','Forward','Antalyaspor','0') " +
							", ('100085','Deniz Kadah','Forward','Antalyaspor','0') " +
							", ('100086','Amadaiya Rennie','Forward','Antalyaspor','0') " +
							", ('100087','Emre Gural','Forward','Antalyaspor','0') " +
							", ('100088','Jean-Armel Drole','Forward','Antalyaspor','0') ");
							
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100089','Serkan Kirintili','Goal Keeper','Atiker Konyaspor','0')" +
							", ('100090','Kaya Tarakci','Goal Keeper','Atiker Konyaspor','0') " +
							", ('100091','Abdulaziz Demircan','Goal Keeper','Atiker Konyaspor','0') " +
							", ('100092','Ali Turan','Defence','Atiker Konyaspor','0') " +
							", ('100093','Mehmet Uslu','Defence','Atiker Konyaspor','0') " +
							", ('100094','Barry Douglas','Defence','Atiker Konyaspor','0') " +
							", ('100095','Volkan Findikli','Defence','Atiker Konyaspor','0') " +
							", ('100096','Nejc Skubic','Defence','Atiker Konyaspor','0') " +
							", ('100097','Jagos Vukovic','Defence','Atiker Konyaspor','0') " +
							", ('100098','Selim Ay','Defence','Atiker Konyaspor','0') " +
							", ('100099','Can Demir Aktav','Defence','Atiker Konyaspor','0') " +
							", ('100100','Ali Camdali','Midfield','Atiker Konyaspor','0') " +
							", ('100101','Marc Kibong Mbamba','Midfield','Atiker Konyaspor','0') " +
							", ('100102','Omer Ali Sahiner','Midfield','Atiker Konyaspor','0') " +
							", ('100103','Alban Meha','Midfield','Atiker Konyaspor','0') " +
							", ('100104','Jens Jonsson','Midfield','Atiker Konyaspor','0') " +
							", ('100105','Halil Ibrahim Sonmez','Midfield','Atiker Konyaspor','0') " +
							", ('100106','Deni Milosevic','Midfield','Atiker Konyaspor','0') " +
							", ('100107','Amir Hadziahmetovic','Midfield','Atiker Konyaspor','0') " +
							", ('100108','Emre Can Atila','Midfield','Atiker Konyaspor','0') " +
							", ('100109','Mücahit Can Akcay','Midfield','Atiker Konyaspor','0') " +
							", ('100110','Dimitar Rangelov','Forward','Atiker Konyaspor','0') " +
							", ('100111','Ioan Hora','Forward','Atiker Konyaspor','0') " +
							", ('100112','Ibrahim Sissoko','Forward','Atiker Konyaspor','0') " +
							", ('100113','Moryke Fofana','Forward','Atiker Konyaspor','0') " +
							", ('100114','Rijad Bajic','Forward','Atiker Konyaspor','0') ");
							
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100115','Haydar Yilmaz','Goal Keeper','Aytemiz Alanyaspor','0')" +
							", ('100116','Alisan Seker','Goal Keeper','Aytemiz Alanyaspor','0') " +
							", ('100117','Zdenek Zlamal','Goal Keeper','Aytemiz Alanyaspor','0') " +
							", ('100118','Lamine Gassama','Defence','Aytemiz Alanyaspor','0') " +
							", ('100119','Carlos Garcia','Defence','Aytemiz Alanyaspor','0') " +
							", ('100120','Fabrice NSkala','Defence','Aytemiz Alanyaspor','0') " +
							", ('100121','Giorgos Tzavellas','Defence','Aytemiz Alanyaspor','0') " +
							", ('100122','Berkan Emir','Defence','Aytemiz Alanyaspor','0') " +
							", ('100123','Birol Parlak','Defence','Aytemiz Alanyaspor','0') " +
							", ('100124','Kenneth Omeruo','Defence','Aytemiz Alanyaspor','0') " +
							", ('100125','Darko Lazic','Defence','Aytemiz Alanyaspor','0') " +
							", ('100126','Nuru Suley','Defence','Aytemiz Alanyaspor','0') " +
							", ('100127','Ismail Aissati','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100128','Taha Yalciner','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100129','Efecan Karaca','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100130','Cenk Ahmet Alkilic','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100131','Guy Landel','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100132','Deniz Vural','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100133','Emre Nefiz','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100134','Isaac Sackey','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100135','Emre Akbaba','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100136','Firat Tayboga','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100137','Umit Turker','Midfield','Aytemiz Alanyaspor','0') " +
							", ('100138','Vagner Love','Forward','Aytemiz Alanyaspor','0') " +
							", ('100139','Daniel Candeias','Forward','Aytemiz Alanyaspor','0') " +
							", ('100140','Glynor Plet','Forward','Aytemiz Alanyaspor','0') " +
							", ('100141','Juunior Fernandes','Forward','Aytemiz Alanyaspor','0') " +
							", ('100142','Wilde Donald Guerrier','Forward','Aytemiz Alanyaspor','0') ");
		
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100143','Fabricio Agosto','Goal Keeper','Besiktas','0')" +
							", ('100144','Tolga Zengin','Goal Keeper','Besiktas','0') " +
							", ('100145','Utku Yuvakuran','Goal Keeper','Besiktas','0') " +
							", ('100146','Huseyin Yilmaz','Goal Keeper','Besiktas','0') " +
							", ('100147','Adriano Correia','Defence','Besiktas','0') " +
							", ('100148','Andreas Beck','Defence','Besiktas','0') " +
							", ('100149','Dusko Tosic','Defence','Besiktas','0') " +
							", ('100150','Caner Erkin','Defence','Besiktas','0') " +
							", ('100151','Luiz Rhodolfo','Defence','Besiktas','0') " +
							", ('100152','Marcelo Guedes','Defence','Besiktas','0') " +
							", ('100153','Gokhan Gonul','Defence','Besiktas','0') " +
							", ('100154','Ersan Gulum','Defence','Besiktas','0') " +
							", ('100155','Atinc Nukan','Defence','Besiktas','0') " +
							", ('100156','Matej Mitrovic','Defence','Besiktas','0') " +
							", ('100157','Fatih Aksoy','Defence','Besiktas','0') " +
							", ('100158','Abdullah Celik','Defence','Besiktas','0') " +
							", ('100159','Ricardo Quaresma','Midfield','Besiktas','10000000') " +
							", ('100160','Gokhan Inler','Midfield','Besiktas','0') " +
							", ('100161','Atiba Hutchinson','Midfield','Besiktas','9000000') " +
							", ('100162','Veli Kavlak','Midfield','Besiktas','0') " +
							", ('100163','Necip Uysal','Midfield','Besiktas','0') " +
							", ('100164','Tolgay Arslan','Midfield','Besiktas','0') " +
							", ('100165','Aras Ozbiliz','Midfield','Besiktas','0') " +
							", ('100166','Oguzhan Ozyakup','Midfield','Besiktas','0') " +
							", ('100167','Anderson Talisca','Midfield','Besiktas','6000000') " +
							", ('100168','Muhammed Enes Durmus','Midfield','Besiktas','0') " +
							", ('100169','Sedat Sahinturk','Midfield','Besiktas','0') " +
							", ('100170','Oguzhan Aydogan','Midfield','Besiktas','0') " +
							", ('100171','Ryan Babel','Forward','Besiktas','8000000') " +
							", ('100172','Demba Ba','Forward','Besiktas','0') " +
							", ('100173','Omer Sismanoglu','Forward','Besiktas','0') " +
							", ('100174','Cenk Tosun','Forward','Besiktas','7000000') " +
							", ('100175','Vincent Aboubakar','Forward','Besiktas','0') ");

	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100176','Mert Gunok','Goal Keeper','Bursaspor','0')" +
							", ('100177','Harun Tekin','Goal Keeper','Bursaspor','0') " +
							", ('100178','Muhammed Sengezer','Goal Keeper','Bursaspor','0') " +
							", ('100179','Ataberk Dadakdeniz','Goal Keeper','Bursaspor','0') " +
							", ('100180','Tomas Sivok','Defence','Bursaspor','0') " +
							", ('100181','Serdar Kurtulus','Defence','Bursaspor','0') " +
							", ('100182','Erdem Ozgenc','Defence','Bursaspor','0') " +
							", ('100183','Ismail Konuk','Defence','Bursaspor','0') " +
							", ('100184','Aziz Behich','Defence','Bursaspor','0') " +
							", ('100185','Boban Jovic','Defence','Bursaspor','0') " +
							", ('100186','Emre Tasdemir','Defence','Bursaspor','0') " +
							", ('100187','Ertugrul Ersoy','Defence','Bursaspor','0') " +
							", ('100188','Onur Atasayar','Defence','Bursaspor','0') " +
							", ('100189','Bunyamin Kasal','Defence','Bursaspor','0') " +
							", ('100190','Rustu Hanli','Defence','Bursaspor','0') " +
							", ('100191','Ricardo Faty','Midfield','Bursaspor','0') " +
							", ('100192','Pablo Batalla','Midfield','Bursaspor','0') " +
							", ('100193','Cristobal Jorquera','Midfield','Bursaspor','0') " +
							", ('100194','Merter Yuce','Midfield','Bursaspor','0') " +
							", ('100195','Furkan Ozcal','Midfield','Bursaspor','0') " +
							", ('100196','Bilal Kisa','Midfield','Bursaspor','0') " +
							", ('100197','Samil Cinaz','Midfield','Bursaspor','0') " +
							", ('100198','Furkan Soyalp','Midfield','Bursaspor','0') " +
							", ('100199','Mert Ornek','Midfield','Bursaspor','0') " +
							", ('100200','Berke Yilmaz','Midfield','Bursaspor','0') " +
							", ('100201','Gokhan Berkay Yildiz','Midfield','Bursaspor','0') " +
							", ('100202','Joshua John','Forward','Bursaspor','0') " +
							", ('100203','Yonathan Del Valle','Forward','Bursaspor','0') " +
							", ('100204','Sercan Yildirim','Forward','Bursaspor','0') " +
							", ('100205','Bogdan Stancu','Forward','Bursaspor','0') " +
							", ('100206','Deniz Yilmaz','Forward','Bursaspor','0') " +
							", ('100207','Sinan Bakis','Forward','Bursaspor','0') " +
							", ('100208','Kubilay Kanatsizkus','Forward','Bursaspor','0') " +
							", ('100209','Ismail Can Cavusluk','Forward','Bursaspor','0') ");
							
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100210','Abdoulaye Diallo','Goal Keeper','Caykur Rizespor','0')" +
							", ('100211','Alperen Uysal','Goal Keeper','Caykur Rizespor','0') " +
							", ('100212','Gokhan Akkan','Goal Keeper','Caykur Rizespor','0') " +
							", ('100213','Umit Kurt','Defence','Caykur Rizespor','0') " +
							", ('100214','Orhan Ovacikli','Defence','Caykur Rizespor','0') " +
							", ('100215','Matic Fink','Defence','Caykur Rizespor','0') " +
							", ('100216','Mohamed Ali Yaakoubi','Defence','Caykur Rizespor','0') " +
							", ('100217','Godfrey Oboabona','Defence','Caykur Rizespor','0') " +
							", ('100218','Dhurgham Ismail','Defence','Caykur Rizespor','0') " +
							", ('100219','Ali Faez Atiyah','Defence','Caykur Rizespor','0') " +
							", ('100220','Nosa Igiebor','Midfield','Caykur Rizespor','0') " +
							", ('100221','Jakob Jantscher','Midfield','Caykur Rizespor','0') " +
							", ('100222','Ozgur Cek','Midfield','Caykur Rizespor','0') " +
							", ('100223','Davide Petrucci','Midfield','Caykur Rizespor','0') " +
							", ('100224','Recep Niyaz','Midfield','Caykur Rizespor','0') " +
							", ('100225','Suleyman Koc','Midfield','Caykur Rizespor','0') " +
							", ('100226','Robin Yalcin','Midfield','Caykur Rizespor','0') " +
							", ('100227','Marwane Saadane','Midfield','Caykur Rizespor','0') " +
							", ('100229','Sinan Yazici','Midfield','Caykur Rizespor','0') " +
							", ('100230','Furkan Simsek','Midfield','Caykur Rizespor','0') " +
							", ('100231','Berat Delihasan','Midfield','Caykur Rizespor','0') " +
							", ('100232','Leonard Kweuke','Forward','Caykur Rizespor','0') " +
							", ('100233','Oguz Han Aynaoglu','Forward','Caykur Rizespor','0') " +
							", ('100234','Patrik Tuszynski','Forward','Caykur Rizespor','0') " +
							", ('100235','Brigght Edomwonyi','Forward','Caykur Rizespor','0') " +
							", ('100236','Ogulcan Caglayan','Forward','Caykur Rizespor','0') ");
							
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100237','Fabiano Ribeiro','Goal Keeper','Fenerbahce','0')" +
							", ('100238','Volkan Demirel','Goal Keeper','Fenerbahce','0') " +
							", ('100239','Ertugrul Taskiran','Goal Keeper','Fenerbahce','0') " +
							", ('100240','Anil Demir','Goal Keeper','Fenerbahce','0') " +
							", ('100241','Simon Kjaer','Defence','Fenerbahce','0') " +
							", ('100242','Gregory Van Der Wiel','Defence','Fenerbahce','0') " +
							", ('100243','Roman Neustadter','Defence','Fenerbahce','0') " +
							", ('100244','Ismail Koybasi','Defence','Fenerbahce','0') " +
							", ('100245','Sener Ozbayrakli','Defence','Fenerbahce','0') " +
							", ('100246','Hasan Ali Kaldirim','Defence','Fenerbahce','0') " +
							", ('100247','Savas Polat','Defence','Fenerbahce','0') " +
							", ('100248','Yigithan Guveli','Defence','Fenerbahce','0') " +
							", ('100249','Miroslav Stoch','Midfield','Fenerbahce','0') " +
							", ('100250','Josef De Souza','Midfield','Fenerbahce','0') " +
							", ('100251','Aatif Chahechouhe','Midfield','Fenerbahce','0') " +
							", ('100252','Mehmet Topal','Midfield','Fenerbahce','0') " +
							", ('100253','Volkan Sen','Midfield','Fenerbahce','0') " +
							", ('100254','Alper Potuk','Midfield','Fenerbahce','0') " +
							", ('100255','Salih Ucan','Midfield','Fenerbahce','0') " +
							", ('100256','Oleksandr Karavayev','Midfield','Fenerbahce','0') " +
							", ('100257','Erdi Can Sehit','Midfield','Fenerbahce','0') " +
							", ('100258','Ozan Tufan','Midfield','Fenerbahce','0') " +
							", ('100259','Ugar Mert Zeybek','Midfield','Fenerbahce','0') " +
							", ('100260','Samed Karakoc','Midfield','Fenerbahce','0') " +
							", ('100261','Robin Van Persie','Forward','Fenerbahce','0') " +
							", ('100262','Moussa Sow','Forward','Fenerbahce','0') " +
							", ('100263','Jeremain Lens','Forward','Fenerbahce','0') " +
							", ('100264','Emmanuel Emenike','Forward','Fenerbahce','0') " +
							", ('100265','Fernandao','Forward','Fenerbahce','0') ");
							
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100266','Fernando Muslera','Goal Keeper','Galatasaray','0')" +
							", ('100267','Cenk Gonen','Goal Keeper','Galatasaray','0') " +
							", ('100268','Eray Iscan','Goal Keeper','Galatasaray','0') " +
							", ('100269','Batuhan Sen','Goal Keeper','Galatasaray','0') " +
							", ('100270','Aurelien Chedjou','Defence','Galatasaray','0') " +
							", ('100271','Sabri Sarioglu','Defence','Galatasaray','0') " +
							", ('100272','Hakan Balta','Defence','Galatasaray','0') " +
							", ('100273','Semih Kaya','Defence','Galatasaray','0') " +
							", ('100274','Serdar Aziz','Defence','Galatasaray','0') " +
							", ('100275','Luis Cavanda','Defence','Galatasaray','0') " +
							", ('100276','Martin Linnes','Defence','Galatasaray','0') " +
							", ('100277','Lionel Carole','Defence','Galatasaray','0') " +
							", ('100278','Ahmet Calik','Defence','Galatasaray','0') " +
							", ('100279','Koray Gunter','Defence','Galatasaray','0') " +
							", ('100280','Soner Gonul','Defence','Galatasaray','0') " +
							", ('100281','Nigel De Jong','Midfield','Galatasaray','0') " +
							", ('100282','Wesley Sneijder','Midfield','Galatasaray','0') " +
							", ('100283','Yasin Oztekin','Midfield','Galatasaray','0') " +
							", ('100284','Josue','Midfield','Galatasaray','0') " +
							", ('100285','Selcuk Inan','Midfield','Galatasaray','0') " +
							", ('100286','Endogan Adili','Midfield','Galatasaray','0') " +
							", ('100287','Tolga Cigerci','Midfield','Galatasaray','0') " +
							", ('100288','Birhan Vatansever','Midfield','Galatasaray','0') " +
							", ('100289','Gokay Guney','Midfield','Galatasaray','0') " +
							", ('100290','Eren Derdiyok','Forward','Galatasaray','0') " +
							", ('100291','Lukas Podolski','Forward','Galatasaray','0') " +
							", ('100292','Berk Ismail Unsal','Forward','Galatasaray','0') " +
							", ('100293','Bruma','Forward','Galatasaray','0') " +
							", ('100294','Garry Rodrigues','Forward','Galatasaray','0') " +
							", ('100295','Sinan Gumus','Forward','Galatasaray','0') " +
							", ('100296','Kerem Caliskan','Forward','Galatasaray','0') ");
							
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100297','Gokhan Degirmence','Goal Keeper','Gaziantepspor','0')" +
							", ('100298','Paulo Victor','Goal Keeper','Gaziantepspor','0') " +
							", ('100299','Erten Ersu','Goal Keeper','Gaziantepspor','0') " +
							", ('100300','Adnan Karabulut','Goal Keeper','Gaziantepspor','0') " +
							", ('100301','Wallace Reis','Defence','Gaziantepspor','0') " +
							", ('100302','Senol Can','Defence','Gaziantepspor','0') " +
							", ('100303','Musa Nizam','Defence','Gaziantepspor','0') " +
							", ('100304','Elyasa Sume','Defence','Gaziantepspor','0') " +
							", ('100305','Bart Van Hintum','Defence','Gaziantepspor','0') " +
							", ('100306','Yoiver Gonzalez','Defence','Gaziantepspor','0') " +
							", ('100307','Baris Yardimci','Defence','Gaziantepspor','0') " +
							", ('100308','Marcos Pedroso','Defence','Gaziantepspor','0') " +
							", ('100309','Caner Guler','Defence','Gaziantepspor','0') " +
							", ('100310','Anis Ben Hatira','Midfield','Gaziantepspor','0') " +
							", ('100311','Marcinho','Midfield','Gaziantepspor','0') " +
							", ('100312','Muhammed Ildiz','Midfield','Gaziantepspor','0') " +
							", ('100313','Abdulkadir Kayali','Midfield','Gaziantepspor','0') " +
							", ('100314','Sergei Kislyak','Midfield','Gaziantepspor','0') " +
							", ('100315','Anton Putsila','Midfield','Gaziantepspor','0') " +
							", ('100316','Sefa Yilmaz','Midfield','Gaziantepspor','0') " +
							", ('100317','Khaly Thiam','Midfield','Gaziantepspor','0') " +
							", ('100318','Doganay Kilic','Midfield','Gaziantepspor','0') " +
							", ('100319','Mohammed Fatau','Midfield','Gaziantepspor','0') " +
							", ('100320','Orkan Cinar','Midfield','Gaziantepspor','0') " +
							", ('100321','Alpay Kocakli','Midfield','Gaziantepspor','0') " +
							", ('100322','Serkan Bakan','Midfield','Gaziantepspor','0') " +
							", ('100323','Davy Angan','Forward','Gaziantepspor','0') " +
							", ('100324','Muhammet Demir','Forward','Gaziantepspor','0') " +
							", ('100325','Ilhan Parlak','Forward','Gaziantepspor','0') " +
							", ('100326','Nabil Ghilas','Forward','Gaziantepspor','0') " +
							", ('100327','Evans Kangwa','Forward','Gaziantepspor','0') ");
					
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100328','Johannes Hopf','Goal Keeper','Genclerbirligi','0')" +
							", ('100329','Nihat Sahin','Goal Keeper','Genclerbirligi','0') " +
							", ('100330','Taha Cengiz Demirtas','Goal Keeper','Genclerbirligi','0') " +
							", ('100331','Sergei Politevich','Defence','Genclerbirligi','0') " +
							", ('100332','Orhan Sam','Defence','Genclerbirligi','0') " +
							", ('100333','Anil Karaer','Defence','Genclerbirligi','0') " +
							", ('100334','Ferhat Gorgulu','Defence','Genclerbirligi','0') " +
							", ('100335','Ugur Ciftci','Defence','Genclerbirligi','0') " +
							", ('100336','Luccas Claro','Defence','Genclerbirligi','0') " +
							", ('100337','Ahmet Oguz','Defence','Genclerbirligi','0') " +
							", ('100338','Omer Alper Tatlisu','Genclerbirligi','Defence','0') " +
							", ('100339','Selcuk Sahin','Midfield','Genclerbirligi','0') " +
							", ('100340','Aydin Karabulut','Midfield','Genclerbirligi','0') " +
							", ('100341','Umut Sozen','Midfield','Genclerbirligi','0') " +
							", ('100342','Murat Duruer','Midfield','Genclerbirligi','0') " +
							", ('100343','Marko Milinkovic','Midfield','Genclerbirligi','0') " +
							", ('100344','Serdar Gurler','Midfield','Genclerbirligi','0') " +
							", ('100345','Aleksandar Scekic','Midfield','Genclerbirligi','0') " +
							", ('100346','Abdul Khalili','Midfield','Genclerbirligi','0') " +
							", ('100347','Cosmin Matei','Midfield','Genclerbirligi','0') " +
							", ('100348','Kamal Issah','Midfield','Genclerbirligi','0') " +
							", ('100349','Bady','Midfield','Genclerbirligi','0') " +
							", ('100350','Jonathan Ring','Midfield','Genclerbirligi','0') " +
							", ('100351','Samuel Owusu','Midfield','Genclerbirligi','0') " +
							", ('100352','Baris Bozdilki','Midfield','Genclerbirligi','0') " +
							", ('100353','Agon Mehmeti','Forward','Genclerbirligi','0') " +
							", ('100354','Etien Velikonja','Forward','Genclerbirligi','0') " +
							", ('100355','Tokelo Rantie','Forward','Genclerbirligi','0') " +
							", ('100357','Vedat Muriqi','Forward','Genclerbirligi','0') ");
									
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100358','Ahmet Sahin','Goal Keeper','Kardemir Karabukspor','0')" +
							", ('100359','Ercument Kafkasyali','Goal Keeper','Kardemir Karabukspor','0') " +
							", ('100360','Oleksandr Rybka','Goal Keeper','Kardemir Karabukspor','0') " +
							", ('100361','Dany Nounkeu','Defence','Kardemir Karabukspor','0') " +
							", ('100362','Baris Basdas','Defence','Kardemir Karabukspor','0') " +
							", ('100363','Iasmin Latovlevici','Defence','Kardemir Karabukspor','0') " +
							", ('100364','Valerica Gaman','Defence','Kardemir Karabukspor','0') " +
							", ('100365','Paul Papp','Defence','Kardemir Karabukspor','0') " +
							", ('100366','Osman Celik','Defence','Kardemir Karabukspor','0') " +
							", ('100367','Mahmut Akan','Defence','Kardemir Karabukspor','0') " +
							", ('100368','Ugurcan Yasin Tabak','Defence','Kardemir Karabukspor','0') " +
							", ('100369','Tayyib Talha Sanuc','Defence','Kardemir Karabukspor','0') " +
							", ('100370','Can Sikilmaz','Defence','Kardemir Karabukspor','0') " +
							", ('100371','Fatih Atik','Midfield','Kardemir Karabukspor','0') " +
							", ('100372','Abdou Traore','Midfield','Kardemir Karabukspor','0') " +
							", ('100373','Olafur Skulason','Midfield','Kardemir Karabukspor','0') " +
							", ('100374','Ceyhun Gulselam','Midfield','Kardemir Karabukspor','0') " +
							", ('100375','Kerim Zengin','Midfield','Kardemir Karabukspor','0') " +
							", ('100376','Cristian Tanase','Midfield','Kardemir Karabukspor','0') " +
							", ('100377','Ilhan Depe','Midfield','Kardemir Karabukspor','0') " +
							", ('100378','Ishak Dogan','Midfield','Kardemir Karabukspor','0') " +
							", ('100379','Andre Polo','Midfield','Kardemir Karabukspor','0') " +
							", ('100380','Dejan Lazarevic','Forward','Kardemir Karabukspor','0') " +
							", ('100381','Mustapha Yatabare','Forward','Kardemir Karabukspor','0') " +
							", ('100382','Evgen Seleznyov','Forward','Kardemir Karabukspor','0') " +
							", ('100383','Serdar Deliktas','Forward','Kardemir Karabukspor','0') " +
							", ('100384','Ermic Zec','Forward','Kardemir Karabukspor','0') " +
							", ('100385','Andrey Bliznichenko','Forward','Kardemir Karabukspor','0') " +
							", ('100386','Arif Bostanci','Forward','Kardemir Karabukspor','0') ");
						
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100387','Ramazan Kose','Goal Keeper','Kasimpasa','0')" +
							", ('100388','Eray Birnican','Goal Keeper','Kasimpasa','0') " +
							", ('100389','Kadem Burak Yasar','Goal Keeper','Kasimpasa','0') " +
							", ('100390','Emirhan Emir','Goal Keeper','Kasimpasa','0') " +
							", ('100391','Olivier Veigneau','Defence','Kasimpasa','0') " +
							", ('100392','Cristian Titi','Defence','Kasimpasa','0') " +
							", ('100393','Veysel Sari','Defence','Kasimpasa','0') " +
							", ('100394','Strahil Popov','Defence','Kasimpasa','0') " +
							", ('100395','Vasil Bozhikov','Defence','Kasimpasa','0') " +
							", ('100396','Loret Sadiku','Defence','Kasimpasa','0') " +
							", ('100397','Kenneth Otigba','Defence','Kasimpasa','0') " +
							", ('100398','Onur Ural','Defence','Kasimpasa','0') " +
							", ('100399','Burak Turan','Defence','Kasimpasa','0') " +
							", ('100400','Herolind Shala','Midfield','Kasimpasa','0') " +
							", ('100401','Abdullah Durak','Midfield','Kasimpasa','0') " +
							", ('100402','Andre Castro','Midfield','Kasimpasa','0') " +
							", ('100403','David Pavelka','Midfield','Kasimpasa','0') " +
							", ('100404','Cristian Guanca','Midfield','Kasimpasa','0') " +
							", ('100405','Kubilay Akyuz','Midfield','Kasimpasa','0') " +
							", ('100406','Hakan Demir','Midfield','Kasimpasa','0') " +
							", ('100407','Hasan Bilal','Midfield','Kasimpasa','0') " +
							", ('100408','Arda Kursat Kaya','Midfield','Kasimpasa','0') " +
							", ('100409','Ahmed Ildiz','Midfield','Kasimpasa','0') " +
							", ('100410','Tunay Torun','Forward','Kasimpasa','0') " +
							", ('100411','Bengali Koita','Forward','Kasimpasa','0') " +
							", ('100412','Adem Buyuk','Forward','Kasimpasa','0') " +
							", ('100413','Turgut Dogan Sahin','Forward','Kasimpasa','0') " +
							", ('100414','Franck Etoundi','Forward','Kasimpasa','0') " +
							", ('100415','Batuhan Altintas','Forward','Kasimpasa','0') " +
							", ('100416','Samuel Eduok','Forward','Kasimpasa','0') " +
							", ('100417','Ali Gocmen','Forward','Kasimpasa','0') ");
				
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100418','Muammer Yildirim','Goal Keeper','Kayserispor','0')" +
							", ('100419','Ali Ahamada','Goal Keeper','Kayserispor','0') " +
							", ('100420','Vedat Karakus','Goal Keeper','Kayserispor','0') " +
							", ('100421','Larrys Mabiala','Defence','Kayserispor','0') " +
							", ('100422','Douglao','Defence','Kayserispor','0') " +
							", ('100423','Jean Armel Kana Biyik','Defence','Kayserispor','0') " +
							", ('100424','Hakan Aslantas','Defence','Kayserispor','0') " +
							", ('100425','Efe Halil Ozarslan','Defence','Kayserispor','0') " +
							", ('100426','Levent Gulen','Defence','Kayserispor','0') " +
							", ('100427','Miladin Stevanovic','Defence','Kayserispor','0') " +
							", ('100428','Devlet Karatas','Defence','Kayserispor','0') " +
							", ('100429','Landry NGuemo','Midfield','Kayserispor','0') " +
							", ('100430','Samba Sow','Midfield','Kayserispor','0') " +
							", ('100431','Alain Traore','Midfield','Kayserispor','0') " +
							", ('100432','Guray Vural','Midfield','Kayserispor','0') " +
							", ('100433','Erkan Kas','Midfield','Kayserispor','0') " +
							", ('100434','Rajko Rotman','Midfield','Kayserispor','0') " +
							", ('100435','Deniz Turuc','Midfield','Kayserispor','0') " +
							", ('100436','Raheem Lawal','Midfield','Kayserispor','0') " +
							", ('100437','Kubilay Sonmez','Midfield','Kayserispor','0') " +
							", ('100438','Umut Sonmez','Midfield','Kayserispor','0') " +
							", ('100439','Erdem Onur Beytas','Midfield','Kayserispor','0') " +
							", ('100440','Kerim Can Guzeldal','Midfield','Kayserispor','0') " +
							", ('100441','Ryan Mendes','Forward','Kayserispor','0') " +
							", ('100442','Welliton Soares','Forward','Kayserispor','0') " +
							", ('100443','Silvestre Varela','Forward','Kayserispor','0') " +
							", ('100444','Umut Bulut','Forward','Kayserispor','0') ");
										
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100445','Volkan Babacan','Goal Keeper','Medipol Basaksehir','0')" +
							", ('100446','Ufuk Ceylan','Goal Keeper','Medipol Basaksehir','0') " +
							", ('100447','Faruk Cakir','Goal Keeper','Medipol Basaksehir','0') " +
							", ('100448','Ahmet Said Kivanc','Goal Keeper','Medipol Basaksehir','0') " +
							", ('100449','Alexandu Epureanu','Defence','Medipol Basaksehir','0') " +
							", ('100450','Egemen Korkmaz','Defence','Medipol Basaksehir','0') " +
							", ('100451','Ferhat Oztorun','Defence','Medipol Basaksehir','0') " +
							", ('100452','Bekir Irtegun','Defence','Medipol Basaksehir','0') " +
							", ('100453','Alparslan Erdem','Defence','Medipol Basaksehir','0') " +
							", ('100454','Ugur Ucar','Defence','Medipol Basaksehir','0') " +
							", ('100455','Yalcin Ayhan','Defence','Medipol Basaksehir','0') " +
							", ('100456','Junior Ciacara','Defence','Medipol Basaksehir','0') " +
							", ('100457','Joseph Attamah','Defence','Medipol Basaksehir','0') " +
							", ('100458','Samuel Holmen','Midfield','Medipol Basaksehir','0') " +
							", ('100459','Marcio Mossoroo','Midfield','Medipol Basaksehir','0') " +
							", ('100460','Emre Belozoglu','Midfield','Medipol Basaksehir','0') " +
							", ('100461','Eren Albayrak','Midfield','Medipol Basaksehir','0') " +
							", ('100462','Mahmut Tekdemir','Midfield','Medipol Basaksehir','0') " +
							", ('100463','Hakan Ozmert','Midfield','Medipol Basaksehir','0') " +
							", ('100464','Doka Madureira','Midfield','Medipol Basaksehir','0') " +
							", ('100465','Edin Visca','Midfield','Medipol Basaksehir','0') " +
							", ('100466','Irfan Can Kahveci','Midfield','Medipol Basaksehir','0') " +
							", ('100467','Cengiz Under','Midfield','Medipol Basaksehir','0') " +
							", ('100468','Emmanuel Adebayor','Forward','Medipol Basaksehir','0') " +
							", ('100469','Stefano Napoleoni','Forward','Medipol Basaksehir','0') " +
							", ('100470','Mustafa Pektemek','Forward','Medipol Basaksehir','0') " +
							", ('100471','Mehmet Batdal','Forward','Medipol Basaksehir','0') ");
							
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
					"VALUES    ('100472','Hakan Arikan','Goal Keeper','Osmanlispor','0')" +
							", ('100473','Zydrunas Karcemarskas','Goal Keeper','Osmanlispor','0') " +
							", ('100474','Ahmet Eyup Turkaslan','Goal Keeper','Osmanlispor','0') " +
							", ('100475','Taha Ayan','Goal Keeper','Osmanlispor','0') " +
							", ('100476','Lukasz Szukala','Defence','Osmanlispor','0') " +
							", ('100477','Tiago Pinto','Defence','Osmanlispor','0') " +
							", ('100478','Aykut Demir','Defence','Osmanlispor','0') " +
							", ('100479','Numan Curuksu','Defence','Osmanlispor','0') " +
							", ('100480','Muhammed Bayir','Defence','Osmanlispor','0') " +
							", ('100481','Vaclav Prochazka','Defence','Osmanlispor','0') " +
							", ('100482','Avdija Vrsajevic','Defence','Osmanlispor','0') " +
							", ('100483','Koray Altinay','Defence','Osmanlispor','0') " +
							", ('100484','Yalcin Eycan Kaya','Defence','Osmanlispor','0') " +
							", ('100485','Ramazan Yucel','Defence','Osmanlispor','0') " +
							", ('100486','Mehmet Guven','Midfield','Osmanlispor','0') " +
							", ('100487','Erdal Kilicaslan','Midfield','Osmanlispor','0') " +
							", ('100488','Musa Cagiran','Midfield','Osmanlispor','0') " +
							", ('100489','Adrien Regattin','Midfield','Osmanlispor','0') " +
							", ('100490','Luiz Carlos','Midfield','Osmanlispor','0') " +
							", ('100491','Adam Maher','Midfield','Osmanlispor','0') " +
							", ('100492','Engin Bekdemir','Midfield','Osmanlispor','0') " +
							", ('100493','Tugay Kacar','Midfield','Osmanlispor','0') " +
							", ('100494','Badou Ndiaye','Midfield','Osmanlispor','0') " +
							", ('100495','Sinan Kurt','Midfield','Osmanlispor','0') " +
							", ('100496','Furkan Polat','Midfield','Osmanlispor','0') " +
							", ('100497','Pierre Webo','Forward','Osmanlispor','0') " +
							", ('100498','Raul Rusescu','Forward','Osmanlispor','0') " +
							", ('100499','Thievy Bifouma','Forward','Osmanlispor','0') " +
							", ('100500','Dzon Delarge','Forward','Osmanlispor','0') " +
							", ('100501','Aminu Umar','Forward','Osmanlispor','0') ");
	
	statement.executeUpdate("INSERT INTO Player (player_id, name, position, team, value)" + 
			"VALUES    ('100502','Onur Kivrak','Goal Keeper','Trabzonspor','0')" +
					", ('100503','Esteban Alvarado','Goal Keeper','Trabzonspor','0') " +
					", ('100504','Ugurcan Cakir','Goal Keeper','Trabzonspor','0') " +
					", ('100505','Carl Medjani','Defence','Trabzonspor','0') " +
					", ('100506','Jan Durica','Defence','Trabzonspor','0') " +
					", ('100507','Joao Pereira','Defence','Trabzonspor','0') " +
					", ('100508','Ugur Demirok','Defence','Trabzonspor','0') " +
					", ('100509','Luis Ibanez','Defence','Trabzonspor','0') " +
					", ('100510','Mustafa Akbas','Defence','Trabzonspor','0') " +
					", ('100511','Zeki Yavru','Defence','Trabzonspor','0') " +
					", ('100512','Emmanuel Mas','Defence','Trabzonspor','0') " +
					", ('100513','Yusuf Erdogan','Midfield','Trabzonspor','0') " +
					", ('100514','Okay Yokuslu','Midfield','Trabzonspor','0') " +
					", ('100515','Mehmet Ekici','Midfield','Trabzonspor','0') " +
					", ('100516','Aytac Kara','Midfield','Trabzonspor','0') " +
					", ('100517','Ogenyi Onazi','Midfield','Trabzonspor','0') " +
					", ('100518','Abdulkadir Omur','Midfield','Trabzonspor','0') " +
					", ('100519','Yusuf Yazici','Midfield','Trabzonspor','0') " +
					", ('100520','Hugo Rodallega','Forward','Trabzonspor','0') " +
					", ('100521','Dame NDoye','Forward','Trabzonspor','0') " +
					", ('100522','Olcay Sahan','Forward','Trabzonspor','0') " +
					", ('100523','Fabian Castillo','Forward','Trabzonspor','0') " +
					", ('100524','Matus Bero','Forward','Trabzonspor','0') ");
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			statement.executeUpdate("INSERT INTO User (user_id, name, birth_date,password)" + 
					"VALUES    ('0','ADMIN','0000-01-01','123456')" );
			statement.executeUpdate("INSERT INTO Statistics (player_id, no_of_games, no_of_goals, no_of_assists, no_of_passes, no_of_shoots )" + 
					"VALUES    ('100522','20','5','10','500','38')" +
							   ", ('100295','20','10','10','500','38')" +
							   ", ('100173','20','6','10','500','38')" +
							   ", ('100175','20','20','10','500','38')" +
							   ", ('100174','20','15','10','500','38')");
			
			//Secondary Indices
			statement.executeUpdate("ALTER TABLE Player ADD INDEX pName (name)");
			statement.executeUpdate("ALTER TABLE Team ADD INDEX tName (name)");
			statement.executeUpdate("ALTER TABLE Coach ADD INDEX cName (name)");
			
			ResultSet rs = statement.executeQuery("SELECT * FROM Player"); //Result For Player Table
	
			System.out.println("Player Table");
			while(rs.next()){
				System.out.println(rs.getString("player_id") + " " + rs.getString("name") + " " + rs.getString("position") + " " + rs.getString("team") + " " + rs.getString("value"));
			}
			System.out.println();
			
			ResultSet rs1 = statement.executeQuery("SELECT * FROM Team"); //Result For Team Table
			
			System.out.println("Team Table");
			while(rs1.next()){
				System.out.println(rs1.getString("team_id") + " " + rs1.getString("name") + " " + rs1.getString("stadium") + " " + rs1.getString("colors") + " " + rs1.getString("date_of_establish") + " " + rs1.getString("city") + " " + rs1.getString("budget")  + " " + rs1.getString("overall_wage"));
			}
			System.out.println();
			
			ResultSet rs2 = statement.executeQuery("SELECT * FROM User"); //Result For User Table
			
			System.out.println("User Table");
			while(rs2.next()){
				System.out.println(rs2.getString("user_id") + " " + rs2.getString("name") + " " + rs2.getString("birth_date")+ " " + rs2.getString("password"));
			}
			System.out.println();
			
			
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

}
