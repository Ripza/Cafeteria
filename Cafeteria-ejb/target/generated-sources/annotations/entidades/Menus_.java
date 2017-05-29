package entidades;

import entidades.Ordermeal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-28T21:20:04")
@StaticMetamodel(Menus.class)
public class Menus_ { 

    public static volatile SingularAttribute<Menus, String> especialDelDia;
    public static volatile SingularAttribute<Menus, Integer> idMenus;
    public static volatile ListAttribute<Menus, Ordermeal> ordermealList;

}