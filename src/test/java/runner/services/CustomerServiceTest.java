package runner.services;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import runner.AppRunner;
import runner.entities.Customer;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppRunner.class)
public class CustomerServiceTest {
    @Autowired
    private CustomerServices customerServices; //Calls the mockito

    @Test
    public void readUserTest() {
        Customer customer = new Customer( 1L, "Radha" , "Ramnik","Patel","234324");
        customer.setId(1L);
        String expectedName= "Radha";
        Mockito.when(customerServices.readCustomer(1L)).thenReturn(customer);
        String testName = customerServices.readCustomer(1L).getFirstName();
        Assert.assertEquals(expectedName, testName);
    }


    @Test
    public void createUserTest() {
        Customer customer = new Customer( 1L, "Radha" , "Ramnik","Patel","234324");
        String expectedName= "Radha";
        Mockito.when(customerServices.createCustomer(customer)).thenReturn(customer);
        String actualName = customer.getFirstName();
        Assert.assertEquals(expectedName, actualName);

    }
    @Test
    public void deleteUserTest() {
        Customer customer = new Customer( 1L, "Radha" , "Ramnik","Patel","234324");
        Boolean expected = false;
        Mockito.when(customerServices.createCustomer(customer)).thenReturn(customer);
        Boolean actual= customerServices.deleteCustomer(1L);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void updateUserTest() throws Exception {
        Customer customer1 = new Customer( 1L, "Radha" , "Ramnik","Patel","234324");
        String expectedUpdateName= "Update the First Name";
        Mockito.when(customerServices.createCustomer(customer1)).thenReturn(customer1);
        customer1.setFirstName(expectedUpdateName);
        Mockito.when(customerServices.updateCustomer(1L , customer1)).thenReturn(customer1);
        String actualUpdatedName= customer1.getFirstName();
        Assert.assertEquals(expectedUpdateName, actualUpdatedName);
    }
}