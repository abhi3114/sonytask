package org.sonytask.Repoistory;

import org.sonytask.Entity.ComplianceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplianceItemRepository extends JpaRepository<ComplianceItem, Long> {

    List<ComplianceItem> findByEpisodeEpisodeNumber(Long number);

}
