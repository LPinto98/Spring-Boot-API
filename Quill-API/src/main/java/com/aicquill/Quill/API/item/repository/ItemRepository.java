package com.aicquill.Quill.API.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.aicquill.Quill.API.item.model.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
	
}
