package domain.repositors;


import java.util.Optional;
import java.util.Set;

public class CustomerQuery {
    private final Optional<Set<String>> ids;

    public Optional<Set<String>> getIds() {
        return ids;
    }

    public CustomerQuery(Optional<Set<String>> ids) {
        this.ids = ids;
    }

    public static class builder {
        private Optional<Set<String>> ids = Optional.empty();

        public builder withIds(Optional<Set<String>> ids) {
            this.ids = ids;
            return this;
        }

        public builder withId(String id) {
            return withIds(Optional.of(Set.of(id)));
        }

        public CustomerQuery build() {
            return new CustomerQuery(ids);
        }
    }
}
