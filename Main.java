import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {
	//Data Place: https://www.sports-reference.com/cbb/boxscores/index.cgi?month=2&day=18&year=2021
	String link = "https://www.sports-reference.com/cbb/boxscores/index.cgi?month=2&day=1&year=2021";
	String link_part_1 = "https://www.sports-reference.com/cbb/boxscores/index.cgi?month=";
	String link_part_2 = "&day=";
	String link_part_3 = "&year=";
	ArrayList<Data> Data_List = new ArrayList<>();
	public Main() throws Exception{
		System.setProperty("http.agent", "Chrome");
		//System.out.println("\"John\"");
		for(int i = 1;i < 20;i++){
			link = link_part_1 + "2" + link_part_2 + Integer.toString(i) + link_part_3 + "2021";
			test();
			//System.out.println(Data_List.size());
		}
		//test();
		System.out.println("WINNER,LOSER,WINNER_SCORE,LOSER_SCORE");
		for(int i = 0;i < Data_List.size();i++){
			System.out.println(Data_List.get(i).winner + "," + Data_List.get(i).loser + "," + Data_List.get(i).winnerScore + "," + Data_List.get(i).loserScore);
		}
	}
	private void test() throws Exception{
		URL url = new URL(link);
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = null;
		int tracker = 0;
		String winner = "", winnerScore = "", loser = "", loserScore = "";
		String test = "";
		while((line = br.readLine()) != null){
			if(line.contains("<tbody>")){
				test = br.readLine();
				if(test.contains("loser")){
					loser = br.readLine();
					loser = loser.replaceAll("\\s", "");
					loser = loser.substring(4, loser.length());
					tracker = 0;
					for(int i = 0;i < loser.length();i++){
						tracker++;
						if(loser.charAt(i) == '>'){
							break;
						}
					}
					loser = loser.substring(tracker, loser.length());
					tracker = 0;
					for(int i = 0;i < loser.length();i++){
						tracker++;
						if(loser.charAt(i) == '<'){
							break;
						}
					}		
					loser = loser.substring(0,tracker-1);
					//Getting Loser Score
					loserScore = br.readLine();
					loserScore = loserScore.replaceAll("\\s", "");
					loserScore = loserScore.substring(17, loserScore.length());	
					tracker = 0;
					for(int i = 0;i < loserScore.length();i++){
						tracker++;
						if(loserScore.charAt(i) == '<'){
							break;
						}						
					}
					loserScore = loserScore.substring(0,tracker-1);
					//Getting the Winner
					for(int i = 0;i < 7;i++){
						winner = br.readLine();
					}
					winner = winner.replaceAll("\\s", "");
					winner = winner.substring(4, winner.length());
					tracker = 0;
					for(int i = 0;i < winner.length();i++){
						tracker++;
						if(winner.charAt(i) == '>'){
							break;
						}
					}
					winner = winner.substring(tracker, winner.length());
					tracker = 0;
					for(int i = 0;i < winner.length();i++){
						tracker++;
						if(winner.charAt(i) == '<'){
							break;
						}
					}		
					winner = winner.substring(0,tracker-1);
					//Getting the Winner Score
					winnerScore = br.readLine();
					winnerScore = winnerScore.replaceAll("\\s", "");
					winnerScore = winnerScore.substring(17, winnerScore.length());	
					tracker = 0;
					for(int i = 0;i < winnerScore.length();i++){
						tracker++;
						if(winnerScore.charAt(i) == '<'){
							break;
						}						
					}
					winnerScore = winnerScore.substring(0,tracker-1);
					Data_List.add(new Data(winner,loser,winnerScore,loserScore));
				}
				if(test.contains("winner")){
					winner = br.readLine();
					winner = winner.replaceAll("\\s", "");
					winner = winner.substring(4, winner.length());
					tracker = 0;
					for(int i = 0;i < winner.length();i++){
						tracker++;
						if(winner.charAt(i) == '>'){
							break;
						}
					}
					winner = winner.substring(tracker, winner.length());
					tracker = 0;
					for(int i = 0;i < winner.length();i++){
						tracker++;
						if(winner.charAt(i) == '<'){
							break;
						}
					}		
					winner = winner.substring(0,tracker-1);
					//Getting Loser Score
					winnerScore = br.readLine();
					winnerScore = winnerScore.replaceAll("\\s", "");
					winnerScore = winnerScore.substring(17, winnerScore.length());	
					tracker = 0;
					for(int i = 0;i < winnerScore.length();i++){
						tracker++;
						if(winnerScore.charAt(i) == '<'){
							break;
						}						
					}
					winnerScore = winnerScore.substring(0,tracker-1);
					//Getting the Winner
					for(int i = 0;i < 7;i++){
						loser = br.readLine();
					}
					loser = loser.replaceAll("\\s", "");
					loser = loser.substring(4, loser.length());
					tracker = 0;
					for(int i = 0;i < loser.length();i++){
						tracker++;
						if(loser.charAt(i) == '>'){
							break;
						}
					}
					loser = loser.substring(tracker, loser.length());
					tracker = 0;
					for(int i = 0;i < loser.length();i++){
						tracker++;
						if(loser.charAt(i) == '<'){
							break;
						}
					}		
					loser = loser.substring(0,tracker-1);
					//Getting the Winner Score
					loserScore = br.readLine();
					loserScore = loserScore.replaceAll("\\s", "");
					loserScore = loserScore.substring(17, loserScore.length());	
					tracker = 0;
					for(int i = 0;i < loserScore.length();i++){
						tracker++;
						if(loserScore.charAt(i) == '<'){
							break;
						}						
					}
					loserScore = loserScore.substring(0,tracker-1);
					Data_List.add(new Data(winner,loser,winnerScore,loserScore));
				}				
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Main main = new Main();
	}
}
class Data{
	String winner,loser;
	int winnerScore,loserScore;
	public Data(String w,String l, String ws,String ls){
		winner = w;
		loser = l;
		winnerScore = Integer.parseInt(ws);
		loserScore = Integer.parseInt(ls);
	}
}
