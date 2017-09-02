package org.jsoll.geo.localidade.converter;

import org.jsoll.geo.localidade.model.Uf;
import org.jsoll.geo.localidade.service.UfService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@FacesConverter(forClass = Uf.class, value = "ufConverter")
public class UfConverter implements Converter {
    @Inject
    private UfService ufService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Uf uf = ufService.findById(Integer.parseInt(s));
        return uf;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return null;
        }
        Uf uf = (Uf) o;
        return uf.getId().toString();
    }
}
