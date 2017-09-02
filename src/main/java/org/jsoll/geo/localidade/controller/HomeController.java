package org.jsoll.geo.localidade.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import org.jsoll.geo.localidade.model.Pais;
import org.jsoll.geo.localidade.model.Uf;
import org.jsoll.geo.localidade.service.CidadeService;
import org.jsoll.geo.localidade.service.PaisService;
import org.jsoll.geo.localidade.service.UfService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
@URLMappings(mappings = {
        @URLMapping(id = "home", pattern = "/home", viewId = "/jsf/index.xhtml"),
        @URLMapping(id = "paises", pattern = "/paises", viewId = "/jsf/paises.xhtml"),
        @URLMapping(id = "ufs", pattern = "/ufs", viewId = "/jsf/ufs.xhtml")
})
public class HomeController {

    @Inject
    private PaisService paisService;

    @Inject
    private UfService ufService;

    @Inject
    private CidadeService cidadeService;

    public List<Pais> getPaises() {
        return paisService.findAll();
    }

    public List<Uf> getUfs() {
        return ufService.findAll();
    }

}
