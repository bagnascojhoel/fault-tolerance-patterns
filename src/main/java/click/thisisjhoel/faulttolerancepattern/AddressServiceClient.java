package click.thisisjhoel.faulttolerancepattern;

import feign.RequestLine;

import java.util.Map;

public interface AddressServiceClient {

    @RequestLine("GET /address")
    Map<String, String> getAddress();

}
