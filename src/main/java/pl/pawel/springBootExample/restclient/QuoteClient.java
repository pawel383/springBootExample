package pl.pawel.springBootExample.restclient;

import org.springframework.web.client.RestTemplate;

/**
 * Created by pawel on 18.01.2017.
 */
public class QuoteClient {

    public Quote run()  {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                "http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

}
