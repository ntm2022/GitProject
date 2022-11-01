import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNews {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            URLConnection conn = url.openConnection();

            InputStream stream = conn.getInputStream();
            InputStreamReader ir = new InputStreamReader(stream);

            BufferedReader reader = new BufferedReader(ir);

            String line;
            String content = null;
            while((line = reader.readLine()) != null){
                /*System.out.println(line);*/
                content += line;
            }
            reader.close();

            Pattern p = Pattern.compile("article-title\">(.*?)</a>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(1));
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}