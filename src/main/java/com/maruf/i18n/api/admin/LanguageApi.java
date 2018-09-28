package com.maruf.i18n.api.admin;

import com.maruf.i18n.entity.Language;
import com.maruf.i18n.service.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languages")
public class LanguageApi {

    private final LanguageService languageService;
    public LanguageApi(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam Long projectId){
        return ResponseEntity.ok()
                .body(languageService.findAll(projectId));
    }

    @GetMapping("/{languageId}")
    public ResponseEntity findById(@PathVariable Long languageId){
        return ResponseEntity.ok()
                .body(languageService.findById(languageId));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Language language){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(languageService.create(language));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Language language){
        return ResponseEntity.ok()
                .body(languageService.update(language));
    }

    @DeleteMapping("/{languageId}")
    public void delete(@RequestParam Long languageId){
        languageService.delete(languageId);
    }

}