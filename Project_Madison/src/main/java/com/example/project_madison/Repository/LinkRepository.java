package com.example.project_madison.Repository;

import com.example.project_madison.Model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<Link,Integer> {

    Link findByRequestId(Integer id);

}
