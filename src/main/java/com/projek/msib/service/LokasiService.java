package com.projek.msib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projek.msib.api.model.Lokasi;
import com.projek.msib.repository.LokasiRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    public Lokasi save(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    public Iterable<Lokasi> findAll() {
        return lokasiRepository.findAll();
    }

    public void removeOne(Long id) {
        lokasiRepository.deleteById(id);
    }
}