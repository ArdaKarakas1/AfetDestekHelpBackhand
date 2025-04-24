
// ChannelRegistrationController.java
package com.adh.afetdestekhelp.controller;

import com.adh.afetdestekhelp.model.ChannelRegistration;
import com.adh.afetdestekhelp.repository.ChannelRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/channels")
@CrossOrigin
public class ChannelRegistrationController {

    @Autowired
    private ChannelRegistrationRepository repository;

    @PostMapping
    public ChannelRegistration registerChannel(@RequestBody ChannelRegistration request) {
        return repository.save(request);
    }

    @GetMapping
    public List<ChannelRegistration> getAllChannels() {
        return repository.findAll();
    }
}