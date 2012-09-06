package example.xml;

import java.util.Collections;

public class FlashMemory implements Contacts {

  public Iterable<Contact> findByName(String name) {
	  System.out.println(this.getClass().getSimpleName()+" findByName:"+name);
    return Collections.emptyList();
  }
}
