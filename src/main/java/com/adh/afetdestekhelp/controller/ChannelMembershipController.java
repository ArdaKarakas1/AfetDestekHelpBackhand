// ChannelMembershipController.java
package com.adh.afetdestekhelp.controller;

import com.adh.afetdestekhelp.model.ChannelMembership;
import com.adh.afetdestekhelp.repository.ChannelMembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/memberships")
@CrossOrigin
public class ChannelMembershipController {

    @Autowired
    private ChannelMembershipRepository repository;

    @PostMapping
    public ResponseEntity<?> registerMembership(@RequestBody ChannelMembership membership) {
        Optional<ChannelMembership> existing = repository.findByTelegramUserIdAndChannelChatId(
                membership.getTelegramUserId(), membership.getChannelChatId()
        );

        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Kullanıcı zaten bu kanalda kayıtlı.");
        }

        return ResponseEntity.ok(repository.save(membership));
    }


    @GetMapping("/by-user")
    public List<ChannelMembership> getByUserId(@RequestParam Long userId) {
        return repository.findByTelegramUserId(userId);
    }
}
