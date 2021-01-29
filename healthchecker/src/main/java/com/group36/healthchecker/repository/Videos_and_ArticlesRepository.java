package com.group36.healthchecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group36.healthchecker.model.Videos_and_Articles;

@Repository
public interface Videos_and_ArticlesRepository extends JpaRepository<Videos_and_Articles, Long> {

}
