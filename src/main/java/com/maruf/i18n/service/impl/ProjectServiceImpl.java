package com.maruf.i18n.service.impl;

import com.maruf.i18n.entity.Project;
import com.maruf.i18n.repository.ProjectRepository;
import com.maruf.i18n.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project) {
        projectRepository
                .findById(project.getId())
                .orElseThrow(() -> new EntityNotFoundException("project not found"));

        return projectRepository.save(project);
    }

    @Override
    public Project findById(Long projectId) {
        return projectRepository
                .findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("project not found"));
    }

    @Override
    public Page<Project> findAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public void delete(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}