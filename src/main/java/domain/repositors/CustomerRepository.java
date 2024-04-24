package domain.repositors;

import domain.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    List<Customer> find(CustomerQuery query);

    default List<Customer> findAll(){
        return find(new CustomerQuery.builder().build());
    }

    default Optional<Customer> findById(String id){
        return find( new CustomerQuery.builder().withId(id).build()).stream().findFirst();
    }
}
