package pro.Controller;
/**
 * Created by user on 23.08.2015.
 */

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pro.Model.Coordinate;
import pro.Service.CoordinateService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    @Autowired
    private CoordinateService service;

    @RequestMapping(value = "/take_my_coordinate",method = RequestMethod.POST)
    public String Post(@RequestParam("nick") String nick,
                       @RequestParam("coordinate_x") String coordinate_x,
                       @RequestParam("coordinate_y") String coordinate_y){
        System.out.println("Name = " + nick + "\nx = " + coordinate_x + "\ny = " + coordinate_y);

        service.saveCoordinate(
                new Coordinate(nick, Double.parseDouble(coordinate_x), Double.parseDouble(coordinate_y)));

        return "index";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        System.out.println("Testing 2 - Send Http POST request");
        sentPost();
        return "index";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String Index(){
        return "index";
    }

    public void sentPost(){
        try {
            String url = "http://localhost:8080/take_my_coordinate";

            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);

            List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
            urlParameters.add(new BasicNameValuePair("nick", "Nick 1"));
            urlParameters.add(new BasicNameValuePair("coordinate_x", "322"));
            urlParameters.add(new BasicNameValuePair("coordinate_y", "422"));
            post.setEntity(new UrlEncodedFormEntity(urlParameters));
            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            System.out.println(result.toString());

        }catch (Exception ex){
            System.out.println("pro.Controller.HelloController " + ex);
        }
    }
}
