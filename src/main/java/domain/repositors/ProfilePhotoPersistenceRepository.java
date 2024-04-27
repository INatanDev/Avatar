package domain.repositors;

import domain.models.ProfilePhoto;

public interface ProfilePhotoPersistenceRepository {
    void save (String customerId, ProfilePhoto profilePhoto);
}
