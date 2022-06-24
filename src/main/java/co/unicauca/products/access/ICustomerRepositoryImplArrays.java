package co.unicauca.products.access;

import co.unicauca.products.domain.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Default;

/**
 * Implementación por defecto. El framewok contenedor de CDI (Contexts and
 * Dependency Injection) carga la implementación por defecto.
 *
 * @author DanielC
 */

@Default
public class ICustomerRepositoryImplArrays implements ICustomerRepository {
   
    /**
     * Array List de clientes
     */
    private static List<Customer> customers;

    public ICustomerRepositoryImplArrays() {
        if (customers == null){
            customers = new ArrayList();
            inicializar();
        }
        
    }

    private void inicializar() {
      
        customers.add(new Customer("1", "Andres", "Castro", "Carrera 14 # 1-12 Popayan", "3192258752", "andresC@hotmail.com", "Masculino"));
        customers.add(new Customer("2", "Lida", "Perez", "Carrera 11 #15-5 Popayan", "316666945", "lidaP@gmail.com", "Femenino"));
        customers.add(new Customer("3", "Camilo", "Rodriguez", "Pandiguando Popayan", "311187454", "camiloR@gmail.com", "Masculino"));
        customers.add(new Customer("4", "Fernanda", "Alvarez", "Calle 11 No 11-11 Popayan", "3005562133", "fernandaA@hotmail.com", "Femenino"));
        customers.add(new Customer("5", "Manuela", "C", "carrera 20 # 2-12 Popayan", "3005485845", "ManuC@hotmail.com", "Femenino"));

    }

    /**
     * Busca u Customer en el arreglo
     *
     * @param id cedula del customer
     * @return objeto Customer
     */
    @Override
    public Customer findCustomer(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean createCustomer(Customer newCustomer) {
        Customer cust = this.findCustomer(newCustomer.getId());
        
        if (cust != null) {
            //Ya existe
            return false;
        }
        customers.add(newCustomer);
        return true;
    }
}
