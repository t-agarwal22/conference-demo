package com.Pluralsight.conferencedemo.controller;

import com.Pluralsight.conferencedemo.model.Session;
import com.Pluralsight.conferencedemo.repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // this will respond to payloads incoming and outgoing as JSON REST endpoints.
@RequestMapping("api/v1/sessions") //tells the router what the mapping URL will look like.
public class SessionController {
@Autowired //inject or auto wire the sessions repository that we just created.
    private SessionRepository sessionRepository;

@GetMapping  // tells which HTTP verb to use, which will be a get verb to call this endpoint.
    private List<Session> list()
  {
    return sessionRepository.findAll();
  }

  @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id)
  {
      return sessionRepository.getOne(id);
  }

  @PostMapping //create
    public Session create(@RequestBody final Session session)
  {
      return sessionRepository.saveAndFlush(session);
  }

  @RequestMapping(value = "{id}",method = RequestMethod.DELETE) //delete
    public void delete(@PathVariable Long id)
  {
    sessionRepository.deleteById(id);
  }

    @RequestMapping(value = "{id}",method = RequestMethod.PUT)//update
    public Session update(@PathVariable Long id ,@RequestBody Session session)
    {
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
