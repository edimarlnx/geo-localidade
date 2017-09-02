package org.jsoll.geo.localidade.controller;

import com.ocpsoft.pretty.faces.annotation.URLAction;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.jsoll.geo.localidade.model.Cidade;
import org.jsoll.geo.localidade.service.CidadeService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
@URLMappings(mappings = {
        @URLMapping(id = "cidades", pattern = "/cidades", viewId = "/jsf/cidades.xhtml"),
        @URLMapping(id = "uf-cidades", pattern = "/uf/#{ufSelecionado : cidadeController.ufSelecionado}/cidades", viewId = "/jsf/cidades.xhtml"),
        @URLMapping(id = "cidade-edit", pattern = "/cidades/edit/#{cidadeId : cidadeController.cidadeId}/cidades", viewId = "/jsf/cidade-edit.xhtml")
})
public class CidadeController {

    @Inject
    private CidadeService cidadeService;

    @Getter
    @Setter
    private String ufSelecionado;

    @Getter
    @Setter
    private Integer cidadeId;

    @Getter @Setter
    private Cidade cidadeEdicao;

    @URLAction(mappingId = "cidade-edit")
    public void onEdit() {
        cidadeEdicao = cidadeService.findById(cidadeId);
    }

    public List<Cidade> getCidades() {
        System.out.printf("###### %s\n", ufSelecionado);
        if (ufSelecionado == null) {
            return cidadeService.findAll();
        }
        return cidadeService.findByUf(ufSelecionado);
    }

    public String salvar() {
        cidadeService.salvar(cidadeEdicao);
        return "pretty:cidades";
    }

}
