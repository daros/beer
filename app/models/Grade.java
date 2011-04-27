package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;

import models.*;

@Entity
public class Grade extends Model {

    @Required
    @ManyToOne(cascade=CascadeType.ALL)
    public Drinker drinker;
    
    @Required
    @ManyToOne(cascade=CascadeType.ALL)
    public Beer beer;
    
    @Required
    @Min(0) @Max(5)
    public int grade;
    
    public String comment;
    

}
