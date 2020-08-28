package com.Pluralsight.conferencedemo.repository;

import com.Pluralsight.conferencedemo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
