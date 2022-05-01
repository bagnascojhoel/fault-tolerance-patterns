package click.thisisjhoel.faulttolerancepattern;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "services.address")
@Data
public class AddressServiceProperties {

    private String url;

}
