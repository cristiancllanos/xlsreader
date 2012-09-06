package example.xml;

import java.util.Collections;

public class SimCard implements Contacts {

  public Iterable<Contact> findByName(String name) {
	  System.out.println(this.getClass().getSimpleName()+" findByName:"+name);
    return Collections.emptyList();
  }
}