package entidades;

import entidades.Ordermeal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-30T18:04:29")
@StaticMetamodel(Horarioocupado.class)
public class Horarioocupado_ { 

    public static volatile SingularAttribute<Horarioocupado, Integer> idHorarioOcupado;
    public static volatile SingularAttribute<Horarioocupado, Date> fecha;
    public static volatile SingularAttribute<Horarioocupado, Ordermeal> orderMealidOrderMeal;

}