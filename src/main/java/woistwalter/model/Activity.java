package woistwalter.model;

import java.io.Serializable;

public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String activity;
	
	public Activity() {};
	
	public Activity(String act) {
		activity = act;
	}
	
	public void setActivity(final String activity) {
		this.activity = activity;
	}
	
	public String getActivity() {
		return activity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activity == null) ? 0 : activity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		return true;
	}
}
