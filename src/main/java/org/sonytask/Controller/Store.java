package org.sonytask.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.sonytask.Abstraction.EpisodeInterface;
import org.sonytask.Entity.ComplianceItem;
import org.sonytask.Entity.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sonyshows")
@CrossOrigin(origins = "*")
@Validated
public class Store {
    @Autowired
    EpisodeInterface episodeInterface;

    @PostMapping("/saveAll")
    @ApiOperation(value = "Create and Stored List of channel and Episode", notes = "Create a List of channel and Episode")
    public List<Episode> saveAllEpisode(@ApiParam(value = "Details of List of channel and Episode to be created", required = true) @Valid @RequestBody List<Episode> Episode) throws Exception {
        return episodeInterface.saveAllEpisodes(Episode);
    }

    @PostMapping("/savesingle")
    @ApiOperation(value = "Create and stored single Episode", notes = "Create a Single Episode and Compliance Item list")
    public Episode saveEpisode(@ApiParam(value = "Details of Single Episode and Compliance Item list", required = true) @Valid @RequestBody Episode Episode) throws Exception {
        return episodeInterface.saveEpisodes(Episode);
    }

    @PostMapping("/saveItems")
    @ApiOperation(value = "Create and Stored Compliance Item List", notes = "Create Compliance Item list")
    public List<ComplianceItem> saveAllComplianceItem(@ApiParam(value = "Details of Compliance Item list", required = true) @Valid @RequestBody List<ComplianceItem> ComplianceItem) throws Exception {
        System.out.println("List " + ComplianceItem.toString());
        return episodeInterface.saveAllComplianceItem(ComplianceItem);
    }
}
