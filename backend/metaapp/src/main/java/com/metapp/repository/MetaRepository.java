package com.metapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metapp.entity.Meta;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> { }
