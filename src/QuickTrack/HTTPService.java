/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickTrack;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.client.methods.HttpGet;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.codec.binary.Base64;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.codec.EncoderException;
*/

/**
 * HTTP Service.
 * This is the outbound service to our remote server.
 * 
 * Available endpoints:
 *  login
 *  getDetails
 *  addTask
 * 
 * @author David Regimbal, Aras Masalaitis, Jesse Wasko, Sumedh Savanur, Gauri Khawadkar <bk.psu.edu>
 */
public class HTTPService {
    
    // local store and initialize
    public static String access_token = "";
    public static String server_url = "";
    
    /**
     * Login Service.
     * Request the server to login a user. 
     * 
     * @param serverUrl
     * @param username
     * @param password
     * @return JSONObject callback
     * @throws ClientProtocolException
     * @throws IOException 
     */
    public JSONObject login(String serverUrl, String username, String password) throws ClientProtocolException, IOException
    { 
        
        JSONObject callback = new JSONObject();
        
        // set the server_url and localstorage
        server_url = serverUrl;
        
        // Connect out to the server URL
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(serverUrl + "/login");
        StringEntity input = new StringEntity("{\"username\":\""+username+"\",\"password\":\""+password+"\"}");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
         
         callback = new JSONObject(line);
         if("error".equals(callback.getString("status")))
         {
             // Login failed
         }
         else
         {
             // Login success; Set and store the access token
             JSONObject data = (JSONObject) callback.get("response");
             access_token = data.getString("token");

         }
         
         return callback;

        }
        
        // Promise
        return callback;
           
    }
    
    /**
     * Register Service.
     * Create a new account and log them in
     * 
     * @param serverUrl
     * @param serverKey
     * @param username
     * @param password
     * @param email
     * @return JSONObject callback
     * @throws org.apache.http.client.ClientProtocolException 
     */
    public JSONObject register(String serverUrl, String serverKey, String username, String password, String email) throws ClientProtocolException, IOException
    {
        JSONObject callback = new JSONObject();
        
        // set the server_url and localstorage
        server_url = serverUrl;
        
        // Connect out to the server URL
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(serverUrl + "/register");
        StringEntity input = new StringEntity("{\"username\":\""+username+"\",\"password\":\""+password+"\",\"email\":\""+email+"\",\"key\":\""+serverKey+"\"}");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
         
         callback = new JSONObject(line);
         if("error".equals(callback.getString("status")))
         {
             // Register failed
         }
         else
         {
             // Register success; Set and store the access token
             JSONObject data = (JSONObject) callback.get("response");
             access_token = data.getString("token");

         }
         
         return callback;

        }
        
        // Promise
        return callback;
    }
    
    /**
     * addTask.
     * Create a new account and log them in
     * 
     * @return JSONObject callback
     * @throws org.apache.http.client.ClientProtocolException 
     */
    public static String addTask(String name, String description, String date, Boolean notify) throws ClientProtocolException, IOException
    {
        
        // Connect out to the server URL
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(server_url + "/queryInsert");
        StringEntity input = new StringEntity("{\"table\": \"tasks\", \"data\": { \"name\": \""+name+"\", \"description\": \""+description+"\"  }}");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
         
         JSONObject callback = new JSONObject(line);
         if("error".equals(callback.getString("status")))
         {
             // Register failed
         }
         else
         {
             // Register success; Set and store the access token
             //JSONObject data = (JSONObject) callback.get("response");
             //access_token = data.getString("token");

         }
         
         //return callback;
         return callback.get("response").toString();

        }
        
        // Promise
        //return callback;
        return "";
    }
 
    public static JSONObject getTask(int id) throws IOException
    {
        
        JSONObject callback = new JSONObject();
        
        // Connect out to the server URL
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(server_url + "/querySelect");
        StringEntity input = new StringEntity("{\"table\": \"tasks\", \"where\":{ \"id\":"+id+"}}");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
         
         return new JSONObject(line);

        }
        
        // Promise
        return callback;
    }
        
    public static JSONObject getDetails() throws IOException
    {
        JSONObject callback = new JSONObject();

        if(access_token != null)
        {   

            // Connect out to the server URL
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(server_url + "/getUserDetails");
            request.setHeader("IstAuth", "Bearer " + access_token);
            request.setHeader("Content-Type","application/json");
            HttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            
            while ((line = rd.readLine()) != null) {
              callback = new JSONObject(line);
              return callback;
            }
            
        }// if not null

        // Promise
        return callback;
    }
    
}
