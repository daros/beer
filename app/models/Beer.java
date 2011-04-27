package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

import models.*;

@Entity
public class Beer extends Model {

    @Required
    public String name;

    public String brewery;

    public String toString() {
        return name;
    }
}
