package woistwalter.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;

public class Family implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Family() {};
	
	private Map<Familymember, List<Activity>> activities = new HashMap<Familymember, List<Activity>>();
	 private List<Familymember> members = new ArrayList<Familymember>();
	 
	 public Map<Familymember, List<Activity>> getActivities() {
		return activities;
	}

	public void setActivities(final Map<Familymember, List<Activity>> activities) {
		this.activities = activities;
	}

	public List<Familymember> getMembers() {
		return members;
	}

	public void setMembers(final List<Familymember> members) {
		this.members = members;
	}

	public void addActivity(Familymember member, Activity... act) {
		 if(!activities.containsKey(member))
			 activities.put(member, new ArrayList<Activity>());
		 
		 for(Activity ac : act)
			 activities.get(member).add(ac);
	 }
	 
	 public void addMember(Familymember member) {
		 members.add(member);
	 }
	 
	 public boolean deleteFamilymember(Familymember member) {
		 if(members.contains(member)) {
			 members.remove(member);
			 
			 // delete the activities from the person if the person has inserted some
			 if(activities.containsKey(member)) 
					 activities.remove(member);
			 
			 return true;
		 }
		 return false;
	 }
	 
	 public Familymember returnByName(String name) {
		 for(Familymember member : members) {
			if(member.getName().equals(name))
				return member;
		 }
		 return null;
	 }
}