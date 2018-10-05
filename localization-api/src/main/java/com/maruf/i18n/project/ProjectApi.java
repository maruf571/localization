package com.maruf.i18n.project;

import com.maruf.i18n.project.entity.Project;
import com.maruf.i18n.project.service.ProjectService;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/api/protected/projects")
public class ProjectApi {

    private final ProjectService projectService;
    public ProjectApi(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity findAll(Pageable pageable){
        return ResponseEntity.ok()
                .body(projectService.findAll(pageable));
    }

    @GetMapping("/{projectId}")
    public ResponseEntity findById(@PathVariable String projectId){
        return ResponseEntity.ok()
                .body(projectService.findById(projectId));
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Project project){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(projectService.create(project));
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Project project){
        return ResponseEntity.ok()
                .body(projectService.update(project));
    }

    @DeleteMapping("/{projectId}")
    public void delete(@RequestParam String projectId){
        projectService.delete(projectId);
    }

}
