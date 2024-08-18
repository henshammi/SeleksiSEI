package com.projek.msib.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projek.msib.api.model.Lokasi;
import com.projek.msib.service.LokasiService;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public Lokasi create(@RequestBody Lokasi lokasi) {
        return lokasiService.save(lokasi);
    }

    @GetMapping
    public Iterable<Lokasi> findAll() {
        return lokasiService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasi) {
        // Cari lokasi berdasarkan ID
        Lokasi existingLokasi = lokasiService.findOne(id);

        if (existingLokasi == null) {
            // Jika lokasi tidak ditemukan, kembalikan 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Perbarui data lokasi dengan data yang diterima dari request body
        existingLokasi.setNama_lokasi(lokasi.getNama_lokasi());
        existingLokasi.setNegara(lokasi.getNegara());
        existingLokasi.setProvinsi(lokasi.getProvinsi());
        existingLokasi.setKota(lokasi.getKota());
        // Anda bisa menambahkan logika lain jika perlu

        // Simpan perubahan
        Lokasi updatedLokasi = lokasiService.save(existingLokasi);

        // Kembalikan lokasi yang diperbarui
        return ResponseEntity.ok(updatedLokasi);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        lokasiService.removeOne(id);
    }

    @GetMapping("/{id}")
    public Lokasi findOne(@PathVariable("id") Long id) {
        return lokasiService.findOne(id);
    }
}