package click.thisisjhoel.faulttolerancepattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AController {

    @Autowired
    AddressServiceClient addressClient;

    @GetMapping("/addresses")
    public Map<String, String> getAddresses() {
        return addressClient.getAddress();
    }

    @GetMapping("/users")
    public Map<String, String> getUsers() {
        return addressClient.getAddress();
    }

}
