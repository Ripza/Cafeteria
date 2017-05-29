package entidades;

import entidades.Comida;
import entidades.Horarioocupado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-29T17:05:43")
@StaticMetamodel(Ordermeal.class)
public class Ordermeal_ { 

    public static volatile SingularAttribute<Ordermeal, String> metodoPago;
    public static volatile SingularAttribute<Ordermeal, Integer> idOrderMeal;
    public static volatile ListAttribute<Ordermeal, Comida> comidaList;
    public static volatile SingularAttribute<Ordermeal, String> ciudad;
    public static volatile SingularAttribute<Ordermeal, String> calle;
    public static volatile SingularAttribute<Ordermeal, String> nroContacto;
    public static volatile SingularAttribute<Ordermeal, String> correo;
    public static volatile SingularAttribute<Ordermeal, String> comuna;
    public static volatile SingularAttribute<Ordermeal, String> numCalle;
    public static volatile SingularAttribute<Ordermeal, String> nombrePersona;
    public static volatile SingularAttribute<Ordermeal, String> depto;
    public static volatile ListAttribute<Ordermeal, Horarioocupado> horarioocupadoList;

}