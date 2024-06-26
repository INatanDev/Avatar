package infrastructure.rest;

import domain.models.ProfilePhoto;
import infrastructure.rest.client.StableDiffusion;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.apache.commons.io.FileUtils;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@ApplicationScoped
public class StableDiffusionService {

    private final StableDiffusion stableDiffusion;

    public StableDiffusionService(@RestClient StableDiffusion stableDiffusion) {
        this.stableDiffusion = stableDiffusion;
    }

    @Transactional
    public Uni<String> generate(ProfilePhoto profilePhoto) throws IOException {
        var filecontent = FileUtils.readFileToByteArray(new File(profilePhoto.originalPhoto()));
        var encondeString = Base64.getEncoder().encodeToString(filecontent);

        return stableDiffusion.img2img(new StableDiffusion.Request(encondeString))
                .onItem()
                .transform(response -> response.images().stream().findFirst().orElseThrow());
    }
}
