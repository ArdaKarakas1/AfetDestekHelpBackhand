// ChannelMembershipRepository.java
package com.adh.afetdestekhelp.repository;

import com.adh.afetdestekhelp.model.ChannelMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ChannelMembershipRepository extends JpaRepository<ChannelMembership, Long> {
    List<ChannelMembership> findByTelegramUserId(Long telegramUserId);

    Optional<ChannelMembership> findByTelegramUserIdAndChannelChatId(Long telegramUserId, Long channelChatId);

}
