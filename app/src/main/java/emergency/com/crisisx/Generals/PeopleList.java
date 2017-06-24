package emergency.com.crisisx.Generals;

import java.util.ArrayList;
import java.util.List;

public class PeopleList {

    public static List<Person> peopleList = new ArrayList<>();

    public PeopleList(){
        peopleList.add(new Person("asfd", "0123456789", "asdf"));
        peopleList.add(new Person("zxc", "0654123798", "rwt"));
        peopleList.add(new Person("qwer", "0987456312", "juh"));
    }

}
