package org.sonytask.Repoistory;

import org.sonytask.Entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepo extends JpaRepository<Episode, Long> {

    List<Episode> findByChannel(String channel);

    Episode findByEpisodeNumber(Long id);

    List<Episode> findByStatus(String status);
}
