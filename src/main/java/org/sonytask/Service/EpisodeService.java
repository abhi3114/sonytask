package org.sonytask.Service;

import org.sonytask.Abstraction.EpisodeInterface;
import org.sonytask.Entity.ComplianceItem;
import org.sonytask.Entity.Episode;
import org.sonytask.Repoistory.ComplianceItemRepository;
import org.sonytask.Repoistory.EpisodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EpisodeService implements EpisodeInterface {

    private final EpisodeRepo episodeRepository;

    @Autowired
    private ComplianceItemRepository complianceItemRepository;


    public EpisodeService(EpisodeRepo episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

  @Override
  @Transactional
    public List<Episode> getEpisodesByChannel(String channel) {
        return episodeRepository.findByChannel(channel);
    }


    @Override
    @Transactional
    public List<Episode> saveAllEpisodes(List<Episode> Episode) throws Exception {
        try {
            List<Episode> Episode1 = episodeRepository.saveAll(Episode);
            return Episode1;
        } catch (Exception e) {
            throw new Exception("Exception in saving " + e);
        }
    }

    @Override
    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }


    @Override
    @Transactional
    public Episode saveEpisodes(Episode Episode) throws Exception {
        try {
            Episode savedEpisode = episodeRepository.save(Episode);
            return savedEpisode;
        } catch (Exception e) {
            throw new Exception("Exception in saving " + e);
        }
    }

    @Override
    @Transactional
    public List<ComplianceItem> saveAllComplianceItem(List<ComplianceItem> ComplianceItem) throws Exception {
        try {
            List<ComplianceItem> complianceItem1 = complianceItemRepository.saveAll(ComplianceItem);
            return complianceItem1;
        } catch (Exception e) {
            throw new Exception("Exception in ComplianceItem saving " + e);
        }
    }


    @Override
    @Transactional
    public Episode getEpisodeByid(Long id) {
        Episode episode = episodeRepository.findByEpisodeNumber(id);
        return episode;
    }

    @Override
    @Transactional
    public List<ComplianceItem> getComplianceItembyEpicodeNumber(Long id) {

        List<ComplianceItem> complianceItems = complianceItemRepository.findByEpisodeEpisodeNumber(id);
        return complianceItems;
    }

    @Override
    public List<Episode> getEpisodesByStatus(String status) {
        return episodeRepository.findByStatus(status);
    }
}
