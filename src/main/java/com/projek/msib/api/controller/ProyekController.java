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

import com.projek.msib.api.model.Proyek;
import com.projek.msib.service.ProyekService;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public Proyek create(@RequestBody Proyek proyek) {
        return proyekService.save(proyek);
    }

    @GetMapping
    public Iterable<Proyek> findAll() {
        return proyekService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Long id, @RequestBody Proyek proyek) {
        // Cari proyek berdasarkan ID
        Proyek existingProyek = proyekService.findOne(id);

        if (existingProyek == null) {
            // Jika proyek tidak ditemukan, kembalikan 404 Not Found
            return ResponseEntity.notFound().build();
        }

        // Perbarui data proyek dengan data yang diterima dari request body
        existingProyek.setNama_proyek(proyek.getNama_proyek());
        existingProyek.setClient(proyek.getClient());
        existingProyek.setTgl_mulai(proyek.getTgl_mulai());
        existingProyek.setTgl_selesai(proyek.getTgl_selesai());
        existingProyek.setPimpinan_proyek(proyek.getPimpinan_proyek());
        existingProyek.setKeterangan(proyek.getKeterangan());
        // Anda bisa menambahkan logika lain jika perlu

        // Simpan perubahan
        Proyek updatedProyek = proyekService.save(existingProyek);

        // Kembalikan proyek yang diperbarui
        return ResponseEntity.ok(updatedProyek);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        proyekService.removeOne(id);
    }

    @GetMapping("/{id}")
    public Proyek findOne(@PathVariable("id") Long id) {
        return proyekService.findOne(id);
    }
}
