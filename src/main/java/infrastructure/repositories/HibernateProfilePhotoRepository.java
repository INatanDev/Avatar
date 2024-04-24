package infrastructure.repositories;

import domain.models.ProfilePhoto;
import domain.repositors.ProfilePhotoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HibernateProfilePhotoRepository implements ProfilePhotoRepository {
    @Override
    public void save(String customerId, ProfilePhoto profilePhoto) {

    }
}
