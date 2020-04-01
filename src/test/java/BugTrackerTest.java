import com.company.model.Employee;
import com.company.model.Product;
import org.junit.*;
import static org.junit.Assert.*;

public class BugTrackerTest {
    @Test
    public void addComment(){
        Employee employee = new Employee(11,"Mihaela","miha@gamil.com");
        assertEquals(employee.addCommentForBug(3,"bug in progress"),false);
    }

    @Test
    public void addBug(){
        Employee employee = new Employee(12,"Carmen","carmen@yahoo.com");
        assertEquals(employee.addBug(9,3,"app blocks","bug open","2","web","ss.jpg","can't open",12),false);
    }

    @Test
    public void updateProduct(){
        Product product =  new Product(5,"mobile","10-11-2019","games app");
        assertEquals(product.getData_lansarii(),"10-11-2019");
        assertEquals(product.getDescriere(),"games app");
        assertEquals(product.updateProduct("mobile","10-11-2019","mobile app",product),true);
    }

}
