package com.welisson.challangeAlura_FotumHub.repository;

import com.welisson.challangeAlura_FotumHub.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {


    Topico findAllById(Long id);
}
