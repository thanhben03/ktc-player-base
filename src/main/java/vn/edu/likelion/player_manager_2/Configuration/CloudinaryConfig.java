package vn.edu.likelion.player_manager_2.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    private String cloudName = "dr4cghpgp";

    private String apiKey = "911254261227848";

    private String apiSecret = "JwQbWAuT5p1RVtAm2D-vZ0y2WUY";

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }
}