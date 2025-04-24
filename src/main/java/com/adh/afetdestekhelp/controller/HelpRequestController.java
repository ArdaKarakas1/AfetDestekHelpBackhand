// HelpRequestController.java
package com.adh.afetdestekhelp.controller;

import com.adh.afetdestekhelp.model.HelpRequest;
import com.adh.afetdestekhelp.repository.HelpRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/help")
@CrossOrigin
public class HelpRequestController {

    @Autowired
    private HelpRequestRepository repository;

    @PostMapping
    public HelpRequest submitHelpRequest(@RequestBody HelpRequest helpRequest) {
        return repository.save(helpRequest);
    }

    @GetMapping
    public List<HelpRequest> getAllHelpRequests() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public HelpRequest getHelpRequestById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
