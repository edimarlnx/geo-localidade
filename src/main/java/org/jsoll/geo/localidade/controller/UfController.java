package org.jsoll.geo.localidade.controller;

import org.jsoll.geo.localidade.model.Uf;
import org.jsoll.geo.localidade.service.UfService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UfController {

    @Inject
    private UfService ufService;

    public List<Uf> getUfs() {
        return ufService.findAll();
    }

}
