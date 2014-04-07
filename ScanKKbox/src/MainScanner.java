import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainScanner {
	
	static String str = null;
	static String[] Songs = null;
	static String[] Artist = null;
	static int no = 0;
	static boolean flag = false;
//	1
	public static void main(String[] arg) throws Exception {
		
		String chinese_kkbox = "http://www.kkbox.com/tw/tc/charts/chinese-index.html";
		String western_kkbox = "http://www.kkbox.com/tw/tc/charts/western-index.html";
		String japanese_kkbox = "http://www.kkbox.com/tw/tc/charts/japanese-index.html";
		String korean_kkbox = "http://www.kkbox.com/tw/tc/charts/korean-index.html";
		String hokkien_kkbox = "http://www.kkbox.com/tw/tc/charts/hokkien-index.html";
		String cantonese_kkbox = "http://www.kkbox.com/tw/tc/charts/cantonese-index.html";
		
//		gotYou(chinese_kkbox, "華語");
//		gotYou(western_kkbox, "西洋");
//		gotYou(japanese_kkbox, "日語");
//		gotYou(korean_kkbox, "韓語");
//		gotYou(hokkien_kkbox, "台語");
//		gotYou(cantonese_kkbox, "粵語");
		
		
		//華語單曲月榜
		String chinese_kkbox_100 = "http://www.kkbox.com/tw/tc/charts/chinese-monthly-song-latest.html";
		gotYou(chinese_kkbox_100, "華語");

		String htifm50 = "http://www.hitoradio.com/newweb/chart_2.php?ch_year=2013&pageNum_rsList=0";
        gotYou(htifm50, "華語");

		
	}
	
	/**
	 * 取得各語系排行榜
	 * @param link
	 * @param language
	 */
	private static void gotYou(String link, String language){
		try {
			URL url_address = new URL(link);
			BufferedReader br = new BufferedReader(new InputStreamReader(url_address.openStream(),"UTF-8"));
			System.out.println("printData2");
			
//			//test
			FileWriter fw = new FileWriter("hitfm.txt");
			
			while ((str = br.readLine()) != null) {

//				flag = printTitle(language + "單曲日榜", "	KKBOX-" + language + "單曲日榜 ", false);
//				flag = printTitle(language + "單曲週榜", "	KKBOX-" + language + "單曲週榜 ", false);
//				flag = printTitle(language + "單曲月榜", "	KKBOX-" + language + "單曲月榜", true);
//				flag = printTitle("song-latest.html\">完整 Top 100 榜單", "", false);
//				printData();
//
//				flag = printTitle(language + "單曲月榜", "	KKBOX-" + language + "單曲月榜", true);
//				printData2();
				
				//test
				fw.write(str+"\n");
			}
//			
//			fw.flush();
//			fw.close();
				
				
				
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	/**
	 * 標題
	 * @param check
	 * @param title
	 */
	private static boolean printTitle(String check, String title, boolean isPrint){
		if (str.contains(check)) {
			no = 0;
			System.out.println(title);
			return isPrint;
		}
		
		return flag;
	}
	
	/**
	 * 歌手+歌曲
	 */
	private static void printData(){
		if(flag == true){
			if (str.contains("<h4 class=")) {
				Songs = str.split("title=\"");
				Songs = Songs[1].split("\">");
			}
			if (str.contains("<h5 class=")) {
				Artist = str.split("title=\"");
				Artist = Artist[1].split("\">");
			}
			
			if(Artist != null && Songs != null){
				System.out.println("No."+ ++no + ": "+Artist[0] + " ----- " + Songs[0]);
				Songs = null;
				Artist = null;
			}
		}
	}
	
	
	/**
	 * 華語單曲日榜 Top 100
	 */
	private static void printData2(){
		
//		System.out.println(str);
		

		if(flag == true){
			if (str.contains("<h4><a href=")) {
				Songs = str.split("title=\"");
				Songs = Songs[1].split("\">");
			}
			if (str.contains("<h5 class=")) {
				Artist = str.split("title=\"");
				Artist = Artist[1].split("\">");
			}
			
			if(Artist != null && Songs != null){
				System.out.println("No."+ ++no + ": "+Artist[0] + " ----- " + Songs[0]);
				Songs = null;
				Artist = null;
			}
		}
	}
}