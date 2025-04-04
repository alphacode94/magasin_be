package com.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.LoginHistory;

@Repository
public interface LoginHistoryRespository extends JpaRepository<LoginHistory, Long> {

}
