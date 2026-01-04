package com.community.group.Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.community.group.entity.Observation;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Long> {

    long countByAuthority(String authority);

    List<Observation> findTop5ByAuthorityOrderByCreatedAtDesc(String authority);

    @Query("SELECT o.user.userName, SUM(o.points) FROM Observation o WHERE o.authority = :authority GROUP BY o.user.userName ORDER BY SUM(o.points) DESC")
    List<Object[]> topContributors(@Param("authority") String authority, PageRequest pageRequest);

} 

