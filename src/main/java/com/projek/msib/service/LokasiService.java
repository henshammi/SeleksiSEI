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
    private LokasiRepository userRepository;

    public Lokasi save(Lokasi user) {
        return userRepository.save(user);
    }

    public Iterable<Lokasi> findAll() {
        return userRepository.findAll();
    }

    public void removeOne(Long id) {
        userRepository.deleteById(id);
    }
}