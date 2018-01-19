package i5b5.mwsi.controllers.factories;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HttpHeaderFactory {

    public HttpHeaders getHttpHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin","*");

        return headers;
    }
}
