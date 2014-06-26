//HW4
import java.io.*;
import java.net.URL;
import org.json.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;
import java.lang.*;
import java.nio.channels.*;

public class TocHw4 {
       public static void read( String strURL ) {
        int chunksize = 4096;
        byte[] chunk = new byte[chunksize];
        int count;
        try  {    
            URL pageUrl = new URL(strURL );       
            // 讀入網頁(位元串流)
            BufferedInputStream bis = new BufferedInputStream(pageUrl.openStream());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("data.json", false));
            //System.out.println("read1() running " );
            while ((count = bis.read(chunk, 0, chunksize)) != -1) {
                bos.write(chunk, 0, count); // 寫入檔案
            }
            bos.close();
            bis.close();
          //System.out.println("Done");   
         }catch (IOException e) {
             e.printStackTrace();
         }
      }
	public static void main(String[] args) throws JSONException, IOException {
        URL dataURL = new URL(args[0] + "?fields=總價元,交易年月,土地區段位置或建物區門牌");
        read(dataURL);

    }

}
