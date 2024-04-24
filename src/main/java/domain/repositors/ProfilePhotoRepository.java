package domain.repositors;

import domain.models.ProfilePhoto;

public interface ProfilePhotoRepository {
    void save (String customerId, ProfilePhoto profilePhoto);
}
