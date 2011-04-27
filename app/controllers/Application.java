package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        String foo = "hello foo";
        render(foo);
    }

    public static void add(Drinker drinker,Beer beer,Grade grade) {
        Drinker d = Drinker.find("name like ?",drinker.name +"%").first();
        if (d != null) {
            drinker = d;
        }
        
        Beer b = Beer.find("name like ?",beer.name+"%").first();
        if (b != null) {
            beer = b;
        }
        
        grade.drinker = drinker;
        grade.beer = beer;
        
        validation.valid(beer);
        validation.valid(drinker);
        validation.valid(grade);
        if (validation.hasErrors()) {
            validation.keep();
            params.flash();
            index();
        }
        
        grade.save();
        
        flash.success("%s gav %s/5 i betyg till %s",drinker.name,grade.grade,beer.name);
        index();
    }

}
