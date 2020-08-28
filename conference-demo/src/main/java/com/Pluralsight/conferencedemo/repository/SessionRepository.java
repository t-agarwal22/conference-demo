package com.Pluralsight.conferencedemo.repository;

import com.Pluralsight.conferencedemo.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository  extends JpaRepository<Session,Long> {
}
