package ApiTests.LoginFree;

import ApiTests.UsedByAll.MakeRequest;
import ApiTests.UsedByAll.ValidationChecker;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// * Created for W-xmlm by Fill on 04.12.2014. Gets application's current version
public class GetApplicationInfo {
    public boolean testGetApplicationInfo(String siteUrl) throws Exception {
        InputStream inStrm;
        long startTime;
        long elapsedTime;
        startTime = System.currentTimeMillis();
        HttpURLConnection httpCon = MakeRequest.getConnection(siteUrl, "application/api/desktop/get-application-info/", "GET");
        assertTrue("Check response code is 200", httpCon.getResponseCode() == 200);
        inStrm = httpCon.getInputStream();
        elapsedTime = System.currentTimeMillis() - startTime;
        InputStreamReader isReader = new InputStreamReader(inStrm);
        BufferedReader br = new BufferedReader(isReader);
        String result = "";
        String line;
        while ((line = br.readLine()) != null) {
            result += line;
        }
        br.close();

        //Парсим JSON
        JSONObject object = new JSONObject(result);
        //Проверяем структуру
        assertTrue("Incorrect id", ValidationChecker.checkIdValue(object.getInt("id")));
        assertTrue("Incorrect version", ValidationChecker.checkStringNotNull(object.getString("version")));
        assertTrue("Incorrect filename", ValidationChecker.checkStringNotNull(object.getString("filename")));
        assertTrue("Incorrect path", ValidationChecker.checkStringNotNull(object.getString("path")));
        assertTrue("Incorrect status", object.getBoolean("status"));
        assertEquals("Incorrect count of Json parameters", object.length(), 5);
        System.out.println("Total elapsed http request/response time in milliseconds: " + elapsedTime);
        return true;
    }
}