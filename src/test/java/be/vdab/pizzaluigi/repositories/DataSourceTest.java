package be.vdab.pizzaluigi.repositories;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@JdbcTest 
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class DataSourceTest {

	  @Test   public void goedGeïnitialiseerd() {
		     } 

}
