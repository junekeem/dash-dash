package com.dashdash.backend.menu.repository;

import com.dashdash.backend.menu.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MenuRepository extends JpaRepository<Menu, UUID> {

    @Override
    Optional<Menu> findById(UUID uuid);

}
