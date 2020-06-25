package woistwalter;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import woistwalter.model.Familymember;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FamilymemberTest {

	@Test
	public void validateSettersAndGetters() throws Exception {

		PojoClass activityPojo = PojoClassFactory.getPojoClass(Familymember.class);

		Validator validator = ValidatorBuilder.create()
				// Lets make sure that we have a getter and a setter for every field defined.
				.with(new SetterMustExistRule()).with(new GetterMustExistRule())

				// Lets also validate that they are behaving as expected
				.with(new SetterTester()).with(new GetterTester()).build();

		// Start the Test
		validator.validate(activityPojo);
	}

	@Test
	public void setNameTest() {
		Familymember mem = new Familymember("Milos");
		
		assertEquals("Milos", mem.getName());
		
		mem.setName("Milosevic");
		
		assertEquals("Milosevic", mem.getName());
	}
	
	@Test
	public void equalTest() {
		Familymember mem = new Familymember("Milos");
		
		assertEquals(true, mem.equals(mem));
		
		Familymember mem2 = new Familymember("Milos");
		
		assertEquals(true, mem.equals(mem2));
		
		Familymember mem3 = new Familymember("Marcel");
		
		assertEquals(false, mem.equals(mem3));
	}
}
