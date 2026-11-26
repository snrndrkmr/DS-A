package com.util;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;

public class Solution {
    /*
     * Complete the function below.
     * Base url: https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */

    static String[] getMovieTitles(String substr) {
        int first_page = 1;
        int total_pages = Integer.MAX_VALUE;
        ArrayList<String> title = new ArrayList<String>();
        Pattern totalPagesPattern = Pattern.compile("\"total_pages\"\\s*:\\s*(\\d+)");
        Pattern titlePattern = Pattern.compile("\"Title\"\\s*:\\s*\"((?:\\\\.|[^\"\\\\])*)\"");
        while(first_page <= total_pages){
            try{
                URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page="+first_page);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestMethod("GET");
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder response = new StringBuilder();
                String result;
                while((result = br.readLine())!=null){
                    response.append(result);
                }
                br.close();
                Matcher pagesMatcher = totalPagesPattern.matcher(response);
                if (pagesMatcher.find()) {
                    total_pages = Integer.parseInt(pagesMatcher.group(1));
                }
                Matcher titleMatcher = titlePattern.matcher(response);
                while (titleMatcher.find()) {
                    title.add(unescapeJsonString(titleMatcher.group(1)));
                }
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

    private static String unescapeJsonString(String value) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char current = value.charAt(i);
            if (current != '\\' || i + 1 >= value.length()) {
                result.append(current);
                continue;
            }
            char escaped = value.charAt(++i);
            switch (escaped) {
                case '"': result.append('"'); break;
                case '\\': result.append('\\'); break;
                case '/': result.append('/'); break;
                case 'b': result.append('\b'); break;
                case 'f': result.append('\f'); break;
                case 'n': result.append('\n'); break;
                case 'r': result.append('\r'); break;
                case 't': result.append('\t'); break;
                case 'u':
                    if (i + 4 < value.length()) {
                        result.append((char) Integer.parseInt(value.substring(i + 1, i + 5), 16));
                        i += 4;
                    }
                    break;
                default: result.append(escaped);
            }
        }
        return result.toString();
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
