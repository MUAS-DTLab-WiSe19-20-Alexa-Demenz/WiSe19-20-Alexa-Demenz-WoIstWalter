package woistwalter;

import static org.junit.Assert.*;

import org.junit.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import woistwalter.model.Activity;

public class ActivityTest {

	@Test
	public void validateSetter() throws Exception {

		PojoClass activityPojo = PojoClassFactory.getPojoClass(Activity.class);

		Validator validator = ValidatorBuilder.create()
				// Lets make sure that we have a getter and a setter for every field defined.
				.with(new GetterMustExistRule())

				// Lets also validate that they are behaving as expected
				.with(new GetterTester()).build();

		// Start the Test
		validator.validate(activityPojo);
	}
	
	@Test
	public void equalTest() {
		Activity act = new Activity("Essen");
		
		assertEquals(true, act.equals(act));
		
		Activity act2 = new Activity("Essen");
		
		assertEquals(true, act.equals(act2));
		
		Activity act3 = new Activity("Schlafen");
		
		assertEquals(false, act.equals(act3));
	}

}
