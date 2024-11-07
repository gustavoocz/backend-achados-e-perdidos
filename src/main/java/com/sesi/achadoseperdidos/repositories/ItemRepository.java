package com.sesi.achadoseperdidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sesi.achadoseperdidos.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{}
