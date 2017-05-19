
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
					"(user_id FLOAT, name VARCHAR(20), birth_date DATE, PRIMARY KEY(user_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Coach" +
					"(coach_id FLOAT, name VARCHAR(20), birth_date DATE, salary FLOAT, PRIMARY KEY(coach_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Player" +
					"(player_id FLOAT, name VARCHAR(20), position VARCHAR(20), player_team VARCHAR(20), value FLOAT, PRIMARY KEY(player_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Agent" +
					"(agent_id FLOAT, name VARCHAR(20), position VARCHAR(20), PRIMARY KEY(agent_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Admin" +
					"(admin_id FLOAT, name VARCHAR(20), position VARCHAR(20), PRIMARY KEY(admin_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Post" +
					"(post_id FLOAT, text VARCHAR(512), date DATE, PRIMARY KEY(post_id))ENGINE=INNODB;");
			statement.executeUpdate("CREATE TABLE Statistics" +
					"(user_id FLOAT, no_of_games INT, no_of_goals INT, no_of_assists INT, no_of_passes INT, no_of_shoots INT,PRIMARY KEY(user_id))ENGINE=INNODB;");
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
					"(post_id FLOAT, user_id FLOAT, text VARCHAR(512), date DATE,PRIMARY KEY(post_id), FOREIGN KEY(post_id) REFERENCES Post(post_id), FOREIGN KEY(user_id) REFERENCES User(user_id))ENGINE=INNODB;");
			
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
			
			statement.executeUpdate("INSERT INTO Player (player_id, name, position, player_team, value)" + 
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
							", ('100159','Ricardo Quaresma','Midfield','Besiktas','0') " +
							", ('100160','Gokhan Inler','Midfield','Besiktas','0') " +
							", ('100161','Atiba Hutchinson','Midfield','Besiktas','0') " +
							", ('100162','Veli Kavlak','Midfield','Besiktas','0') " +
							", ('100163','Necip Uysal','Midfield','Besiktas','0') " +
							", ('100164','Tolgay Arslan','Midfield','Besiktas','0') " +
							", ('100165','Aras Ozbiliz','Midfield','Besiktas','0') " +
							", ('100166','Oguzhan Ozyakup','Midfield','Besiktas','0') " +
							", ('100167','Anderson Talisca','Midfield','Besiktas','0') " +
							", ('100168','Muhammed Enes Durmus','Midfield','Besiktas','0') " +
							", ('100169','Sedat Sahinturk','Midfield','Besiktas','0') " +
							", ('100170','Oguzhan Aydogan','Midfield','Besiktas','0') " +
							", ('100171','Ryan Babel','Forward','Besiktas','0') " +
							", ('100172','Demba Ba','Forward','Besiktas','0') " +
							", ('100173','Omer Sismanoglu','Forward','Besiktas','0') " +
							", ('100174','Cenk Tosun','Forward','Besiktas','0') " +
							", ('100175','Vincent Aboubakar','Forward','Besiktas','0') ");



			statement.executeUpdate("INSERT INTO Player (player_id, name, position, player_team, value)" + 
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
			
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			ResultSet rs = statement.executeQuery("SELECT * FROM Player"); //Result For Player Table
	
			System.out.println("Player Table");
			while(rs.next()){
				System.out.println(rs.getString("player_id") + " " + rs.getString("name") + " " + rs.getString("position") + " " + rs.getString("player_team") + " " + rs.getString("value"));
			}
			System.out.println();
			
			ResultSet rs1 = statement.executeQuery("SELECT * FROM Team"); //Result For Team Table
			
			System.out.println("Team Table");
			while(rs1.next()){
				System.out.println(rs1.getString("team_id") + " " + rs1.getString("name") + " " + rs1.getString("stadium") + " " + rs1.getString("colors") + " " + rs1.getString("date_of_establish") + " " + rs1.getString("city") + " " + rs1.getString("budget")  + " " + rs1.getString("overall_wage"));
			}
			System.out.println();
			
			
			
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}

}
