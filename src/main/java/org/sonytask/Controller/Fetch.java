package org.sonytask.Controller;

import io.swagger.annotations.ApiOperation;
import org.sonytask.Abstraction.EpisodeInterface;
import org.sonytask.Clasess.ComplianceItemResponse;
import org.sonytask.Clasess.EpisodeResponse;
import org.sonytask.Clasess.ListEpisodeResponse;
import org.sonytask.Entity.ComplianceItem;
import org.sonytask.Entity.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sonyshows")
@CrossOrigin(origins = "*")
@Validated
public class Fetch {
    @Autowired
    EpisodeInterface episodeInterface;

    @GetMapping("/applicationWorking")
    @ApiOperation(value = "Check for application Working", notes = "Check for application working")
    public String ALLSet() {
        return "All Working";
    }


    @GetMapping("/getAllEpisode")
    @ApiOperation(value = "Get List of All Episode Created", notes = "It will provide you all Episode with Compliance Items that has been created")
    public ResponseEntity<ListEpisodeResponse> getAllEpisodes() throws Exception {
        // return episodeInterface.getAllEpisodes();
        List<Episode> episodeList = episodeInterface.getAllEpisodes();
        ;
        if (episodeList.isEmpty()) {
            String message = "No data found for episode ";
            ListEpisodeResponse response = new ListEpisodeResponse(null, message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            String message = "Data found for episode";
            ListEpisodeResponse response = new ListEpisodeResponse(episodeList, message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


    @GetMapping("/getEpisode/{id}")
    @ApiOperation(value = "Get Single Episode by Episode Number", notes = "Provide an episodeNumber to get Single Episode")
    public ResponseEntity<EpisodeResponse> getEpisodeByid(@PathVariable(name = "id") Long id) {

        Optional<Episode> episode = Optional.ofNullable(episodeInterface.getEpisodeByid(id));

        if (!episode.isEmpty()) {
            String message = "Data found for episode with ID: " + id;
            EpisodeResponse response = new EpisodeResponse(episode, message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            String message = "No data found for episode with ID: " + id;
            EpisodeResponse response = new EpisodeResponse(null, message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getItem/{id}")
    @ApiOperation(value = "Get Compliance Items by Episode Number", notes = "Provide an episodeNumber to get List of Compliance Items")
    public ResponseEntity<ComplianceItemResponse> getComplianceItembyid(@PathVariable(name = "id") Long id) {

        List<ComplianceItem> complianceItems = episodeInterface.getComplianceItembyEpicodeNumber(id);
        if (complianceItems.isEmpty()) {
            String message = "No data found for episode with ID: " + id;
            ComplianceItemResponse response = new ComplianceItemResponse(null, message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            String message = "Data found for episode with ID: " + id;
            ComplianceItemResponse response = new ComplianceItemResponse(complianceItems, message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }


    @GetMapping("/getAllEpisodeStatus/{status}")
    @ApiOperation(value = "Get List of Episode by status", notes = "Provide an status(i.e 'Completed','Edit required') to get List of Episode")
    public ResponseEntity<ListEpisodeResponse> getEpisodeStatus(@PathVariable(name = "status") String status) throws Exception {
        if (status.equals("Edit required") || status.equals("Completed")) {
            List<Episode> episodeList = episodeInterface.getEpisodesByStatus(status);
            if (episodeList.isEmpty()) {
                String message = "No data found for episode status " + status;
                ListEpisodeResponse response = new ListEpisodeResponse(null, message);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            } else {
                String message = "Data found for episode status " + status;
                ListEpisodeResponse response = new ListEpisodeResponse(episodeList, message);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

        } else {
            String message = "No Such Staus " + status + " exists";
            ListEpisodeResponse response = new ListEpisodeResponse(null, message);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
