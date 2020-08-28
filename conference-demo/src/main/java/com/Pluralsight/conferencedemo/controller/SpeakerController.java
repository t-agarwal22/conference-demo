package com.Pluralsight.conferencedemo.controller;

import com.Pluralsight.conferencedemo.model.Session;
import com.Pluralsight.conferencedemo.model.Speaker;
import com.Pluralsight.conferencedemo.repository.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    private List<Speaker> list()
    {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    private Speaker get(@PathVariable Long id)
    {
        return speakerRepository.getOne(id);
    }

    @PostMapping //create
    public Speaker create(@RequestBody final Speaker speaker)
    {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE) //delete
    public void delete(@PathVariable Long id)
    {
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)//update
    public Speaker update(@PathVariable Long id ,@RequestBody Speaker speaker)
    {
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
