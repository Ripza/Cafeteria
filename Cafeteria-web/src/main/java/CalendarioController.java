

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
 
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
 
@ManagedBean(name = "calctrl", eager = true)
@SessionScoped
public class CalendarioController implements Serializable{
         
    private Date date4;
    private Date date11;
    private String nombre = "Pepito Pagadoble";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    private String ejemplo = "AAAAAAAAA";

    public String getEjemplo() {
        return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }
     
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    
    public String conectar_orden()
    {
        setEjemplo("asdsa");
        System.out.println(getDate4());
        System.out.println(getEjemplo());
        
        System.out.println("Quiere algo, demosle algo");
        return "ordenPage";
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
 
    public Date getDate4() {
        return date4;
    }
 
    public void setDate4(Date date4) {
        this.date4 = date4;
    }
 
    public Date getDate11() {
        return date11;
    }
 
    public void setDate11(Date date11) {
        this.date11 = date11;
    }
}