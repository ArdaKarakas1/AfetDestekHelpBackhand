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
    private HelpRequestRepository helpRequestRepository;

    @PostMapping
    public HelpRequest receiveHelpRequest(@RequestBody HelpRequest request) {
        return helpRequestRepository.save(request);
    }
    @GetMapping
    public List<HelpRequest> getAllRequests() {
        return helpRequestRepository.findAll();
    }

}
