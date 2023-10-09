package org.example.app.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.example.app.entity.Client;
import org.example.app.service.impl.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService service;

    @RequestMapping("/home")
    public String viewHome(Model model) {
        List<Client> client = service.fetchAll();
        model.addAttribute("client", client);
        return "home";
    }

    @RequestMapping("/addClient")
    public String addClient(Model model) {
        model.addAttribute("title", "Add client");
        return "client_add";
    }

    @RequestMapping(value = "/handle-client", method = RequestMethod.POST)
    public RedirectView handleClient(@ModelAttribute Client client, HttpServletRequest request) {
        service.save(client);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping("/delete/{id}")
    public RedirectView deleteClient(@PathVariable("id") Long id, HttpServletRequest request) {
        service.delete(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath() + "/");
        return redirectView;
    }

    @RequestMapping("/update/{clientId}")
    public String updateClient(@PathVariable("clientId") Long id, Model model) {
        model.addAttribute("title","Update Client");
        Client client = service.fetchById(id);
        model.addAttribute("client", client);
        return "client_update";
    }
}
