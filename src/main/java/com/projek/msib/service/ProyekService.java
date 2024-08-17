package com.projek.msib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projek.msib.api.model.Proyek;
import com.projek.msib.repository.ProyekRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    public Proyek save(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public Iterable<Proyek> findAll() {
        return proyekRepository.findAll();
    }

    public void removeOne(Long id) {
        proyekRepository.deleteById(id);
    }
}
