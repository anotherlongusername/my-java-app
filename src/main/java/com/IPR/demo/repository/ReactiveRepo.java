package com.IPR.demo.repository;

import com.IPR.demo.entity.Reactive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReactiveRepo extends JpaRepository<Reactive, Integer> {
}
