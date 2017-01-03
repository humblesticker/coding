import java.util.*;

/*
contact list is same if dinstinct names are same regardless of the order

*/
public class ContactList {
	List<String> names;
	public ContactList(List<String> list) {
		names = list;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof ContactList)) return false;
		Set<String> self = new HashSet<>(this.names), other = new HashSet<>(((ContactList)obj).names);
		return this == obj ? true : self.equals(other);
	}

	@Override
	public int hashCode() {
		return new HashSet<>(this.names).hashCode();
	}

	public List<ContactList> merge(List<ContactList> lists) {
		return new ArrayList<>(new HashSet<ContactList>(lists));
	}
}