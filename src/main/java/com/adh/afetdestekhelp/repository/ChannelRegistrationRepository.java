package com.adh.afetdestekhelp.repository;

import com.adh.afetdestekhelp.model.ChannelRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChannelRegistrationRepository extends JpaRepository<ChannelRegistration, Long> {
    List<ChannelRegistration> findByAddedByUserId(Long userId);
}
