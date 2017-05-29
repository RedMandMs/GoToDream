package soft.happyhamster.com.gotodream.domain;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Vilgodskiy_Sergey on 29.05.2017.
 */

public class Dream extends RealmObject {

    @PrimaryKey
    private Long id;

    private String name;

    private String discription;

    private boolean complite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isComplite() {
        return complite;
    }

    public void setComplite(boolean complite) {
        this.complite = complite;
    }
}
