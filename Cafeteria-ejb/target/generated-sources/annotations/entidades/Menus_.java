package entidades;

import entidades.Comida;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-20T08:21:13")
@StaticMetamodel(Menus.class)
public class Menus_ { 

    public static volatile SingularAttribute<Menus, String> especialDelDia;
    public static volatile ListAttribute<Menus, Comida> comidaList;
    public static volatile SingularAttribute<Menus, Integer> idMenus;

}