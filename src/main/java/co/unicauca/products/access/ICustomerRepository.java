package co.unicauca.products.access;

import co.unicauca.products.domain.entity.Customer;

/**
 * Interface de los servicios del repositorio
 *
 * @author DanielC
 */
public interface ICustomerRepository {
    
    /**
     * Busca un Customer por su ceduka
     * @param id cedula del cliente
     * @return  objeto de tipo Customer
     */
    
    Customer findCustomer(String id);
    public boolean createCustomer(Customer customer);

}
