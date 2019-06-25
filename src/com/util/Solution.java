package com.util;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;
import com.google.gson.*;

public class Solution {
    /*
     * Complete the function below.
     * Base url: https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */

    static String[] getMovieTitles(String substr) {
        int first_page = 1;
        int total_pages = Integer.MAX_VALUE;
        ArrayList<String> title = new ArrayList<String>();
        while(first_page <= total_pages){
            try{
                URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page="+first_page);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String result;
                while((result = br.readLine())!=null){
                    JsonObject  jobj = new Gson().fromJson(result, JsonObject.class);
                    total_pages = jobj.get("total_pages").getAsInt();
                    JsonArray data = jobj.getAsJsonArray("data");
                    for(int i=0;i<data.size();i++){
                        String Title = data.get(i).getAsJsonObject().get("Title").getAsString();
                        title.add(Title);
                    }
                }
                br.close();
                first_page++;
            }
            catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }
        Collections.sort(title);
        return title.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }
        
        res = getMovieTitles(_substr);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        
        bw.close();
    }
}
