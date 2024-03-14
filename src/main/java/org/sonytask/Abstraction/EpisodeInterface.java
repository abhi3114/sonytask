package org.sonytask.Abstraction;

import org.sonytask.Entity.ComplianceItem;
import org.sonytask.Entity.Episode;

import java.util.List;

public interface EpisodeInterface {

    List<Episode> getEpisodesByChannel(String channel);
    List<Episode> saveAllEpisodes(List<Episode> Episode) throws Exception;

    List<Episode> getAllEpisodes();

     Episode saveEpisodes(Episode Episode) throws Exception;
     List<ComplianceItem> saveAllComplianceItem(List<ComplianceItem> ComplianceItem) throws Exception;

     Episode getEpisodeByid(Long id);

     List<ComplianceItem> getComplianceItembyEpicodeNumber(Long id);

    List<Episode> getEpisodesByStatus(String status);
}
