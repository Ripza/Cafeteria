package controladores;

import entidades.Ordermeal;
import controladores.util.util.JsfUtil;
import controladores.util.util.JsfUtil.PersistAction;
import sessionbeans.OrdermealFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("ordermealController")
@SessionScoped
public class OrdermealController implements Serializable {

    @EJB
    private sessionbeans.OrdermealFacadeLocal ejbFacade;
    private List<Ordermeal> items = null;
    private Ordermeal selected;

    public OrdermealController() {
    }

    public Ordermeal getSelected() {
        return selected;
    }

    public void setSelected(Ordermeal selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private OrdermealFacadeLocal getFacade() {
        return ejbFacade;
    }

    public Ordermeal prepareCreate() {
        selected = new Ordermeal();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle2").getString("OrdermealCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle2").getString("OrdermealUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle2").getString("OrdermealDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ordermeal> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    
    

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                    if(persistAction == PersistAction.CREATE)
                    {
                      //int idOrder = this.getItems().size();
                      //  System.out.println(selected.getComidaList());
                      //getFacade().insertarComidas(selected.getComidaList(), idOrder);
                    }
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle2").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle2").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Ordermeal getOrdermeal(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Ordermeal> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ordermeal> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Ordermeal.class)
    public static class OrdermealControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            OrdermealController controller = (OrdermealController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ordermealController");
            return controller.getOrdermeal(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ordermeal) {
                Ordermeal o = (Ordermeal) object;
                return getStringKey(o.getIdOrderMeal());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ordermeal.class.getName()});
                return null;
            }
        }

    }

}
