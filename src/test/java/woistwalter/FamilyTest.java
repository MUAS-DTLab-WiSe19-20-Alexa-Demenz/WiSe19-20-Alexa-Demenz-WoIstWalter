package woistwalter;

import woistwalter.model.Activity;
import woistwalter.model.Family;
import woistwalter.model.Familymember;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FamilyTest {
    @Test
    public void addMemberTest() {
    	Family fam = new Family();
    	assertEquals(0, fam.getMembers().size());
    	Familymember mem = new Familymember("Milos");
    	
    	fam.addMember(mem);
    	assertEquals(1, fam.getMembers().size());
    }
    
    @Test
    public void addActivityTest() {
    	Family fam = new Family();
    	Familymember mem = new Familymember("Milos");
    	fam.addMember(mem);
    	Activity act = new Activity("Macht Musik");
    	fam.addActivity(mem, act);
    	
    	assertEquals(1, fam.getActivities().values().size());
    	assertEquals(act, fam.getActivities().get(mem).get(0));
    	
    	Activity act2 = new Activity("Fährt Bus");
    	fam.addActivity(mem, act2);
    	
    	assertEquals(1, fam.getActivities().values().size());
    	assertEquals(act2, fam.getActivities().get(mem).get(1));
    	
    }
    
    @Test
    public void getNameTest() {
    	
    	Family fam = new Family();
    	Familymember mem = new Familymember("Milos");
    	fam.addMember(mem);

    	assertEquals(mem, fam.returnByName(mem.getName()));
    }
    
    @Test
    public void deleteMemberTest() {
    	Family fam = new Family();
    	Familymember mem = new Familymember("Milos");
    	Familymember mem2 = new Familymember("Marcel");
    	fam.addMember(mem);
    	fam.addActivity(mem, new Activity("Essen"));
    	
    	assertEquals(1, fam.getMembers().size());
    	assertEquals(1, fam.getActivities().size());
    	boolean success = fam.deleteFamilymember(mem);
    	assertEquals(true, success);
    	assertEquals(0, fam.getMembers().size());
    	assertEquals(0, fam.getActivities().size());
    	
       	fam.addMember(mem);
    	boolean success2 = fam.deleteFamilymember(mem2);
    	assertEquals(false, success2);
    	assertEquals(1, fam.getMembers().size());
    }
}
