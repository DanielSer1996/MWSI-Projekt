package i5b5.mwsi.controllers.factories;

import org.springframework.http.HttpHeaders;

public class HttpHeaderFactory {

    public HttpHeaders getHttpHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin","*");

        return headers;
    }
}
