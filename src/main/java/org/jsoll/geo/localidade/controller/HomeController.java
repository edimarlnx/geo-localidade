package org.jsoll.geo.localidade.controller;

import br.com.tecsinapse.exporter.Table;
import br.com.tecsinapse.exporter.style.TableCellStyle;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.jsoll.geo.localidade.model.Cidade;
import org.jsoll.geo.localidade.model.Pais;
import org.jsoll.geo.localidade.model.Uf;
import org.jsoll.geo.localidade.service.CidadeService;
import org.jsoll.geo.localidade.service.PaisService;
import org.jsoll.geo.localidade.service.UfService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

import static br.com.tecsinapse.exporter.style.TableCellStyle.HEADER;

@Named
@RequestScoped
@URLMappings(mappings = {
        @URLMapping(id = "home", pattern = "/home", viewId = "/jsf/index.xhtml"),
        @URLMapping(id = "paises", pattern = "/paises", viewId = "/jsf/paises.xhtml"),
        @URLMapping(id = "ufs", pattern = "/ufs", viewId = "/jsf/ufs.xhtml"),
        @URLMapping(id = "cidades", pattern = "/cidades", viewId = "/jsf/cidades.xhtml"),
        @URLMapping(id = "data-io", pattern = "/data-io", viewId = "/jsf/data-io.xhtml"),
        @URLMapping(id = "uf-cidades", pattern = "/uf/#{ufSelecionado : homeController.ufSelecionado}/cidades", viewId = "/jsf/cidades.xhtml")
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

    @Getter @Setter
    private String ufSelecionado;

    public List<Cidade> getCidades() {
        if (ufSelecionado == null) {
            return cidadeService.findAll();
        }
        return cidadeService.findByUf(ufSelecionado);
    }

    public Table getTable() {
        Table table = new Table();
        TableCellStyle cellStyle = HEADER.clone();
        cellStyle.setIgnoreCssStyle(false);
        table.addNewRow();
        table.add("Cell 1", cellStyle);
        table.add("Cell 2", cellStyle);
        table.add("Cell 3", cellStyle);
        table.add("Cell 4", cellStyle);

        table.addNewRow();
        table.add("Cell 1");
        table.add("Cell 2");
        table.add("Cell 3");
        table.add("Cell 4");

        return table;
    }
}
