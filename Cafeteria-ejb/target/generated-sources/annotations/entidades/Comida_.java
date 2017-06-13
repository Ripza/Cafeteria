package entidades;

import entidades.Menus;
import entidades.Ordermeal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-30T18:04:29")
@StaticMetamodel(Comida.class)
public class Comida_ { 

    public static volatile SingularAttribute<Comida, String> descripcion;
    public static volatile SingularAttribute<Comida, Integer> precio;
    public static volatile ListAttribute<Comida, Menus> menusList;
    public static volatile ListAttribute<Comida, Ordermeal> ordermealList;
    public static volatile SingularAttribute<Comida, String> nombre;
    public static volatile SingularAttribute<Comida, Integer> idComida;

}